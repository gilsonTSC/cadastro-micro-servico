package com.br.myfood.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.reprository.ClientRepository;

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Client insertClient(Client client) {
		return this.clientRepository.save(client);
	}
	
	public Client updateClient(Client client) {
		Optional<Client> newClient = this.clientRepository.findById(client.getId());
		
		if(newClient.isPresent()) {
			return this.clientRepository.save(client);
		}else {
			return null;
		}
	}
	
	public boolean deleteClient(Long id) {
		Optional<Client> client = this.clientRepository.findById(id);
		
		if(client.isPresent()) {
			this.clientRepository.delete(client.get());
			return true;
		}else {
			return false;
		}
	}
}