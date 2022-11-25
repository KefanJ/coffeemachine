package com.example.coffeemachine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.coffeemachine.model.Coffee;

public interface ICoffeeService {

	List<Coffee> getCoffees();

	Optional<Coffee> getCoffeeById(String id);

	Coffee postCoffee(Coffee coffee);

	ResponseEntity<Coffee> putCoffee(String id, Coffee coffee);

	void deleteCoffee(String id);
	
	List<Coffee> getByName(String name);

}