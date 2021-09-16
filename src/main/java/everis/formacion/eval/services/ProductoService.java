package everis.formacion.eval.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import everis.formacion.eval.models.Producto;
import everis.formacion.eval.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository pr;

	public List<Producto> listaProductos() {
		return (List<Producto>) pr.findAll();
	}

	public Producto buscarProducto(Long id) {
		Optional<Producto> p = pr.findById(id);
		if (p.isPresent()) {
			return p.get();
		}
		return null;
	}

	public Producto crearProducto(Producto p) {
		return pr.save(p);
	}

	public void eliminarProducto(Long id) {
		pr.deleteById(id);
	}

}
