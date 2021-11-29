/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Nov 20, 2021
 */
package dmacc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import dmacc.beans.Reservation;


@Service
public interface ReservationService {
    List < Reservation > getAllReservations();
    void saveReservation(Reservation reservation);
    Reservation getReservationById(long id);
    void deleteReservationById(long id);
    
    Page<Reservation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirect);
	
}
