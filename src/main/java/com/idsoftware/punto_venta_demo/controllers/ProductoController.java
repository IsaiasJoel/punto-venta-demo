package com.idsoftware.punto_venta_demo.controllers;

import com.idsoftware.punto_venta_demo.models.entities.Producto;
import com.idsoftware.punto_venta_demo.services.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return new ResponseEntity<>(productoService.obtenerProductos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }
}
