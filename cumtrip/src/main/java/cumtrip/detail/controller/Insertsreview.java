package cumtrip.detail.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cumtrip.admin.controller.Fileinfo;
import cumtrip.detail.service.DetailService;
import cumtrip.vo.M_reviewVO;
import cumtrip.vo.S_reviewVO;

/**
 * Servlet implementation class Insertsreview
 */
@WebServlet("/insertsreview.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024*10,
		maxFileSize = 1024*1024*30,
		maxRequestSize = 1024*1024*50
		)
public class Insertsreview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		DetailService service = DetailService.getInstance();
		S_reviewVO vo = new S_reviewVO();
		
		String stayno = request.getParameter("stayno");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int point = Integer.parseInt(request.getParameter("point"));
//		HttpSession session = request.getSession();
//		session.getAttribute("id");
		String email = "dkrnq@naver.com";
		
		vo.setMem_email(email);
		vo.setStay_no(stayno);
		vo.setSre_content(content);
		vo.setSre_title(title);
		vo.setSre_point(point);

		List<Fileinfo> list = new ArrayList<Fileinfo>();
		
		String uploadPath = "d:/연습용산출물/traveler/review/";
		
		File fdir = new File(uploadPath);
		if(!fdir.exists()) {
			fdir.mkdirs();
		}
		
		String fileName = ""; //파일명이 저장될 변수명 
		Map<String, String> filemap = new HashMap<String,String>();
	 
		 int fileresult = 0;
		 //전체 Part객체 개수만큼 반복 	
		 for(Part part : request.getParts()) {
			 // 1개의 업로드 파일 정보를 구한다. 
			 fileName = extractFilename(part);
			
			 if(!fileName.equals("")) {
			 
				 Fileinfo finfo = new Fileinfo();
				 finfo.setFileName(fileName);
				 finfo.setFileSize((int)Math.ceil((part.getSize()/1024.0)));
				 try {
					 //Upload된 파일을 서버쪽 저장장소에 저장한다. 
					 part.write(uploadPath+File.separator+fileName);
					 finfo.setStatus("Success");
				} catch (IOException e) {
					finfo.setStatus("fail : " +e.getMessage());
				}
				 list.add(finfo); // 파일 정보를 List에 추가
				 vo.setSre_imgpath(fileName);
			 }
		 }
		 int result =service.insertsreview(vo);
		 
		 response.sendRedirect("/cumtrip/view/jsp/detailpagestay.jsp?stayno="+stayno+"");
		 
	}

	private String extractFilename(Part part) {
		String fileName = "";
		
		//각 Part의 Content-Dispostion의 값 구하기 
		String contentDispostion =
				part.getHeader("Content-Disposition");
		String[] items = contentDispostion.split(";");
		for(String item : items) {
			// 파일 정보 찾기 
			if(item.trim().startsWith("filename")) {
				// fileName="test1.txt"
				fileName = item.substring(item.indexOf("=")+2,item.length()-1);
			}
		}
		
		return fileName;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}