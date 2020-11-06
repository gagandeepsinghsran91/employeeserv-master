package com.paypal.bfs.test.employeeserv.converter.impl;

import org.springframework.stereotype.Component;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.converter.Converter;
import com.paypal.bfs.test.employeeserv.entity.AddressEntity;


@Component
public class AddressConverter  implements Converter<Address, AddressEntity>{

	@Override
	public AddressEntity convertToEntity(Address t) {
		if(t!=null) {
			AddressEntity addressEntity = new AddressEntity();
			addressEntity.setLine1(t.getLine1());
			addressEntity.setLine2(t.getLine2());
			addressEntity.setCity(t.getCity());
			addressEntity.setCountry(t.getCountry());
			addressEntity.setZipCode(t.getZipCode());
			
			return addressEntity;
		}
		
		return null;
	}

	@Override
	public Address convertToView(AddressEntity v) {
		if(v!=null) {
			Address address = new Address();
			address.setLine1(v.getLine1());
			address.setLine2(v.getLine2());
			address.setCity(v.getCity());
			address.setCountry(v.getCountry());
			address.setZipCode(v.getZipCode());
			
			return address;
			
		}
		return null;
		
	}

}
