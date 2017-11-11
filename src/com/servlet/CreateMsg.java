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

import com.controller.Factory;
import com.models.Message;

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
		String message=request.getParameter("message");
//		String creator=request.getParameter("creator");   //...
		String creatorId_s=request.getParameter("creatorId");   //...
		int creatorId=Integer.parseInt(creatorId_s);
		Date createTime = new Date(System.currentTimeMillis());
		
		Message m=new Message();
		m.setMessage(message);
		m.setCreatetime(createTime);
		m.setCreator(factory.getUserProfile(creatorId));
		
		if(factory.createMessage(m)!=null) {
			response.sendRedirect("index.jsp");
		}

	}

}
