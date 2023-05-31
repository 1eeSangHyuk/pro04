package com.myshop.util;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {

	@Id		//primary key 이어야함
	@Size(min=5, max=12, message="아이디는 5~12자로 입력해야함")
	String id;
	
	@Column
	@NotNull
	@Size(min=6, max=12, message="비밀번호는 8~12자로 입력해야함")
	@Pattern(regexp="^[a-zA-Z0-9]{8,12}$")
	String pw;
	
	/*
	 	javax.validation와 javax.persistence 패키지에서 지정 가능한 애노테이션 및 옵션 
	 	
		@AssertTrue 참 여부
		@DecimalMax 지정 값 이하의 실수
		@DecimalMin 지정 값 이상의 실수
		@Digits(integer=, fraction=) 정수 여부
		@Pattern(regexp="()") 원하는 패턴 여부
		@Future 미래
		@Past 과거
		@Max 지정 값 이상
		@Min 지정 값 이하
		@NotNull
		@Null 
		@Size(min=,max=)  문자열 또는 배열등의 길이
	 */
}
