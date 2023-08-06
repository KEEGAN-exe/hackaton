package pe.interbank.vo;

import pe.interbank.entity.Rol;
import pe.interbank.entity.Usuario;

public class UserRole {

	private Usuario user;
	private Rol role;
	
	public UserRole() {
	}

	public UserRole(Usuario user, Rol role) {
		super();
		this.user = user;
		this.role = role;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Rol getRole() {
		return role;
	}

	public void setRole(Rol role) {
		this.role = role;
	}
	
}
