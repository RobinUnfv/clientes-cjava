package com.robin.mclientes.repository;

import com.robin.mclientes.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IClienteRepo extends MongoRepository<Cliente, String> {
}
