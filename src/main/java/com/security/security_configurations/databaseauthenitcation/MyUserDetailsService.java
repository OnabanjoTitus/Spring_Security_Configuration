package com.security.security_configurations.databaseauthenitcation;

import com.security.security_configurations.model.Person;
import com.security.security_configurations.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Person>user=userRepository.findByUserName(userName);
        user.orElseThrow(()->new UsernameNotFoundException("UserNot found"+userName));
      log.info("WE found the user -->{}",user);
        return user.map(MyUserDetails::new).get();

    }
}
