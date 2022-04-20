package cumtrip.detail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cumtrip.detail.service.DetailService;
import cumtrip.submain.service.ISubmainService;
import cumtrip.submain.service.SubmainServiceImpl;
import cumtrip.vo.SubPrintVO;

/**
 * Servlet implementation class Selectonephoto
 */
@WebServlet("/selectonephoto.do")
public class Selectonephoto extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	  DetailService service = DetailService.getInstance();
	 	
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String midno = request.getParameter("midno");
		
		List<String> list = service.selectonephoto(midno);
		
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
