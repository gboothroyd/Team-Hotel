package dmacc.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Nov 14, 2021
 */

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade=CascadeType.ALL)
	private Guest guest;
	@OneToOne(cascade=CascadeType.ALL)
	private Room room;
	private LocalDate startDate;
	private LocalDate endDate;
	private int numOccupants;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate, int numOccupants) {
		super();
		this.guest = guest;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numOccupants = numOccupants;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getNumOccupants() {
		return numOccupants;
	}

	public void setNumOccupants(int numOccupants) {
		this.numOccupants = numOccupants;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", guest=" + guest + ", room=" + room + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", numOccupants=" + numOccupants + "]";
	}






}