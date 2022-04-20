package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cumtrip.main.service.PhotoServiceImpl;
import cumtrip.vo.PhotoVO;

@WebServlet("/PhotoServlet.do")
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PhotoServiceImpl service = PhotoServiceImpl.getInstance();
		
		//3.service메소드 호출하기
		List<String> res = service.selectphoto();
		
		
		Gson gson = new Gson();
		String jsondata = gson.toJson(res);
		
		PrintWriter out = response.getWriter();
		out.write(jsondata);
		out.flush();
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
//		vo.setPhoto_no(request.getParameter("photo_no"));
//		vo.setPhoto_path(request.getParameter("photo_path"));
//		//4.결과값을 request에 저장하기
//		request.setAttribute("res1", res);
//		//form에서 입력한 값 가져오기
//		request.setAttribute("res2", vo.getPhoto_path());
//		//5. jsp로 forward
//		request.getRequestDispatcher("").forward(request, response);
		
		
				
			}
	}






















