package com.yanwen.community.controller;

import com.yanwen.community.mapper.QuestionMapper;
import com.yanwen.community.mapper.UserMapper;
import com.yanwen.community.model.Question;
import com.yanwen.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.controller
 * @create 2019-08-29 12:36
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";

    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model) {

        /***
         * 文字回显，当信息不全时提示error，病不消失发布文字信息
         */
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(title==null || title==""){
            model.addAttribute("error","標題不能為空");
            return "publish";
        }

        if(description==null || description==""){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }

        if(tag==null || tag==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }

//获取用户信息
        User user=null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {//会出现cookies为空指针异常。第一次登陆的时候
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
        }

            if(user==null){
                model.addAttribute("error","用户未登录");
                return "publish";
            }

        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreat(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());
        questionMapper.creat(question);//往数据库中添加question数据

        return "redirect:/";


    }

}
