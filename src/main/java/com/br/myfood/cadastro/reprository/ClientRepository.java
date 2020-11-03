package com.br.myfood.cadastro.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.myfood.cadastro.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}