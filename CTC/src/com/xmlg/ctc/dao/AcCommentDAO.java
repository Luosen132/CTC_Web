package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.AcComment;



/**
 *@author 沈益鑫
 * 
 */
public interface AcCommentDAO {
	public boolean insertAcComment(int ac_id,String ac_co_no,String ac_co_content,String ac_co_date);
	public List<AcComment> searchAcCommentById(int acid);
}
