package com.keepmoving.fitness.controller.userInfo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.entity.personInfo.UserImgs;
import com.keepmoving.fitness.service.impl.login.UserInfoServiceImpl;
import com.keepmoving.fitness.service.login.IUserInfoService;
import com.keepmoving.fitness.service.personInfo.IUserBaseInfoService;
import com.keepmoving.fitness.service.personInfo.IUserImgsService;

@Controller
public class UserImgsController {

    @Autowired
    private IUserImgsService iUserImgsService;
    /**
     * 获取用户头像
     * @param request
     * @return
     */
    @RequestMapping("/getPhoto")
    @ResponseBody
    public UserImgs getPhoto(HttpServletRequest request){
        HttpSession session = request.getSession();

        /*----------------------begin---------------------*/
        //暂时模拟session存储用户信息（做好用户登录后这里可以直接删除）
//    	UserInfo user = new UserInfo();
//    	user.setPhone("13336204789");
//    	user.setId(1);
//    	session.setAttribute("userInfo", user);
        /*------------------------end--------------------*/

        UserInfo u = (UserInfo)session.getAttribute("userInfo");
        return iUserImgsService.getPhotoByUserId(u.getUserId());
    }
    /**
     * 上传头像
     * @param
     * @return
     */
    @RequestMapping("/uploadPhoto")
    @ResponseBody
    public HashMap<Object, Object> uploadPhoto(@RequestParam("file") MultipartFile file,HttpSession session,
                                               HttpServletRequest request){
        //获取session
        UserInfo u = (UserInfo)session.getAttribute("userInfo");

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        try {
            if(null!=file){
                //获得当前项目所在路径
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                System.out.println("当前项目所在路径："+pathRoot);
                //生成uuid作为文件名称
                String uuid=UUID.randomUUID().toString().replaceAll("-","");
                System.out.println("文件名称："+uuid);
                //获得文件类型（判断如果不是图片文件类型，则禁止上传）
                String contentType=file.getContentType();
                System.out.println("文件类型："+contentType);
                //获得文件后缀名称
                String imageName=contentType.substring(contentType.indexOf("/")+1);
                System.out.println("文件后缀名称："+imageName);

                //联赛id
                String path= pathRoot +"upload\\";

                //如果不存在，则创建新文件夹
                File f=new File(path);
                if(!f.exists()){
                    f.mkdirs();
                }

                //新生成的文件名称
                String fileName=uuid+"."+imageName;
                System.out.println("新生成的文件名称："+fileName);

                //图片保存的完整路径
                String pathName=path+fileName;

                //图片的静态资源路径
                String imgUrl = com.keepmoving.fitness.util.qiniu.UploadImgUtil.upload(file.getBytes(),file.getOriginalFilename());
                System.out.println("静态资源路径："+imgUrl);

                //复制操作
                //将图片从源位置复制到目标位置
                file.transferTo(new File(pathName));
                map.put("msg", 1);
                map.put("filePath", imgUrl);

                UserImgs userImgs = new UserImgs();
                userImgs.setUserId(u.getUserId());
                //userImgs.setCreateTime();
                userImgs.setImgUrl(imgUrl);
                Long count = iUserImgsService.getCount(u.getUserId());
                if(count > 0){
                    iUserImgsService.UpdateByUserId(userImgs);
                }else{
                    iUserImgsService.addByImg(userImgs);
                }
            }else{
                map.put("msg", 0);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return map;
        }
    }


}
