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
import cumtrip.admin.service.StayService;
import cumtrip.vo.MemberVO;
import cumtrip.vo.RoomVO;

/**
 * Servlet implementation class Selectroom
 */
@WebServlet("/selectroom.do")
public class Selectroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String stayno = request.getParameter("stayno");
		
		StayService service = StayService.getInstance();
		List<RoomVO> list = service.selectroom(stayno);
		
		Gson gson = new Gson();

		String jsonData = gson.toJson(list);
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
