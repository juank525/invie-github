package com.supermercado.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producto")
	private String idProducto;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to DetalleFactura
	@OneToMany(mappedBy="producto")
	private List<DetalleFactura> detalleFacturas;

	//bi-directional many-to-one association to ImagenProducto
	@OneToMany(mappedBy="producto")
	private List<ImagenProducto> imagenProductos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to ProductoPresentacion
	@OneToMany(mappedBy="producto")
	private List<ProductoPresentacion> productoPresentacions;

	public Producto() {
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().add(detalleFactura);
		detalleFactura.setProducto(this);

		return detalleFactura;
	}

	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().remove(detalleFactura);
		detalleFactura.setProducto(null);

		return detalleFactura;
	}

	public List<ImagenProducto> getImagenProductos() {
		return this.imagenProductos;
	}

	public void setImagenProductos(List<ImagenProducto> imagenProductos) {
		this.imagenProductos = imagenProductos;
	}

	public ImagenProducto addImagenProducto(ImagenProducto imagenProducto) {
		getImagenProductos().add(imagenProducto);
		imagenProducto.setProducto(this);

		return imagenProducto;
	}

	public ImagenProducto removeImagenProducto(ImagenProducto imagenProducto) {
		getImagenProductos().remove(imagenProducto);
		imagenProducto.setProducto(null);

		return imagenProducto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ProductoPresentacion> getProductoPresentacions() {
		return this.productoPresentacions;
	}

	public void setProductoPresentacions(List<ProductoPresentacion> productoPresentacions) {
		this.productoPresentacions = productoPresentacions;
	}

	public ProductoPresentacion addProductoPresentacion(ProductoPresentacion productoPresentacion) {
		getProductoPresentacions().add(productoPresentacion);
		productoPresentacion.setProducto(this);

		return productoPresentacion;
	}

	public ProductoPresentacion removeProductoPresentacion(ProductoPresentacion productoPresentacion) {
		getProductoPresentacions().remove(productoPresentacion);
		productoPresentacion.setProducto(null);

		return productoPresentacion;
	}

}