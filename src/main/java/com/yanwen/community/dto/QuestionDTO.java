package com.yanwen.community.dto;

import com.yanwen.community.model.User;
import lombok.Data;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.dto
 * @create 2019-08-30 20:27
 */
@Data
public class QuestionDTO {
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
    private User user;
    //比Question类多加了一个User类
}
