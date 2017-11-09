package com.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Factory;
import com.models.User;;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Factory factory;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
        ServletConfig config = getServletConfig();
        ServletContext sc = config.getServletContext();
        this.factory = (Factory) sc.getAttribute("factory");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");         //前端表单 name 值
		String password = request.getParameter("password");    //前端表单 password 值
		String sex = request.getParameter("sex");              //前端表单 sex 值
		
		User u = new User();
		u.setName(name);
		u.setPasswd(password);
		u.setSex(sex);
		factory.registerUser(u);
		
		response.sendRedirect("/login.jsp");
	}

}
