package utn.edu.ar.redlink.dominio.promociones;

import utn.edu.ar.redlink.dominio.productos.Producto;

public interface Promocion {
	
	public double aplicarPromocion(Producto productos);
	
}
