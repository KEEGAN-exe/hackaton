package pe.interbank.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.interbank.entity.Detalle;
import pe.interbank.repository.DetalleRepository;

@Service
public class DetalleServiceImpl implements DetalleService{
	
	@Autowired
	public DetalleRepository dr;

	@Override
	public void insert(Detalle detalle) {
		dr.save(detalle);
	}

	@Override
	public void update(Detalle detalle) {
		dr.save(detalle);
	}

	@Override
	public void delete(Integer detalleId) {
		dr.deleteById(detalleId);
	}

	@Override
	public Detalle findById(Integer detalleId) {
		return dr.findById(detalleId).orElse(null);
	}

	@Override
	public Collection<Detalle> findAll() {
		return dr.findAll();
	}

}
