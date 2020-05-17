package com.xmlg.ctc.daoimpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.xmlg.ctc.dao.MarketDAO;
import com.xmlg.ctc.entity.Friend;
import com.xmlg.ctc.entity.Market;
import com.xmlg.ctc.entity.Student;
import com.xmlg.ctc.entity.User;
import com.xmlg.ctc.util.JDBCUtil;

public class MarketDAOImpl implements MarketDAO{
	JDBCUtil util=new JDBCUtil();
	

		
		public static void closeConnection(Connection connection) {
			
		}
		


		/**
		 * 添加商品
		 */
		public int addMarket(Market market) {
			String date=util.QueryTime();
			int m=util.update("insert into market(m_user,m_name,m_price,m_state,m_photo,m_time,m_phone) values(?,?,?,?,?,?,?)"
					,market.getUser(),market.getMName(),market.getMPrice(),market.getMState(),market.getMPhoto(),date,market.getMphone());
			return m;	
		}
		
		/**
		 * 获取商品列表
		 */
		public List<Market> queryAllMarkets() {
			 List<Market> list=new ArrayList<Market>();
			 ResultSet rs=util.query("select * from market");
			  
			 try {
				while(rs.next()){
					Market m=new Market();
					m.setUser(rs.getString("m_user"));
					m.setMName(rs.getString("m_name"));
					m.setMPrice(rs.getDouble("m_price"));
					m.setMState(rs.getString("m_state"));
					m.setMPhoto(rs.getString("m_photo"));
					m.setMTime(rs.getString("m_time"));
					m.setMphone(rs.getString("m_phone"));
					
					list.add(m);
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
		 * 获取我发布的商品列表
		 */
		public List<Market> queryMyMarkets(String userno) {
			 List<Market> list=new ArrayList<Market>();
			 ResultSet rs=util.query("select * from market where m_user=?",userno);
			  
			 try {
				while(rs.next()){
					Market m=new Market();
					m.setMId(rs.getInt("m_id"));
					m.setUser(rs.getString("m_user"));
					m.setMName(rs.getString("m_name"));
					m.setMPrice(rs.getDouble("m_price"));
					m.setMState(rs.getString("m_state"));
					m.setMPhoto(rs.getString("m_photo"));
					m.setMTime(rs.getString("m_time"));
					m.setMphone(rs.getString("m_phone"));
					
					list.add(m);
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
		 * 删除我发布的商品列表
		 */
		public int deleteMyMarkets(String id) {
			int rs=util.update("delete from market where m_id=?",id);
		    util.closeAll();
			return rs;
		}



		public int addMarket(String user, String MName, double MPrice,
				int MState, String MPhoto, String MTime, int Mphone) {
			// TODO Auto-generated method stub
			return 0;
		}



		public List<Market> queryAllMarkets(String MName, double MPrice,
				int MState, String MPhoto, String MTime, int Mphone) {
			// TODO Auto-generated method stub
			return null;
		}

}
