package com.bootcamp.cliente.controller;

import com.bootcamp.cliente.businees.ClienteService;
import com.bootcamp.cliente.infrastructure.controller.ClienteController;
import com.bootcamp.cliente.model.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(ClienteController.class)
class ClienteControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private ClienteService clienteImpl;

    @Test
    void findAll(){
        when(clienteImpl.findAll()).thenReturn(Flux.just(getCliente()));
        webTestClient.get()
                .uri("/cliente/findAll")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cliente.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void save(){
        when(clienteImpl.create(getCliente())).thenReturn(Mono.just(getCliente()));
        webTestClient.post()
                .uri("/cliente/save")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getCliente())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cliente.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void findAllBy(){
        when(clienteImpl.findAllBy("1")).thenReturn(Mono.just(getCliente()));
        webTestClient.get()
                .uri("/cliente/findAllBy?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cliente.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void update(){
        when(clienteImpl.update(getCliente())).thenReturn(Mono.just(getCliente()));
        webTestClient.put()
                .uri("/cliente/update")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getCliente())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cliente.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void deleteById() {
        when(clienteImpl.deleteById("1")).thenReturn(Mono.empty());
        webTestClient.delete()
                .uri("/cliente/delete?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }

    public Cliente  getCliente(){
        return new Cliente("12459","12345687","jordy","reyes"
                ,new Date(1994,03,17),"923654789","nttdata2023@nttdata.com","Trujillo");
    }
}
