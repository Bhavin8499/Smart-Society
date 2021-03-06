package com.sgh000575.smartsociety;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.sgh000575.smartsociety.model.UserModel;

import org.json.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SIModel {
    private static SIModel ourInstance;

    static  private  String NORMAL_PREF = "normalprefrence";
    private static SharedPreferences sharedPreferences;
    private UserModel currentUser;
    static private String CURRENT_USER_KEY = "loggedinuser";
    static private String CURRENT_FLATS_KEY = "flats";

    public static void init(Context context){
        ourInstance = new SIModel(context);
    }

    public static SIModel getInstance() {
        return ourInstance;
    }

    public SIModel(Context context) {
        sharedPreferences = context.getSharedPreferences(NORMAL_PREF, Context.MODE_PRIVATE);
    }

    public void saveUser(UserModel model){

        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String str =  gson.toJson(model);
        editor.putString(CURRENT_USER_KEY,str);
        editor.commit();

        currentUser = model;
    }

    public UserModel isUserAvaliable(){
        String str = sharedPreferences.getString(CURRENT_USER_KEY, null);

        if(str == null){
            return null;
        }

        Gson gson = new Gson();

        UserModel model = gson.fromJson(str, UserModel.class);

        if(model == null)
            return null;

        return model;

    }

    public UserModel getUser(){
        String str = sharedPreferences.getString(CURRENT_USER_KEY, null);

        if(str == null){
            return null;
        }

        Gson gson = new Gson();

        currentUser = gson.fromJson(str, UserModel.class);
        return currentUser;
    }

    public void logoutUser(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(CURRENT_USER_KEY);
        editor.commit();

    }


    public void storeFlatDetails(JSONArray jsonArray){
        Gson gson = new Gson();
        String json = gson.toJson(jsonArray);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(CURRENT_FLATS_KEY,json);
        editor.commit();

    }

    public JSONArray getFlatDetails(){

        String str = sharedPreferences.getString(CURRENT_FLATS_KEY, null);

        if(str != null){
            JSONArray arr = new Gson().fromJson(str, JSONArray.class);
            return arr;
        }

        return null;
    }



}
