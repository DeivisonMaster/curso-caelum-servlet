package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.EmpresaDAO;
import br.com.caelum.model.Empresa;

@WebServlet(urlPatterns = "/buscaEmpresa")
public class ServletBuscaEmpresa extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filtro = request.getParameter("filtro");
		Collection<Empresa> empresas = this.buscaEmpresaPorFiltro(filtro);
		
		request.setAttribute("listaEmpresas", empresas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/novaEmpresa.jsp");
		dispatcher.forward(request, response);
	}


	private Collection<Empresa> buscaEmpresaPorFiltro(String filtro) {
		Collection<Empresa> empresas = new ArrayList<>();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresas = empresaDAO.buscaPorFiltro(filtro);
		
		return empresas;
	}
}
