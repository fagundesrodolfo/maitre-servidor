package inicio.banco;

import java.util.ArrayList;

public interface ConfiguraGenericaDao <ObjetoGenerico> {
    
//Método que deverá implementar o código para inserir dados em um tabela   
    
    public void inserir(ObjetoGenerico objt);
    
    public void alterar(ObjetoGenerico objt);
    
    public void excluir();
    
    public void excluirID(int objt);
    
    public ArrayList<ObjetoGenerico> consultar();
    
    
}
