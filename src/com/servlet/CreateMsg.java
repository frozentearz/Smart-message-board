package com.servlet;

import java.io.IOException;
import java.util.Date;

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
        ServletConfig config = getServletConfig();
        ServletContext sc = config.getServletContext();
        this.factory = (Factory) sc.getAttribute("factory");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message=request.getParameter("message");
		String creator=request.getParameter("creator");   //...
		Date createTime=new Date();
		
		Message m=new Message();
		m.setMessage(message);
		m.setCreatetime(createTime);
		//m.setCreator(creator);
		
		if(factory.createMessage(m)!=null) {
			response.sendRedirect("/index.jsp");   //...
		}

	}

}
