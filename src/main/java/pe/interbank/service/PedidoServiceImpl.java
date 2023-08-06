package pe.interbank.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.interbank.entity.Pedido;
import pe.interbank.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	public PedidoRepository pr;
	
	@Override
	public void insert(Pedido pedido) {
		pr.save(pedido);
	}

	@Override
	public void update(Pedido pedido) {
		pr.save(pedido);
	}

	@Override
	public void delete(Integer pedidoId) {
		pr.deleteById(pedidoId);
	}

	@Override
	public Pedido findById(Integer pedidoId) {
		return pr.findById(pedidoId).orElse(null);
	}

	@Override
	public Collection<Pedido> findAll() {
		return pr.findAll();
	}

}
