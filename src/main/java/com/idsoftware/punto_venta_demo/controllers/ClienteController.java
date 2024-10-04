package com.idsoftware.punto_venta_demo.controllers;

import com.idsoftware.punto_venta_demo.models.entities.Cliente;
import com.idsoftware.punto_venta_demo.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return new ResponseEntity<>(clienteService.obtener(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.crear(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.editar(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}