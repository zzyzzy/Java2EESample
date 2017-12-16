package zzyzzy.model;

public class SungJukVO {

	// 멤버 변수들 선언
	protected int sjno;			// 학생번호
	protected String name;		// 이름
	protected int kor; 			// 국어
	protected int eng;			// 영어
	protected int mat;			// 수학
	
	protected int tot;			// 총점
	protected double avrg;		// 평균
	protected String grd;		// 학점
	protected String regdate;	// 등록일
	
	// 생성자
	public SungJukVO() { }

	// 멤버변수 생성자
	public SungJukVO(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// setter/getter
	public int getSjno() {
		return sjno;
	}

	public void setSjno(int sjno) {
		this.sjno = sjno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvrg() {
		return avrg;
	}

	public void setAvrg(double avrg) {
		this.avrg = avrg;
	}

	public String getGrd() {
		return grd;
	}

	public void setGrd(String grd) {
		this.grd = grd;
	}
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	// toString()
	@Override
	public String toString() {
		return "SungJukVO [sjno=" + sjno + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat
				+ ", tot=" + tot + ", avrg=" + avrg + ", grd=" + grd + ", regdate=" + regdate + "]";
	}

}
