package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.EmpresaDAO;
import br.com.caelum.model.Empresa;

@WebServlet(urlPatterns = "/novaEmpresa")
public class ServletNovaEmpresa extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.adiciona(empresa);
		
		PrintWriter escreve = response.getWriter();
		escreve.println("<html><body> " + "Nome da empresa: " + empresa.getNome() + "</body></html>");
	}
	
}
