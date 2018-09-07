package com.sec;

public class UserVO {
	 
    String username, password, role, access_token;
 
    public UserVO(String username, String password, String role) {
        super();
        this.username = username;
        this.password = password;
        this.role = role;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
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
 
    public String getAccess_token() {
        return access_token;
    }
 
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
 
}
