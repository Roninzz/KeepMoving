package com.keepmoving.fitness.controller.login;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.entity.personInfo.UserImgs;
import com.keepmoving.fitness.service.login.IUserInfoService;
import com.keepmoving.fitness.service.personInfo.IUserBaseInfoService;
import com.keepmoving.fitness.service.personInfo.IUserImgsService;
import com.keepmoving.fitness.util.sendsms.AliyunSmsUtils;
import com.keepmoving.fitness.util.sendsms.password.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;


/**
 * @author CYF;
 * @date 2019/9/27.
 */
@Controller
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IUserImgsService userImgsService;

    @Autowired
    private IUserBaseInfoService userBaseInfoService;

    //用于解密
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    //用于设置验证码失效
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //登录成功去首页
    @RequestMapping("/goIndex")
    public String goIndex(String phone, HttpSession session) {

        UserInfo user = userInfoService.findByPhone(phone);

        //获取用户id,并查找其基本信息
        Long userId = user.getUserId();
        UserImgs userImg = userImgsService.getPhotoByUserId(userId);
        UserBaseInfo userBaseInfo = userBaseInfoService.findByUserId(userId);

        //将登录的用户以及其信息放入session作用域
        session.setAttribute("userInfo", user);
        session.setAttribute("userImg",userImg);
        session.setAttribute("userBaseInfo",userBaseInfo);

        return "forward:index/hello";
    }


    //登录action
    @RequestMapping("/loginAct")
    public String loginAct() {
        return "user/login";
    }

    //地图
    @RequestMapping("/goMap")
    public String goMap() {
        return "user/map";
    }

    /**
     * 去登录页面
     *
     * @return
     */
    @RequestMapping("/goLoginAct")
    public String goLoginAct() {
        return "user/login";
    }

    /**
     * 发送消息
     *
     * @param phone
     * @return
     */
    @RequestMapping("/sendMsg")
    @ResponseBody
    public String sendMsg(@RequestParam("phone") String phone) {

        String code = AliyunSmsUtils.getCode();

        SendSmsResponse response = null;
        try {
            response = AliyunSmsUtils.sendSms(phone, code);
            System.out.println(code);

            //将生成的验证码放入redis中，并设置存活时间
//            redisTemplate.opsForValue().set(phone,code,10);
            stringRedisTemplate.opsForValue().set(phone, code, 60, TimeUnit.SECONDS);


        } catch (Exception e) {
            e.printStackTrace();

        }
        return code; //返回验证码给前端
    }

    /**
     * 检查验证码是否过期
     *
     * @param phone
     * @return
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(@RequestParam("phone") String phone) {

        //根据填写的手机从redis中获取验证码，查看是否存在
//        String code = (String) redisTemplate.opsForValue().get(phone);
        String code = (String) stringRedisTemplate.opsForValue().get(phone);
//        System.out.println("redis中获取的验证码为" + code);
        if (code == null) {
            return "error";
        } else {
            return code; //返回验证码给前端
        }


    }

    //注册action
    @RequestMapping("/registerAct")
    public String registerAct() {
        return "user/register";
    }

    //判断手机号是否存在
    @RequestMapping("/judgePhoneAct")
    @ResponseBody
    public String judgePhoneAct(@RequestParam("phone") String phone) {
        //根据输入的电话号，到数据库中查询
        UserInfo userInfo = userInfoService.findByPhone(phone);
        System.out.println(userInfo);

        if (userInfo == null) {
            //如果该手机不存在，则返回yes允许注册
            return "yes";
        } else {
            return "no";
        }
    }


    //注册用户
    @RequestMapping("/addUserInfo")
    public String addUserInfo(UserInfo userInfo) {

        //将客户的密码进行加密放入数据库    加密begin
//        String mdPwd = MD5Utils.MD5(userInfo.getPassword());
//        System.out.println("加密后的密码:" +mdPwd);
//        userInfo.setPassword(mdPwd);
        //加密end
        userInfoService.addUserInfo(userInfo);

        return "/user/login";
    }

    //退出
    @RequestMapping("/exit")
    public String exit(HttpServletRequest req) {

        //清空session
        req.getSession().invalidate();
        return "forward:/goIndex1" ;
    }

    //登录成功去首页
    @RequestMapping("/goIndex1")
    public String goIndex1() {

        return "redirect:index/hello";
    }


//    //验证前台输入密码与加密后的密码是否一致
//    @RequestMapping("/checkPassword")
//    //获取前台输入的手机号及密码
//    public String checkPassword(String phone,String password){
//        //根据phone查找对应的userInfo
//        UserInfo uf = userInfoService.findByPhone(phone);
//        //获取其数据库中加密的密码
//        String password1 = uf.getPassword();
//
//        //判断密码是否一致，第一个参数为前台输入的密码，第二个参数为数据库中加密的密码
//        if (passwordEncoder.matches(password,password1)){
//
//            //若密码正确，重定向到去首页的action
//            return "redirect:goIndex";
//        }else {
//            //否则返回登录页面
//            return "/user/login";
//        }
//
//    }

    @RequestMapping("/gotest")
    public String gotest() {
        return "shiro/test";
    }

    @RequestMapping("/goadd")
    public String goadd() {
        return "shiro/add";
    }

    @RequestMapping("/goupdate")
    public String goupdate() {
        return "shiro/update";
    }

    @RequestMapping("/golanjie")
    public String golanjie() {
        return "shiro/lanjie";
    }

    @RequestMapping("/noAuth")
    public String noAuth() {
        return "shiro/noAuth";
    }

    @RequestMapping("/shiroLogin")
    public String shiroLogin(String phone, String password, Model model) {

        //使用shiro实现认证操作

        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);

        //3.执行登录方法
        try {
            subject.login(token);

            //登录成功,跳转到test页面
            return "redirect:gotest";
        } catch (UnknownAccountException e) {
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "shiro/lanjie";
        } catch (IncorrectCredentialsException e) {
            //登录失败：密码错误
            model.addAttribute("msg", "密码错误");
            return "shiro/lanjie";
        }

    }

//    @RequestMapping("/shiroLogin")
//    public String shiroLogin(String phone, String password, Model model) {
//
//        //使用shiro实现认证操作
//
//        //1.获取Subject
//        Subject subject = SecurityUtils.getSubject();
//
//        //2.封装用户数据
//        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
//
//        //3.执行登录方法
//        try {
//            subject.login(token);
//
//            //登录成功,跳转到test页面
//            return "redirect:gotest";
//        } catch (UnknownAccountException e) {
//            //登录失败:用户名不存在
//            model.addAttribute("msg", "用户名不存在");
//            return "shiro/lanjie";
//        } catch (IncorrectCredentialsException e) {
//            //登录失败：密码错误
//            model.addAttribute("msg", "密码错误");
//            return "shiro/lanjie";
//        }
//
//    }


}
