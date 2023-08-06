package pe.interbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.interbank.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
