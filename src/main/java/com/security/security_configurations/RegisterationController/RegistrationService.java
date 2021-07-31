package com.security.security_configurations.RegisterationController;

import com.security.security_configurations.UserLoginAndRegisterationBackend.AppUser;
import com.security.security_configurations.UserLoginAndRegisterationBackend.AppUserRole;
import com.security.security_configurations.UserLoginAndRegisterationBackend.AppUserService;
import com.security.security_configurations.UserLoginAndRegisterationBackend.ConfirmationToken.ConfirmationToken;
import com.security.security_configurations.UserLoginAndRegisterationBackend.ConfirmationToken.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Slf4j
@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest request) {
      boolean isValidEmail=  emailValidator.test(request.getEmail());
      if(!isValidEmail){
          throw new IllegalArgumentException("Email not valid");
      }
        return appUserService.signUpUser(new AppUser(
                request.getFirstName(),request.getLastName(),
                request.getEmail(),request.getPassword(),
                AppUserRole.USER
        ));

    }

    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }
        log.info("The token found is  -->{}",confirmationToken);
        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());

        return "confirmed";
    }

    public String regenerateToken(String email) {
        log.info("Request hit here Registration service-->{}",email);
        return appUserService.signUpUser(email);
    }
}
