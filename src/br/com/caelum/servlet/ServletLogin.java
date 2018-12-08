package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.UsuarioDAO;
import br.com.caelum.model.Usuario;

@WebServlet(urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter escreve = resp.getWriter();

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscaPorEmail(email);
		if (usuario == null) {
			escreve.println("<html><body><h2> Usuario não encontrado! </h2></body></html>");
		} else {
			escreve.println("<html><body><h2> Usuario logado!</h2>" + usuario.getEmail() + "</body></html>");
			Cookie cookie = new Cookie("usuarioLogado", usuario.getEmail());
			resp.addCookie(cookie);
		}
	}
}
