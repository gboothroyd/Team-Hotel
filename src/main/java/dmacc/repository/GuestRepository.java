package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Guest;


/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Nov 14, 2021
 */
@Repository
public interface GuestRepository  extends JpaRepository<Guest, Long> { } 
