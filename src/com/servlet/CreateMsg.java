package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Factory;
import com.models.*;


/**
 * Servlet implementation class CreateMsg
 */
@WebServlet("/CreateMsg")
public class CreateMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Factory factory;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMsg() {
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
		String message = new String (request.getParameter("message").getBytes("ISO-8859-1"),"UTF-8");
		String time = request.getParameter("time");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Message m = new Message();
		m.setMessage(message);		
		m.setCreator(u);
		m.setCreatetime(time);
		Message mm = factory.createMessage(m);
		if(mm != null) {
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("failed.jsp");			
		}

	}

}
