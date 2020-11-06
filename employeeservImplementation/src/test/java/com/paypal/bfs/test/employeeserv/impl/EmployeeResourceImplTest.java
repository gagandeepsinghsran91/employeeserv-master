package com.paypal.bfs.test.employeeserv.impl;






import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.Assert.assertEquals;

import java.util.Optional;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.converter.impl.EmployeeConverter;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.service.repository.EmployeeRepository;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeResourceImplTest {

	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Mock
	EmployeeConverter employeeConverter;
	
	@InjectMocks
	EmployeeResourceImpl employeeResourceImpl;
	
	Employee employee;
	
	@Before
	public void setup() {
		
		EmployeeEntity entity= new EmployeeEntity();
		employee= new Employee();
		employee.setId(1);
		when(employeeRepository.findById(any(Long.class))).thenReturn(Optional.of(entity));
		when(employeeRepository.save(any(EmployeeEntity.class))).thenReturn(entity);
		when(employeeConverter.convertToEntity(any(Employee.class))).thenReturn(entity);
		
	}
	
	@Test
	public void employeeGetByIdTest() {
		
		ResponseEntity<Employee> response= employeeResourceImpl.employeeGetById("1");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		Mockito.verify(employeeConverter, times(1)).convertToView(any(EmployeeEntity.class));
		
	}
	
	@Test
	public void createEmployeeExistsTest(){
		ResponseEntity<Employee> response=employeeResourceImpl.createEmployee(employee);
		assertEquals(response.getStatusCode(), HttpStatus.CONFLICT);
		Mockito.verify(employeeConverter, times(0)).convertToView(any(EmployeeEntity.class));
		Mockito.verify(employeeConverter, times(0)).convertToEntity(any(Employee.class));
		
	}
	
	
	@Test
	public void createEmployeeTest(){
		when(employeeRepository.findById(any(Long.class))).thenReturn(Optional.empty());
		ResponseEntity<Employee> response=employeeResourceImpl.createEmployee(employee);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		Mockito.verify(employeeConverter, times(1)).convertToView(any(EmployeeEntity.class));
		Mockito.verify(employeeConverter, times(1)).convertToEntity(any(Employee.class));
		
	}

}
