package com.security.security_configurations.RegisterationController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("api/v1/register")
@AllArgsConstructor
public class RegisterController {
    private RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    };
    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable("id") String token) {
        return registrationService.confirmToken(token);
    }
    @PostMapping("/regenerate/{email}")
    public String regenerate(@PathVariable("email") String email){
        log.info("Request hit here controller-->{}",email);
       return registrationService.regenerateToken(email);
    }


}
