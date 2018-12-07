package br.com.caelum.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.model.Empresa;

public class EmpresaDAO {
	/* simulação de um BD */
	private static Map<Long, Empresa> empresas = new HashMap<>();
	
	static {
		geraIdEAdiciona(new Empresa("Doceria bela vista"));
		geraIdEAdiciona(new Empresa("Ferragens Doces"));
		geraIdEAdiciona(new Empresa("Doce de banana"));
		geraIdEAdiciona(new Empresa("Google"));
		geraIdEAdiciona(new Empresa("Alura"));
		geraIdEAdiciona(new Empresa("Casa do codigo"));
	}
	
	public Collection<Empresa> buscaPorFiltro(String parametro) {
		if(parametro == null || parametro.equals(" ")) {
			return empresas.values();
		}
		
		List<Empresa> lista = new ArrayList<>();
		for(Empresa empresa : empresas.values()) {
			if(empresa.getNome().toLowerCase().contains(parametro)) {
				lista.add(empresa);
			}
		}
		return lista;
	}
	
	public void adiciona(Empresa empresa) {
		geraIdEAdiciona(empresa);
	}
	
	private static void geraIdEAdiciona(Empresa empresa) {
		Long id = empresas.size() + 1L;
		empresa.setId(id);
		empresas.put(id, empresa);
	}
	
	
}













