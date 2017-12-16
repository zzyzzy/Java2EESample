package zzyzzy.dao;

import java.util.List;

import zzyzzy.model.SungJukVO;

public interface SungJukDAO {

	void insertSungJuk(SungJukVO sj);		// 성적추가
	List<SungJukVO> selectSungJuk();		// 성적 전체조회	
	SungJukVO selectSungJuk(int sjno);		// 성적 상세조회
	void updateSungJuk(SungJukVO sj);		// 성적수정
	void deleteSungJuk(int sjno);			// 성적삭제
	
}
