package zzyzzy.service;

import java.util.List;

import zzyzzy.dao.SungJukDAO;
import zzyzzy.dao.SungJukDAOImpl;
import zzyzzy.model.SungJukVO;

public class SungJukServiceImpl implements SungJukService {

	// SungJukServiceImpl 객체 생성
	private static SungJukService instance = new SungJukServiceImpl();
	
	// 생성자는 접근제한자를 private으로 설정해서
	// new 연산자를 통한 객체 생성을 막는다
	private SungJukServiceImpl(){ }
	
	// getInstance 메서드를 통해 단일 객체만을 제공한다
	public static SungJukService getInstance(){
	   return instance;
	}	
	
	@Override // 성적 추가
	public void addSungJuk(SungJukVO sj) {
		computeSungJuk(sj);
		SungJukDAO sjdao = SungJukDAOImpl.getInstance();
		
		sjdao.insertSungJuk(sj);
	}

	@Override // 성적 전체조회
	public List<SungJukVO> getSungJuk() {
		SungJukDAO sjdao = SungJukDAOImpl.getInstance();
		
		return sjdao.selectSungJuk();
	}

	@Override // 성적 상세조회
	public SungJukVO getSungJuk(int sjno) {
		SungJukDAO sjdao = SungJukDAOImpl.getInstance();
		
		return sjdao.selectSungJuk(sjno);
	}

	@Override // 성적 수정
	public void modifySungJuk(SungJukVO sj) {
		computeSungJuk(sj);	
		SungJukDAO sjdao = SungJukDAOImpl.getInstance();
	
		sjdao.updateSungJuk(sj);
	}

	@Override // 성적 삭제
	public void removeSungJuk(int sjno) {
		SungJukDAO sjdao = SungJukDAOImpl.getInstance();
		
		sjdao.deleteSungJuk(sjno);
	}
	
	private void computeSungJuk(SungJukVO sj) {
		int tot = sj.getKor() + sj.getEng() + sj.getMat();
		double avrg = (double)tot / 3;
		//avrg = Double.parseDouble(String.format("%.1f", avrg));
		
		String grd = "가";
		switch ((int)avrg/10) {
			case 10: case 9: grd = "수"; break;
			case 8: grd = "우"; break;
			case 7: grd = "미"; break;
			case 6: grd = "양"; break;
		}
		
		sj.setTot(tot);
		sj.setAvrg(avrg);
		sj.setGrd(grd);
	}
	
}
