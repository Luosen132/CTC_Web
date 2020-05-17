package com.xmlg.ctc.dao;

import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.entity.Notice;
import com.xmlg.ctc.entity.TalkComment;

public interface NoticeDAO
{
	 public ArrayList<Notice> getAllItems(int notid);
	   public List<Notice> getAllItems1();
		
		public boolean addNotice(Notice noticenew)throws Exception;
		
		
		public boolean delete(int notid)throws Exception  ;
		
		public boolean modifyNotice(Notice aNotice) throws Exception;
	
}
