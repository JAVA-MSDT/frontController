package com.front.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.controller.Controller;
import com.front.viewresolve.ViewResolver;

public class NewsController implements Controller {

	private static final String NEWS_JSP = "/WEB-INF/pages/main/news.jsp";

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
		ViewResolver resolver = new ViewResolver();

		resolver.forward(NEWS_JSP);
		System.out.println("From: " + this.getClass().getSimpleName());
		return resolver;
	}
}
