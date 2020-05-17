package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.Admin;


/*
 * @author 施建南
 * 管理员登录
 * 2018.01.11
 */
public interface AdminDAO {

	//验证管理员的姓名、密码
	public Admin getAdmins(String adname,String adpassword);
	
	/**
	 * 罗钦
	 * @return
	 */
	public List<Admin> admins();
	//查单个
	public Admin admin_preson(int adminId);
	//修改
	public boolean modifyAdmin(Admin admin);
	//添加
	public boolean addAdmin(Admin admin);
	
	public boolean deleteadmin(int id);
}
