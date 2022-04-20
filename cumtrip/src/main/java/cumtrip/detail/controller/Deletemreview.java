package cumtrip.detail.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cumtrip.detail.service.DetailService;
import cumtrip.vo.M_reviewVO;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class Deletemreview
 */
@WebServlet("/Deletemreview.do")
public class Deletemreview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		DetailService service = DetailService.getInstance();
		M_reviewVO vo = new M_reviewVO();
		
		String midno = request.getParameter("midno");
		System.out.println(midno);
		String mreno = request.getParameter("mreno");
		System.out.println(mreno);
		
		HttpSession session = request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("loginMember");
		
		vo.setMre_no(mreno);
		
		int result = service.deletemreview(vo);
		System.out.println(result);
		
		response.sendRedirect("/cumtrip/view/jsp/detailpage.jsp?midno="+midno+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
