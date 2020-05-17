package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.dao.PrLetterDAO;
import com.xmlg.ctc.entity.PrLetter;
import com.xmlg.ctc.util.JDBCUtil;

public class PrLetterDAOImpl implements PrLetterDAO {
	JDBCUtil util = new JDBCUtil();
	/**
	 * 发送私信
	 * @param a  私信对象
	 * @return x 是否成功发送
	 * @author 罗钦
	 * @since  
	 */
	public int addFriendRe(PrLetter a) {
	
		int x=util.update("insert into pr_letter(pr_fid,pr_message,pr_time) values(?,?,?)", a.getFriend(),a.getPrMessage(),a.getPrTime());
		
		return x;
	}
	/**
	 * 私信阅读状态
	 * @param pr_id  私信id
	 * @return x 是否成功阅读
	 * @author 罗钦
	 * @since  
	 */
	public int modifyFriendRe(int pr_id) {
	
		int x=util.update("update pr_letter set pr_state=1  where pr_id=? AND pr_state=0 ", pr_id);
		
		return x;
	}
	
	/**
	 * 私信按时间排序
	 * @param friendid  私信好友列表id
	 * @return 输出与某人的私信集
	 * @author 罗钦
	 * @since  
	 */
	public List<PrLetter> queryFriendRes(int u_friendid,int fr_friendid) {
		ResultSet rs=util.query("SELECT pr_id,u_no,f_no, pr_fid,pr_message,pr_time,pr_state FROM pr_letter,friend" +
				" WHERE (pr_fid=? OR pr_fid=?) AND pr_fid = f_id " +
				"ORDER BY pr_time ASC ",u_friendid,fr_friendid);
		 List<PrLetter> list=new ArrayList<PrLetter>();
		 
		 try {
			while(rs.next()){
				PrLetter p=new PrLetter();
				p.setPrId(rs.getInt("pr_id"));
				p.setFriend(rs.getInt("pr_fid"));
				p.setPrMessage(rs.getString("pr_message"));
				p.setPrTime(rs.getString("pr_time"));
				p.setPrState(rs.getInt("pr_state"));
				list.add(p);
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
	 * 获取与某个好友有几条未读信息
	 * @param fr_friendid  私信好友对你的好友列表id
	 * @return 输出与某人的私信集
	 * @author 罗钦
	 * @since  
	 */
	public   int queryLeNum(int fr_id) {
		ResultSet rs=util.query("SELECT COUNT(*) AS num FROM pr_letter WHERE (pr_state=0 AND pr_fid =?)",fr_id);
		int num = 0;
		 
		 try {
			while(rs.next()){
				num=rs.getInt("num");
			
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
			
			
			return num;
	}
	
	/**
	 * 获取与所有好友有几条未读信息
	 * @param user_id 用户学号
	 * @return 输出与所有的私信集
	 * @author 罗钦
	 * @since  
	 */
	public   int querySumNum (String user_id) {
		ResultSet rs=util.query("SELECT COUNT(*) AS num FROM pr_letter ,friend WHERE  pr_letter.`pr_state`=0 AND pr_letter.`pr_fid`=friend.`f_id` AND friend.`f_no`=?",user_id);
		int num = 0;
		 
		 try {
			while(rs.next()){
				num=rs.getInt("num");
			
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
			
			
			return num;
	}
	
}


