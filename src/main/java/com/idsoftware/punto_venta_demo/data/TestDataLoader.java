package com.idsoftware.punto_venta_demo.data;

import com.idsoftware.punto_venta_demo.models.entities.Cliente;
import com.idsoftware.punto_venta_demo.models.entities.DetalleVenta;
import com.idsoftware.punto_venta_demo.models.entities.Producto;
import com.idsoftware.punto_venta_demo.models.entities.Venta;
import com.idsoftware.punto_venta_demo.repositories.IClienteRepository;
import com.idsoftware.punto_venta_demo.repositories.IProductoRepository;
import com.idsoftware.punto_venta_demo.services.IVentaService;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;

@Component
public class TestDataLoader {

    private final IProductoRepository productoRepository;
    private final IClienteRepository clienteRepository;
    private final IVentaService ventaService;

    public TestDataLoader(IProductoRepository productoRepository, IClienteRepository clienteRepository, IVentaService ventaService) {
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
        this.ventaService = ventaService;

    }

    @PostConstruct
    public void cargarDatosDePrueba() {
        // Crear productos de prueba
        Producto producto1 = new Producto(null, "Laptop", 1500.0);
        Producto producto2 = new Producto(null, "Smartphone", 800.0);
        Producto producto3 = new Producto(null, "Tablet", 600.0);

        List<Producto> productos = Arrays.asList(producto1, producto2, producto3);
        productoRepository.saveAll(productos);

        // Crear clientes de prueba
        Cliente cliente1 = new Cliente(null, "Juan Pérez", "juan.perez@example.com");
        Cliente cliente2 = new Cliente(null, "María García", "maria.garcia@example.com");

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
        clienteRepository.saveAll(clientes);

        // Crear ventas de prueba
        Venta venta1 = new Venta();
        venta1.setCliente(cliente1);
        venta1.setDetalles(List.of(new DetalleVenta(null, producto1, 1, venta1)));

        Venta venta2 = new Venta();
        venta2.setCliente(cliente2);
        venta2.setDetalles(List.of(new DetalleVenta(null, producto2, 2, venta2)));

        ventaService.registrarVenta(venta1);
        ventaService.registrarVenta(venta2);

        System.out.println("Datos de prueba cargados.");
    }
}
