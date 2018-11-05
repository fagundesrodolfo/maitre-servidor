package inicio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import inicio.Cache;
import inicio.GerenciaUsuarios;
import inicio.banco.ProdutoDao;
import inicio.classes.Produto;

@Service
public class ProdutoServices {
	
	private ProdutoDao dao = new ProdutoDao();

	
	public List<Produto> getProdutos(String chave){
		if (GerenciaUsuarios.getGerenciaUsuarios().verificaLogin(chave)) {
			return Cache.getInstance().getProdutos();
		}
		return null;
	}
	
}
