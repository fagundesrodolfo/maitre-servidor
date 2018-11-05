package inicio.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import inicio.classes.Categoria;
import inicio.servicos.CategoriaServices;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaREST {
	
	@Autowired
	private CategoriaServices servico;
	
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<Categoria>> getCategorias(@RequestHeader HttpHeaders headers){
		List<Categoria> obj = servico.getCategorias(headers.get("chave").get(0));
		return ResponseEntity.ok().body(obj);
	}
	
	

}
