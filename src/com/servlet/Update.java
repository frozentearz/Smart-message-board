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
import com.models.User;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Factory factory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		String updateName=new String(request.getParameter("updatename").getBytes("ISO-8859-1"),"UTF-8");
		String updateSex=new String(request.getParameter("updatesex").getBytes("ISO_8859-1"),"UTF-8");
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
		User u = new User();
		u.setName(updateName);
		u.setPasswd(user.getPasswd());
		u.setSex(updateSex);
		u.setHead(user.getHead());
		u.setUid(user.getUid());
		User returnU = factory.UpdateUser(u);
		System.out.println(returnU);
		if (returnU != null) {
			session.setAttribute("user", returnU);
			response.sendRedirect("MyInfo.jsp");

		} else {
			out.print("<script language='javascript'>alert('Update failed');window.location.href='MyInfo.jsp';</script>");
		}
		
	}

}
