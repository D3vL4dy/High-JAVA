package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

/**
 * Service객체는 DAO에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 
 * 받아온 결과 자료를 Controller에게 보내주는 역할을 한다.
 * 
 * @author PC-14
 *
 */

public interface IBoardService {
	
	/**
	 * BoardVo에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업 성공 : 1, insert 작업 실패 : 0
	 */
	public int insertBoard(BoardVO boardVo);
	
	/**
	 * BoardVo자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param memVo update할 회원 정보가 저장된 BoardVO객체
	 * @param boardNo delete할 게시글 번호가 저장된 BoardNO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMember(BoardVO boardVo, int boardNo);
	
	/**
	 * 글번호를 매개변수로 받아 해당 게시글을 delete하는 메서드
	 * 
	 * @param boardNo delete할 게시글 번호가 저장된 BoardNO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMember(int boardNo);
	
	/**
	 * DB의 전체 게시글을 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return BoardVO객체가 저장된 List
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 글번호를 매개변수로 받아 해당 게시글을 가져와서 List에 담아 반환하는 메서드
	 * 
	 * @return BoardVO객체가 저장된 List
	 */
	public List<BoardVO> getBoardNo_Select();
	
}
