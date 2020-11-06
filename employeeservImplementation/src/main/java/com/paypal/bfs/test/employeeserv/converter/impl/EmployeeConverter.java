package com.paypal.bfs.test.employeeserv.converter.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paypal.bfs.test.employeeserv.api.model.DateOfBirth;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.converter.Converter;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;


@Component
public class EmployeeConverter implements Converter<Employee, EmployeeEntity>{
	
	@Autowired
	AddressConverter addressConverter;

	@SuppressWarnings("deprecation")
	@Override
	public EmployeeEntity convertToEntity(Employee t) {
		
		if(t!=null) {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setFirstName(t.getFirstName());
			employeeEntity.setLastName(t.getLastName());
			employeeEntity.setAddress(addressConverter.convertToEntity(t.getAddress()));
			if(t.getDateOfBirth()!=null) {
				DateOfBirth dob = t.getDateOfBirth();
			employeeEntity.setDateOfBirth(new Date(dob.getYear(),dob.getMonth(),dob.getDate()));
			}
			return employeeEntity;
			//employeeEntity.setDateOfBirth(dateOfBirth);
		}
		
		return null;
	}

	@Override
	public Employee convertToView(EmployeeEntity v) {
		if(v!=null) {
			Employee employee = new Employee();
			employee.setFirstName(v.getFirstName());
			employee.setLastName(v.getLastName());
			employee.setAddress(addressConverter.convertToView(v.getAddress()));
			employee.setDateOfBirth(this.getDateOfBirth(v.getDateOfBirth()));
			
			if(v.getId()!=null) {
				employee.setId(v.getId().intValue());
			}
			return employee;
			
		}
		return null;
	}
	
	private DateOfBirth getDateOfBirth(Date date) {
		if(date!=null) {
			DateOfBirth dob = new DateOfBirth();
			dob.setYear(date.getYear());
			dob.setMonth(date.getMonth());
			dob.setDate(date.getDate());
			return dob;
			
		}
		return null;
		
	}

}
