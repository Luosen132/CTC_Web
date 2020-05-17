/**
 * 
 */
package com.xmlg.ctc.dao;

import java.util.List;
import com.xmlg.ctc.entity.PrLetter;

/**
 * @author 罗钦
 *
 */
public interface PrLetterDAO {
	public int addFriendRe(PrLetter a);
	public int modifyFriendRe(int pr_id);
	public List<PrLetter> queryFriendRes(int u_friendid,int fr_friendid );
	public int queryLeNum(int fr_id);
	public int querySumNum (String user_id) ;
}
