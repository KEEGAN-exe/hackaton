package pe.interbank.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.interbank.entity.Categoria;
import pe.interbank.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	public CategoriaRepository cr;
	
	@Override
	public void insert(Categoria categoria) {
		cr.save(categoria);
	}

	@Override
	public void update(Categoria categoria) {
		cr.save(categoria);
	}

	@Override
	public void delete(Integer categoriaId) {
		cr.deleteById(categoriaId);
	}

	@Override
	public Categoria findById(Integer categoriaId) {
		return cr.findById(categoriaId).orElse(null);
	}

	@Override
	public Collection<Categoria> findAll() {
		return cr.findAll();
	}

}
