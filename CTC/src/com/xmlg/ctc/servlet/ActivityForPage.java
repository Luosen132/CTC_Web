package com.xmlg.ctc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xmlg.ctc.dao.ActivityDAO;
import com.xmlg.ctc.daoimpl.ActivityDAOImpl;
import com.xmlg.ctc.entity.Activity;
import com.xmlg.ctc.service.ActivityService;

public class ActivityForPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ActivityForPage() {
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

         int size=3;//规定每页显示三条数据
		 
		 ActivityDAO activityDAO=new ActivityDAOImpl();
		 //获取数据总量
		 int count=activityDAO.getCount();
		 //总页数
		 int pageCount=((count%size==0)?(count/size):(count/size+1));
		
		// 当前页
		 int page=1;
		
		String str=request.getParameter("page");
		 
		if(str==null||str==""){
			page=1;
		}else{
			//获取传入的当前页数
			page=Integer.valueOf(str);	
		}
		//容错
		page=page<=0?1:page;
		page=page>pageCount?pageCount:page;
		
		
		ActivityService as = new ActivityService();
		List<Activity> list=as.queryAllActivity(page, size);
		
		//将list放入请求域中
		request.setAttribute("list", list);
		
		//将页数放入请求域中
		request.setAttribute("pageCount", pageCount);
		
		//将上一页，下一页的值放入请求域
		int lastpage=page-1;
		//上一页容错
		lastpage=lastpage<=0?1:lastpage;
		
		 //下一页
		int nextpage=page+1;
		//下一页
	    if(nextpage>pageCount){
	    	nextpage=pageCount;
	    }
		
	    request.setAttribute("nextpage", nextpage);
	    request.setAttribute("lastpage", lastpage);
		
	    
	    request.setAttribute("page", page);
		
		//转发(传递请求域中的值)
		request.getRequestDispatcher("Activity.jsp").forward(request, response);
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
