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
 * Servlet implementation class Updatemember
 */
@WebServlet("/updatemember.do")
public class Updatemember extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MemberService service = MemberService.getInstance();
		
		MemberVO vo = new MemberVO();
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String add = request.getParameter("add");
		String tel = request.getParameter("tel");
		vo.setMem_email(email);
		vo.setMem_name(name);
		vo.setMem_addr(add);
		vo.setMem_tel(tel);
		
		int result = 0;
		result = service.updatemember(vo);
		System.out.println(result);
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
