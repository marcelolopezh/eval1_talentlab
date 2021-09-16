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

import everis.formacion.eval.models.Usuario;
import everis.formacion.eval.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("")
	public String index(Model model, @ModelAttribute("usuario") Usuario usuario) {
		//crearUsuarios();
		List<Usuario> usuarios = usuarioService.listaUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "usuario.jsp";
	}

	/*private void crearUsuarios() {
		Usuario usuario1 = new Usuario(Long.parseLong("1"),"Marcelo","Lopez",25,"Mi Casa #123","+56912345432");
		Usuario usuario2 = new Usuario(Long.parseLong("2"),"Diego","Lopez",25,"Mi Casa #435","+56912315432");
		Usuario usuario3 = new Usuario(Long.parseLong("3"),"Nicolás","Lopez",25,"Mi Casa #167","+5691265432");
		usuarioService.crearUsuario(usuario1);
		usuarioService.crearUsuario(usuario2);
		usuarioService.crearUsuario(usuario3);
	}*/

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		if (usuario.getNombre().isBlank() || usuario.getApellido().isBlank() || usuario.getDireccion().isBlank()
				|| usuario.getTelefono().isBlank()) {
			model.addAttribute("error", "Algunos campos están vacíos");
			List<Usuario> usuarios = usuarioService.listaUsuarios();
			model.addAttribute("usuarios", usuarios);
			return "usuario.jsp";
		} else {
			usuarioService.crearUsuario(usuario);
			return "redirect:/usuario";
		}
	}
	
	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		Usuario usuario = usuarioService.buscarUsuarios(id);
		model.addAttribute("usuario", usuario);
		return "editar_usuario.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttrs) {
		if(usuario.getNombre().isBlank() || usuario.getApellido().isBlank() || usuario.getDireccion().isBlank()
				|| usuario.getTelefono().isBlank()) {	
			redirectAttrs.addFlashAttribute("error", "Algunos campos están vacíos");
			return "redirect:/usuario/actualizar/"+usuario.getId();
		}
		else {
			usuarioService.crearUsuario(usuario); //va a service
			return "redirect:/usuario";
		}
	}
	

	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
		usuarioService.eliminarUsuario(id); 
		return "redirect:/usuario";
	}
}
