package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xmlg.ctc.dao.AcademicDAO;
import com.xmlg.ctc.entity.Academic;
import com.xmlg.ctc.util.JDBCUtil;

public class AcademicDAOImpl implements AcademicDAO {
	JDBCUtil util = new JDBCUtil();
	/**
	 * @author 陈梦琳 
	 * */
	public int addAcademic(String id) {
		int i = util.update("update academic set ac_check='1' where ac_id=?",id);
		return i;
	}

	public int deleteAcademic(String id) {
		int i = util.update("delete from academic where ac_id=?",id);
		return i;
	}

	public int getCount() {
		ResultSet rs = util.query("select count(*) as mysum from academic");
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

	public List<Academic> queryAcademicForPage(int page, int size) {

		ResultSet rs=util.query("select * from academic limit ?,?", (page-1)*size,size);
		 List<Academic> list=new ArrayList<Academic>();
//		 
//		 try {
//			while(rs.next()){
//				Academic a=new Academic();
//				a.setAc_id(rs.getInt("ac_id"));
//				a.setAc_no(rs.getString("ac_no"));
//				a.setAcContent(rs.getString("ac_content"));
//				a.setAcHeadline(rs.getString("ac_headline"));
//				a.setAcFile(rs.getString("ac_file"));
//				a.setAcDate(rs.getString("ac_date"));
//				 list.add(a);
//			 }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			util.closeAll();
//		}
//			
			return list;
	}

/**
 * 根据学术编号获得单条记录的学术信息
 * @author 陈梦琳
 */

	public Academic findAcademicById(int id)  {
		ResultSet rs=util.query("select * from academic where ac_id=?",id);
	
				
					Academic a=new Academic();;
					try {
						rs.next();
						a = new Academic();
						a.setAc_id(rs.getInt("ac_id"));
						a.setAc_no(rs.getString("ac_no"));
						a.setAcContent(rs.getString("ac_content"));
						a.setAcHeadline(rs.getString("ac_headline"));
						a.setAcFile(rs.getString("ac_file"));
						a.setAcDate(rs.getString("ac_date"));
						a.setAcCheck(rs.getInt("ac_check"));
					} catch (Exception e) {
						// TODO: handle exception
					}
		return a;
	}

	/**
	 * 学术列表显示
	 * @author 陈梦琳
	 */
	public List<Academic> allAcademic() {
		ResultSet rs=util.query("select * from academic ");
		 List<Academic> list=new ArrayList<Academic>();
		 try {
				while(rs.next()){
					Academic a=new Academic();
					a.setAc_id(rs.getInt("ac_id"));
					a.setAc_no(rs.getString("ac_no"));
					a.setAcContent(rs.getString("ac_content"));
					a.setAcHeadline(rs.getString("ac_headline"));
					a.setAcFile(rs.getString("ac_file"));
					a.setAcDate(rs.getString("ac_date"));
					a.setAcCheck(rs.getInt("ac_check"));
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
	 * @author 沈益鑫
	 * 添加发表学术
	 */
		public boolean addAcademic(Academic academic) {
			 int result= util.update("insert into academic(ac_no,ac_headline,ac_content,ac_file,ac_date) values(?,?,?,?,?)", academic.getAc_no(),academic.getAcHeadline(),academic.getAcContent(),academic.getAcFile(),academic.getAcDate()); 
			 if(result>0){
				 return true;
			 }
				return false;
		}
	/**
	 * @author 沈益鑫
	 * 陈列发表过的学术
	 */
		public List<Academic> AcademicSearch() {
			 ResultSet rs=util.query("select * from academic where ac_check=1 order by ac_date desc");
			 List<Academic> list=new ArrayList<Academic>(); 
			 
			 try {
				while(rs.next()){
					Academic ac=new Academic();
					ac.setAc_id(rs.getInt("ac_id"));
					ac.setAc_no(rs.getString("ac_no"));
					ac.setAcHeadline(rs.getString("ac_headline"));
					ac.setAcContent(rs.getString("ac_content"));
					ac.setAcFile(rs.getString("ac_file"));
					ac.setAcDate(rs.getString("ac_date"));
					 list.add(ac);
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
		 * @author 罗钦
		 * 陈列自己发表过的学术
		 */
			public List<Academic> presonAcademicSearch(String userno) {
				 ResultSet rs=util.query("select * from academic where ac_check=1 AND ac_no=?  order by ac_date desc",userno);
				 List<Academic> list=new ArrayList<Academic>(); 
				 
				 try {
					while(rs.next()){
						Academic ac=new Academic();
						ac.setAc_id(rs.getInt("ac_id"));
						ac.setAc_no(rs.getString("ac_no"));
						ac.setAcHeadline(rs.getString("ac_headline"));
						ac.setAcContent(rs.getString("ac_content"));
						ac.setAcFile(rs.getString("ac_file"));
						ac.setAcDate(rs.getString("ac_date"));
						 list.add(ac);
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
		 * 根据acid查找发表的学术
		 */
	public List<Academic> AcademicSearchByID(int acid) {
		 ResultSet rs=util.query("select * from academic where ac_id=? ",acid);
		 List<Academic> list=new ArrayList<Academic>(); 
		 
		 try {
			while(rs.next()){
				Academic ac=new Academic();
				ac.setAc_id(rs.getInt("ac_id"));
				ac.setAcHeadline(rs.getString("ac_headline"));
				ac.setAcContent(rs.getString("ac_content"));
				ac.setAcFile(rs.getString("ac_file"));
				ac.setAcDate(rs.getString("ac_date"));
				 list.add(ac);
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
	 *根据搜索框内容查找发表过的学术
	 */
		public List<Academic> AcademicSearchHeadline(String headline) {
			ResultSet rs=util.query("select * from academic where ac_headline like ?  order by ac_date desc","%"+headline+"%");
			 List<Academic> list=new ArrayList<Academic>(); 
			 
			 try {
				while(rs.next()){
					Academic ac=new Academic();
					ac.setAc_id(rs.getInt("ac_id"));
					ac.setAc_no(rs.getString("ac_no"));
					ac.setAcHeadline(rs.getString("ac_headline"));
					ac.setAcContent(rs.getString("ac_content"));
					ac.setAcFile(rs.getString("ac_file"));
					ac.setAcDate(rs.getString("ac_date"));
					 list.add(ac);
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
