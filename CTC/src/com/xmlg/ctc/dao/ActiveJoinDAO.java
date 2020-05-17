package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.ActiveJoin;


/**
 * @author 饶金鑫
 * @version 2018-1-17 11:33:12
 */
public interface ActiveJoinDAO {
	
	public boolean joinActivity(int pid , String psid, String upic );
	
	public List<ActiveJoin> findJoinActivityById(int pid);
	
	public List<ActiveJoin> findJoinActivityUpicById(int pid);
	
}
