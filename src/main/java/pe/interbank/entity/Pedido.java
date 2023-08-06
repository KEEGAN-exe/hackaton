package pe.interbank.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pedidoId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd", iso=ISO.DATE)
	private LocalDate fecha;
	@Column
	private Double subtotal;
	@Column
	private Double igv;
	@Column
	private Double total;
	@Column
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Usuario user; 
	
	@JsonBackReference
	@OneToMany(mappedBy = "pedido")
	private Collection<Detalle> detalles;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	

	public Pedido(Integer pedidoId, LocalDate fecha, Double subtotal, Double igv, Double total, String estado,
			Usuario user, Collection<Detalle> detalles) {
		this.pedidoId = pedidoId;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.estado = estado;
		this.user = user;
		this.detalles = detalles;
	}



	@PrePersist
	public void prePersist() {
		fecha=LocalDate.now();
	}

	public Integer getPedidoId() {
		return pedidoId;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Usuario getUser() {
		return user;
	}



	public void setUser(Usuario user) {
		this.user = user;
	}



	public Collection<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(Collection<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	
	
	
}
