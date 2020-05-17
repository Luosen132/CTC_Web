package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.Academic;

public interface AcademicDAO {

	/**
	 * @author 陈梦琳 
	 * */
	//审核通过
	public int addAcademic(String id);

	//删除已发表的学术文章
	public int deleteAcademic(String id);

	public Academic findAcademicById(int id);
	//获得数据库中所有的学术资料
	public List<Academic> allAcademic();
	public List<Academic> queryAcademicForPage(int page,int size);
	public int getCount();
	

	/**
	 *@author 沈益鑫
	 * 
	 */
		public boolean addAcademic(Academic academic) ;
		public List<Academic> AcademicSearch();
		public List<Academic> AcademicSearchByID(int acid);
		public List<Academic> AcademicSearchHeadline(String headline);
		
		public List<Academic> presonAcademicSearch(String userno);

}
