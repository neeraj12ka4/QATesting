package com.sec;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
 
@Configuration
@EnableAuthorizationServer
public class AuthServer extends AuthorizationServerConfigurerAdapter {
 
    @Bean
    public TokenStore tokenStore() {
        InMemoryTokenStore ts = new InMemoryTokenStore();
 
        // Force to generate unique token. Otherwise it generates reusable
        // access token.
        ts.setAuthenticationKeyGenerator(new AuthenticationKeyGenerator() {
 
            @Override
            public String extractKey(OAuth2Authentication authentication) {
                return UUID.randomUUID().toString();
            }
        });
        return ts;
    }
 
    @Autowired
    private AuthenticationManager authenticationManager;
 
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
    }
 
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("web").secret("websecret").scopes("read", "write")
                .accessTokenValiditySeconds(3000)
                .authorizedGrantTypes("password", "refresh_token", "client_credentials");
 
    }
 
}
