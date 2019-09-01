package com.yanwen.community.controller;

import com.yanwen.community.dto.AccessTokenDTO;
import com.yanwen.community.dto.GithubUser;
import com.yanwen.community.mapper.UserMapper;
import com.yanwen.community.model.User;
import com.yanwen.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.controller
 * @create 2019-08-27 20:13
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private  String clientId;

    @Value("${github.client.secret}")
    private  String clientSecret;

    @Value("${github.redirect.uri}")
    private  String clientUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,//注意逗号。一直忽略逗号
                            HttpServletRequest request,
                            HttpServletResponse response) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClientId(clientId);
        accessTokenDTO.setClientSecret(clientSecret);
        accessTokenDTO.setRedirectUri(clientUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());
        if(githubUser==null)
            System.out.println("githubUser为空指");
        if(githubUser.getId()==null){
            System.out.println("githubUser.getId()为空");
        }
        System.out.println(githubUser.getName());
        System.out.println(githubUser.getId());
        System.out.println(githubUser.getAvatarUrl());
        System.out.println(githubUser.getBio());
        System.out.println(githubUser.getName());

        if(githubUser!=null){
            //登录成功,写入cookie和session

            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreat(System.currentTimeMillis());
            user.setGmtModified(System.currentTimeMillis());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
           request.getSession().setAttribute("githubUser",githubUser);
            System.out.println(githubUser.getName());
            System.out.println(githubUser.getId());
            System.out.println(githubUser.getAvatarUrl());
            System.out.println(githubUser.getBio());
            System.out.println(githubUser.getName());
           return "redirect:/"; //返回主页
        }
        else{
            //登录失败
            return "redirect:/";//返回主页。返回根目录。
        }

    }

}
