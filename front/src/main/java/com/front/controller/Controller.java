package com.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.viewresolve.ViewResolver;

public interface Controller {
	ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response);
}
