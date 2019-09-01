package com.yanwen.community.dto;

import lombok.Data;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.dto
 * @create 2019-08-27 20:25
 */
@Data
public class AccessTokenDTO {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String state;

}
