package com.xmlg.ctc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Util;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xmlg.ctc.dao.TalkDAO;

import com.xmlg.ctc.entity.Talk;
import com.xmlg.ctc.util.JDBCUtil;


public  class TalkDAOImp implements TalkDAO {
	JDBCUtil util  = new JDBCUtil();
	
	/**
	 * 添加说说
	 * @param talknew对象
	 * @return 添加说说
	 * @author 陈倍蕾cbl
	 * @since  2018.1.10
	 */	
	
	public boolean addTalk(Talk talknew) throws Exception {
		// TODO Auto-generated method stub
		boolean isOK = false;
		Connection conn = util.getCon();
		String sql = "INSERT INTO talk (t_name,u_no,t_text,t_time) VALUE (?,?,?,?)";
		//String sql = "INSERT INTO talk (t_name,u_no,t_text,t_picture,t_time) VALUE(?,?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			conn = util.getCon();
			preparedStatement = conn.prepareStatement(sql);
			//preparedStatement.setInt(1,talknew.getTId());
			preparedStatement.setString(1,talknew.getTName());
			preparedStatement.setString(2,talknew.getUser());		
			preparedStatement.setString(3,talknew.getTText());
			//preparedStatement.setString(5, talknew.getTPicture());
			preparedStatement.setString(4, talknew.getTTime());
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
	 * 查询说说的方法
	 * @return 遍历所以说说数据
	 * @author 陈倍蕾cbl
	 * @since  2018.1.10
	 */	
	public List<Talk> getAllItems1() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Talk> list=new ArrayList<Talk>(); //集合
		try {
			conn = util.getCon();
			String sql = "select * from notice";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Talk item=new Talk();
				//Customer item = new Customer();
				item.setTId(rs.getInt("t_id"));
				item.setUser(rs.getString("u_no"));			
				item.setTName(rs.getString("t_name"));
				item.setTText(rs.getString("t_text"));
				item.setTPicture(rs.getString("t_picture"));
				item.setTTime(rs.getString("t_time"));
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
	 * 删除说说评论的方法
	 * @param talkId(说说id)
	 * @return 删除此条id的说说
	 * @author 陈倍蕾cbl
	 * @since  2018.1.10
	 */	
	public boolean delete(int talkId) throws Exception {
		// TODO Auto-generated method stub
		boolean isOK = false;
		Connection conn = util.getCon();
    	String sql = "DELETE FROM talk WHERE t_id=?";
    	PreparedStatement preparedStatement;
    	try {
    		conn = util.getCon();
    		preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setInt(1, talkId);
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
	 * 查询说说的方法
	 * @param  uno(用户no)
	 * @return 遍历此用户的说说
	 * @author 陈倍蕾cbl
	 * @since  2018.1.10
	 */	
	public ArrayList<Talk> getAllItems(String uno) {
		// TODO Auto-generated method stub
		Connection conn = util.getCon();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Talk> list=new ArrayList<Talk>(); //集合
		try {
			conn = util.getCon();
	
			String sql = "select * from talk where u_no=? ;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uno);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Talk item=new Talk();
				//Customer item = new Customer();
				item.setTId(rs.getInt("t_id"));
				item.setUser(rs.getString("u_no"));			
				item.setTName(rs.getString("t_name"));
				item.setTText(rs.getString("t_text"));
				item.setTPicture(rs.getString("t_picture"));
				item.setTTime(rs.getString("t_time"));
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
	 * 查询说说的方法
	 * @param  tlId
	 * @return 遍历此id说说的数据
	 * @author 陈倍蕾cbl
	 * @since  2018.1.10
	 */	
	
	public ArrayList<Talk> getAllItems(int tlId) {
		Connection conn = util.getCon();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Talk> list=new ArrayList<Talk>(); //集合
		try {
			conn = util.getCon();
			String sql = "select * from talk where t_id=? ;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tlId);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Talk item=new Talk();
				//Customer item = new Customer();
				item.setTId(rs.getInt("t_id"));
				item.setUser(rs.getString("u_no"));			
				item.setTName(rs.getString("t_name"));
				item.setTText(rs.getString("t_text"));
				item.setTPicture(rs.getString("t_picture"));
				item.setTTime(rs.getString("t_time"));
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
