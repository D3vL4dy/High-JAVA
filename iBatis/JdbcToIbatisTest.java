package kr.or.ddit.basic;

//import java.io.IOException;
//import java.io.Reader;
//import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

//import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
//import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.LprodVO;

/*
 * Lprod테이블에 새로운 데이터를 추가하기
 * 
 * lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 * lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1크게 한다.
 * 
 * 그리고 lprod_gu가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 * 
 * (SQL문이 저장된 xml문서의 파일명 : jdbc.xml)
 */

public class JdbcToIbatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SqlMapClient smc = null;

		try {
//			Charset charset = Charset.forName("utf-8");
//			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapconfig.xml");
//
//			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//
//			rd.close();
			
			smc = SqlMapClientFactory.getSqlMapClient();

			// lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1크게 한다.
			int nextId = (int) smc.queryForObject("jdbc.getMaxId");
			nextId++;

			// 입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력받아서 처리한다.
			String gu;
			int count = 0;
			
			do {
				System.out.print("lprod_gu 입력 : ");
				gu = scan.next();

				count = (int) smc.queryForObject("jdbc.getLprodCount", gu);
				if (count > 0) {
					System.out.println("입력한 상품분류코드 " + gu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요.");
				}
			} while (count > 0);

			System.out.print("lprod_nm 입력 >> ");
			String nm = scan.next();

			// 입력값을 VO에 담는다.
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(nextId);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);

			// sqlMapClient객체변수를 이용해서 처리할 쿼리문을 호출하여 실행한다.
			// 형식) smc.insert("namespace값.id값", 파라미터클래스);
			// 반환값 => insert성공 : null / 실패 : 오류객체
			Object obj = smc.insert("lprod.insertLprod", lvo);
			
			if (obj == null) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
		}

	}
}
