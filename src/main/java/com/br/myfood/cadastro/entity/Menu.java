package com.br.myfood.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.br.myfood.cadastro.dto.MenuDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_menu")
public class Menu {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;
	private Double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurant restaurant;
	
	public static Menu create(MenuDto dto) {
		 return new ModelMapper().map(dto, Menu.class);
	}
	
}