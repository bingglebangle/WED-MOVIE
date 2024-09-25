package Reservation_Con;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;

import Reservaion.SeatDTO;
import food.SnackBackDTO;
import oracle.jdbc.proxy.annotation.Pre;

public class TotalDAO {
	// 1. db 연결
	public TotalDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("연결 완 ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2. 로그인
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("로그인 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 각 정보 꺼내기
	public List<SeatDTO> printmovie(String id) {
		List<SeatDTO> list = new ArrayList<SeatDTO>();
		String sql = "select * from reservation where id = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String image = rs.getString("image");
				String mvname = rs.getString("mvname");
				String cal = rs.getString("cal");
				String time = rs.getString("time");
				String room = rs.getString("room");
				String count = rs.getString("count");
				String seatnum = rs.getString("seatnum");
				SeatDTO movieRsdto = new SeatDTO(image, mvname, cal, time, room, count, seatnum);

				list.add(movieRsdto);
			}
		} catch (SQLException e) {

		}
		return list;

	}

	// 각 정보 꺼내기
	public List<SnackBackDTO> printfood(String id) {
		List<SnackBackDTO> list = new ArrayList<SnackBackDTO>();
		String sql = "select * from snackback where id = ? order by num";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int num = rs.getInt("num");
				String foodname = rs.getString("foodname");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");
				int pricetot = rs.getInt("pricetot");

				SnackBackDTO foodRsdto = new SnackBackDTO(num, foodname, price, amount, pricetot);

				list.add(foodRsdto);
			}
		} catch (SQLException e) {

		}
		return list;

	}

	// 삭제
	public int deletemovie(String mvname, String cal, String time, String room, String count,
			String seatnum, String id) {
		int result = 0;

		String sql = "delete reservation where mvname = ? and cal =? and time =? and  room=? and  count=?and seatnum =? and id=?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvname);
			pstmt.setString(2, cal);
			pstmt.setString(3, time);
			pstmt.setString(4, room);
			pstmt.setString(5, count);
			pstmt.setString(6, seatnum);
			pstmt.setString(7, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

		}
		return result;

	}

}
