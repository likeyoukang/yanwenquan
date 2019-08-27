package com.yanwen.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.controller
 * @create 2019-08-27 12:41
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name,Model model){

        model.addAttribute("name",name);
        return "hello";
    }


}

