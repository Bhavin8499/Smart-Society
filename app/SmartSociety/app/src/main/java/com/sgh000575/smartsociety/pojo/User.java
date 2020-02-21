package com.sgh000575.smartsociety.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class User{

	@SerializedName("data")
	private User data;

	@SerializedName("status")
	private boolean status;

	@SerializedName("phone_no")
	private String phoneNo;

	@SerializedName("password")
	private String password;

	@SerializedName("role")
	private String role;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private String email;

	@SerializedName("phoneno")
	private String phoneno;

	public void setData(User data){
		this.data = data;
	}

	public User getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo(){
		return phoneNo;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPhoneno(String phoneno){
		this.phoneno = phoneno;
	}

	public String getPhoneno(){
		return phoneno;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			",phone_no = '" + phoneNo + '\'' + 
			",password = '" + password + '\'' + 
			",role = '" + role + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_name = '" + userName + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",phoneno = '" + phoneno + '\'' + 
			"}";
		}
}