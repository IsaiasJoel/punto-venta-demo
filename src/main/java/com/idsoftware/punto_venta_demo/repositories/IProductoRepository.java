package com.idsoftware.punto_venta_demo.repositories;

import com.idsoftware.punto_venta_demo.models.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
