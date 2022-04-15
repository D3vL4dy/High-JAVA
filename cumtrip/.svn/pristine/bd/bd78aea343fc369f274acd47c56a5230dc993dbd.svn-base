package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.MemberDao;
import cumtrip.admin.dao.PhotoDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.MemberVO;
import cumtrip.vo.S_photoVO;

public class PhotoService {
	private PhotoDao dao;
	private static PhotoService service;
	
	private PhotoService() {
		dao = PhotoDao.getInstance();
	}
	public static PhotoService getInstance() {
		if(service == null) service = new PhotoService();
		return service;
	}
	
	public int insertstayphoto(Map<String,String> map) {
		SqlMapClient smc = null;
		int result = 0;
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.insertstayphoto(smc, map);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
	public int insertroomphoto(S_photoVO vo) {
		SqlMapClient smc = null;
		int result = 0;
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.insertroomphoto(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return result;
	}
}
