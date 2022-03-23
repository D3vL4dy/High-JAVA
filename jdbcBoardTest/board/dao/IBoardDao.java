package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 Service에 전달하는 Dao의 interface
 * 
 * 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * 
 * @author PC-14
 *
 */

public interface IBoardDao {
	
	/**
	 * BoardVo에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param conn java.sql.Connecion객체
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVO 객체
	 * @return 작업 성공 : 1, insert 작업 실패 : 0
	 * @throws SQLException
	 */
	public int insertBoard(Connection conn, BoardVO boardVo) throws SQLException;
	
	/**
	 * 글번호를 매개변수로 받아 해당 게시글을 update하는 메서드
	 * 
	 * @param conn Connection객체
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVO 객체
	 * @param boardNo update할 게시글 번호가 저장된 BoardNO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 * @throws SQLException
	 */
	public int updateBoard(Connection conn, BoardVO boardVo, int boardNo) throws SQLException;
	
	/**
	 * 글번호를 매개변수로 받아 해당 게시글을 delete하는 메서드 
	 * 
	 * @param conn Connection객체
	 * @param boardNo delete할 게시글 번호가 저장된 BoardNO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 * @throws SQLException
	 */
	public int deleteBoard(Connection conn, int boardNo) throws SQLException;
	
	/**
	 * DB의 전체 게시글을 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @param conn Connection객체
	 * @return BoardVO객체가 저장된 List
	 * @throws SQLException
	 */
	public List<BoardVO> getAllBoard(Connection conn) throws SQLException;
	
	/**
	 * 글번호를 매개변수로 받아 해당 게시글을 가져와서 List에 담아 반환하는 메서드
	 * 
	 * @param conn Connection객체
	 * @param boardNo select할 게시글 번호가 저장된 BoardNO객체
	 * @return BoardVO객체가 저장된 List
	 * @throws SQLException
	 */
	public List<BoardVO> getBoardNo_Select(Connection conn, int boardNo) throws SQLException;
	
	/**
	 * 문자를 매개변수로 받아 해당 게시글을 가져와서 List에 담아 반환하는 메서드
	 * 
	 * @param conn Connection객체
	 * @param boardTitle select할 문자가 저장된 BoardNO객체
	 * @return BoardVO객체가 저장된 List
	 * @throws SQLException
	 */
	public List<BoardVO> selectBoard(Connection conn, String boardTitle) throws SQLException;
	
	/**
	 * 글번호를 매개변수로 받아 해당 게시글의 조회수를 update하는 메서드
	 * 
	 * @param conn Connection객체
	 * @param boardNo update할 게시글 번호가 저장된 BoardNO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 * @throws SQLException
	 */
	public int updateCnt(Connection conn, int boardNo) throws SQLException;
	
}
