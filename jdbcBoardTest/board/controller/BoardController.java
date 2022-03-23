package kr.or.ddit.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private Scanner scan = new Scanner(System.in);
	private IBoardService service;
	
	// 생성자 (singleton 사용)
	public BoardController() {
		service = BoardServiceImpl.getInstance();
	}
	
	// 시작 메서드
	public void startBoard() {
		while (true) {
			displayBoard();
			int choice = displayMenu();

			switch (choice) {
			case 1: // 새글작성
				insertBoard();
				break;
			case 2: // 게시글보기
				boardNo_selectBoard();
				break;
			case 3: // 검색
				selectBoard();
				break;
			case 0: // 작업 끝
				System.out.println("게시판 프로그램 종료....");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}

	private void selectBoard() {
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("-------------------------------------------");
		System.out.print("- 검색할 제목 입력 : ");
		scan.nextLine();
		String boardTitle = scan.nextLine();
		
		List<BoardVO> boardList = service.selectBoard(boardTitle);
		
		if(boardList == null || boardList.size() == 0) {
			
		}else {
			
			for(BoardVO boardVo : boardList) {
				
				int boardNo = boardVo.getBoard_no();
				String boardWriter = boardVo.getBoard_writer();
				int boardCnt = boardVo.getBoard_cnt();
				
				System.out.println();
				System.out.println("-------------------------------------------");
				System.out.println("No\t제 목\t작성자\t조회수");
				System.out.println("-------------------------------------------");
				System.out.println(boardVo.getBoard_no() + "\t" +  boardVo.getBoard_title() + "\t" +  boardWriter + "\t" +  boardCnt);
				System.out.println("-------------------------------------------");
			}
		}
	}

	private void boardNo_selectBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		int boardNo = scan.nextInt();
		int cnt = service.updateCnt(boardNo);
		
		List<BoardVO> boardList = service.getBoardNo_Select(boardNo);
		
		if(boardList == null || boardList.size() == 0) {
			System.out.println("출력할 자료가 없습니다.");
		}else {
			
			for(BoardVO boardVo : boardList) {
				
				String boardTitle = boardVo.getBoard_title();
				String boardWriter = boardVo.getBoard_writer();
				String boardContent = boardVo.getBoard_content();
				Date boardDate = boardVo.getBoard_date();
				int boardCnt = boardVo.getBoard_cnt();
				
				System.out.println();
				System.out.println(boardNo + "번글 내용");
				System.out.println("-------------------------------------------");
				System.out.println(" - 제 목 : " + boardTitle);
				System.out.println(" - 작성자 : " + boardWriter);
				System.out.println(" - 내 용 : " + boardContent);
				System.out.println(" - 작성일 : " + format.format(boardDate));
				System.out.println(" - 조회수 : " + boardCnt);
				System.out.println("-------------------------------------------");
				
				
			}
			System.out.println();
			System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
			System.out.print("작업선택 >> ");
			int input = scan.nextInt();
			
			switch(input) {
			case 1: // 수정
				updateBoard(boardNo);
				break;
			case 2: // 삭제
				deleteBoard(boardNo);
				break;
			}
		}
	}

	private void deleteBoard(int boardNo) {
		
		int cnt = service.deleteBoard(boardNo);
		
		if(cnt > 0) {
			System.out.println();
			System.out.println(boardNo + "번 글이 삭제되었습니다.");
		}else {
			System.out.println("삭제 실패~~");
		}
	}

	private void updateBoard(int boardNo) {
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-------------------------------------------");
		System.out.print("- 제  목 : ");
		scan.nextLine();
		String boardTitle = scan.nextLine();
		
		System.out.print(" - 내 용 >> ");
		scan.nextLine();
		String boardContent = scan.nextLine();
		
		// 입력한 데이터를 VO객체에 저장한다.
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(boardTitle);
		boardVo.setBoard_content(boardContent);
		
		int cnt = service.updateBoard(boardVo, boardNo);
		
		if(cnt > 0) {
			System.out.println(boardNo + "번 글이 수정되었습니다.");
		}else {
			System.out.println("수정 실패!!");
		}
	}

	private void displayBoard() {
		List<BoardVO> boardList = service.getAllBoard();
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println(" No\t제목\t작성자\t조회수");
		System.out.println("-------------------------------------------");
		
		if(boardList == null || boardList.size() == 0) { // 데이터가 없을 경우
			System.out.println("출력할 자료가 하나도 없습니다.");
		}else {
			for(BoardVO boardVo : boardList) {
				int boardNo = boardVo.getBoard_no();
				String boardTitle = boardVo.getBoard_title();
				String boardWriter = boardVo.getBoard_writer();
				int boardCnt = boardVo.getBoard_cnt();
				
				System.out.println(boardNo + "\t" + boardTitle 
						+ "\t" + boardWriter + "\t" + boardCnt);
			}
		}
	}
	
	private void insertBoard() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-------------------------------");

		System.out.print(" - 제 목 >> ");
		scan.nextLine();
		String boardTitle = scan.nextLine();
		
		System.out.print(" - 작성자 >> ");
		String boardWriter = scan.next();
		
		System.out.print(" - 내 용 >> ");
		scan.nextLine();
		String boardContent = scan.nextLine();
		
		// 입력한 데이터를 VO객체에 저장한다.
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(boardTitle);
		boardVo.setBoard_writer(boardWriter);
		boardVo.setBoard_content(boardContent);
		
		int cnt = service.insertBoard(boardVo);
		
		if(cnt > 0) {
			System.out.println("새글이 추가되었습니다.");
		}else {
			System.out.println("새글 추가 실패!!");
		}
	}

	// 메뉴를 출력하고 선택한 작업번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성  2. 게시글보기  3. 검색  0. 작업끝");
		System.out.print("작업선택 >> ");
		return scan.nextInt();
	}

	public static void main(String[] args) {
		new BoardController().startBoard();
	}

}
