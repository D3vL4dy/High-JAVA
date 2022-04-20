package cumtrip.detail.controller;

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

import com.google.gson.Gson;

import cumtrip.detail.service.DetailService;
import cumtrip.vo.MiddleVO;
import cumtrip.vo.MiddleinfoVO;

/**
 * Servlet implementation class Aroundspacephoto
 */
@WebServlet("/aroundrestaurant.do")
public class Aroundrestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			DetailService service = DetailService.getInstance();
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			List<MiddleinfoVO> list = null;
			PrintWriter out = response.getWriter();
			String si = 	request.getParameter("si");
			String gun = 	request.getParameter("gun");
			Map<String,String> map = new HashMap<String, String>();
			map.put("si", si);
			map.put("gun", gun);
			list = service.aroundrestaurantphoto(map);
			
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
