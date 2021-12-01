package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Employee;
import dmacc.beans.Guest;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 30, 2021
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }


