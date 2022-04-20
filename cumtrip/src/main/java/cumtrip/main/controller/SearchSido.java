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

import cumtrip.main.service.IMemberService;
import cumtrip.main.service.MemberServicelmpl;
import cumtrip.vo.Lo_searchVO;


@WebServlet("/SearchSido.do")
public class SearchSido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchSido() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");	
		IMemberService service = MemberServicelmpl.getInstance();
		List<Lo_searchVO> list = service.getSido();
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		
		 String jsonData =	gson.toJson(list);
		
		 out.write(jsonData);
		 out.flush();
		 
		 
		 
		
	}

}
