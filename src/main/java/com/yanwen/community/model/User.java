package com.yanwen.community.model;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.model
 * @create 2019-08-28 22:27
 */
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
    private Integer column7;
    private Integer column8;
    private Integer column9;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(Long gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getColumn7() {
        return column7;
    }

    public void setColumn7(Integer column7) {
        this.column7 = column7;
    }

    public Integer getColumn8() {
        return column8;
    }

    public void setColumn8(Integer column8) {
        this.column8 = column8;
    }

    public Integer getColumn9() {
        return column9;
    }

    public void setColumn9(Integer column9) {
        this.column9 = column9;
    }
}
