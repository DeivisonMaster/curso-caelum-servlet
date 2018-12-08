package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.model.Cookies;
import br.com.caelum.model.Usuario;

@WebServlet(urlPatterns = "/logout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter escreve = response.getWriter();
		// Cookie cookie = new Cookies(request).getCookiesDaRequisicao();
		
		request.getSession().removeAttribute("usuarioLogado");
		//response.sendRedirect("logout.html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logout.html");
		dispatcher.forward(request, response);
	}

	private void apagaCookieDoUsuario(Cookie cookie, HttpServletResponse response, PrintWriter escreve) {
		if (cookie == null) {
			escreve.println("<html><body>Usuario não estava logado</body></html>");
		}
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

}
