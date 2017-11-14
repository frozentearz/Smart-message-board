package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Factory;
import com.models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Factory factory; 
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
    
    /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    String name =new String( request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8" );
	    String password = request.getParameter("password");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    User u = factory.login(name, password);
	    if (u != null) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("user", u);
	    	response.sendRedirect("index.jsp");
	    } else {
	    	out.print("<script language='javascript'>alert('Username or password Wrong!');window.location.href='login.jsp';</script>");
	    }
    }
}
