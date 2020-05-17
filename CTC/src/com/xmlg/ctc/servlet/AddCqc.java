package com.xmlg.ctc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.action.PutAllAction;

import com.oreilly.servlet.MultipartRequest;
import com.sun.jndi.cosnaming.IiopUrl.Address;
import com.xmlg.ctc.dao.CqcDAO;
import com.xmlg.ctc.daoimpl.CqcDAOImpl;
import com.xmlg.ctc.entity.Cqc;
import com.xmlg.ctc.util.FileUp;
import com.xmlg.ctc.util.JDBCUtil;
import com.xmlg.ctc.util.RenamePolicyCos;



/**
 * 
 * @author 饶金鑫
 * @since 2018-1-14 13:07:09
 */

public class AddCqc extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCqc() {
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
		//设定当前文件上传的目标文件夹
		String savePath=request.getRealPath("/upload");
		//设定文件上传的最大容量
		int maxSize=10*10*1024*1024;
		//获取上传请求对象
            MultipartRequest mrequest = new MultipartRequest(request,savePath, maxSize, new RenamePolicyCos());
         
            
            //通过上传请求对象获取提交的数据, 修改编码方式
            String stuid = mrequest.getParameter("stuid");
            String tel = mrequest.getParameter("tel");
            String birthday = mrequest.getParameter("birthday");
            String address = mrequest.getParameter("address");
            address = new String(address.getBytes("iso-8859-1"),"utf-8");
            int singleState = Integer.parseInt(mrequest.getParameter("singleState"));
            String email = mrequest.getParameter("email");
            String picture = mrequest.getParameter("picture");
            String renameFilename = "";
            
           try {
			renameFilename = FileUp.uploadfiles(mrequest) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CqcDAO cqcDAO = new  CqcDAOImpl();
        Cqc cqc = new Cqc();
        cqc.setStuid(stuid);
        cqc.setCqcTel(tel);
        cqc.setCqcBirthday(birthday);
        cqc.setCqcAddress(address);
        cqc.setSingleState(singleState);
        cqc.setCqcEmail(email);
        cqc.setCqcPicture(renameFilename);
        
        request.getSession().setAttribute("cqc", cqc);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        if (cqcDAO.addCqc(cqc)) {
			out.print("<script>alert('报名成功');location.href='Cqc.jsp';</script>");
		}else {
			out.print("<script>alert('报名失败');history.go(-1);</script>");
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
