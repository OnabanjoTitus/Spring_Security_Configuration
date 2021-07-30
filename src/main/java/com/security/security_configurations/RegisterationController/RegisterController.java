package com.security.security_configurations.RegisterationController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
