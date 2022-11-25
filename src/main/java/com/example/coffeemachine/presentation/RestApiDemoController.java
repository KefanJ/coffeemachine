package com.example.coffeemachine.presentation;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coffeemachine.model.Coffee;
import com.example.coffeemachine.service.ICoffeeService;



@RestController
//O@RequestMapping("/coffees")
public class RestApiDemoController {
	

	
	private ICoffeeService service;
	
	public RestApiDemoController(ICoffeeService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
		
		
		
	}
	
	
	@GetMapping
	Iterable<Coffee> getCoffees(){
		return service.getCoffees();
		
	}
	
	@GetMapping("/coffees/{id}")
	Optional<Coffee> getCoffeById(@PathVariable String id){
		return service.getCoffeeById(id);
		
	}
	
	@GetMapping("/coffees/name/{name}")
	Iterable<Coffee> getByName(@PathVariable String name){
		return service.getByName(name);
		
	}
	
	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee) {
		return service.postCoffee(coffee);
	}
	
	@PutMapping("/coffees/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
		
		return service.putCoffee(id, coffee);
	}
	
	@DeleteMapping
	void deleteCoffee(@PathVariable String id) {
		service.deleteCoffee(id);
	}
	
	
	
	
	/*
	private List<Coffee> coffees = new ArrayList<>();

	public RestApiDemoController() {
		// TODO Auto-generated constructor stub
		coffees.addAll(List.of(
				new Coffee("Café Cereza"),
				new Coffee("Café Ganador"),
				new Coffee("Café Lareno"),
				new Coffee("Café Três Pontas")	
				));
	}
	
	
	
	/*@GetMapping("/coffees/{id}")
	public Optional<Coffee> getCoffeeById(@PathVariable String id) {
		
		for (Coffee coffee : coffees) {
			if(coffee.getId().equals(id)) {
				return Optional.of(coffee);
			}
		}		
		return Optional.empty();
	}
	
	@GetMapping("/coffees/{id}")
	public Coffee getCoffeeById(@PathVariable String id) {
		
		for (Coffee coffee : coffees) {
			if(coffee.getId().equals(id)) {
				return coffee;
			}
		}		
		return null;
	}
	
	@PostMapping("/coffees")
	public Coffee postCoffee(@RequestBody Coffee coffee) {
		//coffee.setId(UUID.randomUUID().toString().toString());
		coffees.add(coffee);
		return coffee;
	}
	
	@PutMapping("/coffees/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
		int coffeeIndex = -1;
		
		for (Coffee c : coffees) {
			if(coffee.getId().equals(id)) {
				coffeeIndex = coffees.indexOf(c);
				coffees.set(coffeeIndex, coffee);	
			}
		}
		
		return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
			new ResponseEntity<>(postCoffee(coffee), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/coffees/{id}")
	public void deleteCoffee(@PathVariable String id) {
		coffees.removeIf(c -> c.getId().equals(id));
		
	}
	*/
	
}
