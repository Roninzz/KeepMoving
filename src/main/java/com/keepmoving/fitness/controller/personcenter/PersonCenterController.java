package com.keepmoving.fitness.controller.personcenter;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.dto.FitTimeDTO;
import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.entity.personcenter.Comment;
import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.entity.personcenter.UserPlan;
import com.keepmoving.fitness.entity.personcenter.UserScore;
import com.keepmoving.fitness.entity.plan.CodeStatus;
import com.keepmoving.fitness.entity.plan.Plans;
import com.keepmoving.fitness.entity.plan.Result;
import com.keepmoving.fitness.service.calender.ITrainService;
import com.keepmoving.fitness.service.impl.personcenter.VideoDataServiceImpl;
import com.keepmoving.fitness.service.personInfo.IUserBaseInfoService;
import com.keepmoving.fitness.service.personcenter.ICommentService;
import com.keepmoving.fitness.service.personcenter.IUserPlanService;
import com.keepmoving.fitness.service.personcenter.IUserScoreService;
import com.keepmoving.fitness.service.plan.IPlansService;
import com.keepmoving.fitness.service.vo.IUserReplyServiceVo;
import com.keepmoving.fitness.vo.CommentVo;
import com.keepmoving.fitness.vo.ReplyVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 个人中心controller层
 */
@Controller
@RequestMapping("/person")
public class PersonCenterController {

    @Autowired
    private UserBaseInfo userBaseInfo;

    @Autowired
    private IUserBaseInfoService baseInfoService;

    @Autowired
    private IUserPlanService userPlanService;

    @Autowired
    private UserPlan userPlan;

    @Autowired
    private Plans plan;

    @Autowired
    private IPlansService plansService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserReplyServiceVo userReplyServiceVo;

    @Autowired
    private IUserScoreService userScoreService;

    @Autowired
    private ITrainService trainService;

    @Autowired
    private VideoDataServiceImpl videoDataService;


    @RequestMapping("/center")
    public String center(Model model, HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if (userInfo != null) {
            // 获取用户的基本资料
            userBaseInfo = baseInfoService.findByUserId(userInfo.getUserId());
            // 添加在model作用域
            model.addAttribute("userBaseInfo", userBaseInfo);
        }
        // 获取用户添加的计划信息
        UserPlan uplan = userPlanService.findUserAllPlanByUserId(userInfo.getUserId());
        // 查询用户对应的计划
        if (uplan == null) {
            model.addAttribute("plan", "暂无任何训练计划");
        } else{
            Plans plan = plansService.findById(uplan.getPlanId());
            model.addAttribute("plan", plan.getPlanName());
            model.addAttribute("pid", plan.getId());
        }
        return "/person/person-center";
    }

    @ResponseBody
    @RequestMapping("/train")
    public Result train(@RequestParam(defaultValue = "") String uid){
        Map<String,Object> map = new HashMap<>(16);
        // 查询用户对应的计划信息
        UserPlan userPlan = userPlanService.findUserAllPlanByUserId(Long.valueOf(uid));
        if (userPlan == null){
            return new Result(CodeStatus.ERROR,false,"加载计划安排失败");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            map.put("addTime",userPlan.getAddTime());
            // 获取对应的计划id
            Integer pid = userPlan.getPlanId();

            // 根据计划id查询对应的计划
            Plans plan = plansService.findById(pid);
            List<String> train = trainService.getTitleByPlanId(pid);
            List<String> trainList = new ArrayList<>();
            for (int i = 0; i < plan.getPlanWeek(); i++) {
                for (int j = 0; j < train.size(); j++) {
                    trainList.add(train.get(j));
                }
            }
            map.put("plan",plan);
            map.put("trainList",trainList);
            return new Result(CodeStatus.OK,true,"加载计划安排成功",map);
        }

    }


    /**
     * 获取计划完成度后台
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("/data")
    public Result planData(@RequestParam String uid){
        UserPlan userPlan = userPlanService.findUserAllPlanByUserId(Long.valueOf(uid));
        if (userPlan != null){
            Map<String,Integer> data = getData(userPlan);
            return new Result(CodeStatus.OK,true,"获取计划完成度成功",data);
        }
        return new Result(CodeStatus.OK,true,"当前无训练计划");
    }

    /**
     * 获取前台传的计划id,并将对应的计划添加到用户计划的数据库中
     * @param pid
     * @return
     */
    @ResponseBody
    @PostMapping("/join")
    public Result getJoinPlanId(@RequestParam String pid,@RequestParam String uid){
        UserPlan userPlan = getUserPlan(pid,uid);
        // 保存到数据库
        userPlanService.saveUserPlan(userPlan);
        if (userPlan == null){
            return new Result(CodeStatus.ERROR,false,"添加计划失败");
        }
        return new Result(CodeStatus.OK,true,"添加训练计划成功");
    }

    /**
     * 用户取消计划
     * @param pid 计划id
     * @return
     */
    @ResponseBody
    @RequestMapping("/cancelPlan")
    public Result cancelPlan(@RequestParam String pid,HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        // 将用户的计划信息添加到数据库中
        if (null != pid){
            userPlan.setPlanId(Integer.valueOf(pid));
        }
        // 获取用户id
        userPlan.setUserId(userInfo.getUserId());
        // 获取当前的时间
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        userPlan.setAddTime(date);
        // 获取计划类型
        plan = plansService.findById(Integer.valueOf(pid));
        userPlan.setPlanType(plan.getStatus());
        // 设置计划状态
        userPlan.setPlanStatus(0);
        // 保存到数据库
        userPlanService.updateUserCancelPlan(userPlan);
        if (userPlan == null){
            return new Result(CodeStatus.ERROR,false,"添加计划失败");
        }
        return new Result(CodeStatus.OK,true,"添加训练计划成功");
    }

