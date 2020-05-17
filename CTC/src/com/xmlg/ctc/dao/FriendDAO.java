package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.Friend;


/**
 * 
 * @author 罗钦
 *
 */
public interface FriendDAO {
	public int addFriendRe(String userid,String friendid);//添加申请的好友

	public int deleteFriendRe(String userid,String friendid) ;//删除好友

	public List<Friend> queryAllFriendRes(String userid);//输出所有好友
	
	public List<Friend> queryPriFriendRes(String userid,String friendid);//输出当前私信好友
	
	public Friend queryFriend (int friend_Id);//输出特定好友关系ID对象
	/**
	 * 沈益鑫
	 * @param fno
	 * @return
	 */
	public boolean FriendSearchById(String fno,String uno);//根据好友账号查找是否已有该好友
	
}
