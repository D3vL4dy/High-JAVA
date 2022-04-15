package cumtrip.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindIDpass
 */
@WebServlet("/FindIDpass.do")
public class FindIDpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FindIDpass() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String input = request.getParameter("flag");
		if(input.equals("1")) findId(request, response);
		if(input.equals("2")) findPass(request, response);
		
	}
	
	//아이디찾기
	protected void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("find_name");
		String tel = request.getParameter("find_tel");
		

	}
	
	
	//비밀번호찾기
	protected void findPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("find_name");
		String mail = request.getParameter("find_mail");
		
	}
	
	

}
