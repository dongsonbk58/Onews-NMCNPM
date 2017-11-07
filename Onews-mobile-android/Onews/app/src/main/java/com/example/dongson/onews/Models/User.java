package com.example.dongson.onews.Models;

import java.io.Serializable;

/**
 * Created by Dong Son on 01-Nov-17.
 */

public class User implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String age;
    private String face_id;
    private String google_id;
    private String created_time;
    private String role;

    public User(Integer id, String username, String password, String gender, String age, String face_id, String google_id, String created_time, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.face_id = face_id;
        this.google_id = google_id;
        this.created_time = created_time;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    public String getGoogle_id() {
        return google_id;
    }

    public void setGoogle_id(String google_id) {
        this.google_id = google_id;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", face_id='" + face_id + '\'' +
                ", google_id='" + google_id + '\'' +
                ", created_time='" + created_time + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
