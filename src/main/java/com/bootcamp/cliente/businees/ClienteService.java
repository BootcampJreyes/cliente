package com.bootcamp.cliente.businees;

import com.bootcamp.cliente.model.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteService {
    Flux<Cliente> findAll();

    Mono<Cliente> create(Cliente cliente);

    Mono<Cliente> findAllBy(String id);
    Mono<Cliente> update(Cliente Cliente);
    Mono<Void> deleteById(String id);

}
