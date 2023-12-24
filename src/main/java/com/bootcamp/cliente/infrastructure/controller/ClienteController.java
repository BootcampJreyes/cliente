package com.bootcamp.cliente.infrastructure.controller;

import com.bootcamp.cliente.businees.ClienteService;
import com.bootcamp.cliente.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ClienteController.PRODUCTS)
public class ClienteController {
    public static final String PRODUCTS = "/cliente";
    public static final String FINDALL = "/findAll";
    public static final String SAVE = "/save";
    public static final String FINDALLBY = "/findAllBy";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(FINDALL)
    private Flux<Cliente> findAll() {
        return clienteService.findAll();
    }

    @PostMapping(SAVE)
    private Mono<Cliente> create(@RequestBody Cliente cliente) {
        return clienteService.create(cliente);
    }

    @GetMapping(FINDALLBY)
    private Mono<Cliente> findAllBy(@RequestParam("id") String id) throws Exception{
        return clienteService.findAllBy(id);
    }

    @PutMapping(UPDATE)
    private Mono<Cliente> update(@RequestBody Cliente cliente){
        return clienteService.update(cliente);
    }

    @DeleteMapping(DELETE)
    private Mono<Void> deleteById(@RequestParam("id") String id){
        return clienteService.deleteById(id);
    }
}
