package com.eprern.resoluciones.service;


import com.eprern.resoluciones.model.Usuario;
import com.eprern.resoluciones.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario not found with id " + id));
	}
	
	public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario not found with id " + id));
		BeanUtils.copyProperties(usuarioDetails, usuario, "id");
		
		return usuarioRepository.save(usuario);
	}
	
	public void deleteUsuario(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario not found with id " + id));
		usuarioRepository.delete(usuario);
	}
}