package br.com.caelum.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.model.Usuario;

public class UsuarioDAO {
	private static Map<String, Usuario> usuarios = new HashMap<>();
	
	static {
		usuarios.put("admin@gmail.com", new Usuario("admin@gmail.com", "321"));
	}
	

	public Usuario buscaPorEmail(String email){
		if(!usuarios.containsKey(email)) {
			//throw new IllegalArgumentException("Usuario não cadastrado!");
			return null;
		}
		
		Usuario usuario = usuarios.get(email);
		return usuario;
	}

}
