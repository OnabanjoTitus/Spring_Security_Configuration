package com.security.security_configurations.RegisterationController;

import com.security.security_configurations.UserLoginAndRegisterationBackend.AppUser;
import com.security.security_configurations.UserLoginAndRegisterationBackend.AppUserRole;
import com.security.security_configurations.UserLoginAndRegisterationBackend.AppUserService;
import com.security.security_configurations.UserLoginAndRegisterationBackend.ConfirmationToken.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


}
