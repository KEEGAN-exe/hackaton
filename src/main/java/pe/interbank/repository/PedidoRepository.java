package pe.interbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.interbank.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
