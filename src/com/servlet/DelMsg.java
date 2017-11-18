package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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
import com.models.*;

/**
 * Servlet implementation class DelMsg
 */
@WebServlet("/DelMsg")
public class DelMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Factory factory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMsg() {
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
		PrintWriter out = response.getWriter();
		String strid = new String(request.getParameter("Mid").getBytes("ISO-8859-1"),"UTF-8");
		int mid = Integer.parseInt(strid);
		
		List<Message> list = factory.getMessages();
		for (int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i).getMid());
			if (list.get(i).getMid() == mid) { //如果前台传进来的id值存在于数据库中
				if(factory.DeleteMessage(mid)) {
					response.sendRedirect("MyMsg.jsp");
				} else {
					out.print("<script language='javascript'>alert('Delete failed!');window.location.href='MyMsg.jsp';</script>");
				}
			}
		}
	}
}
