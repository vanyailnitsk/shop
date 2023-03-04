package com.vanyailnitsk.store.configs;

import com.vanyailnitsk.store.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/profile/**").hasRole("USER")
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/","/login","/registration","/catalog").permitAll()
                                .anyRequest().permitAll())
//                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/profile")
//                        .and())//successForwardUrl("/profile"))
//                .logout().logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
