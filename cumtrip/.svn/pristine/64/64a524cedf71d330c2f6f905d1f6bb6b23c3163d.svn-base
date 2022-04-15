package cumtrip.admin.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.vo.S_photoVO;

public class PhotoDao {
	private static PhotoDao dao;
	private PhotoDao() {}
	public static PhotoDao getInstance() {
		if(dao == null) dao = new PhotoDao();
		return dao;
	}
	
	public int insertstayphoto(SqlMapClient smc, Map<String,String> map) throws SQLException{
		int result = 0;
		Object temp = null;
		temp = smc.insert("photo.insertstayphoto", map);
		if(temp == null) {
			result = 1;
		}else {
			result =0;
		}
		
		return result;
	}
	public int insertroomphoto(SqlMapClient smc, S_photoVO vo) throws SQLException{
		int result = 0;
		Object temp = null;
		temp = smc.insert("photo.insertroomphoto", vo);
		if(temp == null) {
			result = 1;
		}else {
			result =0;
		}
		
		return result;
	}
}
