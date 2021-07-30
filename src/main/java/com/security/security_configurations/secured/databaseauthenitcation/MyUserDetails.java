//package com.security.security_configurations.secured.databaseauthenitcation;
//
//import com.security.security_configurations.secured.model.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//@Slf4j
//public class MyUserDetails implements UserDetails {
//    private String userName;
//    private String password;
//    private boolean active;
//    private List<GrantedAuthority> authorityList;
//
//    public MyUserDetails(Person person){
//        this.userName=person.getUserName();
//        this.password=person.getPassword();
//        this.active=person.isActive();
//        this.authorityList= Arrays.stream(person.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//
//    }
//
//    public MyUserDetails(){
//
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        log.info("The authority list is-->{}",authorityList);
//        return authorityList;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return active;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return active;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return  active;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }
//}
