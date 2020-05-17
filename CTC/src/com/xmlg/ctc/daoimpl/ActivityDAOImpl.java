package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xmlg.ctc.dao.ActivityDAO;
import com.xmlg.ctc.entity.Activity;
import com.xmlg.ctc.util.JDBCUtil;

public class ActivityDAOImpl implements ActivityDAO {
	JDBCUtil util = new JDBCUtil();
	
	public int addActivity(String id) {
		int i = util.update("update activity set act_check='1' where act_id=?",id);
		return i;
	}

	public int deleteActivity(String id) {
		int i = util.update("delete from activity where act_id=?",id);
		return i;
	}

	public Activity findActivityById(int id) {
		ResultSet rs=util.query("select * from activity where act_id=?",id);

					Activity a=new Activity();
					try {
						rs.next();
						a = new Activity();
						a.setActId(rs.getInt("act_id"));
						a.setActPerid(rs.getString("act_perid"));
						a.setActTitle(rs.getString("act_title"));
						a.setActType(rs.getString("act_type"));
						a.setActContent(rs.getString("act_content"));
						a.setActTime(rs.getString("act_time"));
						a.setActMaxnum(rs.getInt("act_maxnum"));
						a.setActNum(rs.getInt("act_num"));
						a.setActCheck(rs.getInt("act_check"));
					} catch (Exception e) {
						// TODO: handle exception
					}
		return a;
	}

	
	public List<Activity> queryActivityForPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Activity> allActivity() {
		ResultSet rs=util.query("select * from activity ");
		 List<Activity> list=new ArrayList<Activity>();
		 try {
				while(rs.next()){
					Activity a=new Activity();
					a.setActId(rs.getInt("act_id"));
					a.setActPerid(rs.getString("act_perid"));
					a.setActTitle(rs.getString("act_title"));
					a.setActType(rs.getString("act_type"));
					a.setActContent(rs.getString("act_content"));
					a.setActTime(rs.getString("act_time"));
					a.setActMaxnum(rs.getInt("act_maxnum"));
					a.setActNum(rs.getInt("act_num"));
					a.setActCheck(rs.getInt("act_check"));
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
	 * @author 饶金鑫
	 * @version 2018年1月10日22:36:34
	 */
	//添加活动	
	public boolean  addActivity(Activity a) {
		int result =util.update("insert into activity(act_perid,act_title,act_type,act_content,act_time,act_maxnum,act_num,act_check)value(?,?,?,?,?,?,?,?)",
				a.getActPerid(),a.getActTitle(),a.getActType(),a.getActContent(),a.getActTime(),a.getActMaxnum(),a.getActNum(),a.getActCheck());
		if (result>0) {
			return true;
		}
		return false;
	}

	public int  deleteActivity(int act_id) {
		int i = 0;
		int x = util.update("delete from activity where act_id = ?",act_id);
		if (x>0)
			i=1;
		
		return i;
	}
// 查询活动数
	public int getCount() {
		ResultSet rs=util.query("select count(*) as mysum from activity where act_check=1");
		int count=0;
		try {
			if(rs.next()){
			count=rs.getInt("mysum");	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}	
			
			return count;
		}

	public boolean modifyActivity(Activity c) {
		// TODO Auto-generated method stub
		return false;
	}
//查询活动
	public List<Activity> queryAllActivity( int page,int size) {
		ResultSet rs = util.query("select * from activity where act_check=1  order by act_id desc limit ?,?",(page-1)*size,size);
		List<Activity> list = new ArrayList<Activity>();
		
		try {
			while (rs.next()) {
				Activity a = new Activity();
				a.setActId(rs.getInt("act_id"));
				a.setActPerid(rs.getString("act_perid"));
				a.setActTitle(rs.getString("act_title"));
				a.setActType(rs.getString("act_type"));
				a.setActContent(rs.getString("act_content"));
				a.setActTime(rs.getString("act_time"));
				a.setActMaxnum(rs.getInt("act_maxnum"));
				a.setActNum(rs.getInt("act_num"));
				a.setActCheck(rs.getInt("act_check"));
				
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
	
//根据学号查询发布的活动
	public List<Activity> queryActivity(String perid) {
		ResultSet rs = util.query("Select * from activity where act_perid = ?", perid);
		List<Activity> list = new ArrayList<Activity>();
		try {
			while (rs.next()) {
				Activity a = new Activity();
				a.setActId(rs.getInt("act_id"));
				a.setActPerid(rs.getString("act_perid"));
				a.setActTitle(rs.getString("act_title"));
				a.setActType(rs.getString("act_type"));
				a.setActContent(rs.getString("act_content"));
				a.setActTime(rs.getString("act_time"));
				a.setActMaxnum(rs.getInt("act_maxnum"));
				a.setActNum(rs.getInt("act_num"));
				a.setActCheck(rs.getInt("act_check"));
				
				list.add(a);
		} 
	} catch (Exception e) {
		// TODO: handle exception
	}
       return list;
	}
//活动报名
	public boolean addActNum(Activity activity) {

		int result = util.update("UPDATE activity SET act_num = ? WHERE act_id = ? ", (activity.getActNum()+1),activity.getActId());
		if (result>0) {
			return true;
		}
		return false;
	}
//根据活动id，报名活动
	public Activity queryActivityid(int id) {
		ResultSet rs = util.query("Select * from activity where act_id = ?",id);
		List<Activity> list = new ArrayList<Activity>();
		Activity activity = new Activity();
		try {
			while (rs.next()) {
				Activity a = new Activity();
				a.setActId(rs.getInt("act_id"));
				a.setActPerid(rs.getString("act_perid"));
				a.setActTitle(rs.getString("act_title"));
				a.setActType(rs.getString("act_type"));
				a.setActContent(rs.getString("act_content"));
				a.setActTime(rs.getString("act_time"));
				a.setActMaxnum(rs.getInt("act_maxnum"));
				a.setActNum(rs.getInt("act_num"));
				a.setActCheck(rs.getInt("act_check"));
				
				list.add(a);
		} if (list.size() > 0) {
			activity = list.get(0);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
       return activity;
	}

}
