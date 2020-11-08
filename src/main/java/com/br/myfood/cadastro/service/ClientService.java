package com.br.myfood.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.cadastro.dto.ClientOrderDto;
import com.br.myfood.cadastro.entity.Client;
import com.br.myfood.cadastro.message.ClientSendMessage;
import com.br.myfood.cadastro.reprository.ClientRepository;

@Service
public class ClientService {

	private final ClientRepository clientRepository;
	
	private final ClientSendMessage clientSendMessage;

	@Autowired
	public ClientService(ClientRepository clientRepository, ClientSendMessage clientSendMessage) {
		this.clientRepository = clientRepository;
		this.clientSendMessage = clientSendMessage;
	}
	
	public Client insertClient(Client client) {
		Client newClient = this.clientRepository.save(client);
		this.clientSendMessage.sendMessage(new ClientOrderDto(newClient.getId()));
		return newClient;
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
	
	public Optional<Client> findbyId(Long id) {
		return this.clientRepository.findById(id);
	}
	
}