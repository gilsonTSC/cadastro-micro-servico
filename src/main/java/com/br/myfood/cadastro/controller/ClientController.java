package com.br.myfood.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfood.cadastro.dto.ClientDto;
import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	private final ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping("/insert")
	public ResponseEntity<Client> inserClient(@RequestBody ClientDto dto) {
		
		return ResponseEntity.ok(this.clientService.insertClient(Client.create(dto)));
	}
}