package pe.interbank.service;

import java.util.Collection;

import pe.interbank.entity.Rol;

public interface RolService {
	public abstract void insert(Rol role);
	public abstract void update(Rol role);
	public abstract void delete(Integer userId);
	public abstract Rol findById(Integer rolerId);
	public abstract Collection<Rol> findAll();
}
