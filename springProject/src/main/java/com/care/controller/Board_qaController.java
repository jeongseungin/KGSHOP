package com.care.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyleConstants.ColorConstants;
import javax.xml.transform.Templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.DTO.Board_qaCriteria;
import com.care.DTO.Board_qaDTO;
import com.care.DTO.Board_qaPageMaker;
import com.care.DTO.Board_qaSearchCriteria;
import com.care.DTO.board_qaReplyDTO;
import com.care.service.Board_qaServiceimpl;
import com.care.service.CommonService;
import com.care.template.Constants;

@Controller
public class Board_qaController {
	
	@Autowired
	Board_qaServiceimpl service;
	
	
	
	@RequestMapping("QnA")
	public String QnA(Model model, @ModelAttribute("scri") Board_qaSearchCriteria scri, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String name = "abc";
		session.setAttribute("id", name);//세션생성, 추 후 삭제바람
		
		model.addAttribute("list",service.list(scri));
		
		Board_qaPageMaker pageMaker = new Board_qaPageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		
		return "cs/QnA";
		
	}
	@RequestMapping("QnAwrite")
	public String QnAwrite(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		return "cs/QnAwrite";
	}
	@RequestMapping("savedata")
	public String savedata(Board_qaDTO dto) {
		int i;
		i = service.Board_qaInsert(dto);
		System.out.println("결과값"+i);
		return "redirect:QnA";
	}
	//게시물 조회 & 게시물 댓글 조회
	@RequestMapping("QnAreadView")
	public String read(Board_qaDTO dto, @ModelAttribute("scri") Board_qaSearchCriteria scri, Model model) throws Exception {
			
			int Qa_state = service.read(dto.getQa_seq()).getQa_state();
			System.out.println("비밀글 여부 1=비공개 0=공개 : "+Qa_state);
			
			//게시물 조회
			model.addAttribute("read", service.read(dto.getQa_seq()));
			model.addAttribute("scri", scri);
			
			//게시물 댓글 조회
			List<board_qaReplyDTO> replyList = service.readReply(dto.getQa_seq());
			model.addAttribute("replyList", replyList);
			
			
			if(Qa_state==1) {
				return "cs/QnApassWord";
			}else {
				return "cs/QnAreadView";
				}
			
	}
 	
	//비밀번호 입력 후 게시물 조회
	@RequestMapping("QnApassWord")
	public String QnApassWord(Board_qaDTO dto, @ModelAttribute("scri") Board_qaSearchCriteria scri, Model model) throws Exception {
		model.addAttribute("read", service.read(dto.getQa_seq()));
		model.addAttribute("scri", scri);
		model.addAttribute("replyList", service.readReply(dto.getQa_seq()));
		return "cs/QnAreadView";
	}
	
	// 게시판 수정뷰
	@RequestMapping("updateView")
	public String updateView(Board_qaDTO dto, @ModelAttribute("scri") Board_qaSearchCriteria scri,Model model) throws Exception{
		model.addAttribute("update", service.read(dto.getQa_seq()));
		model.addAttribute("scri", scri);
		return "cs/QnAupdateView";
	}
	
	// 게시판 수정
	@RequestMapping("update")
	public String update(Board_qaDTO dto, @ModelAttribute("scri") Board_qaSearchCriteria scri, RedirectAttributes rttr) throws Exception{
		service.update(dto);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:QnA";
	}
	
	// 게시판 삭제
	@RequestMapping("delete")
	public String delete(Board_qaDTO dto, @ModelAttribute("scri") Board_qaSearchCriteria scri, RedirectAttributes rttr) throws Exception{
		service.delete(dto.getQa_seq());
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:QnA";
	}
	
	// 댓글 작성
	@RequestMapping("replyWrite")
	public String replyWrite(board_qaReplyDTO dto, Board_qaSearchCriteria scri, RedirectAttributes rttr)throws Exception{
		service.writeReply(dto);
		
//		System.out.println("댓글작성 게시판번호"+dto.getQa_seq());
//		System.out.println("댓글작성 페이지값 : "+scri.getPage());
//		System.out.println("댓글작성 서치타입: "+scri.getSearchType());
//		System.out.println("댓글작성 키워드 : "+scri.getKeyword());
		
		rttr.addAttribute("qa_seq", dto.getQa_seq());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:QnAreadView";
	}
	
	//댓글 수정 페이지에 접근하기 위한 컨트롤러와 수정한 값을 전송할 수 있는 컨트롤러를 작성
	//댓글 수정 GET
	@RequestMapping(value = "/replyUpdateView", method = RequestMethod.GET)
	public String replyUpdateView(board_qaReplyDTO dto, Board_qaSearchCriteria scri, Model model) throws Exception{
		
		model.addAttribute("replyUpdate", service.selectReply(dto.getQa_reply_seq()));
		model.addAttribute("scri", scri);
		
		return "cs/QnAreplyUpdateView";
	}
	//댓글 수정 POST
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(board_qaReplyDTO dto, Board_qaSearchCriteria scri, RedirectAttributes rttr) throws Exception {
		
		service.updateReply(dto);
		
		rttr.addAttribute("qa_seq", dto.getQa_seq());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:QnAreadView";
	}
	
	//댓글 삭제 페이지에 들어가기 위한 컨트롤러와 삭제 컨트롤러를 작성
	//댓글 삭제 GET
		@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(board_qaReplyDTO dto, Board_qaSearchCriteria scri, Model model) throws Exception {
			
			model.addAttribute("replyDelete", service.selectReply(dto.getQa_reply_seq()));
			model.addAttribute("scri", scri);
			

			return "cs/QnAreplyDeleteView";
		}
		
		//댓글 삭제
		@RequestMapping(value="/replyDelete", method = RequestMethod.POST)
		public String replyDelete(board_qaReplyDTO dto, Board_qaSearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			service.deleteReply(dto);
			
			rttr.addAttribute("qa_seq", dto.getQa_seq());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:QnAreadView";
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}