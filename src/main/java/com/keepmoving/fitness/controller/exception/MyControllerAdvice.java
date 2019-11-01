package com.keepmoving.fitness.controller.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CYF;
 * @date 2019/10/9.     全局异常处理器，只监视控制层
 */
//@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */

//    @ExceptionHandler(value = Exception.class)
    public String errorHandler(Model model, Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        model.addAttribute("map",map);

        return "exception/my_error";
    }

//    /**
//     * 拦截捕捉自定义异常 MyException.class
//     * @param ex
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(value = MyException.class)
//    public Map myErrorHandler(MyException ex) {
//        Map map = new HashMap();
//        map.put("code", ex.getCode());
//        map.put("msg", ex.getMsg());
//        return map;
//    }

}
