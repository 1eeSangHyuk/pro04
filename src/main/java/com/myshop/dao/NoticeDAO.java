package com.myshop.dao;

import java.util.List;

import com.myshop.dto.NoticeDTO;

public interface NoticeDAO {
	public List<NoticeDTO> noticeList() throws Exception;
	public NoticeDTO noticeDetail(int no) throws Exception;
	public int noticeCnt() throws Exception;
	public void noticeInsert(NoticeDTO dto) throws Exception;
	public void noticeDelete(int no) throws Exception;
	public void noticeEdit(NoticeDTO dto) throws Exception;
	public void noticeCntUpdate(int no) throws Exception;
}
