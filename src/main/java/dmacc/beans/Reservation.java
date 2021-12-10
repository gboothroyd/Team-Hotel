package dmacc.beans;

//import javax.persistence.CascadeType;
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
	@OneToOne
	private Guest guest;
	@OneToOne
	private Room room;
	
	private String startDate;
	private String endDate;
	private int numOccupants;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Guest guest, Room room, String startDate, String endDate, int numOccupants) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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