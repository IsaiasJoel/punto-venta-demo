package com.idsoftware.punto_venta_demo.services;

import com.idsoftware.punto_venta_demo.models.entities.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> obtenerProductos();
    Producto crearProducto(Producto producto);
}
