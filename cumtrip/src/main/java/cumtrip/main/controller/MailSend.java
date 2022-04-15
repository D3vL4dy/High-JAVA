package cumtrip.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import cumtrip.main.service.Mail;


@WebServlet("/MailSend.do")
public class MailSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MailSend() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송데이터 받기		
		String getmail = request.getParameter("mem_email");
		Mail mail = new Mail();
		
		String num = null;
		try {
			num = mail.start(getmail);
			//System.out.println(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4. request에 저장
		request.setAttribute("mailNumber", num);
				
		//view페이지로 forward
		request.getRequestDispatcher("view/jsp/forwardDo/mailsend.jsp").forward(request, response);
	
		
		

		
		
		
	}

}
