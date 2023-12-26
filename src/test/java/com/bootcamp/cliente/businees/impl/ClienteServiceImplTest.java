package com.bootcamp.cliente.businees.impl;

import com.bootcamp.cliente.Repository.ClienteRepository;
import com.bootcamp.cliente.Repository.entities.ClienteEntity;
import com.bootcamp.cliente.model.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;


    @Test
    void findAll() {
        ClienteEntity clienteEntity=new ClienteEntity("12459","12345687","jordy","reyes"
                ,new Date(1994,03,17),"923654789","nttdata2023@nttdata.com","Trujillo");
        Cliente cliente=new Cliente("12459","12345687","jordy","reyes"
                ,new Date(1994,03,17),"923654789","nttdata2023@nttdata.com","Trujillo");
        when(clienteRepository.findAll()).thenReturn(Flux.just(clienteEntity));
        when(clienteServiceImpl.findAll()).thenReturn(Flux.just(cliente));

        Flux<Cliente> resultado = clienteServiceImpl.findAll();
        StepVerifier.create(resultado) // Verifica que haya dos elementos en el flujo
                .expectNext(cliente)
                .expectComplete()
                .verify();
    }

    @Test
    void save() {
        when(clienteRepository.save(getClienteEntity())).thenReturn(Mono.just(getClienteEntity()));
        when(clienteServiceImpl.create(getCliente())).thenReturn(Mono.just(getCliente()));

        Mono<Cliente> resultado = clienteServiceImpl.create(getCliente());

        StepVerifier.create(resultado)
                .expectNext(getCliente())
                .expectComplete()
                .verify();
    }

    @Test
    void findAllBy() {
        when(clienteRepository.findById(anyString())).thenReturn(Mono.just(getClienteEntity()));
        when(clienteServiceImpl.findAllBy(anyString())).thenReturn(Mono.just(getCliente()));

        Mono<Cliente> resultado = clienteServiceImpl.findAllBy("1");

        StepVerifier.create(resultado)
                .expectNext(getCliente())
                .expectComplete()
                .verify();
    }

    @Test
    void update() {
        when(clienteRepository.save(any())).thenReturn(Mono.just(getClienteEntity()));
        when(clienteServiceImpl.update(any())).thenReturn(Mono.just(getCliente()));

        Mono<Cliente> resultado = clienteServiceImpl.update(getCliente());

        StepVerifier.create(resultado)
                .expectNext(getCliente())
                .expectComplete()
                .verify();
    }

    @Test
    void deleteById() {
        when(clienteRepository.deleteById(anyString())).thenReturn(Mono.empty());
        when(clienteServiceImpl.deleteById(anyString())).thenReturn(Mono.empty());

        Mono<Void> resultado = clienteServiceImpl.deleteById("1");

        StepVerifier.create(resultado)
                .expectComplete()
                .verify();
    }

    public ClienteEntity  getClienteEntity(){
        return new ClienteEntity("12459","12345687","jordy","reyes"
                ,new Date(1994,03,17),"923654789","nttdata2023@nttdata.com","Trujillo");
    }
    public Cliente  getCliente(){
        return new Cliente("12459","12345687","jordy","reyes"
                ,new Date(1994,03,17),"923654789","nttdata2023@nttdata.com","Trujillo");
    }
}
