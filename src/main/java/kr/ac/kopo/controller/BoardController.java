package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;

/**
 * 게시판 관련 요청 URI를 처리하는 클래스
 REST URI 정책
메소드 + uri => 행위의 의미 부여
	GET  	/board    	전체게시글 조회
	POST	/board		새글등록
	GET		/board/3		3번게시글 조회
	DELETE	/board/3		3번게시글 삭제
	PUT		/board/3		3번게시글 수정
	
	--------------------------------------------------------------------
	GET 	/board		전체게시글조회		BoardController	list.jsp
	GET		/board/30	30번게시글 조회				detail.jsp
			/board/12	12번게시글 조회
	GET		/board/detail?no=3
	
	DELETE	/board/30	30번게시글 삭제				delete.jsp
			/board/12	12번게시글 삭제
	
	GET		/board/write	새글등록폼				writeForm.jsp
	POST	/board/write	새글 등록					write.jsp
	
	GET		/board/update/30	30번게시글 수정폼				updateForm.jsp
	PUT		/board/update/30	30번게시글 수정				update.jsp


 *
 */

@SessionAttributes({"userVO"})
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/* @RequestMapping("/board") */
	@GetMapping("/board")
	public String selectAllBoard(HttpServletRequest request) throws Exception {
		
		List<BoardVO> list = boardService.searchAllBoard();
				
		request.setAttribute("list", list);
		
		return "board/list";	// "WEB-INF/views/" + board/list + ".jsp"
	}
	
	// /board/detail?no=3
	@GetMapping("/board/detail")
	public String selectBoardByNo(@RequestParam("no") int no, Model model) throws Exception {
		//System.out.println("no : " + no);
		
		BoardVO board = boardService.searchBoardByNo(no);
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	// /board/3    /board/12
	@GetMapping("/board/{no}")
	public String selectBoardByNo2(@PathVariable("no") int no, Model model ) throws Exception {
		
		BoardVO board = boardService.searchBoardByNo(no);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@GetMapping("/board/write")
	public void writeForm(Model model, HttpSession session) {
		
		// 로그인정보 추출(Session객체를 통해서)   
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		
		BoardVO board = new BoardVO();
		board.setWriter(userVO.getId());
		model.addAttribute("boardVO", board);

	}
	
	@PostMapping("/board/write")
	public String write(@Valid BoardVO board, BindingResult result) throws Exception {

		if(result.hasErrors()) 
			return "board/write";
		
		boardService.addBoard(board);
		return "redirect:/board";

	}
}








