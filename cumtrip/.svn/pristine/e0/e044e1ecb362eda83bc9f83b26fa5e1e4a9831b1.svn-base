package cumtrip.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cumtrip.admin.service.RestaurantService;
import cumtrip.admin.service.StayService;
import cumtrip.vo.MiddleVO;
import cumtrip.vo.StayVO;

/**
 * Servlet implementation class Updatestay
 */
@WebServlet("/updatestay.do")

public class Updatestay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		StayService service = StayService.getInstance();
		
		StayVO vo = new StayVO();
		String stayno = request.getParameter("stayno");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		double xsite =  Double.parseDouble(request.getParameter("xsite"));
		double ysite =  Double.parseDouble(request.getParameter("ysite"));
		String code = request.getParameter("code");
		String ex = request.getParameter("ex");
		vo.setStay_no(stayno);
		vo.setStay_name(name);
		vo.setStay_location(addr);
		vo.setStay_x(xsite);
		vo.setStay_y(ysite);
		vo.setStay_cate(code);
		vo.setStay_ex(ex);
		
		int result = 0;
		result = service.updatestay(vo);
		System.out.println(result);
		response.sendRedirect(request.getContextPath()+"/admin/selectstay.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
