package com.xmlg.ctc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xmlg.ctc.util.*;

import com.xmlg.ctc.dao.PrLetterDAO;
import com.xmlg.ctc.daoimpl.PrLetterDAOImpl;
import com.xmlg.ctc.entity.PrLetter;

public class Add_Prservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8603866552966448479L;

	/**
	 * Constructor of the object.
	 */
	public Add_Prservlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  //设置请求编码
		
		 request.setCharacterEncoding("utf-8");
		  JDBCUtil util = new JDBCUtil();
			//获取提交和内容
		  	int friend_id =8;
			String pr_message=request.getParameter("dope");
			String pr_time = util.QueryTime();
			PrLetter prLetter = new PrLetter(friend_id, pr_message, pr_time, 0);
			PrLetterDAO prLetterDAO = new PrLetterDAOImpl();
			int i = prLetterDAO.addFriendRe(prLetter);
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(i>0){
			out.print("<script>alert('添加成功');location.href='QArticleForPage';</script>");
		}else{
			out.print("<script>alert('添加失败');history.go(-1);</script>");
		}
	   out.flush();
	   out.close();
	
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
