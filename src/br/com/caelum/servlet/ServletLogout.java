package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.model.Cookies;

@WebServlet(urlPatterns = "/logout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter escreve = response.getWriter();
		Cookie cookie = new Cookies(request).getCookiesDaRequisicao();

		if (cookie == null) {
			escreve.println("<html><body>Usuario não estava logado</body></html>");
		}
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		escreve.println("<html><body>Deslogado com sucesso!</body></html>");

	}

}
