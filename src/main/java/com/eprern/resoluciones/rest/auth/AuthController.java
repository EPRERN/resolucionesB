package com.eprern.resoluciones.rest.auth;

import com.eprern.resoluciones.model.Usuario;
import com.eprern.resoluciones.service.auth.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // habilita Angular
public class AuthController {
    
    private final AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/login")
    public boolean login(@RequestBody Usuario loginRequest) {
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
