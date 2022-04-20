package cumtrip.main.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.util.SqlMapClientFactory;

public class PhotoDaoImpl{
	
	private SqlMapClient client;
	private static PhotoDaoImpl dao;
	
	private  PhotoDaoImpl() {
		client = SqlMapClientFactory.getsqlMapClient();
	}
	
	public static PhotoDaoImpl getInstance() {
		if( dao == null ) dao = new PhotoDaoImpl();
		return dao;
	}


	
	public List<String> selectphoto() throws SQLException {
			List<String> list = null;
		
		list = client.queryForList("photo.selectphoto");
		
		return list;
	}


	

}
