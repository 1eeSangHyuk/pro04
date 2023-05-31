package com.myshop.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.dto.MemberDTO;
import com.myshop.util.MemberValidator;

@Controller
@RequestMapping("/check/*")
public class CheckController {
	
	@GetMapping("check1")
	public String getCheck1() {
		return "check/check1";
	}
	
	// form tag 를 활용한 폼 검증
	@PostMapping("check1")
	public String postCheck1(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "check/result1";
	}
	
	@GetMapping("check2")
	public String getCheck2() {
		return "check/check2";
	}
	
	// JavaScript 를 활용한 폼 검증
	@PostMapping("check2")
	public String postCheck2(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "check/result2";
	}
	
	@GetMapping("check3")
	public String getCheck3() {
		return "check/check3";
	}
	
	//jQuery를 통한 폼 검증
	@GetMapping("check3.do")
	public String postCheck3(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		String addr = "check/result3";
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return addr;
	}
	
	@GetMapping("check4")
	public String getCheck4() {
		return "check/check4";
	}
	
	//validation-api 를 활용한 폼 검증
	@PostMapping("check4")
	public String postCheck4(@ModelAttribute("member") MemberDTO member, Model model, BindingResult result) {
		String addr = "check/result4";
		MemberValidator memVal = new MemberValidator();
		memVal.validate(member, result);
		if(result.hasErrors()) {
			addr = "check/error4";
		}
		return addr;
	}
	
	
	@InitBinder 
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberValidator());
	} 
	
	@GetMapping("check5")
	public String getCheck5() {
		return "check/check5";
	}	
	
	//(@Valid+@InitBinder) 를 활용한 폼 검증
	@PostMapping("check5")
	public String postCheck5(@ModelAttribute("member") @Valid MemberDTO member, Model model, BindingResult result) { 
		String addr = "check/result5";
//		MemberValidator memVal = new MemberValidator();
//		memVal.validate(member, result);
		if(result.hasErrors()) { 
			addr = "check/error5"; 
		} 
		return addr; 
	}
	 
}