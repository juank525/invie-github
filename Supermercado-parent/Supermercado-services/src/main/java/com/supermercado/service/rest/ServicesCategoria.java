package com.supermercado.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermercado.entities.Categoria;
import com.supermercado.model.dao.CategoriaDao;

import java.util.List;

@RestController
@RequestMapping("/rest/servicio/categorias")
public class ServicesCategoria {

	@Autowired(required = true)
	private CategoriaDao categoriaDao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Categoria> getCategorias() {
		System.out.println("Listar todas las categorias");
		List<Categoria> listaCategorias = null;
		listaCategorias = categoriaDao.getCategorias();
		return listaCategorias;
	}

	@RequestMapping(path = "/{idCategoria}", method = RequestMethod.GET, produces = "application/json")
	public Categoria getCategoria(@PathVariable int idCategoria) {
		Categoria categoria = null;
		categoria = categoriaDao.getCategoria(idCategoria);
		return categoria;
	}

	@RequestMapping(path = "/addCategoria", method = RequestMethod.POST, produces="text/plain")
	public String addCategoria(@RequestBody Categoria nuevaCategoria) {
		String respuesta = null;
		respuesta = categoriaDao.addCategoria(nuevaCategoria);
		return respuesta;
	}
}
