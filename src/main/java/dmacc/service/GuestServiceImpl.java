/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Nov 21, 2021
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

import dmacc.beans.Guest;
import dmacc.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	private GuestRepository guestRepo;
	
	@Override
	public List<Guest> getAllGuests() {
		return guestRepo.findAll();
	}

	@Override
	public void saveGuest(Guest guest) {
		this.guestRepo.save(guest);
	}

	@Override
	public Guest getGuestById(long id) {
		Optional<Guest> optional = guestRepo.findById(id);
		Guest guest = null;
		if (optional.isPresent()) {
			guest = optional.get();
		} else {
			throw new RuntimeException(" Guest not found for id : " + id);
		}
		return guest;
	}

	@Override
	public void deleteGuestById(long id) {
		this.guestRepo.deleteById(id);
	}
	
	@Override
	public Page<Guest> findGuestPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.guestRepo.findAll(pageable);
	}
	
}
