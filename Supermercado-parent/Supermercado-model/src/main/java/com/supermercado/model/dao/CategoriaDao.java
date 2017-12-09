package com.supermercado.model.dao;

import java.util.List;

import com.supermercado.entities.Categoria;

public interface CategoriaDao {
	public List<Categoria> getCategorias();
	public Categoria getCategoria (int idCategoria);
	public String addCategoria(Categoria nuevaCategoria);
}
