package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao dao;
	
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		Connection conn = null;
		int cnt = 0; // 반환값 변수
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.insertBoard(conn, boardVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int updateMember(BoardVO boardVo, int boardNo) {
		Connection conn = null;
		int cnt = 0; // 반환값 변수
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateBoard(conn, boardVo, boardNo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteMember(int boardNo) {
		Connection conn = null;
		int cnt = 0; // 반환값 변수
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.deleteBoard(conn, boardNo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		Connection conn = null;
		List<BoardVO> memList = null;
		
		try {
			conn = DBUtil3.getConnection();
			memList = dao.getAllBoard(conn);
			
		} catch (SQLException e) {
			memList = null;
		} finally {
			if(conn != null) try { conn.close(); } catch (SQLException e) {}
		}
		return memList;
	}

	@Override
	public List<BoardVO> getBoardNo_Select() {
		Connection conn = null;
		List<BoardVO> memList = null;
		
		try {
			conn = DBUtil3.getConnection();
			memList = dao.getAllBoard(conn);
			
		} catch (SQLException e) {
			memList = null;
		} finally {
			if(conn != null) try { conn.close(); } catch (SQLException e) {}
		}
		return memList;
	}

}
