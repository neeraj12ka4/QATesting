package com.sec;

import java.util.HashMap;
import java.util.Map;
 
import javax.annotation.PostConstruct;
 
import org.springframework.stereotype.Repository;
 

 
@Repository
public class UserDAOImpl implements UserDAO {
 
    private static Map<String, UserVO> mapUsers;
 
    @PostConstruct
    public void init() {
        mapUsers = new HashMap<>();
        mapUsers.put("admin", new UserVO("admin", "1234", "ADMIN"));
        mapUsers.put("agogoi", new UserVO("agogoi", "1234", "ADMIN"));
    }
 
    @Override
    public UserVO getUserByUsername(String username) {
        UserVO user = mapUsers.get(username);
        return user;
    }
 
    @Override
    public void updateAccessToken(String username, String accessToken) {
        UserVO user = mapUsers.get(username);
        if (user != null) {
            user.setAccess_token(accessToken);
        }
    }
}
