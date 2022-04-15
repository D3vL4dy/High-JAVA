package cumtrip.main.service;

import java.util.List;

import cumtrip.vo.Lo_searchVO;
import cumtrip.vo.MemberVO;


public interface IMemberService {

	
	
	//중복검사 메서드
	public List<MemberVO> Count( String id );
	

	//저장하기
	public String insert( MemberVO vo );
	
	//로그인
	public List<MemberVO> getMember(MemberVO memVo);
	
	//검색시 시도 나오는 메서드
	public List<Lo_searchVO> getSido(Lo_searchVO sidoVo);
	
}
