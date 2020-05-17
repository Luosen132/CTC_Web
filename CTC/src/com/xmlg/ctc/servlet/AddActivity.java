package com.xmlg.ctc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xmlg.ctc.dao.ActivityDAO;
import com.xmlg.ctc.daoimpl.ActivityDAOImpl;
import com.xmlg.ctc.entity.Activity;


public class AddActivity extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddActivity() {
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

               request.setCharacterEncoding("utf-8");
		
               String perid = request.getParameter("perid");
               String title = request.getParameter("title");
               String type = request.getParameter("type");
               String content = request.getParameter("content");
               String time = request.getParameter("time");
              int activitynum = Integer.parseInt(request.getParameter("activitynum"));
		 
              ActivityDAO activityDAO = new ActivityDAOImpl();
              Activity a = new Activity();
              a.setActPerid(perid);
              a.setActTitle(title);
              a.setActType(type);
              a.setActContent(content);
              a.setActTime(time);
              a.setActMaxnum(activitynum);
              
              request.getSession().setAttribute("a",a);
              response.setContentType("text/html;charset=utf-8");
              PrintWriter out = response.getWriter();
              
              if (activityDAO.addActivity(a)) {
      			out.print("<script>alert('添加成功');location.href='ActivityForPage?page=1';</script>");
      		}else {
      			out.print("<script>alert('添加失败');history.go(-1);</script>");
      		}
              out.flush();
              out.close();
	}

	private int Integer(String parameter) {
		// TODO Auto-generated method stub
		return 0;
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
