package cumtrip.main.service;

import java.sql.SQLException;
import java.util.List;

import cumtrip.admin.dao.PhotoDao;
import cumtrip.main.dao.PhotoDaoImpl;


public class PhotoServiceImpl{
	
	private PhotoDaoImpl dao;
	private static PhotoServiceImpl service;
	
	private PhotoServiceImpl() {
		
		dao = PhotoDaoImpl.getInstance();
	}
	
	public static PhotoServiceImpl getInstance() {
		if(service == null) service = new PhotoServiceImpl();
		return service;
		
	}


	public List<String> selectphoto() {
		List<String> photo=null;
		
		try {
			photo = dao.selectphoto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photo;
	}

}
