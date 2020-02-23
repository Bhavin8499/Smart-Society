package com.sgh000575.smartsociety.model;

import org.json.JSONObject;

public class MaintanceModel {

    private String id;
    private String maintanceName;
    private String maintanceDate;
    private String price;
    private String uploaderId;
    private String societyId;

    /**
     * No args constructor for use in serialization
     *
     */
    public MaintanceModel() {
    }

    /**
     *
     * @param uploaderId
     * @param price
     * @param societyId
     * @param id
     * @param maintanceName
     * @param maintanceDate
     */
    public MaintanceModel(String id, String maintanceName, String maintanceDate, String price, String uploaderId, String societyId) {
        super();
        this.id = id;
        this.maintanceName = maintanceName;
        this.maintanceDate = maintanceDate;
        this.price = price;
        this.uploaderId = uploaderId;
        this.societyId = societyId;
    }

    public MaintanceModel(JSONObject obj){
        try {
            this.id = obj.getString("id");
            this.maintanceName = obj.getString("maintance_name");
            this.maintanceDate = obj.getString("maintance_date");
            this.price = obj.getString("price");
            this.uploaderId = obj.getString("uploader_id");
            this.societyId = obj.getString("society_id");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MaintanceModel withId(String id) {
        this.id = id;
        return this;
    }

    public String getMaintanceName() {
        return maintanceName;
    }

    public void setMaintanceName(String maintanceName) {
        this.maintanceName = maintanceName;
    }

    public MaintanceModel withMaintanceName(String maintanceName) {
        this.maintanceName = maintanceName;
        return this;
    }

    public String getMaintanceDate() {
        return maintanceDate;
    }

    public void setMaintanceDate(String maintanceDate) {
        this.maintanceDate = maintanceDate;
    }

    public MaintanceModel withMaintanceDate(String maintanceDate) {
        this.maintanceDate = maintanceDate;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public MaintanceModel withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(String uploaderId) {
        this.uploaderId = uploaderId;
    }

    public MaintanceModel withUploaderId(String uploaderId) {
        this.uploaderId = uploaderId;
        return this;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public MaintanceModel withSocietyId(String societyId) {
        this.societyId = societyId;
        return this;
    }

}
