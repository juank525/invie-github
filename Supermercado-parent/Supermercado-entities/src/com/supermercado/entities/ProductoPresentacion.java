package com.supermercado.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the producto_presentacion database table.
 * 
 */
@Entity
@Table(name = "producto_presentacion")
@NamedQuery(name = "ProductoPresentacion.findAll", query = "SELECT p FROM ProductoPresentacion p")
public class ProductoPresentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductoPresentacionPK id;

	@Column(name = "precio_compra")
	private BigDecimal precioCompra;

	@Column(name = "precio_venta")
	private BigDecimal precioVenta;

	// bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private Producto producto;

	// bi-directional many-to-one association to Presentacion
	@ManyToOne
	@JoinColumn(name = "id_presentacion", insertable = false, updatable = false)
	private Presentacion presentacion;

	public ProductoPresentacion() {
	}

	public ProductoPresentacionPK getId() {
		return this.id;
	}

	public void setId(ProductoPresentacionPK id) {
		this.id = id;
	}

	public BigDecimal getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Presentacion getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

}