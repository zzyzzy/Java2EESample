package zzyzzy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import zzyzzy.model.SungJukVO;

public class SungJukDAOImpl implements SungJukDAO {
	
		private String rbPath = "jdbc.mariadb";
		private String DRV = null;
		private String URL = null;
		private String USR = null;
		private String PWD = null;
		
		private String insertSQL = "insert into sungjuk (name,kor,eng,mat,tot,avrg,grd) values (?,?,?,?,?,?,?)";
		private String selectSQL = "select sjno, name, kor, eng, mat, regdate from sungjuk order by sjno desc";
		private String selectOneSQL = "select * from sungjuk where sjno = ?";
		private String updateSQL = "update sungjuk set name=?, kor=?, eng=?, mat=?, tot=?, avrg=?, grd=?, regdate=current_timestamp where sjno = ?";
		private String deleteSQL = "delete from sungjuk where sjno = ?";
		
	
		// SungJukDAOImpl 객체 생성
		private static SungJukDAO instance = new SungJukDAOImpl();
		
		// 생성자는 접근제한자를 private으로 설정해서
		// new 연산자를 통한 객체 생성을 막는다
		private SungJukDAOImpl(){ 
			ResourceBundle rb = ResourceBundle.getBundle(rbPath);
			DRV = rb.getString("DRV");
			URL = rb.getString("URL");
			USR = rb.getString("USR");
			PWD = rb.getString("PWD");
		}
		
		// getInstance 메서드를 통해 단일 객체만을 제공한다
		public static SungJukDAO getInstance(){
		   return instance;
		}
		
		// 성적 추가
		@Override
		public void insertSungJuk(SungJukVO sj) {
			System.out.println(sj.getTot());
			try (
				Connection conn = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
		    ) {
		    	pstmt.setString(1, sj.getName());
		    	pstmt.setInt(2, sj.getKor());
		    	pstmt.setInt(3, sj.getEng());
		    	pstmt.setInt(4, sj.getMat());
		    	pstmt.setInt(5, sj.getTot());
		    	pstmt.setDouble(6, sj.getAvrg());
		    	pstmt.setString(7, sj.getGrd());
		    	
		    	int count = pstmt.executeUpdate();	
		    	System.out.println(count + " 건의 데이터가 추가되었습니다");
		    	
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		}

		// 성적 전체 조회
		@Override
		public List<SungJukVO> selectSungJuk() {
			List<SungJukVO> list = new ArrayList<>();
			
			try (
				Connection conn = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
		    ) {
				 while (rs.next()) { 
					 SungJukVO sj = new SungJukVO();
						 sj.setSjno(rs.getInt(1));
						 sj.setName(rs.getString(2));
						 sj.setKor(rs.getInt(3));
						 sj.setEng(rs.getInt(4));
						 sj.setMat(rs.getInt(5));
						 sj.setRegdate(rs.getString(6));
					 list.add(sj);
				 }
		    	
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
			return list;
		}

		// 성적 상세 조회
		@Override
		public SungJukVO selectSungJuk(int sjno) {
			SungJukVO sj = new SungJukVO();
			
			try (
				Connection conn = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pstmt = conn.prepareStatement(selectOneSQL);
		    ) {
				pstmt.setInt(1, sjno);
				
				try ( ResultSet rs = pstmt.executeQuery(); ) {
				
					 while (rs.next()) { 
						 sj.setSjno(rs.getInt(1));
						 sj.setName(rs.getString(2));
						 sj.setKor(rs.getInt(3));
						 sj.setEng(rs.getInt(4));
						 sj.setMat(rs.getInt(5));
						 sj.setTot(rs.getInt(6));
						 sj.setAvrg(rs.getDouble(7));
						 sj.setGrd(rs.getString(8));
						 sj.setRegdate(rs.getString(9));
					 }
		    	
				}
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
			return sj;
		}

		// 성적 수정
		@Override
		public void updateSungJuk(SungJukVO sj) {
			try (
				Connection conn = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
		    ) {
		    	pstmt.setString(1, sj.getName());
		    	pstmt.setInt(2, sj.getKor());
		    	pstmt.setInt(3, sj.getEng());
		    	pstmt.setInt(4, sj.getMat());
		    	pstmt.setInt(5, sj.getTot());
		    	pstmt.setDouble(6, sj.getAvrg());
		    	pstmt.setString(7, sj.getGrd());
		    	pstmt.setInt(8, sj.getSjno());
		    	
		    	int count = pstmt.executeUpdate();	
		    	System.out.println(count + " 건의 데이터가 수정되었습니다");
		    	
		    } catch (Exception e) {
		      e.printStackTrace();
		    }			
		}

		// 성적 삭제
		@Override
		public void deleteSungJuk(int sjno) {
			try (
				Connection conn = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
			    ) {
			    	pstmt.setInt(1, sjno);
			    	
			    	int count = pstmt.executeUpdate();	
			    	System.out.println(count + " 건의 데이터가 삭제되었습니다");
			    	
			    } catch (Exception e) {
			      e.printStackTrace();
			    }	
		}
		
}
