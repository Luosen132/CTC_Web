package com.xmlg.ctc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUserCheckYan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddUserCheckYan() {
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

		String my=request.getParameter("check");
		
		HttpSession session=request.getSession();
		String computer=(String) session.getAttribute("rand");
		
        String u_no=request.getParameter("u_no");
        String u_name=request.getParameter("u_name");
        u_name =new String(u_name.getBytes("iso-8859-1"),"utf-8");
        String u_realname=request.getParameter("u_realname");
        u_realname =new String(u_realname.getBytes("iso-8859-1"),"utf-8");
		String u_password=request.getParameter("u_password");
		String u_password2=request.getParameter("u_password2");
		int u_school=Integer.parseInt(request.getParameter("u_school"));
		int u_college=Integer.parseInt(request.getParameter("u_college")); 
		String u_IDcard=request.getParameter("u_IDcard");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(my.equals(computer)){
			out.print("<script>alert('验证成功');</script>");
			
			String uNo1="u_school";
			request.setAttribute("u_school", uNo1);
			
			String uName1="u_no";
			request.setAttribute("u_no", uName1);
			
			String uRealname1="u_password";
			request.setAttribute("u_password", uRealname1);
			
			String uPassword1="u_password";
			request.setAttribute("u_password", uPassword1);
		
			String uPassword3="u_password";
			request.setAttribute("u_password", uPassword3);
			
			String uSchool1="u_password";
			request.setAttribute("u_password", uSchool1);
			
			String uCollege1="u_password";
			request.setAttribute("u_password", uCollege1);

			String uIdcard1="u_password";			
			request.setAttribute("u_password", uIdcard1);

			request.getRequestDispatcher("addUser2.jsp").forward(request, response);
			
		}else{
			out.print("<script>alert('验证失败'); history.go(-1);</script>");
		}
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
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
