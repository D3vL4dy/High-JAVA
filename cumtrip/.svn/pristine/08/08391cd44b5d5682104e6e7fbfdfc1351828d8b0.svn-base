package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class MypageLikejjim
 */
@WebServlet("/MypageLikejjim.do")
public class MypageLikejjim extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String no1 = request.getParameter("number_no");
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");
		
		
		
		MemberVO vo = new MemberVO();
		vo.setMre_no(no1);
		vo.setMem_email(sessionValue.getMem_email());
		
		//2.service객체 얻기
		IMemberService service = MemberServicelmpl.getInstance();

		
		//3.service메소드 호출하기
		int res = service.likeMypagedelect(vo);
		request.setAttribute("res1", res);

	
		request.getRequestDispatcher("view/jsp/forwardDo/result2.jsp").forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String no1 = request.getParameter("number_no");
		
		HttpSession session = request.getSession();
		
		List<MemberVO> sessionValue = (List<MemberVO>)session.getAttribute("loginMember");
		
		String mem_mailset = null;
		for(MemberVO vo2 : sessionValue) {
			mem_mailset = vo2.getMem_email();
		}
		
		
		MemberVO vo = new MemberVO();
		vo.setMre_no(no1);
		vo.setMem_email(mem_mailset);
		
		//2.service객체 얻기
		IMemberService service = MemberServicelmpl.getInstance();

		
		//3.service메소드 호출하기
		int res = service.likeMypagedelect2(vo);
		request.setAttribute("res1", res);

	
		request.getRequestDispatcher("view/jsp/forwardDo/result2.jsp").forward(request, response);
		
	}

}
