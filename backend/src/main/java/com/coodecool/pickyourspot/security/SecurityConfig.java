package com.coodecool.pickyourspot.security;

import com.coodecool.pickyourspot.config.JwtAuthenticationFilter;
import com.coodecool.pickyourspot.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/api/login", "/api/registration").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login", "/api/registration", "/api/table/free-tables").permitAll()
                .antMatchers(HttpMethod.POST, "/reservation").hasAuthority(Role.USER.name())
                .antMatchers(HttpMethod.DELETE, "/reservation").hasAuthority(Role.USER.name())
                .antMatchers(HttpMethod.GET, "/api/user").hasAuthority(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // FIXME: Is this a no-op?
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
