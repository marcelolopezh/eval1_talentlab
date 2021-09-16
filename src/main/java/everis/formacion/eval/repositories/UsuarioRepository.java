package everis.formacion.eval.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import everis.formacion.eval.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

}
