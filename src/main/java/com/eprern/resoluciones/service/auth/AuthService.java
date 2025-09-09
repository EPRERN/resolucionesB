package com.eprern.resoluciones.service.auth;

import com.eprern.resoluciones.model.Usuario;
import com.eprern.resoluciones.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
	
	private final UsuarioRepository usuarioRepository;
	
	public AuthService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Optional<Usuario> login(String username, String password) {
		return usuarioRepository.findByUsername(username)
				.filter(user -> user.getPassword().equals(password)); // ideal: usar BCrypt
	}

}