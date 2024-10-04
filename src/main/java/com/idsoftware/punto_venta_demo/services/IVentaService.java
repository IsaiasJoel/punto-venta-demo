package com.idsoftware.punto_venta_demo.services;

import com.idsoftware.punto_venta_demo.models.entities.Venta;

import java.util.List;

public interface IVentaService {
    List<Venta> obtenerVentas();
    Venta registrarVenta(Venta venta);
}
