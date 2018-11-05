package inicio.banco;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import inicio.classes.Usuario;

public class UsuarioDao {

	public UsuarioDao() {

    }

    public void inserir(Usuario usuario) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO Usuario (login, senha, nome_Usuario,email, acesso, ativo) VALUES (?,?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String ativo = "N";
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            //prepara a sentença com a consulta da string
            stmt = con.prepareStatement(sql);

            //subtitui as interrograções da consulta, pelo valor específico
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNome_usuario());
            stmt.setString(4, usuario.getEmail());
            stmt.setInt(5, usuario.getAcesso());
            stmt.setString(6, ativo);

            stmt.execute(); //executa o comando no banco
            stmt.close(); //fecha a sentença

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void inserirAlterarSenha(Usuario usuario) {

        String sql = "INSERT INTO AlterarSenha (login, senha, PrimeiroLog, AlterarSenha, dtMin, hrMin, dtMax, hrMax) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            //prepara a sentença com a consulta da string
            stmt = con.prepareStatement(sql);

            //subtitui as interrograções da consulta, pelo valor específico
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getPrimeiroLogin());
            stmt.setString(4, usuario.getAlterarSenha());
            stmt.setInt(5, usuario.getDataMin());
            stmt.setInt(6, usuario.getHoraMin());
            stmt.setInt(7, usuario.getDataMax());
            stmt.setInt(8, usuario.getHoraMax());

            stmt.execute(); //executa o comando no banco
            stmt.close(); //fecha a sentença

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void LogUsuario(Usuario usuario) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO Log (login, nome_Usuario, acesso, IpMaquina) VALUES (?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF

            //prepara a sentença com a consulta da string
            stmt = con.prepareStatement(sql);

            //subtitui as interrograções da consulta, pelo valor específico
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getNome_usuario());
            stmt.setInt(3, usuario.getAcesso());
            stmt.setString(4, usuario.getIpMaquina());

            stmt.execute(); //executa o comando no banco
            stmt.close(); //fecha a sentença

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void alterar(Usuario usuario) {
        String sql = "UPDATE Usuario SET login = ?, nome_Usuario = ?,email =?, acesso = ? WHERE login = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getNome_usuario());
            stmt.setString(3, usuario.getEmail());
            stmt.setInt(4, usuario.getAcesso());
            stmt.setString(5, usuario.getLogin());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void alterarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET login = ?, senha = ? WHERE login = ? and senha = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenhaAnterior());

            System.out.println("login banco:" + usuario.getLogin());
            System.out.println("senha nova banco:" + usuario.getSenha());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void alterarSituação(Usuario usuario) {
        String sql = "UPDATE Usuario SET login = ? ,ativo = ? WHERE login = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getAtivo());
            stmt.setString(3, usuario.getLogin());

            System.out.println("login" + usuario.getLogin());
            System.out.println("ativo)" + usuario.getAtivo());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }
    //apagar depois nao vai ter essa opção de excluir todos os registros da tabela

