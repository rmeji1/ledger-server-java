package com.ledgers.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@Order(0)
public class SecurityConfiguartion extends ResourceServerConfigurerAdapter {

	@Override
    public void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/casinos/**").authenticated();
	}
	
}
