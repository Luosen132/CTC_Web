package com.xmlg.ctc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.dao.UserDAO;
import com.xmlg.ctc.entity.College;
import com.xmlg.ctc.entity.Cqc;
import com.xmlg.ctc.entity.Hobby;
import com.xmlg.ctc.entity.School;
import com.xmlg.ctc.entity.Student;
import com.xmlg.ctc.entity.User;
import com.xmlg.ctc.util.JDBCUtil;

/*
 * @author 施建南
 * 用户注册，用户登录两者的接口实现
 */
public class UserDAOImpl implements UserDAO{
	JDBCUtil util=new JDBCUtil();
	
	//注册用户（添加用户）
	public int addUser(User aUser){

		int x=util.update("insert into user(u_no,u_name,u_realname,u_password,u_school,u_college,u_IDcard) values(?,?,?,?,?,?,?)"
				, aUser.getUNo(),aUser.getUName(),aUser.getURealname(),aUser.getUPassword(),aUser.getUSchool(),aUser.getUCollege(),aUser.getUIdcard());

		return x;
	}

	
	//用户登录
	public User getUsers(int uSchool, String uNo,String uPassword) {
		// TODO Auto-generated method stub
		ResultSet rs=util.query("select * from user where u_school =? and u_no=? and u_password=?"
														, uSchool, uNo, uPassword);
		List<User> list=new ArrayList<User>();
		
		User aUsers = new User();
		try {
			while (rs.next()) {
				User aUser=new User();
				aUser.setUSchool(rs.getInt("u_school"));
				aUser.setUNo(rs.getString("u_no"));
				aUser.setUPassword(rs.getString("u_password"));
				aUser.setUstate(rs.getInt("u_state"));
				list.add(aUser);
			}
			if(list.size()>0){
				aUsers=list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return aUsers;
	}

	//获取学生表里的数据
	public Student getSthdents(int sSchool, int sCollege, String sNo,
			String sName, String sIDcard) {
		// TODO Auto-generated method stub
		ResultSet rs=util.query("select * from student where s_school =? and s_college=? and s_no=? and s_name=? and s_IDcard=?"
				, sSchool, sCollege, sNo, sName, sIDcard);
		List<Student> list=new ArrayList<Student>();
		
		Student aStudents = new Student();
		
		try {
			while (rs.next()) {
				Student aStudent=new Student();
				aStudent.setSchool(rs.getInt("s_school"));
				aStudent.setCollege(rs.getInt("s_college"));
				aStudent.setSNo(rs.getString("s_no"));
				aStudent.setSName(rs.getString("s_name"));
				aStudent.setSIdcard(rs.getString("s_IDcard"));
				list.add(aStudent);
				
				if(list.size()>0){
					aStudents=list.get(0);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return aStudents;
	}
	

	/**
	 * @author 施建南
	 * 用户忘记密码身份验证
	 */
	public User getForgetPasswordUsers(int uSchool, String uNo,String URealname,String UIdcard) {
		// TODO Auto-generated method stub
		ResultSet rs=util.query("select * from user where u_school =? and u_no=? and u_realname=? and u_IDcard=?"
														, uSchool, uNo, URealname,UIdcard);
		List<User> list=new ArrayList<User>();
		
		User aUsers = new User();
		try {
			while (rs.next()) {
				User aUser=new User();
				aUser.setUSchool(rs.getInt("u_school"));
				aUser.setUNo(rs.getString("u_no"));
				aUser.setURealname(rs.getString("u_realname"));
				aUser.setUIdcard(rs.getString("u_IDcard"));
				list.add(aUser);
			}
			if(list.size()>0){
				aUsers=list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return aUsers;
	}

	//获取学校编号对应的学校名称
	public List<School> SchoolSearch() {
		
		 ResultSet rs=util.query("select * from school ");
		 List<School> list=new ArrayList<School>(); 
		 
		 try {
			while(rs.next()){
				School s=new School();
				s.setSchId(rs.getInt("sch_id"));
				s.setSchName(rs.getString("sch_name"));
				 list.add(s);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;
	}
	public List<School> SchoolSearchById(int  schID) {
		
		 ResultSet rs=util.query("select * from school where sch_id=?",schID);
		 List<School> list=new ArrayList<School>(); 
		 
		 try {
			while(rs.next()){
				School s=new School();
				s.setSchId(rs.getInt("sch_id"));
				s.setSchName(rs.getString("sch_name"));
				 list.add(s);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;
	}
	
	//获取学院编号对应的学院名称
	public List<College> CollegeSearch() {
		
		 ResultSet rs=util.query("select * from college ");
		 List<College> list=new ArrayList<College>(); 
		 
		 try {
			while(rs.next()){
				College c=new College();
				c.setColId(rs.getInt("col_id"));
				c.setColName(rs.getString("col_name"));
				 list.add(c);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;
	}
	
	
	public List<College> CollegeSearchById(int  colID) {
		
		 ResultSet rs=util.query("select * from college where col_id=?",colID);
		 List<College> list=new ArrayList<College>(); 
		 
		 try {
			while(rs.next()){
				College c=new College();
				c.setColId(rs.getInt("col_id"));
				c.setColName(rs.getString("col_name"));
				 list.add(c);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;
	}
	
	
	//获取用户表的学号
	public User getUsersByNO(String uNo) {
		// TODO Auto-generated method stub
		ResultSet rs=util.query("select * from user where u_no=?", uNo);
		List<User> list=new ArrayList<User>();
		
		User aUsers = new User();
		try {
			while (rs.next()) {
				User aUser=new User();
				aUser.setUNo(rs.getString("u_no"));
				list.add(aUser);
			}
			if(list.size()>0){
				aUsers=list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return aUsers;
	}
	
	/**
	 * 查询个人详细信息
	 * @author 陈梦琳
	 */
	public User findUserById(String id) {
		ResultSet rs=util.query("select * from user where u_no=?",id);
		 
					User a=new User();
					try {
						rs.next();
						a.setUNo(rs.getString("u_no"));
						a.setUName(rs.getString("u_name"));
						a.setURealname("u_realname");
						a.setUPassword(rs.getString("u_password"));
						a.setUPicture(rs.getString("u_picture"));
						a.setUSchool(rs.getInt("u_school"));
						a.setUCollege(rs.getInt("u_college"));
						a.setUIdcard(rs.getString("u_IDcard"));
						a.setUSex(rs.getString("u_sex"));
						a.setUPhone(rs.getString("u_phone"));
						a.setHobby(rs.getString("u_hobby"));
						a.setUPersonality(rs.getString("u_personality"));
						a.setUCensus(rs.getString("u_census"));
						a.setUSingle(rs.getInt("u_single"));
						a.setUDispark(rs.getInt("u_dispark"));
						a.setUstate(rs.getInt("u_state"));
						a.setUCqcId(rs.getInt("u_cqc_id"));
					} catch (Exception e) {
						// TODO: handle exception
					}
		return a;
	}

	public List<User> findUsersByNameUltimate(String text) {
		// TODO Auto-generated method stub
		return null;
	}

/**
 * 重置密码为身份证后六位
 * @author 陈梦琳
 */
	public int modifyPwd(String id,String idCard) {
		String pwd = idCard.substring(12, 18);
		int i=util.update("update user set u_password =? where u_no=?",pwd, id);
		// TODO Auto-generated method stub
		return i;
	}



	public int stopUser(String id) {
		int i =util.update("update user set u_state=0 where u_no=?", id);
	    return i;
	}

	public List<User> allUser() {
		ResultSet rs=util.query("select * from user");
		 List<User> list=new ArrayList<User>();
		 try {
				while(rs.next()){
					User a=new User();
					a.setUNo(rs.getString("u_no"));
					a.setUName(rs.getString("u_name"));
					a.setURealname(rs.getString("u_realname"));
					a.setUPassword(rs.getString("u_password"));
					a.setUPicture(rs.getString("u_picture"));
					a.setUSchool(rs.getInt("u_school"));
					a.setUCollege(rs.getInt("u_college"));
					a.setUIdcard(rs.getString("u_IDcard"));
					a.setUSex(rs.getString("u_sex"));
					a.setUPhone(rs.getString("u_phone"));
					a.setHobby(rs.getString("u_hobby"));
					a.setUPersonality(rs.getString("u_personality"));
					a.setUCensus(rs.getString("u_census"));
					a.setUSingle(rs.getInt("u_single"));
					a.setUDispark(rs.getInt("u_dispark"));
					a.setUstate(rs.getInt("u_state"));
					 list.add(a);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeAll();
			}
		return list;
	}
	
	/**
	 * @author 沈益鑫
	 */
	public List<User> userSearch(String u_no,String u_name,String u_school,String u_college,String u_single,String u_sex,String u_hobby) {
		ResultSet rs = util
		.query("select * from user where u_no  like ? and u_name like ? and u_school like ? and u_college like ? and u_single like ? and u_sex like ? and u_hobby like ? ",
				"%" + u_no + "%", "%" + u_name + "%", "%" + u_school
						+ "%", "%" + u_college + "%", "%" + u_single
						+ "%", "%" + u_sex + "%", "%" + u_hobby + "%");

		 List<User> list=new ArrayList<User>();
		 
		 try {
			while(rs.next()){
				User u=new User();
				u.setUNo(rs.getString("u_no"));
				u.setUPicture(rs.getString("u_picture"));
				u.setUName(rs.getString("u_name"));
				 list.add(u);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;

	}
	
	public List<Hobby> HobbySearch() {
		 ResultSet rs=util.query("select * from hobby ");
		 List<Hobby> list=new ArrayList<Hobby>(); 
		 
		 try {
			while(rs.next()){
				Hobby h=new Hobby();
				h.setHId(rs.getInt("h_id"));
				h.setHName(rs.getString("h_name"));
				 list.add(h);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;
	}
	
	
	public List<Hobby> HobbySearchById(int  hobID) {
		ResultSet rs=util.query("select * from hobby where h_id = ?",hobID);
		List<Hobby> list=new ArrayList<Hobby>(); 
		
		try {
			while(rs.next()){
				Hobby h=new Hobby();
				h.setHId(rs.getInt("h_id"));
				h.setHName(rs.getString("h_name"));
				list.add(h);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;
	}
	
	public List<User> userSearchByUno(String u_no) {
		 ResultSet rs=util.query("select * from user where u_no = ? ",u_no);
		 List<User> list=new ArrayList<User>();
		 
		 try {
			while(rs.next()){
				User u=new User();
				u.setUNo(rs.getString("u_no"));
				u.setUPicture(rs.getString("u_picture"));
				u.setUName(rs.getString("u_name"));
				u.setUCollege(rs.getInt("u_college"));
				u.setUSchool(rs.getInt("u_school"));
				u.setUSex(rs.getString("u_sex"));
				u.setHobby(rs.getString("u_hobby"));
				u.setUPersonality(rs.getString("u_personality"));
				u.setUCensus(rs.getString("u_census"));
				u.setUSingle(rs.getInt("u_single"));
				 list.add(u);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;

	}
	
	/**
	 * @author 饶金鑫
	 * 根据学号查询是否投过票
	 */
	public boolean addUCqcid(String userid , int cqcid) {
		int result = util.update("UPDATE user SET u_cqc_id = ? WHERE u_no = ? ",cqcid,userid);
		if (result>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @author 陈倍蕾
	 * 修改个人资料
	 */
	public boolean modify(User user) {
		// TODO Auto-generated method stub
		boolean isOK = false;
		Connection conn=null;
		String sql = "update user SET u_hobby=?"
				+ ",u_name=? ,u_school=? ,u_college=? ,u_sex=? ,u_personality=? ,u_census=? ,u_single=?"
				+ " WHERE u_no=?";
		PreparedStatement preparedStatement;
		try {conn = util.getCon();
			preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getHobby());
			preparedStatement.setString(2, user.getUName());
			preparedStatement.setInt(3, user.getUSchool());
			preparedStatement.setInt(4, user.getUCollege());
			preparedStatement.setString(5, user.getUSex());
			preparedStatement.setString(6, user.getUPersonality());
			preparedStatement.setString(7, user.getUCensus());
			preparedStatement.setInt(8, user.getUSingle());
			preparedStatement.setString(9, user.getUNo());
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				isOK = true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return isOK;
	}
	/**
	 * 修改头像
	 * @param c
	 * @return
	 */

	public boolean modifyPicture(User user) {
		int result =util.update("UPDATE user SET u_picture = ? WHERE u_no = ?",user.getUPicture(),user.getUNo());
			
		if (result>0) {
			return true;
		}
		return false;
	}
	
}
