package com.sec;

import java.util.ArrayList;

import javax.servlet.ServletContext;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

 
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    ServletContext ctx;
 
    @Autowired
    UserDAO userDAO;
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("admin").password("1234").roles("USER");
        // auth.inMemoryAuthentication().withUser("agogoi").password("1234").roles("USER");
        auth.authenticationProvider(new AuthenticationProvider() {
 
            @Override
            public boolean supports(Class<?> authentication) {
                // TODO Auto-generated method stub
                return true;
            }
 
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = authentication.getName();
                String password = authentication.getCredentials().toString();
 
                UserVO userVO = userDAO.getUserByUsername(username);
                if (userVO.getPassword().equals(password)) {
 
                    // Set the current logged user.
                    ctx.setAttribute("LOGGED_USER", userVO);
 
                    UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(userVO, password,
                            new ArrayList<>());
                    return u;
                } else {
                    return null;
                }
            }
        });
    }
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
 
    /**
     * Resource server.
     * 
     * @author anupam
     *
     */
    @Configuration
    @EnableResourceServer
    public static class ResourceServer extends ResourceServerConfigurerAdapter {
 
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId("test");
        }
 
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/login").permitAll();
            http.authorizeRequests().antMatchers("/data").authenticated();
        }
 
    }
 
}
