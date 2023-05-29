package com.myshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.dto.NoticeDTO;
import com.myshop.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeList.do")
	public String getNoticeList(Model model) throws Exception {
		List<NoticeDTO> noticeList = noticeService.noticeList();
		int i = noticeService.noticeCnt();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("cnt", i);
		return "notice/noticeList";		// WEB-INF/views/notice/noticeList.jsp
	}
	
	@GetMapping("noticeDetail.do")
	public String getNoticeDetail(HttpServletRequest request, Model model) throws Exception {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		noticeService.noticeCntUpdate(noticeNo);
		NoticeDTO notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);
		return "notice/noticeDetail";
	}
	
	@GetMapping("noticeInsert.do")
	public String noticeInsert() {
		return "notice/noticeInsert";
	}
	
	@PostMapping("noticeInsert.do")
	public String noticeInsertPro(HttpServletRequest request) throws Exception {
		NoticeDTO notice = new NoticeDTO();
		notice.setNotiTitle(request.getParameter("notiTitle"));
		notice.setNotiText(request.getParameter("notiText"));
		noticeService.noticeInsert(notice);
		return "redirect:noticeList.do";
	}
	
	@GetMapping("noticeUpdate.do")
	public String noticeUpdate(HttpServletRequest request, Model model) throws Exception {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeDTO notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);
		return "notice/noticeUpdate";
	}
	
	@PostMapping("noticeUpdate.do")
	public String noticeUpdatePro(HttpServletRequest request, Model model) throws Exception {
		NoticeDTO notice = new NoticeDTO();
		notice.setNotiNO(Integer.parseInt(request.getParameter("noticeNo")));
		notice.setNotiTitle(request.getParameter("notiTitle"));
		notice.setNotiText(request.getParameter("notiText"));
		noticeService.noticeEdit(notice);
		return "redirect:noticeDetail.do";
	}
	
	@GetMapping("noticeDelete.do")
	public String noticeDelete(HttpServletRequest request) throws Exception {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		noticeService.noticeDelete(noticeNo);
		return "redirect:noticeList.do";
	}
}