    public void ExcluirId(String login) {
        String sql = "DELETE FROM Usuario where login = ?";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void DeletarAlterarSenha(Usuario usuario) {
        String sql = "DELETE FROM AlterarSenha where login = ?";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public int checkAcesso(String loginEnt, String senhaEnt) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int acesso = 0;

        try {

            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE login = ? and senha = ?");
            stmt.setString(1, loginEnt);
            stmt.setString(2, senhaEnt);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String online = rs.getString("ativo");
                acesso = rs.getInt("acesso");

                System.out.println("achouu");
                if ("N".equals(online) && acesso != 2) {

                    Usuario usuario = new Usuario();
                    usuario.setLogin(rs.getString("login"));
                    usuario.setNome_usuario(rs.getString("nome_Usuario"));
                    usuario.setAcesso(rs.getInt("acesso"));
                    usuario.setIpMaquina(InetAddress.getLocalHost().getHostAddress());
                    // ativar
                    //online = "S";
                    online = "N";
                    usuario.setAtivo(online);
                    LogUsuario(usuario);
                    alterarSituação(usuario);

                } else {

                    if (acesso != 2) {
                        acesso = 9;
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return acesso;

    }

    public int checkAcesso(String loginEnt) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int acesso = 0;

        try {

            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE login = ? ");
            stmt.setString(1, loginEnt);

            rs = stmt.executeQuery();

            if (rs.next()) {

                acesso = rs.getInt("acesso");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return acesso;

    }

    // Para validar o login na alteração de Senha
    public boolean ValidarLogin(Usuario usuario) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean acesso = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM AlterarSenha WHERE login = ? and senha = ?");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenhaAnterior());

            rs = stmt.executeQuery();

            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Acho login:" + usuario.getLogin());
                acesso = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return acesso;

    }

    public boolean checkLogin(String loginEnt) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean confirma = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE login = ? ");
            stmt.setString(1, loginEnt);

            rs = stmt.executeQuery();

            if (rs.next()) {
                confirma = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return confirma;

    }

    public void ConsultaAlterarSenha(Usuario usuario) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM AlterarSenha WHERE login = ? and senha = ?");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario.setPrimeiroLogin(rs.getString("PrimeiroLog"));
                usuario.setAlterarSenha(rs.getString("AlterarSenha"));
                usuario.setDataMin(rs.getInt("dtMin"));
                usuario.setHoraMin(Integer.parseInt(rs.getString("hrMin")));
                usuario.setDataMax(rs.getInt("dtMax"));
                usuario.setHoraMax(Integer.parseInt(rs.getString("hrMax")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public ArrayList<Usuario> consultar() {

        ArrayList<Usuario> listaProdutos = new ArrayList<Usuario>();
        String sql = "SELECT * FROM Usuario";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);

            //recebe o resultado da consulta
            rs = stmt.executeQuery();

            //percorrer cada linha do resultado
            while (rs.next()) {
                //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setNome_usuario(rs.getString("nome_Usuario"));
                usuario.setAcesso(rs.getInt("acesso"));
                usuario.setEmail(rs.getString("email"));
                usuario.setAtivo(rs.getString("ativo"));

                //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                listaProdutos.add(usuario);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaProdutos;

    }

    public void ConsultarUsuario(Usuario usuario) {

        String sql = "SELECT * FROM Usuario where login = ?";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            //recebe o resultado da consulta
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario.setLogin(rs.getString("login"));
                usuario.setNome_usuario(rs.getString("nome_Usuario"));
                usuario.setAcesso(rs.getInt("acesso"));
                usuario.setEmail(rs.getString("email"));
                // pegar a senha anterior para a mudança de senha caso nao seja pela primeira vez
                // porque a senha fica como a anterior ate q a nova senha seja inserida
                usuario.setSenhaAnterior(rs.getString("senha"));
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
            public ArrayList<Usuario> consultarLogTempo(Usuario usuario,String DataInicio, String DataFim) {

        ArrayList<Usuario> listaLog = new ArrayList<Usuario>();
        String sql = "SELECT * FROM Log Where dtHoraLog >= ? and dtHoraLog <= ? ";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, DataInicio);
            stmt.setString(2, DataFim);

            //recebe o resultado da consulta
            rs = stmt.executeQuery();

            //percorrer cada linha do resultado
            while (rs.next()) {
                //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                usuario = new Usuario();

                usuario.setLogin(rs.getString("Login"));
                usuario.setNome_usuario(rs.getString("nome_Usuario"));
                usuario.setAcesso(rs.getInt("acesso"));
                usuario.setIpMaquina(rs.getString("IpMaquina"));
                usuario.setDtHoraLog(rs.getString("dtHoraLog"));


                //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                listaLog.add(usuario);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaLog;

    }
             
    public ArrayList<Usuario> consultarLog(Usuario usuario) {

        ArrayList<Usuario> listaLog = new ArrayList<Usuario>();
        String sql = "SELECT * FROM Log";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);

            //recebe o resultado da consulta
            rs = stmt.executeQuery();

            //percorrer cada linha do resultado
            while (rs.next()) {
                //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                usuario = new Usuario();

                usuario.setLogin(rs.getString("Login"));
                usuario.setNome_usuario(rs.getString("nome_Usuario"));
                usuario.setAcesso(rs.getInt("acesso"));
                usuario.setIpMaquina(rs.getString("IpMaquina"));
                usuario.setDtHoraLog(rs.getString("dtHoraLog"));


                //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                listaLog.add(usuario);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaLog;

    }

        // Recuperar o ultimo login acessado pela maquina
    public String RecuperaLogin() throws SQLException, UnknownHostException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String login = null;

    
//usuario.setIpMaquina(InetAddress.getLocalHost().getHostAddress());
            stmt = con.prepareStatement("SELECT * FROM Log where IpMaquina = ? ORDER BY dtHoraLog DESC LIMIT 1");
           
                stmt.setString(1, InetAddress.getLocalHost().getHostAddress());
    

            rs = stmt.executeQuery();

            if (rs.next()) {
                
                login = rs.getString("Login");
                String dtHoraLog =rs.getString("dtHoraLog");
                System.out.println("banco.dao.UsuarioDao.RecuperaLogin() - Data Hora: " +dtHoraLog);
                System.out.println("banco.dao.UsuarioDao.RecuperaLogin() - Login: " +login);
            }

        return login;

    }
}
