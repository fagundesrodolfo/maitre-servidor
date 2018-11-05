package inicio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import inicio.Cache;
import inicio.GerenciaUsuarios;
import inicio.banco.PedidoDao;
import inicio.classes.Pedido;


@Service
public class PedidoServices {
	
	private PedidoDao dao = new PedidoDao();
	
	public List<Pedido> procuraPorMesa(int mesa, String chave) {
		if (GerenciaUsuarios.getGerenciaUsuarios().verificaLogin(chave)) {
			Cache cache = Cache.getInstance();
			return dao.consultarMesa(mesa);
		}
		return null;
	}
	
	public List<Pedido> inserePedidoPorMesa(List<Pedido> pedidos, int mesa, String chave){
		if (GerenciaUsuarios.getGerenciaUsuarios().verificaLogin(chave)) {
			for(Pedido p: pedidos) {
				p.setIdMesa(mesa);
				p.setIdUsuario(GerenciaUsuarios.getGerenciaUsuarios().getUsuario(chave));
				dao.inserir(p);
			}
			return (List<Pedido>) procuraPorMesa(mesa, chave);
		}
		return null;
	}

	public List<Pedido> cancelarPedido(List<Pedido> pedidos, int mesa, String chave){
		if (GerenciaUsuarios.getGerenciaUsuarios().verificaLogin(chave)) {
			for(Pedido p: pedidos) {
				p.setIdMesa(mesa);
				p.setIdUsuario(GerenciaUsuarios.getGerenciaUsuarios().getUsuario(chave));
				dao.inserir(p);
			}
			return procuraPorMesa(mesa, chave);
		}
		return null;
	}
	
	public List<Pedido> procuraTodos(String chave) {
		if (GerenciaUsuarios.getGerenciaUsuarios().verificaLogin(chave)) {
			return (List<Pedido>) dao.consultar();
		}
		return null;
	}
	
}
