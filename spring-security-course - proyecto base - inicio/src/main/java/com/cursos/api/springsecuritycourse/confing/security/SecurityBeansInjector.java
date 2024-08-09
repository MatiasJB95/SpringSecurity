package com.cursos.api.springsecuritycourse.confing.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class SecurityBeansInjector {
    @Bean
   public AuthenticationManager authenticationManager() {
        
    }
}
