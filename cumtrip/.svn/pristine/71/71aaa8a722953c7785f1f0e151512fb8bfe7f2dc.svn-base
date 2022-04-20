package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class MypageReview
 */
@WebServlet("/MypageReview.do")
public class MypageReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MypageReview() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");
		
		Map<String,String> v3 = new HashMap<String,String>();
		v3.put("id1", sessionValue.getMem_email());
		v3.put("id2", sessionValue.getMem_email());
		
		//2.service객체 얻기
		IMemberService service = MemberServicelmpl.getInstance();

		
		//3.service메소드 호출하기
		List<MemberVO> res = service.reviweMypage01(v3);
		
		
		
		
		request.setAttribute("res1", res);

	
		request.getRequestDispatcher("view/jsp/forwardDo/mypageReview.jsp").forward(request, response);
	
	}

	
}
