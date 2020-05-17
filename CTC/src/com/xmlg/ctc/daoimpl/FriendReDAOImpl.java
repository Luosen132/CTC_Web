package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.dao.FriendReDAO;
import com.xmlg.ctc.entity.FriendRe;
import com.xmlg.ctc.entity.Hobby;
import com.xmlg.ctc.util.JDBCUtil;
/**
 * 
 * @author 沈益鑫
 *
 */
public class FriendReDAOImpl implements FriendReDAO {
	
	JDBCUtil util=new  JDBCUtil();
  
	public int insertFriendRe(String reNo, String reStuno, String reTime) {
		int rs=util.update("insert  into friend_re(re_no,re_stuno,re_time) values(?,?,?)", reNo,reStuno,reTime);
		try {
			if(rs!=0){
				rs= 1;
			}else {
				rs= 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return rs;
		 		
	}

	public List<FriendRe> searchFriendReByRestuno(String re_stuno) {

		ResultSet rs=util.query("select * from friend_re  where re_operation=2 and re_stuno=? order by re_time desc",re_stuno);
		List<FriendRe> list=new ArrayList<FriendRe>(); 
		
		try {
			while(rs.next()){
				FriendRe fri=new FriendRe();
				fri.setReId(rs.getInt("re_id"));
				fri.setStringByReNo(rs.getString("re_no"));
				fri.setStringByReStuno(rs.getString("re_stuno"));
				fri.setReOperation(rs.getInt("re_operation"));
				fri.setReTime(rs.getString("re_time"));
				list.add(fri);
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
	 * 
	 * @author 沈益鑫
	 *根据主键编号查找
	 */
	public boolean deleteFriendReById(int reId) {
		int result = util
		.update("delete from friend_re  where re_id=?",reId);
if (result > 0) {
	return true;
}
return false;
	}
	/**
	 * reNo发送人，reStuno接收人
	 * @author 沈益鑫
	 *根据reNo，reStuno编号查找
	 */
	public  List<FriendRe> searchFriendRe(String reNo, String reStuno) {
		ResultSet rs = util.query("select * from friend_re  where re_no=? and re_stuno=?", reNo,reStuno);
List<FriendRe> list=new ArrayList<FriendRe>(); 
		
		try {
			while(rs.next()){
				FriendRe fri=new FriendRe();
				fri.setReId(rs.getInt("re_id"));
				fri.setStringByReNo(rs.getString("re_no"));
				fri.setStringByReStuno(rs.getString("re_stuno"));
				fri.setReOperation(rs.getInt("re_operation"));
				fri.setReTime(rs.getString("re_time"));
				list.add(fri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return list;
	}

}
