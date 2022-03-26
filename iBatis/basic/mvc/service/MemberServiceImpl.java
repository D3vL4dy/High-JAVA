package kr.or.ddit.basic.mvc.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;

	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance(); 
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	Scanner scan = new Scanner(System.in);
	SqlMapClient smc = null;

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = dao.insertMember(smc, memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = dao.deleteMember(smc, memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			cnt = dao.updateMember(smc, memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = null;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			memList = dao.getAllMember(smc);
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0;
		try {
			smc = SqlMapClientFactory.getSqlMapClient();
			count = dao.getMemberCount(smc, memId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

//	@Override
//	public int updateMember2(Map<String, String> paramMap) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	

}