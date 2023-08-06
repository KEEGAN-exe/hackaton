package pe.interbank.service;

import java.util.Collection;

import pe.interbank.entity.Usuario;


public interface UserService {
	public abstract void insert(Usuario user);
	public abstract void update(Usuario user);
	public abstract void delete(Integer userId);
	public abstract Usuario findById(Integer userId);
	public abstract Collection<Usuario> findAll();
	public abstract Collection<Object[]> findAll_withUsers1();
	public abstract Collection<Object[]> findAll_withUsers2();
	public abstract Usuario findByUsername(String usuario);
}
