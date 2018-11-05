package inicio.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import inicio.classes.Pedido;
import inicio.servicos.PedidoServices;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoREST {

	@Autowired
	private PedidoServices servico;

@RequestMapping(value = "/{mesa}", method = RequestMethod.GET)
private ResponseEntity<List<Pedido>> getPedidosMesa(@PathVariable int mesa, @RequestHeader HttpHeaders headers){
	List<Pedido> obj = servico.procuraPorMesa(mesa, headers.get("chave").get(0));
	return ResponseEntity.ok().body(obj);
}

@RequestMapping(value = "/insere/{mesa}", method = RequestMethod.POST)
private ResponseEntity<List<Pedido>> inserePedidosMesa(@RequestBody List<Pedido> pedidos, @PathVariable int mesa, @RequestHeader HttpHeaders headers){
	List<Pedido> obj = servico.inserePedidoPorMesa(pedidos, mesa, headers.get("chave").get(0));
	return ResponseEntity.ok().body(obj);
}

@RequestMapping(value = "/cancelar/{mesa}", method = RequestMethod.POST)
private ResponseEntity<List<Pedido>> cancelarPedidos(@RequestBody List<Pedido> pedidos, @PathVariable int mesa, @RequestHeader HttpHeaders headers){
	List<Pedido> obj = servico.cancelarPedido(pedidos, mesa, headers.get("chave").get(0));
	return ResponseEntity.ok().body(obj);
}

@RequestMapping(value = "/todos", method = RequestMethod.GET)
private ResponseEntity<List<Pedido>> getPedidos(@RequestHeader HttpHeaders headers){
	List<Pedido> obj = servico.procuraTodos(headers.get("chave").get(0));
	System.out.println("REtornando: " + obj.toString());
	return ResponseEntity.ok().body(obj);
}
	
}
