package edu.charusat.OAuthDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

        private final CustomOAuth2UserService customOAuth2UserService;

        public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
                System.out.println("✅ SecurityConfig constructor initialized");
                this.customOAuth2UserService = customOAuth2UserService;
        }

        @Bean
        public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/user-info").permitAll()
                                                .anyRequest().authenticated())
                                .oauth2Login(oauth2 -> oauth2
                                                .userInfoEndpoint(userInfo -> {
                                                        System.out.println(
                                                                        "✅ CustomOAuth2UserService is being registered with Spring Security");
                                                        userInfo.userService(customOAuth2UserService);
                                                })
                                                .defaultSuccessUrl("http://localhost:3000/dashboard", true));

                return http.build();
        }

}
