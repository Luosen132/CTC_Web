package com.xmlg.ctc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCUtil {
	//用户名
	private final static String NAME="root";
	//密码
	private final static String PWD="123";
	//驱动语句
	private final static String DRIVER="com.mysql.jdbc.Driver";
	//连接语句
	private final static String PATH="jdbc:mysql://127.0.0.1:3306/ctc?useUnicode=true&characterEncoding=UTF-8";
	//连接对象
	private Connection con;
	//预编译语句对象
	private PreparedStatement ps;
	//结果集
	private ResultSet rs;
	
/**
 * 获取数据库连接对象
 * @return  数据连接对象
 */
	public Connection getCon(){
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(PATH, NAME, PWD);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	/**
	 * 关闭数据库所有操作对象的方法
	 */
	public void closeAll(){	
		try {
			if(rs!=null){
				rs.close();
			}	
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (Exception e2) {
		e2.printStackTrace();
		}	
	}
	
	
	
	/**
	 * 增删改通用方法
	 * @param sql  sql语句
	 * @param obj  需要传入的参数
	 * @return     受影响行数
	 * JDK1.5之后允许使用动态传参
	 */
	public int update(String sql,Object...obj){
		int result=0;
		try {
			con=getCon();
			ps=con.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
		result=ps.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}	
		return result;
	}
	
	/**
	 * 查询的方法
	 * @param sql  sql语句
	 * @param obj  参入的参数
	 * @return     结果集
	 */
	public ResultSet query(String sql,Object...obj){
		try {
			con=getCon();
			ps=con.prepareStatement(sql);
			if(obj!=null){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	/**
	 * 获取当前系统时间
	 * @return
	 */
	public String QueryTime(){

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = format.format(date);
		return time;
		
	}
	/**
	 * 判断单身
	 * @param x
	 * @return
	 */
	public String single (int x){
		String singleString = null;
		if (x==0) {
			singleString="单身";
		} else  if(x==1){
			singleString="非单身";
		}else{
			singleString="保密";
		}
		return singleString;
	}
	
}
