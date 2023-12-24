package com.bootcamp.cliente.model.entity;

import com.bootcamp.cliente.Repository.entities.ClienteEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {
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



}
