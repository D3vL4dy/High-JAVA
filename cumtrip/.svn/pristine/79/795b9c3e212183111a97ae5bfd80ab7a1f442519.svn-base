package cumtrip.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cumtrip.admin.service.MemberService;
import cumtrip.vo.MemberVO;

/**
 * Servlet implementation class Selectonemember
 */
@WebServlet("/selectonemember.do")
public class Selectonemember extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		
		MemberService service = MemberService.getInstance();
		MemberVO vo = null;
		vo = service.selectMemberone(email);
		Gson gson = new Gson();

		String jsonData = gson.toJson(vo);
		out.write(jsonData);
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