    /**
     * 评论分页
     * @param model
     * @param pageNum 当前页
     * @param pageSize 每页显示的条数
     * @return
     */
    @RequestMapping("/comment")
    public String commentPage(Model model, HttpServletRequest request,@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "2") String pageSize){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if (userInfo != null) {
            Map<String, Object> map = commentService.getCommentByUserId(userInfo.getUserId(), Integer.valueOf(pageNum), Integer.valueOf(pageSize));
            // 获取分页的信息
            PageInfo<Comment> pageInfo = (PageInfo<Comment>) map.get("pageInfo");
            model.addAttribute("pageInfo", pageInfo);
            List<CommentVo> commentVoList = (List<CommentVo>) map.get("commentVoList");
            model.addAttribute("commentVoList", commentVoList);
        }
        return "/person/comment-data";
    }

    @ResponseBody
    @RequestMapping("/checkJoin")
    public Result checkJoin(@RequestParam String uid){
        UserPlan userPlan = userPlanService.findUserAllPlanByUserId(Long.valueOf(uid));
        if (userPlan == null){
            return new Result(CodeStatus.OK,true,"尚未加入任何计划");
        }
        return  new Result(CodeStatus.ERROR,false,"已加入训练计划");
    }

    @ResponseBody
    @RequestMapping("/fit-record")
    public Result fitRecord(Model model, @RequestParam String uid){
        List<UserPlan> userPlan = userPlanService.findUserPlanRecordByUserId(Long.valueOf(uid));
        List<Plans> plansList = new ArrayList<>();
        Plans plans = null;
        if (userPlan != null) {
            for (UserPlan u : userPlan) {
                plans = plansService.findById(u.getPlanId());
            }
        }
        return  new Result(CodeStatus.OK,true,"已加入训练计划",plans);
    }

    /**
     * 用户的回复数据进行分页渲染
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/reply")
    public String reply(Model model, HttpServletRequest request,@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "2") String pageSize){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        Map<String,Object> map = userReplyServiceVo.getUserReplyInfoByUserId(userInfo.getUserId(),Integer.valueOf(pageNum),Integer.valueOf(pageSize));
        // 获取封装回复数据的第三方实体类
        List<ReplyVo> replyVoList = (List<ReplyVo>) map.get("replyVoList");
        // 获取分页的信息
        PageInfo<Reply> replyPageInfo = (PageInfo<Reply>) map.get("replyPageInfo");
        model.addAttribute("replyVoList",replyVoList);
        model.addAttribute("replyPageInfo",replyPageInfo);
        return "/person/reply-data";
    }

//    @GetMapping("/record")
//    public String record(Model model) {
//        UserPlan uplan = userPlanService.findUserAllPlanByUserId(Long.valueOf(2));
//        Plans nplan = plansService.findById(uplan.getPlanId());
//        model.addAttribute("nplan", nplan);
//        List<UserPlan> userPlans = userPlanService.findUserPlanRecordByUserId(Long.valueOf(4));
//        List<Plans> plans = new ArrayList<>();
//        for (UserPlan u : userPlans) {
//            Plans plan = plansService.findById(u.getPlanId());
//            plans.add(plan);
//        }
//        model.addAttribute("plans", plans);
//        return "/person/fit-record";
//    }

    /**
     * 保存前端页面用户对计划的评分
     * @param u
     * @return
     */
    @ResponseBody
    @RequestMapping("/score")
    public String score(UserScore u){
        userScoreService.savePlanScore(u);
        return "" ;
    }

    /**
     * 获取用户结束时间
     * @param date 加入计划时间
     * @param day 总的训练天数
     * @return
     * @throws ParseException
     */
    public static Date addDate(Date date, long day) throws ParseException {
        long time = date.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        return new Date(time);
    }


    /**
     * 将用户的计划信息添加到数据库中
     * @param pid
     * @return
     */
    public UserPlan getUserPlan(String pid,String uid){
        userPlan.setPlanId(Integer.valueOf(pid));
        // 获取用户id
        userPlan.setUserId(Long.valueOf(uid));
        // 获取当前的时间
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        userPlan.setAddTime(date);
        Plans plan = plansService.findById(Integer.valueOf(pid));
        Integer week = plan.getPlanWeek();
        try {
            userPlan.setEndTime(addDate(date,week*7));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 获取计划类型
        plan = plansService.findById(Integer.valueOf(pid));
        userPlan.setPlanType(plan.getStatus());
        // 设置计划状态
        userPlan.setPlanStatus(1);
        return userPlan;
    }

    /**
     * 获取用户计划完成度
     * @param userPlan
     * @return
     */
    public  Map<String,Integer> getData(UserPlan userPlan){
        Date endTime = userPlan.getEndTime();
        Date startTime = userPlan.getAddTime();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();
        c1.setTime(startTime);
        c2.setTime(new Date());
        c3.setTime(endTime);

        Integer start = c1.get(Calendar.DAY_OF_YEAR);
        Integer end = c2.get(Calendar.DAY_OF_YEAR);
        Integer complete = end - start;
        Plans plan = plansService.findById(userPlan.getPlanId());
        Integer all = plan.getPlanWeek()*7;

        Map<String,Integer> data = new HashMap<>(16);
        data.put("complete",complete);
        data.put("all",all);
        return data;
    }

}
