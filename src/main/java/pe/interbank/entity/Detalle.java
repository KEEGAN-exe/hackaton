package pe.interbank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallePedido")
public class Detalle implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer detalleId;
	
	@Column
	private Integer cantidad;
	@Column
	private Double subtotal;
	@Column
	private Integer precioUnitario;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	public Detalle() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Detalle(Integer detalleId, Integer cantidad, Double subtotal, Integer precioUnitario, Pedido pedido,
			Producto producto) {
		this.detalleId = detalleId;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.precioUnitario = precioUnitario;
		this.pedido = pedido;
		this.producto = producto;
	}



	public Integer getDetalleId() {
		return detalleId;
	}

	public void setDetalleId(Integer detalleId) {
		this.detalleId = detalleId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	
	
	
	
}
