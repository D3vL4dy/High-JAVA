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

import cumtrip.admin.service.MemberService;
import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class Mypage_update
 */
@WebServlet("/Mypage_update.do")
public class Mypage_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Mypage_update() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");
		//String mem_mailset = sessionValue.getMem_email();


		sessionValue.setMem_pass(request.getParameter("mem_pass"));
		sessionValue.setMem_name(request.getParameter("mem_name"));
		sessionValue.setMem_addr(request.getParameter("mem_addr"));
		sessionValue.setMem_tel(request.getParameter("mem_tel"));
		

		
		//2.service객체 얻기
		IMemberService service = MemberServicelmpl.getInstance();
		
		//3.service메소드 호출하기
		int res = service.updateMember_Mypage(sessionValue);
		
		//4.결과값을 request에 저장하기
		request.setAttribute("res1", res);
		//5. jsp로 forward
		request.getRequestDispatcher("view/jsp/forwardDo/result2.jsp").forward(request, response);
		
		
	}

}
