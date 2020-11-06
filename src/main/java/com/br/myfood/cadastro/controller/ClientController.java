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
		Client client = null;
		try {
			client = this.clientService.insertClient(Client.create(dto));
		}catch(Exception e){
			ResponseEntity.badRequest().body(e);
		}
		return ResponseEntity.ok(client);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientDto){
		Client client = Client.create(clientDto);
		client.setId(id);
		
		Client updateClient = this.clientService.updateClient(client);
		
		return Objects.nonNull(updateClient) ? ResponseEntity.ok(updateClient) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id){
		return this.clientService.deleteClient(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Client> findById(@PathVariable("id") Long id){
		Optional<Client> client = this.clientService.findbyId(id);
		
		return client.isPresent() ? ResponseEntity.ok(client.get()) : ResponseEntity.notFound().build();
	}
	
}