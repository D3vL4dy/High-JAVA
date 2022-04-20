package cumtrip.detail.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cumtrip.detail.service.DetailService;
import cumtrip.vo.M_commentVO;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class Insertcomment
 */
@WebServlet("/insertcomment.do")
public class Insertcomment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			M_commentVO mvo = new M_commentVO();
			DetailService service = DetailService.getInstance();
			PrintWriter out = response.getWriter();
			
			String mreno = request.getParameter("mreno");
			String content = request.getParameter("content");
			HttpSession session = request.getSession();
			MemberVO vo = (MemberVO)session.getAttribute("loginmember");
			String email = vo.getMem_email();
			
			mvo.setCom_content(content);
			mvo.setMem_email(email);
			mvo.setMre_no(mreno);
			
			int result = service.insertcomment(mvo);
			
			Gson gson = new Gson();
			String jsondata =  gson.toJson(result);
			
			out.write(jsondata);
			response.flushBuffer();
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
