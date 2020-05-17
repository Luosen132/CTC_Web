/**
 * 
 */
package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.dao.FriendDAO;
import com.xmlg.ctc.entity.Friend;
import com.xmlg.ctc.util.JDBCUtil;

/**
 * @author 罗钦
 *
 */
public class FriendDAOImpl implements FriendDAO {

		JDBCUtil util = new JDBCUtil();
	/**
	 * 添加申请的好友
	 * @param userid  用户id
	 * @param friendid  好友id
	 * @return 添加是否成功
	 * @author 罗钦
	 * @since  
	 */
	public int addFriendRe(String userid, String friendid) {
		int i =0;
		int x=util.update("insert into friend(u_no,f_no) values(?,?)", userid,friendid);
		int y=util.update("insert into friend(u_no,f_no) values(?,?)",friendid, userid);
		if(x>0&&y>0)
			i=1;
		
		return i;
	}
	/**
	 * 删除好友
	 * @param userid  用户id
	 * @param friendid  好友id
	 * @return 删除是否成功
	 * @author 罗钦
	 * @since  
	 */
	public int deleteFriendRe(String userid, String friendid) {
		int i =0;
		int x=util.update("DELETE FROM friend WHERE u_no=? AND f_no=? ", userid,friendid);
		int y=util.update("DELETE FROM friend WHERE u_no=? AND f_no=? ",friendid, userid);
		if(x>0&&y>0)
			i=1;
		
		return i;
	}

	/**
	 * 输出用户所有好友
	 * @param userid  用户id
	 * @return 输出好友集
	 * @author 罗钦
	 * @since  
	 */
	public List<Friend> queryAllFriendRes(String userid) {
		 ResultSet rs=util.query("select * from friend where u_no =?",userid);
		 List<Friend> list=new ArrayList<Friend>();
		 
		 try {
			while(rs.next()){
				Friend f=new Friend();
				f.setFId(rs.getInt("f_id"));
				f.setStringByFNo(rs.getString("f_no"));
				f.setStringByUNo(rs.getString("u_no"));
				 list.add(f);
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
	 * 输出当前私信好友
	 * @param userid  用户id
	 * @param friendid  私信好友id
	 * @return 输出好友集
	 * @author 罗钦
	 * @since  
	 */

	public List<Friend> queryPriFriendRes(String userid, String friendid) {
		ResultSet rs=util.query("select * from friend where (u_no =? or u_no= ? )AND (f_no = ? or f_no = ?) ",userid,friendid,userid,friendid);
		 List<Friend> list=new ArrayList<Friend>();
		 
		 try {
			while(rs.next()){
				Friend f=new Friend();
				f.setFId(rs.getInt("f_id"));
				f.setStringByFNo(rs.getString("f_no"));
				f.setStringByUNo(rs.getString("u_no"));
				 list.add(f);
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
	 * 输出当前私信对应与当前用户的好友关系对象
	 * @param userid  用户id
	 * @param friendid  私信好友id
	 * @return 输出好友对应当前用户的好友对象
	 * @author 罗钦
	 * @since  
	 */

	public Friend queryfrRes(String userid, String friendid) {
		ResultSet rs=util.query("select * from friend where u_no= ?  AND  f_no = ?  ",friendid,userid);
		
		Friend f = new Friend();
		 try {
			while(rs.next()){
				 f=new Friend();
				f.setFId(rs.getInt("f_id"));
				f.setStringByFNo(rs.getString("f_no"));
				f.setStringByUNo(rs.getString("u_no"));

			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
			
			
			return f ;
	}
	
	
	
	
	/**
	 * 由好友关系id找出对象
	 * @param friend_Id  好友关系id
	 * @return 输出好友关系对象
	 * @author 罗钦
	 * @since  
	 */

	public Friend queryFriend(int friend_Id) {
		ResultSet rs=util.query("select * from friend where f_id=?" , friend_Id);
		List<Friend> list=new ArrayList<Friend>();
		Friend f1 = new Friend();
				try {
					while(rs.next()){
						Friend f=new Friend();
						f.setFId(rs.getInt("f_id"));
						f.setStringByFNo(rs.getString("f_no"));
						f.setStringByUNo(rs.getString("u_no"));
						 list.add(f);
					 }
					f1=list.get(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			return f1;
	}
	
	/**
	 * 根据好友账号查找是否已有该好友
	 * 沈益鑫
	 * @param fno
	 * @return
	 */
	public boolean FriendSearchById(String uno,String fno) {
		 ResultSet result= util.query("select * from friend where u_no=? and f_no=?",uno,fno); 
		 try {
			if(result.next()){
				 return true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
	}

}
