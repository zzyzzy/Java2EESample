package zzyzzy.service;

import java.util.List;

import zzyzzy.model.SungJukVO;

public interface SungJukService {
	
	void addSungJuk(SungJukVO sj);		// 성적추가
	List<SungJukVO> getSungJuk();		// 성적 전체조회	
	SungJukVO getSungJuk(int sjno);		// 성적 상세조회
	void modifySungJuk(SungJukVO sj);	// 성적수정
	void removeSungJuk(int sjno);		// 성적삭제
}
