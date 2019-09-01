package com.yanwen.community.model;

import lombok.Data;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.model
 * @create 2019-08-28 22:27
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
    private String avatarUrl;
    private Integer column8;
    private Integer column9;

}
