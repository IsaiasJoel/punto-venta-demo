package com.idsoftware.punto_venta_demo.services;

import com.idsoftware.punto_venta_demo.models.entities.Venta;
import com.idsoftware.punto_venta_demo.repositories.IVentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    private final IVentaRepository ventaRepository;

    public VentaServiceImpl(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    public Venta registrarVenta(Venta venta) {
        venta.setFecha(LocalDateTime.now());
        return ventaRepository.save(venta);
    }
}
