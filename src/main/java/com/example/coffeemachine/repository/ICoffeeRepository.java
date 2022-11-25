package com.example.coffeemachine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeemachine.model.Coffee;

public interface ICoffeeRepository extends JpaRepository<Coffee, String> {
	List<Coffee> findByName(String name);
}
