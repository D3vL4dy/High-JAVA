package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.MainDao;
import cumtrip.admin.dao.PlaceDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.MiddleVO;

public class MainService {
	private MainDao dao;
	private static MainService service;
	
	private MainService() {
		dao = MainDao.getInstance();
	}
	public static MainService getInstance() {
		if(service == null) service = new MainService();
		return service;
	}
	
	public List<String> spacemain(){
		SqlMapClient smc = null;
		List<String> list = null;
		
		try {
		smc = SqlMapClientFactory.getsqlMapClient();
		list = dao.spacemain(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<String> restaurntmain(){
		SqlMapClient smc = null;
		List<String> list = null;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			list = dao.restaurantmain(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<String> staymain(){
		SqlMapClient smc = null;
		List<String> list = null;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			list = dao.staymain(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
