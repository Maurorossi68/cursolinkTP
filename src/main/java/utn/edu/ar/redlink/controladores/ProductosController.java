package utn.edu.ar.redlink.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.repositorios.RepoProductoSpring;
/*
@RestController
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private RepoProductoSpring repo;
	
	@GetMapping("")
	public List<Producto> listarProductos() {
		return new ArrayList<Producto>(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public Producto obtenerUnProducto(@PathVariable("id") int idProducto) {
		return repo.findById(idProducto);
	}
	
	@Transactional
	@PostMapping("")
	public String agregarProducto(@RequestBody @Valid Producto unProducto,			
			BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			repo.save(unProducto);
			return "ok";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "no ok, con errores";
		}
	}
}
*/
