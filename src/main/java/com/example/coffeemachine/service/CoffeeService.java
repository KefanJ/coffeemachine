package com.example.coffeemachine.service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.coffeemachine.model.Coffee;
import com.example.coffeemachine.repository.ICoffeeRepository;

@Service
public class CoffeeService implements ICoffeeService {
	
	private ICoffeeRepository coffeeDao;
	
	
	
	
	 public CoffeeService(ICoffeeRepository coffeeDao) {
		super();
		this.coffeeDao = coffeeDao;
	}

	@Override
	public List<Coffee> getCoffees(){
		 return coffeeDao.findAll();
	 }
	 
	 @Override
	public Optional<Coffee> getCoffeeById(String id) {
		 
		 return coffeeDao.findById(id);
	 }
	 
	 @Override
	public Coffee postCoffee( Coffee coffee) {
			return coffeeDao.save(coffee);
		}
	 
	@Override
	public ResponseEntity<Coffee> putCoffee(String id,  Coffee coffee){
			
			return(coffeeDao.existsById(id))
					? new ResponseEntity<>(coffeeDao.save(coffee), HttpStatus.OK)
					: new ResponseEntity<>(coffeeDao.save(coffee), HttpStatus.CREATED);	
		}
	
	@Override
	public void deleteCoffee(String id) {
		coffeeDao.deleteById(id);
	}

	@Override
	public List<Coffee> getByName(String name) {
		// TODO Auto-generated method stub
		return coffeeDao.findByName(name);
	}


	
	
	 
}
