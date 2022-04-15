package cumtrip.admin.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.vo.MiddleVO;

public class RestaurantDao {
	private static RestaurantDao dao;
	private RestaurantDao() {}
	public static RestaurantDao getInstance() {
		if(dao == null) dao = new RestaurantDao();
		return dao;
	}
	
	public int insertrestaurant(SqlMapClient smc, Map<String,Object> map) throws SQLException{
		int result = 0;
		Object temp = null;
		temp = smc.insert("middle.insertrestaurant", map);
		if(temp == null) {
			result = 1;
		}else {
			result =0;
		}
		
		return result;
	}
	public int insertphoto(SqlMapClient smc, Map<String,String> map) throws SQLException{
		int result = 0;
		Object temp = null;
		temp = smc.insert("photo.insertphoto", map);
		if(temp == null) {
			result = 1;
		}else {
			result =0;
		}
		
		return result;
	}
	public List<MiddleVO> selectallrestaurant(SqlMapClient smc) throws SQLException{
		List<MiddleVO> list = null;
		list = smc.queryForList("middle.selectallrestaurant");
		return list;
	
	}
	public MiddleVO selectonerestaurant(SqlMapClient smc,String midno) throws SQLException{
		MiddleVO vo = null;
		vo = (MiddleVO)smc.queryForObject("middle.selectallrestaurant",midno);
		return vo;
		
	}
	public int updaterestaurant(SqlMapClient smc,MiddleVO vo) throws SQLException{ 
		int result = 0 ;
		
		
		result = smc.update("middle.updaterestaurant", vo);
		
	return result;
	}
	
}