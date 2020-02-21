package com.sgh000575.smartsociety.model;

import android.util.Log;

import org.json.JSONObject;

public class UserModel {
//"user_id": 0,
//        "user_name": "",
//        "email": "san@gmail.com",
//        "phone_no": "",
//        "id": "1",
//        "name": "bhavin sanchaniya",
//        "password": "8a815098ceb5a7a554191f28c10d2940",
//        "phoneno": "849487214",
//        "role": "Admin"
public String user_id;
public String user_name;
public String email;
public String phone_no;
public String id;
public String name;
public String password;
public String phoneno;
public String role;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
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


    public UserModel(JSONObject object) {

        try {
            user_id = object.getString("user_id");
            user_name = object.getString("user_name");
            email = object.getString("email");
            phone_no = object.getString("phone_no");
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
