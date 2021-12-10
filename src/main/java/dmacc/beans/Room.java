package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author booth - gboothroyd@dmacc.edu CIS175 - Fall 2021 Nov 9, 2021
 */

@Entity
public class Room {
	
	@Id
	private long roomNum;
	
	private String availability;
	private double roomPrice;
	private String roomSize;
	private String discountCode;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(long roomNum, String availability, double roomPrice, String roomSize) {
		super();
		this.roomNum = roomNum;
		this.availability = availability;
		this.roomPrice = roomPrice;
		this.roomSize = roomSize;

	}

	public String getAvailability() {
		return availability;
	}

	public long getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(long roomNum) {
		this.roomNum = roomNum;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}


	public double getRoomPrice() {
		return roomPrice;
	}


	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}


	public String getRoomSize() {
		return roomSize;
	}


	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}
	

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		double discount = .1;
		double roomPriceDiscount = 0;
		this.discountCode = discountCode;
		if(discountCode.equals("Hotel")) {
			roomPriceDiscount = roomPrice * discount;
			this.roomPrice = roomPrice - roomPriceDiscount;
		}
	}

	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", availability=" + availability + ", roomPrice=" + roomPrice
				+ ", roomSize=" + roomSize + ", discountCode=" + discountCode + "]";

	}
}