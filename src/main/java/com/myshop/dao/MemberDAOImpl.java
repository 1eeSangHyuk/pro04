package com.myshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	SqlSession sqlSession;

	//회원 목록
	@Override
	public List<MemberDTO> memberList() throws Exception {
		return sqlSession.selectList("member.memberList");
	}
	
	//회원수
	@Override
	public int memberCount() throws Exception {
		return sqlSession.selectOne("member.memberCount");
	}
	
	//특정 회원정보 조회
	@Override
	public MemberDTO getMember(String id) throws Exception {
		return sqlSession.selectOne("member.getMember", id);
	}
	
	//로그인 : 컨트롤러에서 처리
	@Override
	public MemberDTO signIn(MemberDTO mdto) throws Exception {
		return sqlSession.selectOne("member.signIn", mdto);
	}
	
	//로그인 : DAO에서 처리
	@Override
	public MemberDTO loginCheck(MemberDTO mdto) throws Exception {
		MemberDTO member = sqlSession.selectOne("member.loginCheck");
		if(member.getId().equals(mdto.getId()) && member.getPw().contentEquals(mdto.getPw())) {
			return member;
		} else {
			member = null;
		}
		return member;
	}
	
	//로그인 : AJax로 Service에서 로그인 처리
	@Override
	public MemberDTO login(MemberDTO mdto) throws Exception {
		return sqlSession.selectOne("member.login", mdto);
	}

	//회원가입
	@Override
	public void memberInsert(MemberDTO mdto) throws Exception {
		sqlSession.insert("member.memberInsert", mdto);		
	}

	@Override
	public void memberUpdate(MemberDTO mdto) throws Exception {
		sqlSession.update("member.memberUpdate", mdto);		
	}

	@Override
	public void memberDelete(String id) throws Exception {
		sqlSession.delete("member.memberDelete", id);
	}

}
