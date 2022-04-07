package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/jsonController.do")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setCharacterEncoding("utf-8");
		// 응답 데이터가 JSON데이터일 경우 ContentType을 아래와 같이 변경한다.
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();

		String choice = request.getParameter("choice");

		// Gson객체 생성
		Gson gson = new Gson();

		// JSON으로 변환된 문자열이 저장될 변수 선언
		String jsonData = null;
		switch (choice) {
		case "string":
			String str = "안녕하세요.";
			
			// 전송할 데이터를 JSON형태의 문자열로 변환한다.
			// Gson객체의 toJson()메서드 이용
			jsonData = gson.toJson(str);
			
			break;
		}
		System.out.println("jsonData => " + jsonData);
		out.write(jsonData);
		response.flushBuffer();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
