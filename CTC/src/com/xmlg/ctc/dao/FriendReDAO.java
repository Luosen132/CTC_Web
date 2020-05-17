/**
 * 
 */
package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.FriendRe;

/**
 * @author 沈益鑫
 * 
 */
public interface FriendReDAO {
	public int insertFriendRe(String re_no,String re_stuno,String re_time);
	public List<FriendRe> searchFriendReByRestuno(String re_stuno);
	public boolean deleteFriendReById(int reId);
	public  List<FriendRe> searchFriendRe(String re_no,String re_stuno);
}
