package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

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
		PrintWriter escreve = response.getWriter();
		
		escreve.println("<html>");
		escreve.println("<head>");
		escreve.println("<title>");
		escreve.println("Busca Empresa");
		escreve.println("</title>");
		escreve.println("</head>");
		escreve.println("<body>");
		escreve.println("Resultado da busca: " );
		escreve.println("<ul>");
		
		String filtro = request.getParameter("filtro");
		buscaEmpresaPorFiltro(escreve, filtro);
		
		escreve.println("</ul>");
		escreve.println("</body>");
		escreve.println("</html>");
	}

	private void buscaEmpresaPorFiltro(PrintWriter escreve, String filtro) {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> empresas = empresaDAO.buscaPorFiltro(filtro);
		for(Empresa empresa : empresas) {
			escreve.println("<li>" + "Id: " + empresa.getId() + "Nome: " + empresa.getNome() + "</li>");
		}
	}
}
