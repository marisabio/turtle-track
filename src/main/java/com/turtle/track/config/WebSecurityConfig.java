package com.turtle.track.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain habilitarSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->  // spring security bloqueia todos as paginas e endpoints
                        requests.requestMatchers("/","/home") //libera para usuarios nao logas / e /home
                                .permitAll().anyRequest().authenticated()) //demais paginas e endpoints precisam estar logads
                .formLogin((form) ->
                        form.loginPage("/login").permitAll()
                )
                .logout((logout) ->
                        logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService criarUserDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
