package pe.interbank.service;

import java.util.Collection;

import pe.interbank.entity.Pedido;

public interface PedidoService {
	public abstract void insert(Pedido pedido);
	public abstract void update(Pedido pedido);
	public abstract void delete(Integer pedidoId);
	public abstract Pedido findById(Integer pedidoId);
	public abstract Collection<Pedido> findAll();

}
