package inicio.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import inicio.classes.Produto;

public class ProdutoDao implements ConfiguraGenericaDao<Produto> {
// Para Fazer qualqr acesso ao banco de dados precisa da Conexao
      
    public ProdutoDao(){
  
    }
    
   public ArrayList<Produto> ConsultaNomeProduto(Produto produto) {
        
        ArrayList<Produto> listaProdutos= new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto where nomeProduto = ?";
        
        try{        
                PreparedStatement sentenca = ConnectionFactory.getConnection().prepareStatement(sql);
                sentenca.setString(1, produto.getNomeProduto());
                System.out.println("banco.dao.ProdutoDao.ConsultaNomeProduto()"+produto.getNomeProduto());
                
                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();
                

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                    produto = new Produto();
                    produto.setIdProduto(resultadoSentenca.getInt("IdProduto"));
                    produto.setIdCategoria(resultadoSentenca.getInt("IdCategoria"));
                    produto.setNomeProduto(resultadoSentenca.getString("NomeProduto"));
                    produto.setDescProduto(resultadoSentenca.getString("DescProduto"));
                    produto.setVlProduto(resultadoSentenca.getFloat("VlProduto"));
                    System.out.println("produto do banco="+produto.getIdProduto());
                   
                    //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                    listaProdutos.add(produto);
                

                
            }
            
                sentenca.close();
                ConnectionFactory.getConnection().close();
            return listaProdutos;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Produto> ConsultaCategoria(Produto produto) {
        
        ArrayList<Produto> listaProdutos= new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto where IdCategoria = ?";
        
        try
        {

                PreparedStatement sentenca = ConnectionFactory.getConnection().prepareStatement(sql);
                sentenca.setInt(1, produto.getIdCategoria());
                System.out.println("caegoria na pesquisa="+produto.getIdCategoria());
                
                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();
                

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                    produto = new Produto();
                    produto.setIdProduto(resultadoSentenca.getInt("IdProduto"));
                    produto.setIdCategoria(resultadoSentenca.getInt("IdCategoria"));
                    produto.setNomeProduto(resultadoSentenca.getString("NomeProduto"));
                    produto.setDescProduto(resultadoSentenca.getString("DescProduto"));
                    produto.setVlProduto(resultadoSentenca.getFloat("VlProduto"));
                    System.out.println("produto do banco="+produto.getIdProduto());
                   
                    //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                    listaProdutos.add(produto);
                }

                sentenca.close();
                ConnectionFactory.getConnection().close();
            
            
            return listaProdutos;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    @Override
    public void inserir(Produto p) {
      
        Connection con = null;
        PreparedStatement sentenca = null;
        try {
            con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement("INSERT INTO Produto (IdProduto, IdCategoria, nomeProduto, descProduto, vlProduto) VALUES (?,?,?,?,?)");
           
                sentenca.setInt(1,p.getIdProduto()); 
                sentenca.setInt(2,p.getIdCategoria());
                sentenca.setString(3,p.getNomeProduto().toUpperCase().trim()); 
                sentenca.setString(4,p.getDescProduto().toUpperCase().trim());
                sentenca.setFloat(5,p.getVlProduto());
                
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença

           sentenca.executeUpdate();

        } catch (SQLException ex) {
            
            
        } finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
        
    }

        
    @Override
    public void alterar(Produto produto) {
        
        String sql = "UPDATE Produto SET IdProduto = ?, IdCategoria = ?, nomeProduto = ?, descProduto = ?, vlProduto = ? WHERE IdProduto = ?";
        Connection con = null;
        PreparedStatement sentenca = null;
        try {
            con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement(sql);
           
               sentenca.setInt(1,produto.getIdProduto()); 
                sentenca.setInt(2,produto.getIdCategoria());
                sentenca.setString(3,produto.getNomeProduto().toUpperCase().trim()); 
                sentenca.setString(4,produto.getDescProduto().toUpperCase().trim());
                sentenca.setFloat(5,produto.getVlProduto());
                sentenca.setInt(6,produto.getIdProduto()); 
                sentenca.execute();
                sentenca.close();

        } catch (SQLException ex) {
            
            
        } finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }

    }
// apagar depois nao vai ter essa opção de excluir todos os registros da tabela
    @Override
    public void excluir() {
        
       String sql = "DELETE FROM Produto";
        Connection con = null;
        PreparedStatement sentenca = null;
        try {
            con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement(sql);
           
                sentenca.execute();
                sentenca.close();

        } catch (SQLException ex) {
            
            
        } finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
        
    }
   
    @Override
    public void excluirID(int produto) {
        
         String sql = "DELETE FROM Produto where IdProduto = ?";
        Connection con = null;
        PreparedStatement sentenca = null;
        try {
            con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement(sql);
                sentenca.setInt(1, produto);
                sentenca.execute();
                sentenca.close();

        } catch (SQLException ex) {
            
            
        } finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
        
    }
    
   
    
    
    @Override
    public ArrayList<Produto> consultar() {
        
        List<Produto> listaProdutos= new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto";
        Connection con = null;
        PreparedStatement sentenca = null;
        try {
            
            con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement(sql);
            ResultSet resultadoSentenca = sentenca.executeQuery();
            
             while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                    Produto produto = new Produto();
                    produto.setIdProduto(resultadoSentenca.getInt("IdProduto"));
                    produto.setIdCategoria(resultadoSentenca.getInt("IdCategoria"));
                    produto.setNomeProduto(resultadoSentenca.getString("NomeProduto"));
                    produto.setDescProduto(resultadoSentenca.getString("DescProduto"));
                    produto.setVlProduto(resultadoSentenca.getFloat("VlProduto"));
                      //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                    listaProdutos.add(produto);
                }
      
        } catch (SQLException ex) {
            
            
        } finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
        
        return (ArrayList<Produto>) listaProdutos;
    }
    
