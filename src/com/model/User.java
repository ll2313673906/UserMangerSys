package com.model;

public class User {
    private int userId;
    private  String userName;
    private String password;
    private String email;
    private String grade;
    private String picture;

    public User(int userId, String userName, String password, String email, String grade, String picture) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.grade = grade;
        this.picture = picture;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
