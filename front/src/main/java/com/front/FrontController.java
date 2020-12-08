package com.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.front.controller.Controller;
import com.front.controller.ControllerFactory;
import com.front.viewresolve.ViewResolver;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTROLLER_NAME = "controller";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void processRequest(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		String controllerName = request.getParameter(CONTROLLER_NAME);
		System.out.println(" Controller is: " + controllerName);

		ControllerFactory factory = new ControllerFactory();
		Controller controller = factory.getController(controllerName);
		ViewResolver resolver = controller.resolve(request, response);
		dispatch(request, response, resolver);
	}

	private void dispatch(final HttpServletRequest request, final HttpServletResponse response,
			final ViewResolver resolver) throws ServletException, IOException {

		String view = resolver.getView();
		switch (resolver.getResolveAction()) {
		case FORWARD:
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
			dispatcher.forward(request, response);
			break;
		case REDIRECT:
			response.sendRedirect(view);
			break;

		default:
			break;
		}

	}

}