    public void ConsultaID(Produto produto) throws SQLException {
        
        String sql = "SELECT nomeProduto, vlProduto FROM Produto where IdProduto = ?";
        Connection con = null;
        PreparedStatement sentenca = null;
        ResultSet resultadoSentenca = null;
           
        
        try{
            
            con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement(sql);
            resultadoSentenca = sentenca.executeQuery();
                
                sentenca.setInt(1,produto.getIdProduto());
                produto.setNomeProduto(resultadoSentenca.getString("nomeProduto"));
                produto.setVlProduto(resultadoSentenca.getFloat("VlProduto"));
                sentenca.execute();
                sentenca.close();
               
            }catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, sentenca, resultadoSentenca);
        }
       }
    
    public Produto consultaId(int id){
        
        String sql = "SELECT * FROM Produto where IdProduto = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nome = "";
        Produto p = null;
        
        try {
             
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                    p = new Produto();
                    p.setIdProduto(rs.getInt("IdProduto"));
                    p.setIdCategoria(rs.getInt("IdCategoria"));
                    p.setNomeProduto(rs.getString("NomeProduto"));
                    p.setDescProduto(rs.getString("DescProduto"));
                    p.setVlProduto(rs.getFloat("VlProduto"));
            }
            

        } catch (SQLException ex) {
           System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return p;

    }
    
    
        public boolean checkIdProduto(int idProduto) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean confirma = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM Produto WHERE IdProduto = ?");
            stmt.setInt(1, idProduto);
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
 
    
    public ArrayList<Produto> consultar(int idProduto){
        
        ArrayList<Produto> listaProduto= new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto where IdProduto = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sentenca = null;
        ResultSet rs = null;
        try
        {
                sentenca = con.prepareStatement(sql);
                sentenca.setInt(1, idProduto);
                //recebe o resultado da consulta
                rs = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(rs.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("IdProduto"));
                    produto.setNomeProduto(rs.getString("NomeProduto"));

                   
                    //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                    listaProduto.add(produto);
                }

                sentenca.close();         
                 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, sentenca, rs);

        }
        return listaProduto;
    }    
    
  
}
