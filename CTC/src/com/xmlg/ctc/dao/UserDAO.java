package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.College;
import com.xmlg.ctc.entity.Hobby;
import com.xmlg.ctc.entity.School;
import com.xmlg.ctc.entity.Student;
import com.xmlg.ctc.entity.User;

/*
 * @author 施建南
 * 用户注册，用户登录两者的接口
 */
public interface UserDAO {
	
	//注册用户（添加用户）
	public int addUser(User aUser);
	
	//用户登录
	public User getUsers(int uSchool,String uNo,String uPassword);
	
	//获取学校编号对应的学校名称
	public List<School> SchoolSearch();
	public List<School> SchoolSearchById(int  schID);
	
	
	//用户忘记密码重置验证
	public User getForgetPasswordUsers(int uSchool, String uNo,String URealname,String UIdcard); 
	
	
	//获取学院编号对应的学院名称
	public List<College> CollegeSearch();
	public List<College> CollegeSearchById(int  colID);
	
	//获取学生表里的数据
	public Student getSthdents(int sSchool,int sCollege,
			String sNo,String sName,String sIDcard);
	
	//获取用户表的学号
	public User getUsersByNO(String uNo);
	
	/**
	 * @author 陈梦琳
	 * 
	 */

		//封号
		public int stopUser(String id);
		//重置密码
		public int modifyPwd(String id,String idCard);
		//获得所有用户列表
		public List<User> allUser();
		//模糊查询
		public List<User> findUsersByNameUltimate( String text);
		public User findUserById(String id);

		/**
		 *@author 沈益鑫
		 * 
		 */
		public List<User> userSearch(String a,String b,String c,String d,String e,String f,String g);
		public List<User> userSearchByUno(String u_no);
		public List<Hobby> HobbySearch();
		public List<Hobby> HobbySearchById(int  hobID);

		/**
		 * @author 饶金鑫
		 * 
		 */
		
		public boolean addUCqcid(String userid , int cqcid);
		
		/**
		 * @author 陈倍蕾
		 * 修改个人资料
		 */
		public boolean modify(User user);
		
		public boolean modifyPicture(User user);
		
}
