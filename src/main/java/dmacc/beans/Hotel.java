package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 9, 2021
 */

@Entity
public class Hotel {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String availability;
	private double roomPrice;
	private String roomSize;
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param availability
	 * @param roomPrice
	 * @param roomSize
	 */
	public Hotel(String name, String availability, double roomPrice, String roomSize) {
		super();
		this.name = name;
		this.availability = availability;
		this.roomPrice = roomPrice;
		this.roomSize = roomSize;
		
	}
	/**
	 * @return the availability
	 */
	
	
	public String getAvailability() {
		return availability;
	}
	/**
	 * @return the id
	 */

	/**
	 * @param availability the availability to set
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	/**
	 * @return the roomPrice
	 */
	public double getRoomPrice() {
		return roomPrice;
	}
	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	/**
	 * @return the roomSize
	 */
	public String getRoomSize() {
		return roomSize;
	}
	/**
	 * @param roomSize the roomSize to set
	 */
	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", availability=" + availability + ", roomPrice=" + roomPrice + ", roomSize="
				+ roomSize + "]";
	}
	
	
	
	

}
