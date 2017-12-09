package com.supermercado.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supermercado.entities.Categoria;
import com.supermercado.model.dao.CategoriaDao;
import com.supermercado.model.repository.CategoriaRepository;

@Repository("categoriaDao")
public class CategoriaImpl implements CategoriaDao {

	@Autowired(required = true)
	private CategoriaRepository categoriaRepository;

	public List<Categoria> getCategorias() {
		List<Categoria> listaCategoria = null;
		System.out.println("Inicio metodo del model getCategorias");
		listaCategoria = (List<Categoria>) categoriaRepository.findAll();
		System.out.println("Cantidad Categorias" + listaCategoria.size());
		return listaCategoria;
	}

	public Categoria getCategoria(int idCategoria) {
		Long id = (long) idCategoria;
		System.out.println("ID CATEGORIA: " + id);
		Categoria categoria = categoriaRepository.findByIdCategoria(idCategoria);
		return categoria;
	}

	@Override
	public String addCategoria(Categoria nuevaCategoria) {
		String respuesta = null;
		try {
			categoriaRepository.save(nuevaCategoria);
			respuesta = "OK";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			respuesta = "NOK";
		}

		return respuesta;
	}

}
