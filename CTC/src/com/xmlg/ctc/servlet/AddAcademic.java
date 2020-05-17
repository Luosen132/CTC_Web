package com.xmlg.ctc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xmlg.ctc.dao.AcademicDAO;
import com.xmlg.ctc.daoimpl.AcademicDAOImpl;
import com.xmlg.ctc.entity.Academic;
import com.xmlg.ctc.util.FileUp;
import com.xmlg.ctc.util.JDBCUtil;
import com.xmlg.ctc.util.RenamePolicyCos;

public class AddAcademic extends HttpServlet {
	
	/**
	 * Constructor of the object.
	 */
	public AddAcademic() {
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
		//设定当前文件上传的目标文件夹
		  String savePath=request.getRealPath("/upload");
		  //设定文件上传的最大容量
		  int maxSize=10*10*1024*1024;	//100M
		  
		  //获取上传的请求对象
		 MultipartRequest mrequest=new MultipartRequest(request, savePath, maxSize, new RenamePolicyCos()); 
		  //通过上传请求对象获取提交的数据
		 
		// String ac_no="1521162132";		 //获取发表人学号
		 String ac_no=mrequest.getParameter("ac_no");		 //获取发表人学号
		 ac_no=new String(ac_no.getBytes("iso-8859-1"),"utf-8");
		 
		 String ac_headline=mrequest.getParameter("ac_headline");		 //获取标题
		 ac_headline=new String(ac_headline.getBytes("iso-8859-1"),"utf-8");
		 
		 String ac_content=mrequest.getParameter("ac_content");//获取内容
		 ac_content=new String(ac_content.getBytes("iso-8859-1"),"utf-8");
		 
		 JDBCUtil util=new JDBCUtil();//获取当前系统时间
		 String ac_date = util.QueryTime();

	
		 
		 String renameFilename="";
		try {
			 renameFilename= FileUp.uploadfiles(mrequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		AcademicDAO dao=new AcademicDAOImpl();
		Academic academic=new Academic();
		academic.setAc_no(ac_no);
		academic.setAcHeadline(ac_headline);
		academic.setAcContent(ac_content);
		academic.setAcFile(renameFilename);
		academic.setAcDate(ac_date);
		request.getSession().setAttribute("academic", academic);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		if(dao.addAcademic(academic)){
			out.print("<script>alert('发表成功，请等待审核！！！');location.href='academicCommunication.jsp';</script>");
		}else{
			out.print("<script>alert('发表失败！！！');history.go(-1);</script>");			
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
