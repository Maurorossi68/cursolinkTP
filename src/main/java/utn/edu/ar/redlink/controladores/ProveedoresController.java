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

import utn.edu.ar.redlink.dominio.productos.Proveedor;
import utn.edu.ar.redlink.repositorios.RepoProvSpring;
/*
@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
	
	@Autowired
	private RepoProvSpring repo;
	
	@GetMapping("")
	public List<Proveedor> listarProductos() {
		return new ArrayList<Proveedor>(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public Proveedor obtenerUnProv(@PathVariable("id") int idProv) {
		return repo.findById(idProv);
	}
	
	@Transactional
	@PostMapping("")
	public String agregarProv(@RequestBody @Valid Proveedor unProv,			
			BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			repo.save(unProv);
			return "ok";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "error";
		}
	}
}
*/