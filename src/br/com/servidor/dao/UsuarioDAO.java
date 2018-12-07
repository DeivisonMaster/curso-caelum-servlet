package br.com.servidor.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.servidor.model.Usuario;

public class UsuarioDAO {
	private static final Map<String, Usuario> usuarios = new HashMap<>();
	
	static {
		usuarios.put("katia@gmail.com", new Usuario("katia@gmail.com", "123"));
		usuarios.put("admin@gmail.com", new Usuario("admin@gmail.com", "321"));
	}
	
	public Usuario buscaPorEmailESenha(String email) {
		if(!usuarios.containsKey(email)) {
			return null;
		}
		
		Usuario usuario = usuarios.get(email);
		if(usuario != null) {
			return usuario;
		}
		return null;
	}

}
