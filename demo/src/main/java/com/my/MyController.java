package com.my;


import java.util.Map;
 
import javax.servlet.ServletContext;
 
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sec.UserVO;

 
@RestController
public class MyController {
 
    @Autowired
    TokenStore tokenStore;
 
    @Autowired
    ServletContext ctx;
 
    @Autowired
    UserDAO userDAO;
 
    @RequestMapping(path = "/data", method = RequestMethod.POST)
    public @ResponseBody String getData(@RequestBody String params) {
        return "You have successfully accessed the service with the access token.";
    }
 
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Map<?, ?> doLogin(@RequestBody Map<String, Object> params) throws Exception {
 
        String username = (String) params.get("username");
        String password = (String) params.get("password");
 
        // Get the access token for the currently successful logged in user.
        // This method call sets the logged user in a context attribute in the
        // {@link AppSecurityConfig} class.
        Map<?, ?> map = getAccessToken(username, password);
 
        // Get logged user from the context.
        UserVO loggedUser = (UserVO) ctx.getAttribute("LOGGED_USER");
 
        // Now revoke the access token he is holding.
        // This means that if the user is logged in in some browser, he will no
        // longer be able to access
        // the secure REST services as we are deleting his access token.
        if (loggedUser.getAccess_token() != null && !loggedUser.getAccess_token().equals("")) {
            revokeAccessToken(loggedUser.getAccess_token());
        }
 
        // Now update the user with the new access token.
        loggedUser.setAccess_token((String) map.get("access_token"));
 
        // We do not need any information of the logged in user.
        // So delete this information for the context attribute.
        ctx.removeAttribute("LOGGED_USER");
 
        return map;
    }
 
    private Map<?, ?> getAccessToken(String username, String password) throws Exception {
        String authUrl = "http://localhost:8080/app/oauth/token?";
        StringBuilder authParams = new StringBuilder("client_id=web&client_secret=websecret&grant_type=password");
        authParams.append("&username=").append(username).append("&password=").append(password);
 
        String url = authUrl.concat(authParams.toString());
        ResponseEntity<String> response = new TestRestTemplate("web", "websecret").postForEntity(url, null,
                String.class);
        String responseText = response.getBody();
 
        Map<?, ?> map = new ObjectMapper().readValue(responseText, Map.class);
        return map;
    }
 
    private void revokeAccessToken(String token) {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        if (accessToken != null) {
            tokenStore.removeAccessToken(accessToken);
        }
    }
 
}
