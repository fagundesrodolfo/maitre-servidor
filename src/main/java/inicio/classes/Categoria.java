package inicio.classes;

import java.io.Serializable;

public class Categoria implements Serializable{

    private int IdCategoria;
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(int IdCategoria, String nomeCategoria) {
        this.IdCategoria = IdCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    /**
     * @return the IdCategoria
     */
    public int getIdCategoria() {
        return IdCategoria;
    }

    /**
     * @param IdCategoria the IdCategoria to set
     */
    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    /**
     * @return the nomeCategoria
     */
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * @param nomeCategoria the nomeCategoria to set
     */
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

}
