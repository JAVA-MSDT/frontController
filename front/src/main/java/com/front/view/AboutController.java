package com.front.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.controller.Controller;
import com.front.viewresolve.ViewResolver;

public class AboutController implements Controller{

	private static final String ABOUT_JSP = "/WEB-INF/pages/main/about.jsp";

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
		ViewResolver resolver = new ViewResolver();

		resolver.forward(ABOUT_JSP);
		System.out.println("From: " + this.getClass().getSimpleName());

		return resolver;
	}


}
