package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao{
	
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {};
	
	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBoard(Connection conn, BoardVO boardVo) throws SQLException {
		String sql = "insert into jdbc_board "
				+ "(board_no, board_title, board_writer, board_date, board_cnt, board_content) "
				+ "values(board_seq.nextVal, ?, ?, sysdate, 0, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getBoard_title());
		pstmt.setString(2, boardVo.getBoard_writer());
		pstmt.setString(3, boardVo.getBoard_content());
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt!=null) pstmt.close();
		
		return cnt;
	}

	@Override
	public int updateBoard(Connection conn, BoardVO boardVo, int boardNo) throws SQLException {
		String sql = "update jdbc_board set "
				+ "board_title = ?, board_writer = ? "
				+ "where board_no = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getBoard_title());
		pstmt.setString(2, boardVo.getBoard_writer());
		pstmt.setInt(3, boardNo);

		int cnt = pstmt.executeUpdate();
		
		if(pstmt!=null) pstmt.close();
		
		return cnt;
	}

	@Override
	public int deleteBoard(Connection conn, int boardNo) throws SQLException {
		String sql = "delete from jdbc_board where board_no = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt!=null) pstmt.close();
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard(Connection conn) throws SQLException {
		List<BoardVO> boardList = null; // 반환값이 저장될 변수
		String sql = "select board_no, board_title, board_writer, board_cnt from jdbc_board";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		boardList = new ArrayList<BoardVO>();
		while(rs.next()) { // 포인터가 가리키는 곳이 하나의 레코드
			BoardVO boardVo = new BoardVO(); // 1개의 레코드가 저장될 변수
			boardVo.setBoard_no(rs.getInt("board_no"));
			boardVo.setBoard_title(rs.getString("board_title"));
			boardVo.setBoard_writer(rs.getString("board_writer"));
			boardVo.setBoard_cnt(rs.getInt("board_cnt"));
			
			boardList.add(boardVo); // List에 baordVO객체 추가
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
			
		return boardList;
	}

	@Override
	public List<BoardVO> getBoardNo_Select(Connection conn, int boardNo) throws SQLException {
		List<BoardVO> boardList = null; // 반환값이 저장될 변수
		String sql = "select * from jdbc_board where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		
		ResultSet rs = pstmt.executeQuery();

		boardList = new ArrayList<BoardVO>();
		if(rs.next()) {
			BoardVO boardVo = new BoardVO(); // 1개의 레코드가 저장될 변수
			boardVo.setBoard_title(rs.getString("board_title"));
			boardVo.setBoard_writer(rs.getString("board_writer"));
			boardVo.setBoard_content(rs.getString("board_content"));
			boardVo.setBoard_date(rs.getDate("board_date"));
			boardVo.setBoard_cnt(rs.getInt("board_cnt"));
			
			boardList.add(boardVo); // List에 baordVO객체 추가
		}

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();

		return boardList;
	}

	@Override
	public List<BoardVO> selectBoard(Connection conn, String boardTitle) throws SQLException {
		List<BoardVO> boardList = null; // 반환값이 저장될 변수
		String sql = "select * from jdbc_board where board_title like '%' || ? || '%'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardTitle);
		
		ResultSet rs = pstmt.executeQuery();

		boardList = new ArrayList<BoardVO>();
		if(rs.next()) {
			BoardVO boardVo = new BoardVO(); // 1개의 레코드가 저장될 변수
			boardVo.setBoard_no(rs.getInt("board_no"));
			boardVo.setBoard_title(rs.getString("board_title"));
			boardVo.setBoard_writer(rs.getString("board_writer"));
			boardVo.setBoard_date(rs.getDate("board_date"));
			
			boardList.add(boardVo); // List에 baordVO객체 추가
		}

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();

		return boardList;
	}

	@Override
	public int updateCnt(Connection conn, int boardNo) throws SQLException {
		String sql = "update jdbc_board set "
				+ "board_cnt = board_cnt+1 where board_no = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);

		int cnt = pstmt.executeUpdate();
		
		if(pstmt!=null) pstmt.close();
		
		return cnt;
	}

}
