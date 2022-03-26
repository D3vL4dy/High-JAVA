package kr.or.ddit.basic.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;
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
	
	SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
	
	@Override
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(memVo.getMem_id());
		memberVo.setMem_pass(memVo.getMem_pass());
		memberVo.setMem_name(memVo.getMem_name());
		memberVo.setMem_tel(memVo.getMem_tel());
		memberVo.setMem_addr(memVo.getMem_addr());
		
		Object obj = smc.insert("member.insertMember", memberVo);
		
		if (obj == null) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		return 0;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(memId);
		
		int cnt = smc.delete("member.insertMember", memId);
		
		if (cnt > 0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		return 0;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_pass(memVo.getMem_pass());
		memberVo.setMem_name(memVo.getMem_name());
		memberVo.setMem_tel(memVo.getMem_tel());
		memberVo.setMem_addr(memVo.getMem_addr());
		memberVo.setMem_id(memVo.getMem_id());
		
		int cnt = smc.delete("member.updateMember", memberVo);
		
		if (cnt > 0) {
			System.out.println("update 성공");
		} else {
			System.out.println("update 실패");
		}
		return 0;
	}

	@Override
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberCount(SqlMapClient smc, String memId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int updateMember2(SqlMapClient smc, Map<String, String> paramMap) throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}



}
