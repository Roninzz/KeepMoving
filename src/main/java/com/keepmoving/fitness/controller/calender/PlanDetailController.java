package com.keepmoving.fitness.controller.calender;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.dto.CommentDTO;
import com.keepmoving.fitness.dto.ReplyDTO;
import com.keepmoving.fitness.entity.personcenter.Comment;
import com.keepmoving.fitness.entity.personcenter.Thump;
import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.entity.personcenter.UserPlan;
import com.keepmoving.fitness.entity.plan.CodeStatus;
import com.keepmoving.fitness.entity.plan.Plans;

import com.keepmoving.fitness.entity.plan.Result;

import com.keepmoving.fitness.service.calender.IPlanDescriptionService;
import com.keepmoving.fitness.service.calender.IPlanScoreService;
import com.keepmoving.fitness.service.calender.ITrainService;
import com.keepmoving.fitness.service.personInfo.IUserBaseInfoService;
import com.keepmoving.fitness.service.personInfo.IUserImgsService;
import com.keepmoving.fitness.service.personcenter.ICommentService;
import com.keepmoving.fitness.service.personcenter.IThumpService;
import com.keepmoving.fitness.service.personcenter.IReplyService;
import com.keepmoving.fitness.service.personcenter.IUserPlanService;
import com.keepmoving.fitness.service.plan.IPlansService;
import com.keepmoving.fitness.service.vo.IPlanCommentServiceVo;
import com.keepmoving.fitness.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author:Kenny
 * @version:1.0
 * @description:
 */
@Controller
@RequestMapping("/plan-detail")
public class PlanDetailController {

    @Autowired
    private IPlanDescriptionService planDescriptionService;

    @Autowired
    private IPlanScoreService planScoreService;

    @Autowired
    private IPlansService plansService;

    @Autowired
    private Plans plan;

    @Autowired
    private ITrainService trainService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IReplyService replyService;

    @Autowired

    private IThumpService thumpService;

    @Autowired
    private IPlanCommentServiceVo planCommentServiceVo;

    @Autowired
    private IUserPlanService userPlanService;

    @Autowired
    private IUserBaseInfoService userBaseInfoService;

    @Autowired
    private IUserImgsService userImgsService;


    @ResponseBody
    @RequestMapping("/plan-data")
    public Result train(@RequestParam Integer pid,@RequestParam String uid){
        Map<String,Object> data = new HashMap<>(16);
        // 获取对应的用户id
        UserPlan userPlan = userPlanService.findUserAllPlanByUserId(Long.valueOf(uid));

        if (userPlan != null && userPlan.getPlanId().equals(pid)){
            data.put("flage",userPlan.getPlanStatus());
        }else {
            data.put("flage",0);
        }
        // 获取计划安排的描述
        String description = planDescriptionService.getPlanDescriptionByPlanId(pid);
        data.put("description",description);
        List<String> trainContent = trainService.getTitleByPlanId(pid);
        data.put("trainContent",trainContent);
        // 获取计划的评分
        Double planScore = planScoreService.getPlanScoreByPlanId(pid);
        data.put("planScore",planScore);
        // 获取计划的相关信息
        plan = plansService.findById(pid);
        data.put("plan",plan);
        // 获取点赞数据
        Thump thump = thumpService.findByPlanId(pid);
        data.put("thump",thump);
        return new Result(CodeStatus.OK,true,"加载计划信息内容成功",data);
    }


