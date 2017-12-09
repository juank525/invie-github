package com.supermercado.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imagen_producto database table.
 * 
 */
@Entity
@Table(name="imagen_producto")
@NamedQuery(name="ImagenProducto.findAll", query="SELECT i FROM ImagenProducto i")
public class ImagenProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_imagen_producto")
	private String idImagenProducto;

	private String ruta;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public ImagenProducto() {
	}

	public String getIdImagenProducto() {
		return this.idImagenProducto;
	}

	public void setIdImagenProducto(String idImagenProducto) {
		this.idImagenProducto = idImagenProducto;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}