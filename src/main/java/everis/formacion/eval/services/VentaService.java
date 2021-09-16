package everis.formacion.eval.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import everis.formacion.eval.models.Venta;
import everis.formacion.eval.repositories.VentaRepository;
@Service
public class VentaService {
	@Autowired VentaRepository vr;
	public List<Venta> listaVentas(){
		return (List<Venta>) vr.findAll();
	}
	public Venta buscarVentas(Long id) {
		Optional<Venta> v = vr.findById(id);
		if(v.isPresent()) {
			return v.get();
		}
		return null;
	}
	public Venta crearVenta(Venta v) {
		return vr.save(v);
	}
	public void eliminarVenta(Long id) {
		vr.deleteById(id);
	}
}
