package com.myshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.dto.NoticeDTO;

@Repository 
public class NoticeDAOImpl implements NoticeDAO{
	
	//의존성 주입, DI(dependency injection) -> IOC(inversion of control)
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<NoticeDTO> noticeList() {
		return sqlSession.selectList("notice.noticeList");
	}

	@Override
	public NoticeDTO noticeDetail(int no) {
		return sqlSession.selectOne("notice.noticeDetail", no);
	}

	@Override
	public int noticeCnt() {
		return sqlSession.selectOne("notice.noticeCnt");
	}

	@Override
	public void noticeInsert(NoticeDTO dto) {
		sqlSession.insert("notice.noticeInsert", dto);
		
	}

	@Override
	public void noticeDelete(int no) {
		sqlSession.delete("notice.noticeDelete", no);
		
	}

	@Override
	public void noticeEdit(NoticeDTO dto) {
		sqlSession.update("notice.noticeEdit", dto);	
	}

	@Override
	public void noticeCntUpdate(int no) throws Exception {
		sqlSession.update("notice.noticeCntUpdate", no);
		
	}
		
}