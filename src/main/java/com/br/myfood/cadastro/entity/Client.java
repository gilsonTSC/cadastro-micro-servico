package com.br.myfood.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.br.myfood.cadastro.dto.ClientDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_client")
public class Client {

	private String name;
	private String email;
	private String password;
	
	public static Client create(ClientDto dto) {
		 return new ModelMapper().map(dto, Client.class);
	}
	
}