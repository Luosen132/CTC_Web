package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;
import com.xmlg.ctc.dao.ActiveJoinDAO;
import com.xmlg.ctc.entity.ActiveJoin;
import com.xmlg.ctc.entity.Activity;
import com.xmlg.ctc.util.JDBCUtil;

/**
 * @author 饶金鑫
 * @version 2018-1-17 11:33:04
 */
public class ActiveJoinDAOImpl implements ActiveJoinDAO {
	  JDBCUtil util = new JDBCUtil();
		//加入报名活动的人
		public boolean joinActivity( int pid , String psid, String upic ) {
			int result =util.update("insert into active_join(act_id,join_userid,join_picture)value(?,?,?)",
					pid,psid,upic);
			if (result>0) {
				return true;
			}
			return false;
		}
		//根据活动id查询信息
		public List<ActiveJoin> findJoinActivityById(int pid) {
			ResultSet rs=util.query("select * from active_join where act_id=?",pid);
			List< ActiveJoin> list = new ArrayList< ActiveJoin>();
			ActiveJoin activeJoin=new ActiveJoin();
			try {
				while (rs.next()) {
			    ActiveJoin aj=new ActiveJoin();
				aj = new ActiveJoin();
				aj.setActJoinId(rs.getInt("act_join_id"));
				aj.setActId(rs.getInt("act_id"));
				aj.setJoinUserid(rs.getString("join_userid"));
				aj.setJoinPicture(rs.getString("join_picture"));
				
				list.add(aj);
		} if (list.size() > 0) {
			activeJoin = list.get(0);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
       return list;
  }
		//根据活动id查询报名照片
		public List< ActiveJoin> findJoinActivityUpicById(int pid) {
			ResultSet rs=util.query("select * from active_join where act_id=?",pid);
			List< ActiveJoin> list = new ArrayList< ActiveJoin>();
			ActiveJoin activeJoin=new ActiveJoin();
			try {
				while (rs.next()) {
			    ActiveJoin aj=new ActiveJoin();
				aj = new ActiveJoin();
				aj.setActJoinId(rs.getInt("act_join_id"));
				aj.setActId(rs.getInt("act_id"));
				aj.setJoinUserid(rs.getString("join_userid"));
				aj.setJoinPicture(rs.getString("join_picture"));
				
				list.add(aj);
		} if (list.size() > 0) {
			activeJoin = list.get(0);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
       return list;

  }
}
