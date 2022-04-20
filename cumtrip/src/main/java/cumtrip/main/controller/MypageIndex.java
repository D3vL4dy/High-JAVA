package cumtrip.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cumtrip.vo.MemberVO;


@WebServlet("/MypageIndex.do")
public class MypageIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MypageIndex() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		/*
		 * Session데이터 읽어오기
		 * 1. Session객체 생성 및 현재 세션 가져오기
		 * 
		*/	
		HttpSession session = request.getSession();
		
		/*
		 * 2. Session데이터 가져오기 ==> setAttribute()메서드를 이용한다.
		 * 		형식) Session객체.setAttribute("key값");
		*/
		
		//session값을 개별적으로 구하는 방법
		MemberVO sessionValue = (MemberVO)session.getAttribute("loginMember");
		
		
		

		request.setAttribute("mypageInter", sessionValue);
		request.getRequestDispatcher("view/jsp/forwardDo/mypageInter.jsp").forward(request, response);
		
		
	}

}
