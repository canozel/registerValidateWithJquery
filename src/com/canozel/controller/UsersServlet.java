package com.canozel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canozel.dao.UserDAO;
import com.canozel.dao.UserDAOImpl;
import com.canozel.model.User;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	
    public UsersServlet() {
        super();
        dao = new UserDAOImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		dao.addUser(user);
		RequestDispatcher view = request.getRequestDispatcher( "index.jsp" );
		request.setAttribute("userEmail", request.getParameter("email"));
        view.forward(request, response);
	}
}
