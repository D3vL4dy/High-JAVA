package kr.or.ddit.basic.reqNres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int a = Integer.parseInt(request.getParameter("number1"));
		int b = Integer.parseInt(request.getParameter("number2"));
		String op = request.getParameter("op");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습 Form</title></head>");
		out.println("<body>");
		
		out.println("<h2>계산 결과</h2>");
		
		double result = 0; // 계산 결과가 저장될 변수
		boolean calcOK = true; // 계산 성공 여부가 저장될 변수
		
		// switch문
		switch(op) {
	      case "+" : result = a + b; break;
	      case "-" : result = a - b; break;
	      case "*" : result = a * b; break;
	      case "/" : 
	         if(b != 0) {
	            result = (double)a / b; break;   
	         } else {
	        	 calcOK = false;
	         }
	         break;
	      case "%" : 
	         if(b != 0) {
	            result = a % b; break;   
	         } else {
	        	 calcOK = false;
	         }
	         break;
	      }
		
		out.println(a + op + b + " = ");
		if(calcOK==true) {
			out.println(result);
		}else {
			out.println("계산 불능 (0으로 나누기)");
		}
		
		// if문
//		if(op.equals("+")) {
//			out.println(a + op + b + " = " + (a + b));
//		}else if(op.equals("-")) {
//			out.println(a + op + b + " = " + (a - b));
//		}else if(op.equals("*")) {
//			out.println(a + op + b + " = " + (a * b));
//		}else if(op.equals("/")){
//			out.println(a + op + b + " = " + ((double)a / b));
//		}else {
//			out.println(a + op + b + " = " + (a % b));
//		}
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
