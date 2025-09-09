package com.eprern.resoluciones.rest;


import com.eprern.resoluciones.model.Usuario;
import com.eprern.resoluciones.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		List<Usuario> usuarios = usuarioService.getAllUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
		Usuario updatedUsuario = usuarioService.updateUsuario(id, usuarioDetails);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
		return ResponseEntity.noContent().build();
	}
}