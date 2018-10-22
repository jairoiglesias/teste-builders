package br.com.builders.treinamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.builders.treinamento.dto.request.CustomerRequest;

public interface CustomerRepository extends MongoRepository<CustomerRequest, String>{
	
}
