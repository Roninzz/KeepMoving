package com.keepmoving.fitness.controller.food;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:Kenny
 * @version:1.0
 * @description:饮食页面
 */
@Controller
@RequestMapping("/food")
public class FoodController {

    @RequestMapping("/food-list")
    public String food(){
        return "/food/food";
    }

    @RequestMapping("/food-detail")
    public String foodDetail(){
        return "/food/food-detail";
    }
}
