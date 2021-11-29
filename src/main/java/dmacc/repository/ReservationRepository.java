package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dmacc.beans.Reservation;


/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Nov 14, 2021
 */
@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long> {
	
	//Queries now flow from the service and webcontroller files. EA
	
	
	/*
	@Query("SELECT r FROM Reservation r WHERE r.guest.id = ?1")
	Reservation findReservationByGuestId(long id);
	*/
} 