package com.yanwen.community.model;

/**
 * @author likeyou
 * @user 12397
 * @package com.yanwen.community.model
 * @create 2019-08-28 22:27
 */
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtGreat;
    private Long gmtModified;
    private int column7;
    private int column8;
    private int column9;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Long getGmtGreat() {
        return gmtGreat;
    }

    public void setGmtGreat(Long gmtGreat) {
        this.gmtGreat = gmtGreat;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getColumn7() {
        return column7;
    }

    public void setColumn7(int column7) {
        this.column7 = column7;
    }

    public int getColumn8() {
        return column8;
    }

    public void setColumn8(int column8) {
        this.column8 = column8;
    }

    public int getColumn9() {
        return column9;
    }

    public void setColumn9(int column9) {
        this.column9 = column9;
    }
}
