package pe.interbank.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.interbank.entity.Producto;
import pe.interbank.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	public ProductoRepository pr;

	@Override
	public void insert(Producto producto) {
		pr.save(producto);
	}

	@Override
	public void update(Producto producto) {
		pr.save(producto);
	}

	@Override
	public void delete(Integer productoId) {
		pr.deleteById(productoId);
	}

	@Override
	public Producto findById(Integer productoId) {
		return pr.findById(productoId).orElse(null);
	}

	@Override
	public Collection<Producto> findAll() {
		return pr.findAll();
	}
}
