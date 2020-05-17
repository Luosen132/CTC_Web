package com.xmlg.ctc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.dao.AcCommentDAO;
import com.xmlg.ctc.entity.AcComment;
import com.xmlg.ctc.util.JDBCUtil;

/**
 *@author 沈益鑫
 * 
 */
public class AcCommentDAOImpl implements AcCommentDAO {

	JDBCUtil util = new JDBCUtil();

	/**
	 * @author 沈益鑫 添加评论
	 * @return boolean
	 */
	public boolean insertAcComment(int acId, String acCoNo, String acCoContent,
			String acCoDate) {
		int result = util
				.update(
						"insert into ac_comment(ac_id,ac_co_no,ac_co_content,ac_co_date) values(?,?,?,?)",
						acId, acCoNo, acCoContent, acCoDate);
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @author 沈益鑫 根据学术发表编号查找评论
	 * @return list
	 */
	public List<AcComment> searchAcCommentById(int acid) {
		ResultSet rs = util.query("select * from ac_comment where ac_id=?",
				acid);
		List<AcComment> list = new ArrayList<AcComment>();

		try {
			while (rs.next()) {
				AcComment acComment = new AcComment();
				acComment.setAccono(rs.getString("ac_co_no"));
				acComment.setAcCoContent(rs.getString("ac_co_content"));
				acComment.setAcCoDate(rs.getString("ac_co_date"));
				list.add(acComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return list;
	}

}
