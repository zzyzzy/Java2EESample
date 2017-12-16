package zzyzzy;

import zzyzzy.model.SungJukVO;
import zzyzzy.service.SungJukService;
import zzyzzy.service.SungJukServiceImpl;

public class SungJukMain {

	public static void main(String[] args) {
		
		SungJukService sjsrv = SungJukServiceImpl.getInstance();

		// 성적데이터 추가
		SungJukVO sj1 = new SungJukVO("혜교", 99,98,99);
		sjsrv.addSungJuk(sj1);
		
		// 성적데이터 전체 조회
		for(SungJukVO sj : sjsrv.getSungJuk()) {
			System.out.println(sj);			
		};
		
		// 성적데이터 상세조회
		System.out.println(sjsrv.getSungJuk(6));
		
		// 성적데이터 수정
		sj1 = new SungJukVO("지현", 54, 78, 32);
		sj1.setSjno(3);
		sjsrv.modifySungJuk(sj1);
		
		// 성적데이터 삭제
		sjsrv.removeSungJuk(2);
		
	}

}
