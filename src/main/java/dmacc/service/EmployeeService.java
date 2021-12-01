package dmacc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import dmacc.beans.Employee;
import dmacc.beans.Room;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 30, 2021
 */
@Service
public interface EmployeeService {
    List < Employee > getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    
    Page<Employee> findEmployeePaginated(int pageNo, int pageSize, String sortField, String sortDirect);
}
