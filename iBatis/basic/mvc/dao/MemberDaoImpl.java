package kr.or.ddit.basic.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.mvc.vo.MemberVo;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao{
	
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() {}
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		Object obj = smc.insert("member.insertMember", memberVo);
		
		return obj;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		int cnt = (int) smc.delete("member.insertMember", memId);
		
		return cnt;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		int cnt = (int) smc.delete("member.updateMember", memberVo);
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException {
		List<MemberVo> memList = smc.queryForList("member.getAllMember");
		
		return memList;
	}

	@Override
	public int getMemberCount(SqlMapClient smc, String memId) throws SQLException {
		int count = (int) smc.queryForObject("member.getMemberCount", memId);

        return count;
	}

//	@Override
//	public int updateMember2(SqlMapClient smc, Map<String, String> paramMap) throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}



}
