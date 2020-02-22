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
