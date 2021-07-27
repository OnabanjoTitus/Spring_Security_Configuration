//package com.security.security_configurations.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //set my configuration
//        auth.inMemoryAuthentication()
//                .withUser("Titus")
//                .password("Titus")
//                .roles("USER")
//                .and()
//                .withUser("a")
//                .password("a")
//                .roles("ADMIN");
//
//    }
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/security/").permitAll()
//                .antMatchers("/security/admin").hasRole("ADMIN")
//                .antMatchers("/security/user").hasAnyRole("USER","ADMIN")
//                .and().formLogin();
//    }
//}
