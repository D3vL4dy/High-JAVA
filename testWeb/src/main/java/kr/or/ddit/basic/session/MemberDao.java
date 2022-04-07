package kr.or.ddit.basic.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kr.or.ddit.basic.util.DBUtil3;

public class MemberDao {
	private static MemberDao dao;
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	
	public MemberVO getMember(MemberVO memVo) {
		MemberVO returnMemberVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from mymember "
					+ "where mem_id=? and mem_pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			
			rs = pstmt.executeQuery();
			
			// 데이터가 1개이기 때문에 while문 대신 if문 사용
			if(rs.next()) {
				returnMemberVo = new MemberVO();
				returnMemberVo.setMem_id(rs.getString("mem_id"));
				returnMemberVo.setMem_name(rs.getString("mem_name"));
				returnMemberVo.setMem_pass(rs.getString("mem_pass"));
				returnMemberVo.setMem_tel(rs.getString("mem_tel"));
				returnMemberVo.setMem_addr(rs.getString("mem_addr"));
			}
		} catch (SQLException e) {
			returnMemberVo = null;
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return returnMemberVo;
	}
}
