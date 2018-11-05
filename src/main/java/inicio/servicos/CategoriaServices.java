package inicio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import inicio.Cache;
import inicio.GerenciaUsuarios;
import inicio.banco.CategoriaDao;
import inicio.classes.Categoria;

@Service
public class CategoriaServices {

private CategoriaDao dao = new CategoriaDao();

	public List<Categoria> getCategorias(String chave){
		if (GerenciaUsuarios.getGerenciaUsuarios().verificaLogin(chave)) {
			return Cache.getInstance().getCategorias();
		}
		return null;
	}
	
}
