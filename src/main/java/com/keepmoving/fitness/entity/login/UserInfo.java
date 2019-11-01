package com.keepmoving.fitness.entity.login;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserInfo implements Serializable {

    private Integer id;

    private Long userId;

    private String username;

    private String phone;

    private String password;

    //手机号是否验证
    private int verify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public UserInfo(Integer id, Long userId, String username, String phone, String password) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfo{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", username='").append(username).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }

}