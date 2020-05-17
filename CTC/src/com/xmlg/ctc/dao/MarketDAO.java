package com.xmlg.ctc.dao;

import java.util.List;

import com.xmlg.ctc.entity.Friend;
import com.xmlg.ctc.entity.Market;

public interface MarketDAO {
	public int addMarket(Market market);//发布商品
	
	public List<Market> queryAllMarkets(String MName, double MPrice, int MState,
			String MPhoto, String MTime,int Mphone);//输出所有商品信息
	
}
