package com.paypal.bfs.test.employeeserv.converter;

import org.springframework.stereotype.Component;

@Component
public interface Converter<T, V> {
	
	V convertToEntity(T t);
	
	T convertToView(V v);

}
