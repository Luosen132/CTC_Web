package com.xmlg.ctc.dao;

import java.util.ArrayList;

import com.xmlg.ctc.entity.TalkComment;

public interface TalkCommentDAO {

	
	public ArrayList<TalkComment> getAllItems(int tcid);
	
	public boolean addComment1(TalkComment talkcommentnew)throws Exception;
	
	public boolean delete1(int tccomment_id)throws Exception  ;
	
	
}
