package com.pgiannoukkos.hibernate.controller;

import com.pgiannoukkos.hibernate.dao.UserDAO;
import org.hibernate.HibernateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserRegisterController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName").toLowerCase();
		String password = request.getParameter("password");
		String email = request.getParameter("email").toLowerCase();

		HttpSession session = request.getSession(true);

		try {

			if (UserDAO.userExists(userName, email)) {
				response.sendRedirect("./error.jsp");
			} else {
				UserDAO.createUser(userName, password, email);
				response.sendRedirect("./success.jsp");
			}

		} catch (HibernateException ex) {
			response.getWriter().append(ex.getMessage());
		}
	}
}
