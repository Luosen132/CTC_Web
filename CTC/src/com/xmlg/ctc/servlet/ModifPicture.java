package com.xmlg.ctc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.xmlg.ctc.dao.UserDAO;
import com.xmlg.ctc.daoimpl.UserDAOImpl;
import com.xmlg.ctc.entity.User;
import com.xmlg.ctc.util.FileUp;
import com.xmlg.ctc.util.RenamePolicyCos;


public class ModifPicture extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ModifPicture() {
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
		int maxSize=10*10*1024*1024;
		//获取上传请求对象
            MultipartRequest mrequest = new MultipartRequest(request,savePath, maxSize, new RenamePolicyCos());
         
            String userno = mrequest.getParameter("userno");
           
            String renameFilename = "";
            
           try {
			renameFilename = FileUp.uploadfiles(mrequest) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User(userno,renameFilename); 
      
        UserDAO userDao = new UserDAOImpl();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        if (userDao.modifyPicture(user)) {
			out.print("<script>alert('上传成功');location.href='modifyperson.jsp';</script>");
		}else {
			out.print("<script>alert('上传失败');history.go(-1);</script>");
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
