package pe.interbank.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productoId;
	@Column
	private String nombre;
	@Column
	private String image;
	@Column
	private Integer stock;
	@Column
	private Double precio;
	@ManyToOne
	@JoinColumn(name="categoriaId", nullable=false)
	private Categoria categoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "producto")
	private Collection<Detalle> itemsDetalle;

	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer productoId, String nombre, String image, Integer stock, Double precio) {
		this.productoId = productoId;
		this.nombre = nombre;
		this.image = image;
		this.stock = stock;
		this.precio = precio;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Collection<Detalle> getItemsDetalle() {
		return itemsDetalle;
	}

	public void setItemsDetalle(Collection<Detalle> itemsDetalle) {
		this.itemsDetalle = itemsDetalle;
	} 
	
	
	
}
