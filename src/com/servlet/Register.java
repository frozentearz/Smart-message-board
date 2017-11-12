package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    }
    
    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
    	ServletContext sc = config.getServletContext();
        this.factory = (Factory) sc.getAttribute("factory");
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = new String( request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");         //前端表单 name 值
		String password = request.getParameter("password");    //前端表单 password 值
		String sex = request.getParameter("sex");              //前端表单 sex 值
		request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
		User u = new User();
		u.setName(name);
		u.setPasswd(password);
		u.setSex(sex);
		int random=(new Random()).nextInt(10)+1;
		u.setHead("img\\avatar\\avatar_0"+random+".jpg");
		User ReturnU = factory.registerUser(u);
		System.out.println(ReturnU);
		if (ReturnU != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect("index.jsp");
		} else {
			out.print("<script language='javascript'>alert('The user name has been registered');window.location.href='signup.jsp';</script>");
		}
		
		
	}

}
