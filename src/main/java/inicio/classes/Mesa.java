package inicio.classes;

import java.io.Serializable;

public class Mesa implements Serializable{
	private static final long serialVersionUID = 1L;
	
  
	private Integer IdMesa;
    private String Emuso;
    private float ValorTotal;

    public Mesa(Integer IdMesa, String Emuso, float ValorTotal) {
        this.IdMesa = IdMesa;
        this.Emuso = Emuso;
        this.ValorTotal = ValorTotal;
    }

    public Mesa() {
    }
    
    public Mesa(Integer idMesa) {
        this.IdMesa = IdMesa;
        Emuso = "S";
        
    
    }
    
    
    /**
     * @return the IdMesa
     */
    public Integer getIdMesa() {
        return IdMesa;
    }

    /**
     * @param IdMesa the IdMesa to set
     */
    public void setIdMesa(Integer IdMesa) {
        this.IdMesa = IdMesa;
    }


    /**
     * @return the Emuso
     */
    public String getEmuso() {
        return Emuso;
    }

    /**
     * @param Emuso the Emuso to set
     */
    public void setEmuso(String Emuso) {
        this.Emuso = Emuso;
    }

    /**
     * @return the ValorTotal
     */
    public float getValorTotal() {
        return ValorTotal;
    }

    /**
     * @param ValorTotal the ValorTotal to set
     */
    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

	
}
