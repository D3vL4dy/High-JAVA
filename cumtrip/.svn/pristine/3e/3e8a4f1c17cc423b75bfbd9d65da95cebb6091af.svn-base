package cumtrip.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cumtrip.admin.service.RestaurantService;
import cumtrip.vo.MiddleVO;

/**
 * Servlet implementation class Updatespace
 */
@WebServlet("/updatespace.do")
public class Updatespace extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		RestaurantService service = RestaurantService.getInstance();
		
		MiddleVO vo = new MiddleVO();
		String midno = request.getParameter("midno");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		double xsite =  Double.parseDouble(request.getParameter("xsite"));
		double ysite =  Double.parseDouble(request.getParameter("ysite"));
		String web = request.getParameter("web");
		String time = request.getParameter("time");
		String code = request.getParameter("code");
		String ex = request.getParameter("ex");
		String cost = request.getParameter("cost");
		vo.setMid_no(midno);
		vo.setMid_name(name);
		vo.setMid_location(addr);
		vo.setMid_x(xsite);
		vo.setMid_y(ysite);
		vo.setMid_web(web);
		vo.setMid_time(time);
		vo.setMain_code(code);
		vo.setMid_ex(ex);
		vo.setMid_cost(cost);
		
		int result = 0;
		result = service.updaterestaurant(vo);
		System.out.println(result);
		response.sendRedirect(request.getContextPath()+"/admin/selectspace.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
