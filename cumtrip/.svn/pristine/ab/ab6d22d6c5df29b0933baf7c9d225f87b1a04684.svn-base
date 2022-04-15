package cumtrip.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cumtrip.admin.service.MemberService;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class Updatemember2
 */
@WebServlet("/updatemember2.do")
public class Updatemember2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MemberService service = MemberService.getInstance();
		
		MemberVO vo = new MemberVO();
		String email = request.getParameter("email");
		System.out.println(email);
		int result = 0;
		
		result = service.updatemember2(email);
		
		response.sendRedirect(request.getContextPath()+"/admin/membertable.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
