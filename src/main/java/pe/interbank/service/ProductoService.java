package pe.interbank.service;

import java.util.Collection;

import pe.interbank.entity.Producto;

public interface ProductoService {
	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer productoId);
	public abstract Producto findById(Integer productoId);
	public abstract Collection<Producto> findAll();

}
