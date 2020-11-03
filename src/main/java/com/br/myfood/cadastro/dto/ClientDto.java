package com.br.myfood.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private String name;
	private String email;
	private String password;
	
}