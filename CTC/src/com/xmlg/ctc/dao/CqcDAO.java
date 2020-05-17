package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.Cqc;




/**
 * @author 饶金鑫
 * @since 2018年1月10日22:03:11
 */
public interface CqcDAO {
	public boolean addCqc(Cqc c);
	
	public int deleteCqc(int cqc_id);

	public Cqc queryCqc(String stuid);
	
	public List<Cqc> queryAllCqc();

	public int getCount();
	
	public boolean addCqcNum(Cqc cqc);

}
