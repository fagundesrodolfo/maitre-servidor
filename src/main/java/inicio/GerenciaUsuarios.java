package inicio;

import java.util.HashMap;
import java.util.Map;

import inicio.classesDTO.loginDTO;



public class GerenciaUsuarios {

	// funcionamento do login
	// o sistema ira receber email e senha verificar se existe usuario cadastrado
	// ira registrar o usuario como cadastrado e ira fornecer uma chave essa chave
	// podera ser utilizada
	// para realizar as operações REST, ela sera enviada em toda requisição rest no
	// header

	// Na requisição sera enviada uma chave de acesso

	private static GerenciaUsuarios instance;

	Map<String, loginDTO> usuariosLogados = new HashMap<String, loginDTO>();

	private GerenciaUsuarios() {

	}

	public static GerenciaUsuarios getGerenciaUsuarios() {
		if (instance == null) {
			instance = new GerenciaUsuarios();
		}
		return instance;
	}

	public loginDTO loginDeUsuarios(loginDTO user) {

		if (user == null) {
			return null;
		}

		if (user.getLogin() == null || user.getSenha() == null) {
			return null;
		}

		if (user.getLogin() == "" || user.getSenha() == "") {
			return null;
		}

		// Verifica se o usuario esta logado
		// se estiver o registro dele é excluido e criado um novo
		for (String chave : usuariosLogados.keySet()) {
			loginDTO u = usuariosLogados.get(chave);
			if (u.getLogin() == user.getLogin() && u.getSenha() == user.getSenha()) {
				usuariosLogados.remove(u);
			}
		}

		String chaveAux = geraChave(user.getLogin());
		usuariosLogados.put(chaveAux,user);
		return new loginDTO(chaveAux, user.getLogin());
	}

	public String getUsuario(String chave) {
		return usuariosLogados.get(chave).getLogin();
	}
	
	// gerar uma chave aleatoria
	private String geraChave(String email) {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		String chave = "";
		
		char[] c = email.toCharArray();
		do {
			 chave += carct[(int) (Math.random()*carct.length)];
			 chave += c[(int) (Math.random()*c.length)];
		}while(chave.length()<100);
		
		if(!usuariosLogados.containsKey(chave)) {
			return chave;
		}else {
			return geraChave(email);
		}
		
	}

	public Boolean verificaLogin(String chave) {
		return usuariosLogados.containsKey(chave);
	}
}
