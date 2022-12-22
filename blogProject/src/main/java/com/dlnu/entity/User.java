package com.dlnu.entity;

import java.util.Objects;

public class User {
    private int id;
    private String uname;
    private String pwd;
    private String emil;
    private String imgaddress;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", emil='" + emil + '\'' +
                ", imgaddress='" + imgaddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(uname, user.uname) && Objects.equals(pwd, user.pwd) && Objects.equals(emil, user.emil) && Objects.equals(imgaddress, user.imgaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uname, pwd, emil, imgaddress);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(String imgaddress) {
        this.imgaddress = imgaddress;
    }

    public User(String uname, String pwd, String emil, String imgaddress) {
        this.uname = uname;
        this.pwd = pwd;
        this.emil = emil;
        this.imgaddress = imgaddress;
    }




}