    @ResponseBody
    @RequestMapping("/comment-data")
    public Result commentData(@RequestParam(defaultValue = "1") String pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize,
                              @RequestParam String pid){
        Integer id = Integer.valueOf(pid);
        Map<String,Object> data = new HashMap<>(16);
        Map<String,Object> commentMap;
        commentMap = planCommentServiceVo.getPlanCommentByPlanId(id,Integer.valueOf(pageNum),pageSize);
        // 获取评论和回复的信息
        List<CommentVo> commentVoList = (List<CommentVo>) commentMap.get("commentVoList");
        PageInfo<Comment> commentPageInfo = (PageInfo<Comment>) commentMap.get("commentPageInfo");
        data.put("pageNum",pageNum);
        data.put("pageSize",commentPageInfo.getPageSize());
        data.put("pages",commentPageInfo.getPages());
        data.put("commentVoList",commentVoList);
        // 总的评论数
        List<Comment> commentList = commentService.findAllCommentsByPlanId(id);
        data.put("commentSize",commentList.size());
        return new Result(CodeStatus.OK,true,"加载评论内容成功",data);
    }


    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam Integer id){
        model.addAttribute("pid",id);

        return "/plan/plan-detail";
    }


    /**
     * 接受用户填写的评论信息
     * @param commentDTO 接受页面传的评论数据
     */
    @ResponseBody
    @PostMapping("/saveComment")
    public Result saveComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        // 获取页面传输的数据
        comment.setUserId(commentDTO.getUserId());
        comment.setContent(commentDTO.getContent());
        comment.setPlanId(commentDTO.getPlanId());
        comment.setStatus(0);
        Date date = new Date();
        comment.setCreateTime(date);
        commentService.saveUserComment(comment);
        if (comment.getContent() == null){
            return new Result(CodeStatus.ERROR,false,"评论内容不能为空");
        }
        CommentVo commentVo = getComment(comment);
        return new Result(CodeStatus.OK,true,"评论成功",commentVo);
    }

    public CommentVo getComment(Comment comment){
        CommentVo commentVo = new CommentVo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String time = sdf.format(date);
        commentVo.setCommentUserName(userBaseInfoService.findByUserId(comment.getUserId()).getUsername());
        commentVo.setDate(time);
        commentVo.setContent(comment.getContent());
        commentVo.setCommentUserImg(userImgsService.getPhotoByUserId(comment.getUserId()).getImgUrl());
        return commentVo;
    }

    /**
     * 点赞数增加
     * @param planId
     * @return
     */
    @RequestMapping("/addThumpNum")
    @ResponseBody
    public String addThumpNum(String planId){

        //点赞数加一
        thumpService.addThumpNum(Integer.valueOf(planId));
        //重新查询该计划点赞数
        Integer thumpNum = thumpService.getThumpNumByPlanId(Integer.valueOf(planId));

        //返回给前端页面
        return thumpNum.toString();
    }

    /**
     * 点赞数增加
     * @param planId
     * @return
     */
    @RequestMapping("/subThumpNum")
    @ResponseBody
    public String subThumpNum(String planId){

        //点赞数加一
        thumpService.subThumpNum(Integer.valueOf(planId));
        //重新查询该计划点赞数
        Integer thumpNum = thumpService.getThumpNumByPlanId(Integer.valueOf(planId));

        //返回给前端页面
        return thumpNum.toString();
    }

    /**
     * 接受用户填写的回复信息
     * @param replyDTO 接受传输的数据
     */
    @ResponseBody
    @PostMapping("/saveReply")
    public Result saveReply(ReplyDTO replyDTO){
        Reply reply = new Reply();
        // 获取页面传输的数据
        reply.setCommentId(replyDTO.getCommentId());
        reply.setReplyUser(Long.valueOf(replyDTO.getReplyUserId()));
        reply.setReplyContent(replyDTO.getReplyContent());
        reply.setStatus(0);
        Date date = new Date();
        reply.setReplyTime(date);
        System.out.println(reply);
        replyService.saveUserReply(reply);
        // 查询出用户回复完之后对应的评论用户信息和回复用户信息
        Comment comment = commentService.findCommentByCommentId(replyDTO.getCommentId());


        if (reply.getReplyContent() == null){
            return new Result(CodeStatus.ERROR,false,"回复内容不能为空",reply);
        }
        return new Result(CodeStatus.OK,true,"回复成功",reply);
    }
}
