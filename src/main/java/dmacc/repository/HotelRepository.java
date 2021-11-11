package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Hotel;


/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 10, 2021
 */
@Repository
public interface HotelRepository  extends JpaRepository<Hotel, Long> { } 


