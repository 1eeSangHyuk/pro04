package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.dao.MemberDAO;
import com.myshop.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO mdao;

	//회원 목록
	@Override
	public List<MemberDTO> memberList() throws Exception {
		return mdao.memberList();
	}

	//회원수
	@Override
	public int memberCount() throws Exception {
		return mdao.memberCount();
	}

	//특정 회원정보
	@Override
	public MemberDTO getMember(String id) throws Exception {
		return mdao.getMember(id);
	}

	//로그인 : 컨트롤러에서 로그인 처리
	@Override
	public MemberDTO signIn(MemberDTO mdto) throws Exception {
		return mdao.signIn(mdto);
	}

	//로그인 : DAO에서 로그인 처리
	@Override
	public MemberDTO loginCheck(MemberDTO mdto) throws Exception {
		return mdao.loginCheck(mdto);
	}

	//로그인 : AJax로 서비스에서 로그인 처리
	@Override
	public MemberDTO login(MemberDTO mdto) throws Exception {
		return mdao.login(mdto);
	}

	//회원 가입
	@Override
	public void memberInsert(MemberDTO mdto) throws Exception {
		mdao.memberInsert(mdto);
	}

	//회원정보 수정
	@Override
	public void memberUpdate(MemberDTO mdto) throws Exception {
		mdao.memberUpdate(mdto);
	}

	//회원 탈퇴
	@Override
	public void memberDelete(String id) throws Exception {
		mdao.memberDelete(id);
	}

}
