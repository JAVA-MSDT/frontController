package com.front.controller;

import com.front.view.AboutController;
import com.front.view.BlogController;
import com.front.view.NewsController;

public class ControllerFactory {

	public ControllerFactory() {

	}

	public Controller getController(final String controllerName) {

		switch (controllerName) {
		case "news":
			return new NewsController();
		case "about":
			return new AboutController();
		case "blog":
			return new BlogController();
		default:
		}
		return null;
	}
}
