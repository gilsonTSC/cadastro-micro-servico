package com.br.myfood.cadastro.service;

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
	
}