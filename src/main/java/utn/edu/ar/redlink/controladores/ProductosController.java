package utn.edu.ar.redlink.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utn.edu.ar.redlink.dominio.productos.Producto;
import utn.edu.ar.redlink.repositorios.RepoProductoSpring;
/*
@RestController
public class ProductosController {
	
	@Autowired
	private RepoProductoSpring repo;
	
	@GetMapping(path="/productos",params = {"page"})
	public Page<Producto> findPaginated(@RequestParam(value="page", required=true) Integer page, 
	  @RequestParam(value="size", required=false) Integer size,
	  @RequestParam(value="sort", required=false) String sort) {
		Pageable pageRequest;
		if(size == null) { size=1;}
		if(sort == null ) {
			 pageRequest = PageRequest.of(page, size, Sort.unsorted());
		}else{
			 pageRequest = PageRequest.of(page, size, Sort.by(sort));
		}
		
		return repo.findAll(pageRequest);
	}
	
	@GetMapping("/productos")
	public List<Producto> findAll(){
		return repo.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto obtenerUnProducto(@PathVariable("id") int idProducto) {
		return repo.findById(idProducto);
	}

	@PostMapping("/productos")
	public Producto agregarProducto(@RequestBody @Valid Producto unProducto,			
			BindingResult bindingResult) {
		if(unProducto.getMiProveedor() != null) {
			unProducto.getMiProveedor().addMisProductos(unProducto);
		}
		if(unProducto.getMiVendedor() != null) {
			unProducto.getMiVendedor().addProdAlaVenta(unProducto);
		}
		repo.save(unProducto);
		return  unProducto;
	}
}
*/
