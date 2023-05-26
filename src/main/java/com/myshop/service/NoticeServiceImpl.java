package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.dao.NoticeDAO;
import com.myshop.dto.NoticeDTO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO noticeDao;
	
	@Override
	public List<NoticeDTO> noticeList() throws Exception {
		return noticeDao.noticeList();
	}

	@Override
	public NoticeDTO noticeDetail(int no) throws Exception {
		return noticeDao.noticeDetail(no);
	}

	@Override
	public int noticeCnt() throws Exception {
		return noticeDao.noticeCnt();
	}

	@Override
	public void noticeInsert(NoticeDTO dto) throws Exception {
		noticeDao.noticeInsert(dto);
	}

	@Override
	public void noticeDelete(int no) throws Exception {
		noticeDao.noticeDelete(no);		
	}

	@Override
	public void noticeEdit(NoticeDTO dto) throws Exception {
		noticeDao.noticeEdit(dto);		
	}

	@Override
	public void noticeCntUpdate(int no) throws Exception {
		noticeDao.noticeCntUpdate(no);
	}
	
}
