package com.idsoftware.punto_venta_demo.services;

import com.idsoftware.punto_venta_demo.models.entities.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> obtener();
    Cliente crear(Cliente cliente);
    Cliente editar(Cliente cliente);
    void eliminar(Long id);
}
