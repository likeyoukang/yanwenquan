package com.yanwen.community.controller;

import com.yanwen.community.dto.PaginationDTO;
import com.yanwen.community.dto.QuestionDTO;
import com.yanwen.community.mapper.QuestionMapper;
import com.yanwen.community.mapper.UserMapper;
import com.yanwen.community.model.Question;
import com.yanwen.community.model.User;
import com.yanwen.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.controller
 * @create 2019-08-27 12:41
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "page",defaultValue = "1") Integer page,
                        @RequestParam(value = "szie",defaultValue = "5") Integer size
                        ){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
        }
        PaginationDTO pagination =questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }


}

