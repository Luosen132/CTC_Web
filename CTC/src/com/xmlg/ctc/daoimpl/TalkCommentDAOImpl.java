package com.xmlg.ctc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xmlg.ctc.dao.TalkCommentDAO;
import com.xmlg.ctc.util.JDBCUtil;
import com.xmlg.ctc.entity.TalkComment;

public class TalkCommentDAOImpl implements TalkCommentDAO {
	JDBCUtil util  = new JDBCUtil();
	/**
	 * 查询说说评论的方法
	 * @param tctid(说说id)
	 * @return 评论数据的集合
	 * @author 陈倍蕾cbl
	 * @since  2018.1.10
	 */	
	public ArrayList<TalkComment> getAllItems(int tctid)
	{
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<TalkComment> list=new ArrayList<TalkComment>(); //集合
		try {
			conn = util.getCon();
			String sql = "select * from talk_comment where tc_tid=? ;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tctid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				TalkComment item=new TalkComment();
			item.setTcId(rs.getInt("tc_id"));
			item.setTcTid(rs.getInt("tc_tid"));			
				item.setUser(rs.getString("u_no"));
				item.setTcText(rs.getString("tc_text"));
				item.setTcTime(rs.getString("tc_time"));
				
				list.add(item);// 把一个信息加入集合
				
			}
			
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			//释放数据对象
			if(rs!=null)
			{
				try
				{
				   rs.close();
				   rs=null;
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try
				{
					stmt.close();
					stmt=null;					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}return list;
		
	
	}	
	
	
    
	
	/**
	 * 删除说说的方法
	 * @param  tc_id(评论id)
	 * @return 删除此tc_id的数据
	 * @author cbl
	 * @since  2018.1.10
	 */
	public boolean delete1(int tccommentId) throws Exception {
		// TODO Auto-generated method stub
		boolean isOK = false;
		Connection conn=util.getCon();
    	String sql = "DELETE FROM talk_comment WHERE tc_id=?";
    	PreparedStatement preparedStatement;
    	try {
    		conn = util.getCon();
    		preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setInt(1, tccommentId);
    		int i = preparedStatement.executeUpdate();
    		if (i != 0) {
    			isOK = true;
    		}
    	} catch (Exception e) {
    		// TODO 自动生成的 catch 块
    		e.printStackTrace();
    	} finally {
    		util.closeAll();
    	}
    	return isOK;
	}



	/**
	 * 添加说说的方法
	 * @param talkcommentnew对象
	 * @return 添加数据
	 * @author cbl
	 * @since  2018.1.10
	 */

	public boolean addComment1(TalkComment talkcommentnew) throws Exception {
		
	
			boolean isOK = false;
			Connection conn=null;
			String sql = "INSERT INTO talk_comment(tc_tid,u_no,tc_text,tc_time) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = null;
			try {
				conn = util.getCon();
				preparedStatement=conn.prepareStatement(sql);
				preparedStatement.setInt(1,talkcommentnew.getTcTid());
				preparedStatement.setString(2, talkcommentnew.getUser());
				preparedStatement.setString(3,talkcommentnew.getTcText());
				preparedStatement.setString(4, talkcommentnew.getTcTime());

				int i = preparedStatement.executeUpdate();
				if (i == 1) {
					isOK = true;
				}
			} catch (SQLException e) {
				// TODO
				e.printStackTrace();
			} finally {
				util.closeAll();
			}
			return isOK;

		}
		
		

	
	
	
	
	
	
	}
