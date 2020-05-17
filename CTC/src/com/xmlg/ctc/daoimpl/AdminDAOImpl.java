package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.dao.AdminDAO;
import com.xmlg.ctc.entity.Academic;
import com.xmlg.ctc.entity.Admin;
import com.xmlg.ctc.util.JDBCUtil;

public class AdminDAOImpl implements AdminDAO{
	JDBCUtil util=new JDBCUtil();
	
	//管理员登录
	public Admin getAdmins(String adname,String adpassword) {
		// TODO Auto-generated method stub
		ResultSet rs=util.query("select * from admin where admin_name =? and admin_password=?"
											,adname,adpassword);
		List<Admin> list=new ArrayList<Admin>();
		Admin ads = new Admin();
		try {
			while (rs.next()) {
				Admin ad=new Admin();
				ad.setAdId(rs.getInt("id"));
				ad.setAdminName(rs.getString("admin_name"));
				ad.setAdminPassword(rs.getString("admin_password"));
				list.add(ad);
			}
			if(list.size()>0){
			ads=list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return ads;
	}
	
	
	public List<Admin> admins(){
		 ResultSet rs=util.query("select * from admin ");
		 List<Admin> list=new ArrayList<Admin>(); 
		 
		 try {
			while(rs.next()){
				Admin s=new Admin();
				s.setAdId(rs.getInt("id"));
				s.setAdminName(rs.getString("admin_name"));
				s.setAdminPassword(rs.getString("admin_password"));
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
	
	
	public Admin admin_preson(int adminId){
		 ResultSet rs=util.query("select * from admin where id=? ",adminId);
		Admin s=new Admin(); 
		 
		
			try {
				rs.next();
				s.setAdId(rs.getInt("id"));
				s.setAdminName(rs.getString("admin_name"));
				s.setAdminPassword(rs.getString("admin_password"));
			} catch (Exception e) {
				// TODO: handle exception
			}
		return s;
		
		
	}
	
	//修改管理员资料
public boolean modifyAdmin(Admin admin) {
		
		int result = util.update("UPDATE admin SET admin_name = ? ,admin_password=?  WHERE id = ? ", admin.getAdminName(),admin.getAdminPassword(),admin.getAdId());
		if (result>0) {
			return true;
		}
		return false;
	}
//添加管理员资料
public boolean addAdmin(Admin admin) {
	 int result= util.update("insert into admin(admin_name,admin_password) values(?,?)", admin.getAdminName(),admin.getAdminPassword()); 
	 if(result>0){
		 return true;
	 }
		return false;
}
//删除
public boolean deleteadmin(int id) {
	int result=util.update("delete from admin where id=?",id);
	if(result>0){
		 return true;
	 }
		return false;
}


	
	
	
}
