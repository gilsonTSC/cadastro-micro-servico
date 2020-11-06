package com.br.myfood.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.br.myfood.cadastro.dto.RestaurantDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_restaurant")
public class Restaurant {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;
	private String email;
	private String password;
	
	public static Restaurant create(RestaurantDto dto) {
		 return new ModelMapper().map(dto, Restaurant.class);
	}
	
}