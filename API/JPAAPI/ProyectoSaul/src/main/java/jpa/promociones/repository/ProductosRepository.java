package jpa.promociones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.promociones.modelo.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Integer>{

}
