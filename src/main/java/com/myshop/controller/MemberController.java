package com.myshop.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.dto.MemberDTO;
import com.myshop.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService mService;
	
	@Autowired
	HttpSession session;
	
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	//약관 페이지 로딩
	@GetMapping("terms.do")
	public String getTermsForm() {
		return "member/terms";
	}
	
	//회원가입 폼 로딩
	@GetMapping("signUp.do")
	public String getSignUpFrom() {
		return "member/signUp";
	}
	
	//아이디 중복체크
	@PostMapping("idCheck.do")
	public void idCheckCtrl(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String id = request.getParameter("id");
		logger.info(id);
		
		boolean res = false;
		MemberDTO member = mService.getMember(id);
		
		if(member != null) {
			res = false;
		} else {
			res = true;
		}
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		json.put("res", res);
		out.println(json.toString());
	}
	
	//회원 가입 - 회원 가입 처리
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String memberInsertCtrl(MemberDTO member, Model model) throws Exception {
		member.setPw(pwdEncoder.encode(member.getPw()));
		logger.info("암호화된 비밀번호 : "+member.getPw());
		mService.memberInsert(member);
		return "redirect:/";
	}
	
	//로그인 폼 로딩 (RequestMethod 기술하지 않으면, 기본이 GET임)
	@RequestMapping("loginForm.do")
	public String getMemberLoginForm() {
		return "member/login";
	}
	
	//로그인 	- 컨트롤러에서 세션 처리 O
	@PostMapping("signIn.do")
	public String memberSignInCtrl(@RequestParam String id, @RequestParam String pw) throws Exception {
		session.invalidate();
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		mdto.setPw(pw);
		MemberDTO login = mService.signIn(mdto);
		if(login!=null && pwdEncoder.matches(login.getPw(), mdto.getPw())) {
			session.setAttribute("sid", id);
			session.setAttribute("member", login);
			return "redirect:/";
		} else {
			return "redirect:loginForm.do";
		}
	}
	//로그인 - Service에서 세션 처리
	/*
	 * @PostMapping("login.do") public String memberLoginCtrl() {
	 * session.invalidate();
	 * 
	 * }
	 */
	//로그인 : DAO에서 처리
	
	//로그아웃
	@GetMapping("logout.do")
	public String memberLogout() {
		session.invalidate();
		return "redirect:/";
	}
}
