package com.yanwen.community.model;


import lombok.Data;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.model
 * @create 2019-08-29 20:51
 */
//data标签。lombok中提供getter和setter方法和tostring方法
    //https://projectlombok.org/features/all
    //lombok网址。详情见网址
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private Long gmtCreat;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}