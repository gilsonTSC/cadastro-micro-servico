package com.br.myfood.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.cadastro.dto.MenuDto;
import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.entity.Restaurant;
import com.br.myfood.cadastro.reprository.MenuRepository;
import com.br.myfood.cadastro.reprository.RestaurantRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;
	private final RestaurantRepository restaurantRepository;

	@Autowired
	public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
		this.menuRepository = menuRepository;
		this.restaurantRepository = restaurantRepository;
	}
	
	public Menu insertMenu(MenuDto menuDto) {
		
		Optional<Restaurant> restaurant = this.restaurantRepository.findById(menuDto.getRestaurant());
		if(restaurant.isPresent()) {
			Menu menu = Menu.create(menuDto);
			menu.setRestaurant(restaurant.get());
			return this.menuRepository.save(menu);
		}
		return null;
	}
	
	public Menu updateMenu(Menu menu) {
		Optional<Menu> newMenu = this.menuRepository.findById(menu.getId());
		
		if(newMenu.isPresent()) {
			return this.menuRepository.save(menu);
		}else {
			return null;
		}
	}
	
	public boolean deleteMenu(Long id) {
		Optional<Menu> menu = this.menuRepository.findById(id);
		
		if(menu.isPresent()) {
			this.menuRepository.delete(menu.get());
			return true;
		}else {
			return false;
		}
	}
	
	public Optional<Menu> findbyId(Long id) {
		return this.menuRepository.findById(id);
	}
	
}