package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.Activity;

/**
 * @author 陈梦琳
 * 
 */
public interface ActivityDAO {
	//审核通过
	public int addActivity(String id);	
	//删除已有的活动
	public int deleteActivity(String id);
	//获取所有的活动列表
	public List<Activity> allActivity();
	public Activity findActivityById(int id);
	//分页显示
	public List<Activity> queryActivityForPage(int page,int size);
	public int getCount();
	

	/**
	 * @author 饶金鑫
	 * @version 2018年1月10日22:32:21
	 */

public boolean addActivity(Activity a);
	
	public int deleteActivity(int act_id);
	
	public List<Activity> queryActivity(String perid);
	
	public Activity queryActivityid (int id);
	
	public boolean modifyActivity(Activity a);

	public List<Activity> queryAllActivity(int page,int size);
	
	public boolean addActNum(Activity activity);

}
