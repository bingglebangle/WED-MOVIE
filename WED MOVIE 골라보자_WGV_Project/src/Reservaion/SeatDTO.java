package Reservaion;

import java.sql.Connection;
import java.sql.DriverManager;

public class SeatDTO {
	
	String image;
	String mvname;
	String cal;
	String time;
	String room;
	String count;
	String seatnum;
	String id;



	
	public SeatDTO() {

	}
	public SeatDTO(String image, String mvname, String cal, String time, String room, String count, String seatnum) {
		super();
		this.image = image;
		this.mvname = mvname;
		this.cal = cal;
		this.time = time;
		this.room = room;
		this.count = count;
		this.seatnum = seatnum;
	}
	public SeatDTO(String image, String mvname, String cal, String time, String room, String count, String seatnum,
			String id) {
		super();
		this.image = image;
		this.mvname = mvname;
		this.cal = cal;
		this.time = time;
		this.room = room;
		this.count = count;
		this.seatnum = seatnum;
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMvname() {
		return mvname;
	}

	public void setMvname(String mvname) {
		this.mvname = mvname;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}


	public String getSeatnum() {
		return seatnum;
	}


	public void setSeatnum(String seatnum) {
		this.seatnum = seatnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}