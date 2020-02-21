package com.sgh000575.smartsociety.pojo;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("status")
    private boolean status;
    @SerializedName("data")
    private String data;

}
