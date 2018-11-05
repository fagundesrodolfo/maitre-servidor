package inicio.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import inicio.classes.Produto;
import inicio.servicos.ProdutoServices;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoREST {
	
	@Autowired
	private ProdutoServices servico;
	
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<Produto>> getProdutos(@RequestHeader HttpHeaders headers){
		List<Produto> obj = servico.getProdutos(headers.get("chave").get(0));
		return ResponseEntity.ok().body(obj);
	}

}
