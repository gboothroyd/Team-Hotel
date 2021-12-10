package dmacc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dmacc.beans.Employee;
import dmacc.repository.EmployeeRepository;


/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 30, 2021
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository eRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return eRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.eRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = eRepo.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id : " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.eRepo.deleteById(id);
	}
	
	@Override
	public Page<Employee> findEmployeePaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.eRepo.findAll(pageable);
	}
	
}
