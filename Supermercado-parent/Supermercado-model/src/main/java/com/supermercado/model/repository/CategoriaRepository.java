package com.supermercado.model.repository;

import org.springframework.data.repository.CrudRepository;
import com.supermercado.entities.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	public Categoria findByIdCategoria(int idCategoria);
}
