package cumtrip.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.admin.dao.MemberDao;
import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.MemberVO;

public class MemberService {
	private MemberDao dao;
	private static MemberService service;
	
	private MemberService() {
		dao = MemberDao.getInstance();
	}
	public static MemberService getInstance() {
		if(service == null) service = new MemberService();
		return service;
	}
	
	public List<MemberVO> selectMember(){
		SqlMapClient smc = null;
		List<MemberVO> list = null;
		
		try {
		smc = SqlMapClientFactory.getsqlMapClient();
		list = dao.selectMember(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public MemberVO selectMemberone(String email){
		SqlMapClient smc = null;
		MemberVO vo = null;
		
		try {
		smc = SqlMapClientFactory.getsqlMapClient();
		vo  = dao.selectMemberone(smc, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	public int updatemember( MemberVO vo){
		SqlMapClient smc = null;
		int result = 0;
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.updatemember(smc, vo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	public int updatemember2( String email){
		SqlMapClient smc = null;
		int result = 0;
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.updatemember2(smc, email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
}
