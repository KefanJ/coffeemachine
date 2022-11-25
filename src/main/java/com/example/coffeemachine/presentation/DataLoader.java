package com.example.coffeemachine.presentation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.coffeemachine.model.Coffee;
import com.example.coffeemachine.repository.ICoffeeRepository;

@Component
public class DataLoader {
	private  ICoffeeRepository coffeeRepository;

	public DataLoader(ICoffeeRepository coffeeRepository) {
		super();
		this.coffeeRepository = coffeeRepository;
	}
	
	@PostConstruct
	private void loadData() {
		coffeeRepository.saveAll(List.of(
				new Coffee("Café Cereza"),
				new Coffee("Café Ganador"),
				new Coffee("Café Lareno"),
				new Coffee("Café Três Pontas")				
				));
	}
	

}
