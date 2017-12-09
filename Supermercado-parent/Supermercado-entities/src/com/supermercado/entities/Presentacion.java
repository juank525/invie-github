package com.supermercado.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the presentacion database table.
 * 
 */
@Entity
@NamedQuery(name="Presentacion.findAll", query="SELECT p FROM Presentacion p")
public class Presentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_presentacion")
	private int idPresentacion;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to ProductoPresentacion
	@OneToMany(mappedBy="presentacion")
	private List<ProductoPresentacion> productoPresentacions;

	public Presentacion() {
	}

	public int getIdPresentacion() {
		return this.idPresentacion;
	}

	public void setIdPresentacion(int idPresentacion) {
		this.idPresentacion = idPresentacion;
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

	public List<ProductoPresentacion> getProductoPresentacions() {
		return this.productoPresentacions;
	}

	public void setProductoPresentacions(List<ProductoPresentacion> productoPresentacions) {
		this.productoPresentacions = productoPresentacions;
	}

	public ProductoPresentacion addProductoPresentacion(ProductoPresentacion productoPresentacion) {
		getProductoPresentacions().add(productoPresentacion);
		productoPresentacion.setPresentacion(this);

		return productoPresentacion;
	}

	public ProductoPresentacion removeProductoPresentacion(ProductoPresentacion productoPresentacion) {
		getProductoPresentacions().remove(productoPresentacion);
		productoPresentacion.setPresentacion(null);

		return productoPresentacion;
	}

}