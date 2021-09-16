package everis.formacion.eval.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import everis.formacion.eval.models.Usuario;
import everis.formacion.eval.repositories.UsuarioRepository;
@Service
public class UsuarioService {
	@Autowired UsuarioRepository ur;
	public List<Usuario> listaUsuarios(){
		return (List<Usuario>) ur.findAll();
	}
	public Usuario buscarUsuarios(Long id) {
		Optional<Usuario> u = ur.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
	}
	public Usuario crearUsuario(Usuario u) {
		return ur.save(u);
	}
	public void eliminarUsuario(Long id) {
		ur.deleteById(id);
	}
}
