package cumtrip.submain.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cumtrip.util.SqlMapClientFactory;
import cumtrip.vo.SubPrintVO;

//mapper접근 - SqlMapClient객체가 필요
//dao클래스 객체 생성 - 리턴 - service에서 사용
public class SubmainDaoImpl implements ISubmainDao{
	private SqlMapClient client;
	private static ISubmainDao dao;
	
	private SubmainDaoImpl() {
		client = SqlMapClientFactory.getsqlMapClient();
	}
	
	public static ISubmainDao getInstance() {
		if(dao == null) dao = new SubmainDaoImpl();
		return dao;
	}
	
	@Override
	public List<SubPrintVO> tPrint() throws SQLException {
		return client.queryForList("sub.tprint"); // namespace.id
	}

	@Override
	public List<SubPrintVO> fPrint() throws SQLException {
		return client.queryForList("sub.fprint"); // namespace.id
	}


}
