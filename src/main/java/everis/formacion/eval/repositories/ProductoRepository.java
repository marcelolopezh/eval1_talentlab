package everis.formacion.eval.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import everis.formacion.eval.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long>{

}
