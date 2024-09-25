package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
	//1. 드라이버 등록 확인
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. DB 접속
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	// 3. sql 작업
	// 검색 기능
	public List<MoiveDTO> searchArticle(String name){
		String sql = "select * from movie where name like ?";
		List<MoiveDTO> list = new ArrayList<MoiveDTO>();
		
		// 1) DB 접속
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 2) SQL 작업
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MoiveDTO dto = new MoiveDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setAgeimage(rs.getString("ageimage"));
				dto.setImage(rs.getString("image"));
				// 리스트에 저장
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	// 테스트용 전체 검색
	public List<MoiveDTO> selectArticle(){
		String sql = "select * from movie";
		List<MoiveDTO> list = new ArrayList<MoiveDTO>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String ageimage = rs.getString("ageimage");
				String image = rs.getString("image");
				MoiveDTO dto = new MoiveDTO(num, name, age, ageimage, image);
				// 리스트에 저장
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
