package com.xdf.pojo;

import java.io.Serializable;

/**
 * 用户的实体类
 */
public class Users implements Serializable{

     private  int  id;  //主键 id
     private   String   userName;
     private   String   password;

    public Users() {
    }

    public Users(int id, String userName, String password) {

        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Users(int i) {
        this.id=i;
    }

    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
