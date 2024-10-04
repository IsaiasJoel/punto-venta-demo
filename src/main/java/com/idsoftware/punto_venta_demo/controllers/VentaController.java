package com.idsoftware.punto_venta_demo.controllers;

import com.idsoftware.punto_venta_demo.models.entities.Venta;
import com.idsoftware.punto_venta_demo.services.IVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        return new ResponseEntity<>(ventaService.obtenerVentas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Venta> registrarVenta(@RequestBody Venta venta) {
        return new ResponseEntity<>(ventaService.registrarVenta(venta), HttpStatus.CREATED);
    }
}
