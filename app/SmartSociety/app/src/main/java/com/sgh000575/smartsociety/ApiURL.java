package com.sgh000575.smartsociety;

import com.android.volley.toolbox.StringRequest;

public final class ApiURL {

    public static String  baseURL = "http://192.168.43.55/smartsociety/web/api/";

    //api start from here
    public static String API_LOGIN = baseURL+"user/login.php";

    public static String API_SECUIRY_NEW_MEMBER_COME = baseURL+"security/newpersoncome.php";
    public static String API_GET_ALL_MAINTANCE = baseURL+"maintance/getmaintancedetails.php";

}
