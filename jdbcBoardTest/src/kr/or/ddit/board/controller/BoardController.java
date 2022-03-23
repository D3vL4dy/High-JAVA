package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
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
				break;
			case 0: // 작업 끝
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}

	private void boardNo_selectBoard() {
		List<BoardVO> boardList = service.getBoardNo_Select();
		
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		int boardNo = scan.nextInt();
		
		System.out.println(boardNo + "번글 내용");
		System.out.println("-------------------------------------------");
		System.out.println(" - 제 목 : " + ((BoardVO) boardList).getBoard_title());
		System.out.println(" - 작성자 : " + ((BoardVO) boardList).getBoard_writer());
		System.out.println(" - 내 용 : " + ((BoardVO) boardList).getBoard_content());
		System.out.println(" - 작성일 : " + ((BoardVO) boardList).getBoard_date());
		System.out.println(" - 조회수 : " + ((BoardVO) boardList).getBoard_cnt());
		System.out.println("-------------------------------------------");
		
		System.out.print("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.print("작업선택 >> ");

		return scan.nextInt();
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
		String boardTitle = scan.next();
		
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
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성  2. 게시글보기  3. 검색  0. 작업끝");
		System.out.print("작업선택 >> ");
		return scan.nextInt();

	}

	public static void main(String[] args) {
		new BoardController().startBoard();
	}

}
