package br.com.servidor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.com.servidor.model.Empresa;

public class EmpresaDAO {
	private static final Map<Long, Empresa> empresas = new HashMap<>();

	static {
		geraIdEAdiciona(new Empresa("Doceria bela vista"));
		geraIdEAdiciona(new Empresa("Ferragens Doces"));
		geraIdEAdiciona(new Empresa("Doce de banana"));
		geraIdEAdiciona(new Empresa("Google"));
		geraIdEAdiciona(new Empresa("Alura"));
		geraIdEAdiciona(new Empresa("Casa do codigo"));
	}
	
	public Collection<Empresa> buscaPorSimilaridade(String nome){
		if(nome == null || nome.equals(" ")) {
			return empresas.values();
		}else {
			List<Empresa> lista = new LinkedList<>();
			
			for(Empresa empresa : empresas.values()) {
				if(empresa.getNome().toLowerCase().contains(nome.toLowerCase())) {
					lista.add(empresa);
				}
			}
			return lista;
		}
	}
	
	public void adiciona(Empresa empresa) {
		geraIdEAdiciona(empresa);
	}
	
	public Empresa buscaPorId(String id) {
		if(id == null) {
			return null;
		}
		Empresa empresa = empresas.get(new Long(id));
		
		return empresa;
	}

	private static void geraIdEAdiciona(Empresa empresa) {
		Long id =  empresas.size() + 1L;
		empresa.setId(id);
		empresas.put(id, empresa);
	}
	
}















