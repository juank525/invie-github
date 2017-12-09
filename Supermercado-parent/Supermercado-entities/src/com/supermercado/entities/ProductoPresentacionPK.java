package com.supermercado.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the producto_presentacion database table.
 * 
 */
@Embeddable
public class ProductoPresentacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_producto", insertable=false, updatable=false)
	private String idProducto;

	@Column(name="id_presentacion", insertable=false, updatable=false)
	private int idPresentacion;

	public ProductoPresentacionPK() {
	}
	public String getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdPresentacion() {
		return this.idPresentacion;
	}
	public void setIdPresentacion(int idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductoPresentacionPK)) {
			return false;
		}
		ProductoPresentacionPK castOther = (ProductoPresentacionPK)other;
		return 
			this.idProducto.equals(castOther.idProducto)
			&& (this.idPresentacion == castOther.idPresentacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProducto.hashCode();
		hash = hash * prime + this.idPresentacion;
		
		return hash;
	}
}