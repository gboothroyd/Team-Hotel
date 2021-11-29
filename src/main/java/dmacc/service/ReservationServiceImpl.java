/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Nov 20, 2021
 */
package dmacc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dmacc.beans.Reservation;
import dmacc.repository.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepo.findAll();
	}

	@Override
	public void saveReservation(Reservation reservation) {
		this.reservationRepo.save(reservation);
	}

	@Override
	public Reservation getReservationById(long id) {
		Optional<Reservation> optional = reservationRepo.findById(id);
		Reservation reservation = null;
		if (optional.isPresent()) {
			reservation = optional.get();
		} else {
			throw new RuntimeException(" Reservation not found for id :: " + id);
		}
		return reservation;
	}

	@Override
	public void deleteReservationById(long id) {
		this.reservationRepo.deleteById(id);
	}

	@Override
	public Page<Reservation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.reservationRepo.findAll(pageable);
	}
	
	
}
