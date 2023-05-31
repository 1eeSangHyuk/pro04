package com.myshop.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.util.MemberVO;

@Controller
@RequestMapping("/check/*")
public class CheckController2 {
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new MemberValidator());/	
//	}
	
	@GetMapping("check6")
	public String getCheck6(MemberVO memberVO) {
		return "check/check6";
	}
	
	//@Valid 를 활용한 폼 검증
	@PostMapping("check6.do")
	public String postCheck6(@ModelAttribute("memberVO") @Valid MemberVO memberVO, BindingResult result) {
		String addr = "check/result6";
		if(result.hasErrors()) {
			addr = "check/error6";
		}
		return addr;
	}
}