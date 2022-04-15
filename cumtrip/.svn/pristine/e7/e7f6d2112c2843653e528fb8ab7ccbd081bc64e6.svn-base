package cumtrip.admin.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.vo.RoomVO;
import cumtrip.vo.StayVO;

public class StayDao {
	private static StayDao dao;
	private StayDao() {}
	public static StayDao getInstance() {
		if(dao == null) dao = new StayDao();
		return dao;
	}
	public int updateroom(SqlMapClient smc, Map<String,String> map)throws SQLException{
		int result = 0;
		
		result = smc.update("stay.updateroom", map);
		
		return result;
	}
	public int insertstay(SqlMapClient smc, StayVO vo) throws SQLException{
		int result = 0;
		Object temp = null;
		temp = smc.insert("stay.insertstay", vo);
		if(temp == null) {
			result = 1;
		}else {
			result =0;
		}
		return result;
	}
	public String selectstayno(SqlMapClient smc, Map<String,String> map) throws SQLException {
		String stayno = null;
		
		stayno = (String) smc.queryForObject("stay.selectstayno",map);
		
		return stayno;
	}
	public int insertroom(SqlMapClient smc, Map<String,String> map) throws SQLException{
		int result = 0;
		Object temp = null;
		temp = smc.insert("stay.insertroom", map);
		if(temp == null) {
			result = 1;
		}else {
			result =0;
		}
		return result;
	}
	public List<StayVO> selectallstay(SqlMapClient smc)throws SQLException{
		List<StayVO> list = null;
		list = smc.queryForList("stay.selectallstay");
		return list;
	}
	public int updatestay(SqlMapClient smc, StayVO vo)throws SQLException{
		int result = 0;
		
		result = smc.update("stay.updatestay", vo);
		
		return result;
	}
	public List<RoomVO> selectroom(SqlMapClient smc, String stayno)throws SQLException{
		List<RoomVO> list = null;
		
		list = smc.queryForList("stay.selectroom", stayno);
		return list;
	}
	

	public StayVO selectonestay(SqlMapClient smc, String stayno)throws SQLException{
		StayVO vo = null;
		vo = (StayVO)smc.queryForObject("stay.selectonestay", stayno);
		return vo;
		
	}
}
