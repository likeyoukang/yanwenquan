package com.yanwen.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.controller
 * @create 2019-08-27 12:41
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


}

