package com.xmlg.ctc.service;

import java.util.List;

import com.xmlg.ctc.dao.ActivityDAO;

import com.xmlg.ctc.daoimpl.ActivityDAOImpl;

import com.xmlg.ctc.entity.Activity;

public class ActivityService {
	private ActivityDAO activityDAO = new ActivityDAOImpl();

	public List<Activity> queryAllActivity(int page, int size) {
		if (page < 0 || size < 0) {
			return null;
		} else {
			// 能够进入数据层取到相应的数据
			return activityDAO.queryAllActivity(page, size);
		}
	}
}
