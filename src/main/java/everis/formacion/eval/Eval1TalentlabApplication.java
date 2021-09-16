package everis.formacion.eval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import everis.formacion.eval.services.ProductoService;
import everis.formacion.eval.services.UsuarioService;

@SpringBootApplication
public class Eval1TalentlabApplication {
	public static void main(String[] args) {
		SpringApplication.run(Eval1TalentlabApplication.class, args);	
	}
}
