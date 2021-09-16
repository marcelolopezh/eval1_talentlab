package everis.formacion.eval.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import everis.formacion.eval.models.Producto;
import everis.formacion.eval.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ProductoService productoService;

	@RequestMapping("")
	public String index(Model model, @ModelAttribute("producto") Producto producto) {
		List<Producto> productos = productoService.listaProductos();
		model.addAttribute("productos", productos);
		return "producto.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto producto, Model model) {
		if (producto.getNombre().isBlank() || producto.getDescripcion().isBlank() || producto.getPrecio()==null
				|| producto.getCategoria().isBlank()) {
			model.addAttribute("error", "Algunos campos están vacíos o erróneos");
			List<Producto> productos = productoService.listaProductos();
			model.addAttribute("productos", productos);
			return "producto.jsp";
		} else {
			productoService.crearProducto(producto);
			return "redirect:/producto";
		}
	}
	
	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		Producto producto = productoService.buscarProducto(id);
		model.addAttribute("producto", producto);
		return "editar_producto.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("producto") Producto producto, RedirectAttributes redirectAttrs) {
		if(producto.getNombre().isBlank() || producto.getDescripcion().isBlank() || producto.getPrecio()==null
				|| producto.getCategoria().isBlank()) {	
			redirectAttrs.addFlashAttribute("error", "Algunos campos están vacíos o erróneos");
			return "redirect:/producto/actualizar/"+producto.getId();
		}
		else {
			productoService.crearProducto(producto); //va a service
			return "redirect:/producto";
		}
	}
	

	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
		productoService.eliminarProducto(id); 
		return "redirect:/producto";
	}
}
