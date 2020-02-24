package com.sgh000575.smartsociety.model;

import android.util.Log;

import org.json.JSONObject;

public class UserModel {

    public String user_id;
    public String id;
    public String name;
    public String email;
    public String password;
    public String phoneno;
    public String role;
    public String society_id;
    public String society_code;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return name;
    }

    public void setUser_name(String user_name) {
        this.name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phoneno;
    }

    public void setPhone_no(String phone_no) {
        this.phoneno = phone_no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSociety_id(String society_id) {
        this.society_id = society_id;
    }

    public String getSociety_id() {
        return society_id;
    }

    public UserModel(JSONObject object) {

        try {
            user_id = object.getString("user_id");
            society_id = object.getString("society_id");
            email = object.getString("email");
            society_code = object.getString("society_code");
            id = object.getString("id");
            name = object.getString("name");
            password = object.getString("password");
            phoneno = object.getString("phoneno");
            role = object.getString("role");
        }
        catch (Exception e){
            Log.d("SocietyError", e.getMessage());
        }

    }
}
