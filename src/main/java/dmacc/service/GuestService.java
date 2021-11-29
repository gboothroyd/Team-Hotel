/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Nov 21, 2021
 */
package dmacc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import dmacc.beans.Guest;

@Service
public interface GuestService {

    List < Guest > getAllGuests();
    void saveGuest(Guest guest);
    Guest getGuestById(long id);
    void deleteGuestById(long id);
    
    Page<Guest> findGuestPaginated(int pageNo, int pageSize, String sortField, String sortDirect);
	
}
