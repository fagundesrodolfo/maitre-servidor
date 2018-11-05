package inicio.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import inicio.classesDTO.loginDTO;
import inicio.servicos.UsuarioServices;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioREST {

	@Autowired
	private UsuarioServices servico;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<loginDTO> login(@RequestBody loginDTO user) {
		loginDTO obj = servico.login(user);
		return ResponseEntity.ok().body(obj);
	}
	
}
