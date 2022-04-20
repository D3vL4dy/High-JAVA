package cumtrip.detail.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import cumtrip.vo.S_commentVO;

/**
 * Servlet implementation class Insertstaycomment
 */
@WebServlet("/insertstaycomment.do")
public class Insertstaycomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		S_commentVO svo = new S_commentVO();
		DetailService service = DetailService.getInstance();
		PrintWriter out = response.getWriter();
		
		String sreno = request.getParameter("sreno");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("loginmember");
		String email = vo.getMem_email();
		
		svo.setSco_content(content);
		svo.setMem_email(email);
		svo.setSre_no(sreno);
		
		int result = service.insertstaycomment(svo);
		
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
