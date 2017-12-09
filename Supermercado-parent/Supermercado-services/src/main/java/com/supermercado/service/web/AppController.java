package com.supermercado.service.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	@RequestMapping(value = "/categorias", method = RequestMethod.GET, produces = "text/html")
	String categorias() {
		return "categorias";
	}
}
