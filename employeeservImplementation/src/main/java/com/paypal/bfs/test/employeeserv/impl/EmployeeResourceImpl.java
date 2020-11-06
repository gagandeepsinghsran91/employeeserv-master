package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.converter.impl.EmployeeConverter;
import com.paypal.bfs.test.employeeserv.service.repository.EmployeeRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeConverter employeeConverter;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

    	Employee employee = employeeConverter.convertToView(employeeRepository.findById(Long.valueOf(id)).orElse(null));

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee){
    	
    	
    	if(!employeeRepository.findById(Long.valueOf(employee.getId())).isPresent()) {
    
    		Employee employeeView =  employeeConverter.convertToView(employeeRepository.save(employeeConverter.convertToEntity(employee)));
    		 return new ResponseEntity<>(employeeView, HttpStatus.CREATED); 
    	}
    	
   

         return new ResponseEntity<>(employee, HttpStatus.CONFLICT);
    	
    }
}
