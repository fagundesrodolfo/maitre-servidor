package inicio.classes;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Integer IdPedido = -1;
	
    //@JsonFormat(pattern="YYYY-MM-DD HH:MM:SS")
    private String dtHoraPedido;
    
	
	
    private String dtHoraPedido1 = "";
    
    private Integer IdMesa = 0;
    private String IdUsuario = "";
    private Integer IdProduto = 0;
    private Integer qtProduto = 0;
    private Float vlPedido = 0.0f;

    public Pedido() {
    }




    @Override
	public String toString() {
		return "Pedido [IdPedido=" + IdPedido + ", dtHoraPedido=" + dtHoraPedido + ", dtHoraPedido1=" + dtHoraPedido1
				+ ", IdMesa=" + IdMesa + ", IdUsuario=" + IdUsuario + ", IdProduto=" + IdProduto + ", qtProduto="
				+ qtProduto + ", vlPedido=" + vlPedido + "]";
	}




	public Integer getIdPedido() {
		return IdPedido;
	}




	public void setIdPedido(Integer idPedido) {
		IdPedido = idPedido;
	}




	public String getDtHoraPedido() {
		return dtHoraPedido;
	}




	public void setDtHoraPedido(String dtHoraPedido) {
		this.dtHoraPedido = dtHoraPedido;
	}




	public String getDtHoraPedido1() {
		return dtHoraPedido1;
	}




	public void setDtHoraPedido1(String dtHoraPedido1) {
		this.dtHoraPedido1 = dtHoraPedido1;
	}




	public Integer getIdMesa() {
		return IdMesa;
	}




	public void setIdMesa(Integer idMesa) {
		IdMesa = idMesa;
	}




	public String getIdUsuario() {
		return IdUsuario;
	}




	public void setIdUsuario(String idUsuario) {
		IdUsuario = idUsuario;
	}




	public Integer getIdProduto() {
		return IdProduto;
	}




	public void setIdProduto(Integer idProduto) {
		IdProduto = idProduto;
	}




	public Integer getQtProduto() {
		return qtProduto;
	}




	public void setQtProduto(Integer qtProduto) {
		this.qtProduto = qtProduto;
	}




	public Float getVlPedido() {
		return vlPedido;
	}




	public void setVlPedido(Float vlPedido) {
		this.vlPedido = vlPedido;
	}




	
}
