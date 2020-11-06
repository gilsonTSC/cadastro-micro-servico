package com.br.myfood.cadastro.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfood.cadastro.dto.RestaurantDto;
import com.br.myfood.cadastro.entity.Restaurant;
import com.br.myfood.cadastro.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	private final RestaurantService restaurantService;
	
	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping("/insert")
	public ResponseEntity<Restaurant> inserRestaurant(@RequestBody RestaurantDto dto) {
		Restaurant restaurant = null;
		try {
			restaurant = this.restaurantService.insertRestaurant(Restaurant.create(dto));
		}catch(Exception e){
			ResponseEntity.badRequest().body(e);
		}
		return ResponseEntity.ok(restaurant);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDto restaurantDto){
		Restaurant restaurant = Restaurant.create(restaurantDto);
		restaurant.setId(id);
		
		Restaurant updateRestaurant = this.restaurantService.updateRestaurant(restaurant);
		
		return Objects.nonNull(updateRestaurant) ? ResponseEntity.ok(updateRestaurant) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("id") Long id){
		return this.restaurantService.deleteRestaurant(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Restaurant> findById(@PathVariable("id") Long id){
		Optional<Restaurant> restaurant = this.restaurantService.findbyId(id);
		
		return restaurant.isPresent() ? ResponseEntity.ok(restaurant.get()) : ResponseEntity.notFound().build();
	}
	
}