package cumtrip.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cumtrip.admin.service.PlaceService;
import cumtrip.admin.service.StayService;
import cumtrip.vo.MiddleVO;
import cumtrip.vo.StayVO;

/**
 * Servlet implementation class Selectonestay
 */
@WebServlet("/selectonestay.do")
public class Selectonestay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String stayno = request.getParameter("stayno");
		
		StayService service = StayService.getInstance();
		StayVO vo = null;
		vo = service.selectonestay(stayno);
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
