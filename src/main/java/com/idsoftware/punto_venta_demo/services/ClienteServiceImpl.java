package com.idsoftware.punto_venta_demo.services;

import com.idsoftware.punto_venta_demo.models.entities.Cliente;
import com.idsoftware.punto_venta_demo.models.entities.Producto;
import com.idsoftware.punto_venta_demo.repositories.IClienteRepository;
import com.idsoftware.punto_venta_demo.repositories.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> obtener() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editar(Cliente cliente) {
        Cliente encontrado = clienteRepository.findById(cliente.getId()).orElseThrow();

        encontrado.setNombre(cliente.getNombre());
        encontrado.setCorreo(cliente.getCorreo());

        return clienteRepository.save(encontrado);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}