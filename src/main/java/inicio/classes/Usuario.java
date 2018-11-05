package inicio.classes;

import java.io.Serializable;

public class Usuario implements Serializable{ 
	private static final long serialVersionUID = 1L;
	

private String login;
private String senha;
private String senhaAnterior;
private String nome_usuario;
private Integer acesso;
private String ativo;
private String Email;
private String IpMaquina;
private String PrimeiroLogin;
private String AlterarSenha;
private String DtHoraLog;
private Integer DataMin;
private Integer HoraMin;
private Integer DataMax;
private Integer HoraMax;

public String getDtHoraLog() {
    return DtHoraLog;
}

public void setDtHoraLog(String DtHoraLog) {
    this.DtHoraLog = DtHoraLog;
}

public String getLogin() {
    return login;
}

public void setLogin(String login) {
    this.login = login;
}

public String getSenha() {
    return senha;
}

public void setSenha(String senha) {
    this.senha = senha;
}

public String getSenhaAnterior() {
    return senhaAnterior;
}

public void setSenhaAnterior(String senhaAnterior) {
    this.senhaAnterior = senhaAnterior;
}

public String getNome_usuario() {
    return nome_usuario;
}

public void setNome_usuario(String nome_usuario) {
    this.nome_usuario = nome_usuario;
}

public Integer getAcesso() {
    return acesso;
}

public void setAcesso(Integer acesso) {
    this.acesso = acesso;
}

public String getAtivo() {
    return ativo;
}

public void setAtivo(String ativo) {
    this.ativo = ativo;
}

public String getEmail() {
    return Email;
}

public void setEmail(String Email) {
    this.Email = Email;
}

public String getIpMaquina() {
    return IpMaquina;
}

public void setIpMaquina(String IpMaquina) {
    this.IpMaquina = IpMaquina;
}

public String getPrimeiroLogin() {
    return PrimeiroLogin;
}

public void setPrimeiroLogin(String PrimeiroLogin) {
    this.PrimeiroLogin = PrimeiroLogin;
}

public String getAlterarSenha() {
    return AlterarSenha;
}

public void setAlterarSenha(String AlterarSenha) {
    this.AlterarSenha = AlterarSenha;
}

public Integer getDataMin() {
    return DataMin;
}

public void setDataMin(Integer DataMin) {
    this.DataMin = DataMin;
}

public Integer getHoraMin() {
    return HoraMin;
}

public void setHoraMin(Integer HoraMin) {
    this.HoraMin = HoraMin;
}

public Integer getDataMax() {
    return DataMax;
}

public void setDataMax(Integer DataMax) {
    this.DataMax = DataMax;
}

public Integer getHoraMax() {
    return HoraMax;
}

public void setHoraMax(Integer HoraMax) {
    this.HoraMax = HoraMax;
}




}
