package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.xmlg.ctc.util.JDBCUtil;
import com.xmlg.ctc.dao.CqcDAO;
import com.xmlg.ctc.entity.Cqc;


/**
 * @author 饶金鑫
 * @since 2018年1月10日22:20:11
 */

public class CqcDAOImpl implements CqcDAO{
	JDBCUtil util = new JDBCUtil();
//添加校花
	public boolean addCqc(Cqc c) {
		int result =util.update("insert into cqc(cqc_tel,cqc_stuid,cqc_birthday,cqc_address,singleState,cqc_email,cqc_picture,cqc_num)value(?,?,?,?,?,?,?,?)",
				c.getCqcTel(),c.getStuid(),c.getCqcBirthday(),c.getCqcAddress(),c.getSingleState(),c.getCqcEmail(),c.getCqcPicture(),c.getCqcNum());
		if (result>0) {
			return true;
		}
		return false;
	}
//删除校花
	public int deleteCqc(int cqc_id) {
		int i = 0;
		int x = util.update("delete from cqc where cqc_id = ?",cqc_id);
		if (x>0)
			i=1;
		
		return i;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

// 查询单个校花信息
	public Cqc queryCqc(String stuid) {
		ResultSet rs = util.query("Select * from cqc where cqc_stuid = ?", stuid);
		List<Cqc> list = new ArrayList<Cqc>();
		Cqc cqc = new Cqc();
		
			try {
				while (rs.next()) {
					Cqc c = new Cqc();
					c.setCqcId(rs.getInt("cqc_id"));
					c.setCqcTel(rs.getString("cqc_tel"));
					c.setStuid(rs.getString("cqc_stuid"));
					c.setCqcBirthday(rs.getString("cqc_birthday"));
					c.setCqcAddress(rs.getString("cqc_address"));
					c.setSingleState(rs.getInt("singleState"));
					c.setCqcEmail(rs.getString("cqc_email"));
					c.setCqcPicture(rs.getString("cqc_picture"));
					c.setCqcNum(rs.getInt("cqc_num"));
					list.add(c);
				}
				if (list.size() > 0) {
					cqc = list.get(0);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		return cqc;
	}

	//查询所有校花信息
	public List<Cqc> queryAllCqc() {
	ResultSet rs = util.query("select * from cqc");
	List<Cqc> list = new ArrayList<Cqc>();
	try {
		while(rs.next()) {
			Cqc c = new Cqc();
			c.setCqcId(rs.getInt("cqc_id"));
			c.setCqcTel(rs.getString("cqc_tel"));
			c.setStuid(rs.getString("cqc_stuid"));
			c.setCqcBirthday(rs.getString("cqc_birthday"));
			c.setCqcAddress(rs.getString("cqc_address"));
			c.setSingleState(rs.getInt("singleState"));
			c.setCqcEmail(rs.getString("cqc_email"));
			c.setCqcPicture(rs.getString("cqc_picture"));
			c.setCqcNum(rs.getInt("cqc_num"));
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

	public boolean addCqcNum(Cqc cqc) {
		
		int result = util.update("UPDATE cqc SET cqc_num = ? WHERE cqc_id = ? ", (cqc.getCqcNum()+1),cqc.getCqcId());
		if (result>0) {
			return true;
		}
		return false;
	}




}
