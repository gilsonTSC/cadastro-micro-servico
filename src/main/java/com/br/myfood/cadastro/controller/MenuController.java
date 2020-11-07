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

import com.br.myfood.cadastro.dto.MenuDto;
import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	private final MenuService menuService;
	
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@PostMapping("/insert")
	public ResponseEntity<MenuDto> inserMenu(@RequestBody MenuDto menuDto) {
		try {
			Menu menu = this.menuService.insertMenu(menuDto);
			
			if (Objects.nonNull(menu)) {
				MenuDto dto = new MenuDto();
				dto.setId(menu.getId());
				dto.setName(menu.getName());
				dto.setPrice(menu.getPrice());
				dto.setRestaurant(menu.getRestaurant().getId());
				
				return ResponseEntity.ok(dto);
			}
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable("id") Long id, @RequestBody MenuDto menuDto){
		Menu menu = Menu.create(menuDto);
		menu.setId(id);
		
		Menu updateMenu = this.menuService.updateMenu(menu);
		
		return Objects.nonNull(updateMenu) ? ResponseEntity.ok(updateMenu) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Menu> deleteMenu(@PathVariable("id") Long id){
		return this.menuService.deleteMenu(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Menu> findById(@PathVariable("id") Long id){
		Optional<Menu> menu = this.menuService.findbyId(id);
		
		return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();
	}
	
}