package com.myshop.util;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myshop.dto.MemberDTO;

public class MemberValidator implements Validator {
	
	public void validate(Object obj, Errors error) {
		MemberDTO member = (MemberDTO) obj;
		
		//빈 값 검증
		ValidationUtils.rejectIfEmpty(error, "id", "member.id.empty", "아이디를 입력해주세요");
		ValidationUtils.rejectIfEmpty(error, "pw", "member.pw.empty", "비밀번호를 입력해주세요");
		
		//입력형식 검증
		Pattern pat1 = Pattern.compile("^[a-z0-9]{5,12}$", Pattern.CASE_INSENSITIVE);
		Pattern pat2 = Pattern.compile("^[a-zA-Z0-9]{8,12}$", Pattern.CASE_INSENSITIVE);
		if(!(pat1.matcher(member.getId()).matches())) {
			error.rejectValue("id", "member.id.invalid");
		}		
		if(!(pat2.matcher(member.getPw()).matches())) {
			error.rejectValue("pw", "member.pw.invalid");
		}
		
		/*
		String id = member.getId();
		String pw = member.getPw();
		
		if(id == null || id.trim().isEmpty()) {
			error.rejectValue("id", "아이디가 비어 있습니다.");
		}
		
		if(pw == null || pw.trim().isEmpty()) {
			error.rejectValue("pw", "비밀번호가 비어 있습니다.");
		}
		
        //id가 8~12 이하인지 확인
        else if(id.length() >= 8 && id.length() <= 12) {
            error.rejectValue("id", "bad size"); 
        }
        
        //pw가 6~12자 이하인지 확인
        if(pw.length() >= 6 && pw.length() <= 12) {
            error.rejectValue("pw", "bad size");
        }
        */
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberDTO.class.equals(clazz);
	}
}
