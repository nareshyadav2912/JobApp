package com.example.spring_rest.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customiser->customiser.disable());
        httpSecurity.authorizeHttpRequests(request->request.anyRequest().authenticated());
        //httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1= User.withDefaultPasswordEncoder()
//                                        .username("naresh")
//                                        .password("1234")
//                                        .roles("USER")
//                                        .build();
//        UserDetails user2= User.withDefaultPasswordEncoder()
//                .username("suresh")
//                .password("1234")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        return provider;
    }

}
