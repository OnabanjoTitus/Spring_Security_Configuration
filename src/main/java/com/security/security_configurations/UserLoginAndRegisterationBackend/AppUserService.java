package com.security.security_configurations.UserLoginAndRegisterationBackend;

import com.security.security_configurations.UserLoginAndRegisterationBackend.ConfirmationToken.ConfirmationToken;
import com.security.security_configurations.UserLoginAndRegisterationBackend.ConfirmationToken.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Slf4j
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND=
            "user with email %s not found";
    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND,email)));
    }

    public String signUpUser(AppUser appUser){
        boolean userExists=userRepository.findByEmail(appUser.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException("user with this email already exists");
        }
        userRepository.save(appUser);
        String encodedPassword=bCryptPasswordEncoder
                .encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        String token=UUID.randomUUID().toString();
        ConfirmationToken confirmationToken= new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(5),appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public String signUpUser(String email){
        AppUser userExists=userRepository.findAppUserByEmail(email);
        log.info("Request hit here app user found  service and we returned the token-->{}",userExists.getEmail());
        if(userExists.getEmail()!=null){
            String token=UUID.randomUUID().toString();
            ConfirmationToken confirmationToken= new ConfirmationToken(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    userExists
            );
            confirmationTokenService.saveConfirmationToken(confirmationToken);
            log.info("Request hit here app user service and we returned the token-->{}",token);
            return token;
        }else{
            throw new IllegalStateException("user with this email does not exists");
        }


    }

    public void enableAppUser(String email) {
         AppUser appUser=userRepository.findAppUserByEmail(email);
         appUser.setEnabled(true);
         userRepository.save(appUser);
    }
}

