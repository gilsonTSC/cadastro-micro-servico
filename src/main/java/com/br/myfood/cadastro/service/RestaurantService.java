package com.br.myfood.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.cadastro.entity.Restaurant;
import com.br.myfood.cadastro.reprository.RestaurantRepository;

@Service
public class RestaurantService {

	private final RestaurantRepository restaurantRepository;

	@Autowired
	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	public Restaurant insertRestaurant(Restaurant restaurant) {
		return this.restaurantRepository.save(restaurant);
	}
	
	public Restaurant updateRestaurant(Restaurant restaurant) {
		Optional<Restaurant> newRestaurant = this.restaurantRepository.findById(restaurant.getId());
		
		if(newRestaurant.isPresent()) {
			return this.restaurantRepository.save(restaurant);
		}else {
			return null;
		}
	}
	
	public boolean deleteRestaurant(Long id) {
		Optional<Restaurant> restaurant = this.restaurantRepository.findById(id);
		
		if(restaurant.isPresent()) {
			this.restaurantRepository.delete(restaurant.get());
			return true;
		}else {
			return false;
		}
	}
	
	public Optional<Restaurant> findbyId(Long id) {
		return this.restaurantRepository.findById(id);
	}
	
}