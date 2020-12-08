package com.front.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.controller.Controller;
import com.front.viewresolve.ViewResolver;

public class BlogController implements Controller{
	private static final String BLOG_JSP = "/WEB-INF/pages/main/blog.jsp";

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
		ViewResolver resolver = new ViewResolver();

		request.setAttribute("blog_post", "Blog Post");
		resolver.forward(BLOG_JSP);
		System.out.println("From: " + this.getClass().getSimpleName());

		return resolver;
	}


}
