package com.eprern.resoluciones.service.auth;

import com.eprern.resoluciones.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    private final UsuarioRepository usuarioRepository;
    
    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    public boolean login(String username, String password) {
        return usuarioRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password)) // acá deberías usar BCrypt
                .orElse(false);
    }
}
