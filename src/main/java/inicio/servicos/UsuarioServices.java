package inicio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.GerenciaUsuarios;
import inicio.banco.UsuarioDao;
import inicio.classes.Hash;
import inicio.classesDTO.loginDTO;

@Service
public class UsuarioServices {
	
	private UsuarioDao dao = new UsuarioDao();
	
	public loginDTO login(loginDTO user) {

		String SenhaHash = new Hash().get_SHA_512_SecurePassword(user.getSenha());
        user.setSenha(SenhaHash);

		int acesso = dao.checkAcesso(user.getLogin(), user.getSenha());
		if(acesso != 0) {
			return GerenciaUsuarios.getGerenciaUsuarios().loginDeUsuarios(user);
		}
		
		return null;
	}

}
