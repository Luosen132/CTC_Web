package com.xmlg.ctc.dao;

import java.util.ArrayList;
import java.util.List;

import com.xmlg.ctc.entity.Talk;

public interface TalkDAO {
    public ArrayList<Talk> getAllItems(int tlId);
	
	public boolean addTalk(Talk talknew)throws Exception;
	
	public boolean delete(int talk_id)throws Exception  ;
	public List<Talk> getAllItems1();

}
