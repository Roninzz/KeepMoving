package com.keepmoving.fitness.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 健身动作
 */
@Controller
@RequestMapping("/action")
public class ActionController {

    @RequestMapping("/action-list")
    public String actionList(){
        return "/action/fit-action";
    }

    @RequestMapping("/action-detail")
    public String actionDetail(){
        return "/action/action-video";
    }

}
