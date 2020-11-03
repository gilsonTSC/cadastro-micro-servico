package com.br.myfood.cadastro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfood.cadastro.dto.ClientDto;

@RestController
@RequestMapping("/client")
public class ClientController {

	@PostMapping("/insert")
	public ResponseEntity<ClientDto> inserClient(@RequestBody ClientDto dto) {
		
		return ResponseEntity.ok(dto);
	}
}