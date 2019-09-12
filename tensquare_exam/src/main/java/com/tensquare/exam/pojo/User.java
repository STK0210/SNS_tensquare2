package com.tensquare.exam.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 *
 * @author Administrator
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private String id;//id号

    private String username;//用户的名字
    private String password;//密码
    private String registdata;//注册的数据
    private Integer role;//角色，-1为管理员，1为用户

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistdata() {
        return registdata;
    }

    public void setRegistdata(String registdata) {
        this.registdata = registdata;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registdata='" + registdata + '\'' +
                ", role=" + role +
                '}';
    }
}
