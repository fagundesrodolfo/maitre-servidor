package inicio.classes;

import java.io.Serializable;

public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer IdProduto;  
    private Integer IdCategoria;
    private String nomeProduto;
    private String descProduto;
    private float vlProduto;
    private Integer valida;

    public Produto() {
    }

    public Produto(Integer IdProduto, Integer IdCategoria, String nomeProduto, String descProduto, float vlProduto, Integer valida) {
        this.IdProduto = IdProduto;
        this.IdCategoria = IdCategoria;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.vlProduto = vlProduto;
        this.valida = valida;
    }
    
    

    /**
     * @return the IdProduto
     */
    public Integer getIdProduto() {
        return IdProduto;
    }

    /**
     * @param IdProduto the IdProduto to set
     */
    public void setIdProduto(Integer IdProduto) {
        this.IdProduto = IdProduto;
    }

    /**
     * @return the IdCategoria
     */
    public Integer getIdCategoria() {
        return IdCategoria;
    }

    /**
     * @param IdCategoria the IdCategoria to set
     */
    public void setIdCategoria(Integer IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the descProduto
     */
    public String getDescProduto() {
        return descProduto;
    }

    /**
     * @param descProduto the descProduto to set
     */
    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    /**
     * @return the vlProduto
     */
    public float getVlProduto() {
        return vlProduto;
    }

    /**
     * @param vlProduto the vlProduto to set
     */
    public void setVlProduto(float vlProduto) {
        this.vlProduto = vlProduto;
    }

    /**
     * @return the valida
     */
    public Integer getValida() {
        return valida;
    }

    /**
     * @param valida the valida to set
     */
    public void setValida(Integer valida) {
        this.valida = valida;
    }
	
}
