package com.sgh000575.smartsociety;

public final class ApiURL {
    //http://192.168.43.204/smartsociety/web/api/user/login.php
    public static String  baseURL = "http://192.168.43.163/Smart-Society/web/api/";
    //api start from here
    public static String API_LOGIN = baseURL+"user/login.php";
    public static String API_REGISTER = baseURL+"user/register.php";
    public static String API_ADD_MEMBER = baseURL+"member/addmember.php";
    public static String API_GET_ALL_MEMBER = baseURL+"member/getmemberhouse.php";
    public static String API_UPD_MEMBER = baseURL+"member/updatemember.php";
    public static String API_DEL_MEMBER = baseURL+"member/deletemember.php";
}
