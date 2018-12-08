package br.com.caelum.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/* refatorar */
public class Cookies {
	private HttpServletRequest req;

	public Cookies(HttpServletRequest req) {
		this.req = req;
	}
	
	public String getUsuario() {
		String usuario = "<deslogado>";
		
		Cookie[] cookies = this.req.getCookies();
		if(cookies == null) return usuario;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("usuarioLogado")) {
				usuario = cookie.getValue();
			}
		}
		return usuario;
	}
	
	public Cookie getCookiesDaRequisicao() {
		Cookie[] cookies = this.req.getCookies();
		if(cookies == null) {
			return null;
		}
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("usuarioLogado")) {
				return cookie;
			}
		}
		return null;
	}
}
