package pe.interbank.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Rol implements Serializable{


	private static final long serialVersionUID=1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rolId;
	@Column
	private String nombre;
	
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> users = new HashSet<>();
	
	public Rol() {
		// TODO Auto-generated constructor stub
	}
	


	public Rol(Integer rolId, String nombre) {
		this.rolId = rolId;
		this.nombre = nombre;
	}
	public Integer getRolId() {
		return rolId;
	}
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
