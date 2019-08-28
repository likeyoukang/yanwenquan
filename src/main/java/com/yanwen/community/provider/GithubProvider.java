package com.yanwen.community.provider;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.yanwen.community.dto.AccessTokenDTO;
import com.yanwen.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.provider
 * @create 2019-08-27 20:23
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string=response.body().string();
                String token = string.split("&")[0].split("=")[1];
                System.out.println(string);


                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
        }

     public GithubUser getUser(String accessToken){

         OkHttpClient client = new OkHttpClient();
         Request request = new Request.Builder()
                 .url("https://api.github.com/user?access_token="+accessToken) //忘记加access_tokend导致无法拿到数据。容易忽略的一点。
                 .build();
         try (Response response = client.newCall(request).execute()) {
             String string=response.body().string();
             GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
             return githubUser;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
}


