package com.xmlg.ctc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.dao.NoticeDAO;
import com.xmlg.ctc.entity.Notice;

import com.xmlg.ctc.util.JDBCUtil;

public class NoticeDAOImpl implements NoticeDAO {
	/**
	 * 添加通知的方法
	 * @param 
	 * @return 数据的集合
	 * @author cbl
	 * @since  2018.1.10
	 */	
	JDBCUtil util  = new JDBCUtil();
	public boolean addNotice(Notice noticenew) throws Exception {
		boolean isOK = false;
		Connection conn = util.getCon();
		String sql = "INSERT INTO notice (not_title,not_content,not_time) VALUE(?,?,?)";
		PreparedStatement preparedStatement;
		try {
			conn = util.getCon();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, noticenew.getNot_title());
			preparedStatement.setString(2,noticenew.getNot_content());
			preparedStatement.setString(3, noticenew.getNot_time());

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
	/**
	 * 删除通知的方法
	 * @param 
	 * @author cbl
	 * @since  2018.1.10
	 */	
	public boolean delete(int notid) throws Exception {
		// TODO Auto-generated method stub
		boolean isOK = false;
		Connection conn=null;
    	String sql = "DELETE FROM notice WHERE not_id=?";
    	PreparedStatement preparedStatement;
    	try {
    		conn = util.getCon();
    		preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setInt(1, notid);
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

	
	public boolean modifyNotice(Notice aNotice) throws Exception {
		// TODO Auto-generated method stub
		boolean isOK = false;
		Connection conn=null;
		String sql = "update notice SET not_title=?"
				+ ",not_content=? ,not_time=? "
				+ " WHERE not_id=?";
		PreparedStatement preparedStatement;
		try {
			conn = util.getCon();
			preparedStatement = conn.prepareStatement(sql);
			

			preparedStatement.setString(1, aNotice.getNot_title());
			preparedStatement.setString(2, aNotice.getNot_content());
			preparedStatement.setString(3, aNotice.getNot_time());
			preparedStatement.setInt(4, aNotice.getNot_id());
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
	 * 查询通知的方法
	 * @param 
	 * @return 数据的集合
	 * @author cbl
	 * @since  2018.1.10
	 */	
	public List<Notice> getAllItems1() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Notice> list=new ArrayList<Notice>(); //集合
		try {
			conn = util.getCon();
			String sql = "select * from notice";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Notice item=new Notice();
				//Customer item = new Customer();
				item.setNot_id(rs.getInt("not_id"));			
				item.setNot_title(rs.getString("not_title"));
				item.setNot_content(rs.getString("not_content"));
				item.setNot_time(rs.getString("not_time"));
				
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
	public ArrayList<Notice> getAllItems(int notid) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Notice> list=new ArrayList<Notice>(); //集合
		try {
			conn = util.getCon();
			String sql = "select * from notice where not_id=? ;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, notid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Notice item=new Notice();
				//Customer item = new Customer();
				item.setNot_id(rs.getInt("not_id"));			
				item.setNot_title(rs.getString("not_title"));
				item.setNot_content(rs.getString("not_content"));
				item.setNot_time(rs.getString("not_time"));
				
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

	


}
