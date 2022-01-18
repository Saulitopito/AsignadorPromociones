package jpa.promociones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jpa.promociones.modelo.ProdCliente;

public interface ProdClienteRepository extends JpaRepository<ProdCliente, Integer>{
	
	/**
	 * productoCliente: Acceder al valor ajustado del producto de un cliente, despu�s de la 
	 * 					asignaci�n de una promoci�n y la implementaci�n de su descuento
	 * @param clienteID
	 * @return - Productos asociado a un cliente, seg�n el id del cliente
	 */
	@Transactional
	@Query(value = "SELECT /*+ ALL_ROWS INDEX(prod_cliente, prod_cliente_id) */ * FROM PROD_CLIENTE WHERE CLIENTE_ID = ?", nativeQuery = true)
	ProdCliente productoCliente(Integer clienteID);
	
}
