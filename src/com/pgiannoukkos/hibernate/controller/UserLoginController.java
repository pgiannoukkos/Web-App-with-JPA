package com.pgiannoukkos.hibernate.controller;

import com.pgiannoukkos.hibernate.dao.UserDAO;
import org.hibernate.HibernateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName").toLowerCase();
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);

		try {

			if (UserDAO.checkUserLogin(userName, password)) {
				request.setAttribute("message", "Wrong username or password!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.setAttribute("username", userName);
				getServletContext().getRequestDispatcher("/hello.jsp").forward(request, response);
			}

		} catch (HibernateException ex) {
			response.getWriter().append(ex.getMessage());
		}
	}
}
