package com.idsoftware.punto_venta_demo.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class DetalleVenta {

    public DetalleVenta() {}

    public DetalleVenta(Long id, Producto producto, int cantidad, Venta venta) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.venta = venta;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    private int cantidad;

    @ManyToOne
    @JsonBackReference //Para evitar que se llame recursivamente a sí mismo
    private Venta venta;

    // Getters, setters y constructores

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
