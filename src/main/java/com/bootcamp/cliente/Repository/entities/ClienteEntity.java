package com.bootcamp.cliente.Repository.entities;

import com.bootcamp.cliente.model.entity.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "cliente")
public class ClienteEntity {
    @Id
    private String id;
    private String dni;
    private String nombre;
    private String apellido;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fechaNacimiento;
    private String celular;
    private String email;
    private String ciudad;

    public ClienteEntity() {

    }
    public ClienteEntity toClienteEntity(Cliente cliente) {
        ClienteEntity clienteEntity = ClienteEntity.builder().build();
        BeanUtils.copyProperties(cliente,clienteEntity);
        return clienteEntity;
    }
    public Cliente toCliente() {
        Cliente cliente = Cliente.builder().build();
        BeanUtils.copyProperties( this, cliente);
        return cliente;
    }
}
