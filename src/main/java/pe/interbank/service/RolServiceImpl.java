package pe.interbank.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.interbank.entity.Rol;
import pe.interbank.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	public RolRepository rp;
	
	@Override
	public void insert(Rol role) {
		rp.save(role);
	}

	@Override
	public void update(Rol role) {
		rp.save(role);
	}

	@Override
	public void delete(Integer userId) {
		rp.deleteById(userId);
	}

	@Override
	public Rol findById(Integer rolerId) {
		return rp.findById(rolerId).orElse(null);
	}

	@Override
	public Collection<Rol> findAll() {
		return rp.findAll();
	}

}
