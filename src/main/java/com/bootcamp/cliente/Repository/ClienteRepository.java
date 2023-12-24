package com.bootcamp.cliente.Repository;

import com.bootcamp.cliente.Repository.entities.ClienteEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<ClienteEntity, String> {

}
