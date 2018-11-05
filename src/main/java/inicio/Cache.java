package inicio;

import java.util.List;

import inicio.banco.CategoriaDao;
import inicio.banco.ProdutoDao;
import inicio.classes.Categoria;
import inicio.classes.Produto;


public class Cache {
private static Cache instance;
	
	private List<Produto> produtos;
	
	private List<Categoria> categorias;
	
	private Cache() {
				
	}

	public static Cache getInstance() {
		if(instance == null) {
			instance = new Cache();
		}
		return instance;
	}

	public static void setInstance(Cache instance) {
		Cache.instance = instance;
	}


	public List<Produto> getProdutos() {
		if(produtos == null || produtos.isEmpty()) {
			produtos = new ProdutoDao().consultar();
		}
		return produtos;
	}
	
	public Produto getProduto(int id) {
		for(Produto p: produtos) {
			if(p.getIdProduto() == id) {
				return p;
			}
		}
		return null;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Categoria> getCategorias() {
		if(categorias == null || categorias.isEmpty()) {
			categorias = new CategoriaDao().consultar();
		}
		return categorias;
	}
	
	public Categoria getCategoria(int id) {
		for(Categoria c: categorias) {
			if(c.getIdCategoria() == id) {
				return c;
			}
		}
		return null;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
