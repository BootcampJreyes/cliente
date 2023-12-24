package com.bootcamp.cliente.businees.impl;

import com.bootcamp.cliente.Repository.ClienteRepository;
import com.bootcamp.cliente.Repository.entities.ClienteEntity;
import com.bootcamp.cliente.businees.ClienteService;
import com.bootcamp.cliente.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Flux<Cliente> findAll() {
        return this.clienteRepository
                .findAll()
                .map(ClienteEntity::toCliente);
    }

    @Override
    public Mono<Cliente> create(Cliente cliente) {
        return clienteRepository.save(new ClienteEntity().toClienteEntity(cliente))
                .map(ClienteEntity::toCliente);
    }

    @Override
    public Mono<Cliente> findAllBy(String id){
        return clienteRepository.findById(id)
                .map(ClienteEntity::toCliente);
    }
    @Override
    public Mono<Cliente> update(Cliente cliente){
        return clienteRepository.save(new ClienteEntity().toClienteEntity(cliente))
                .map(ClienteEntity::toCliente);
    }
    @Override
    public Mono<Void> deleteById(String id){
        return clienteRepository.deleteById(id);
    }
}
