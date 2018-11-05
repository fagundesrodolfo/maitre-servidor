package inicio.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import inicio.classes.Categoria;

public class CategoriaDao {

	 public CategoriaDao() {
	        
	    }  
	   
	    public void ConsultaNome(Categoria categoria) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {

	            stmt = con.prepareStatement("SELECT * FROM Categoria WHERE nomeCategoria = ?");
	            stmt.setString(1, categoria.getNomeCategoria());


	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                categoria.setIdCategoria(rs.getInt("IdCategoria"));

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }

	    }
	    
	    public ArrayList<Categoria> consultar() {
	        
	        Connection con = ConnectionFactory.getConnection();
	        
	        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
	        String sql = "SELECT * FROM Categoria";
	        PreparedStatement sentenca = null;
	        ResultSet rs = null;
	        
	        try{
	                sentenca = con.prepareStatement(sql);
	                
	                //recebe o resultado da consulta
	                rs = sentenca.executeQuery();

	                //percorrer cada linha do resultado
	                while(rs.next()) 
	                {
	                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
	                    Categoria categoria = new Categoria();
	                    categoria.setIdCategoria(rs.getInt("IdCategoria"));
	                    categoria.setNomeCategoria(rs.getString("NomeCategoria"));

	                   
	                    //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
	                    listaCategoria.add(categoria);
	                }

	                sentenca.close();         
	                 
	        } catch (SQLException ex) {
	            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, sentenca, rs);

	        }
	        return listaCategoria;
	    }    

	 
	 
	    public String SelecionaCategoria(int idCategoria) {
	        
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        String nomeCategoria = null;

	        try {

	            stmt = con.prepareStatement("SELECT * FROM Categoria WHERE IdCategoria = ?");
	            stmt.setInt(1, idCategoria);


	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                nomeCategoria = rs.getString("nomeCategoria");

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }
	        return nomeCategoria;

	    }
	    
	    public int SelecionaCategoria(String nomeCategoria) {
	        
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        int idCategoria = 0;

	        try {

	            stmt = con.prepareStatement("SELECT * FROM Categoria WHERE nomeCategoria = ?");
	            stmt.setString(1, nomeCategoria);


	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                idCategoria = rs.getInt("IdCategoria");

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }
	        return idCategoria;

	    }

	
}
