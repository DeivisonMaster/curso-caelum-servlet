package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.model.Cookies;

@WebFilter(urlPatterns = "/*")
public class ServletFiltroAuditoria implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req =  (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		String usuario = new Cookies(req).getUsuario();
		
		chain.doFilter(req, response);
		
		System.out.println("Usuario " + usuario + " acessando a URI " + uri);
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
