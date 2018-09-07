package com.sec;



public interface UserDAO {
 
    UserVO getUserByUsername(String username);
 
    void updateAccessToken(String username, String accessToken);
 
}