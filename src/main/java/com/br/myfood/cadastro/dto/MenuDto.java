package com.br.myfood.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

	private Long id;
	private String name;
	private Double price;
	private Long restaurant;
	
}