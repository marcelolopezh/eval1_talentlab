package everis.formacion.eval.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import everis.formacion.eval.models.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta,Long>{

}
