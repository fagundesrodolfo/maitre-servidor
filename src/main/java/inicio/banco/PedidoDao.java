package inicio.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import inicio.classes.Pedido;

public class PedidoDao implements ConfiguraGenericaDao<Pedido>{

 

    public PedidoDao() {
        
    }


    @Override
    public void inserir(Pedido pedido) {
        
        String sql = "INSERT INTO Pedido (IdMesa, IdUsuario, IdProduto, qtProduto, vlPedido, dtHoraPedido) VALUES (?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement sentenca = null;
        try {
            con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement(sql);
           
                sentenca.setInt(1, pedido.getIdMesa());
                sentenca.setString(2, pedido.getIdUsuario());
                sentenca.setInt(3, pedido.getIdProduto());
                sentenca.setInt(4, pedido.getQtProduto());
                sentenca.setFloat(5, pedido.getVlPedido());
                /*SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
                Date parsed = null;
				try {
					parsed = format.parse(pedido.getDtHoraPedido());
				} catch (ParseException e) {
					e.printStackTrace();
				}
                //java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());*/
                System.out.println("Tentando salvar: "+ pedido.getDtHoraPedido());
				sentenca.setString(6,pedido.getDtHoraPedido());
				
                
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença

          // sentenca.executeUpdate();

        } catch (SQLException ex) {
        	   System.out.println("Erro ao salvar: " + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
        
    }
    
    public void deleteIdMesa(int mesa) {
        String sql = "delete from Pedido where idMesa = " + mesa + ";";
        Connection con = null;
        PreparedStatement sentenca = null;
        
            try {
                
                con = ConnectionFactory.getConnection();
                sentenca = con.prepareStatement(sql);
          
                sentenca.execute();
                sentenca.close();
        
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
    }
    
    public void excluirID(int pedido) {
        String sql = "DELETE FROM Pedido where IdPedido= ?";
        Connection con = null;
        PreparedStatement sentenca = null;
        
            try {
                
                con = ConnectionFactory.getConnection();
                sentenca = con.prepareStatement(sql);
                
                 sentenca.setInt(1, pedido);
            
                sentenca.execute();
                sentenca.close();
                
                
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }

    }
    @Override
        public void alterar(Pedido pedido) {
        String sql ="UPDATE Pedido SET qtProduto = ?, vlPedido = ? WHERE IdPedido = ?"; 
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement sentenca = null;
        
            try {
                
                con = ConnectionFactory.getConnection();
                sentenca = con.prepareStatement(sql);
                
                    sentenca.setInt(1,pedido.getQtProduto());
                    sentenca.setFloat(2,pedido.getVlPedido());
                    sentenca.setInt(3,pedido.getIdPedido());
            
                sentenca.execute();
                sentenca.close();
                
                
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
    }



    
    public void excluir(Pedido p) {
        
        String sql = "DELETE FROM Pedido WHERE idPedido = ?"; 
        Connection con = null;
        PreparedStatement sentenca = null;
       try {
                       con = ConnectionFactory.getConnection();
            sentenca = con.prepareStatement(sql);
            sentenca.setInt(1, p.getIdPedido());

            sentenca.executeUpdate();

        } catch (SQLException ex) {
           
        } finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
    }

    @Override
    public ArrayList<Pedido> consultar() {
        
    	
        ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
        String sql = "SELECT * FROM Pedido";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sentenca = null;
        
        try
        {
                sentenca = con.prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                    Pedido obj = new Pedido();
                    obj.setIdPedido(resultadoSentenca.getInt("IdPedido"));
                    obj.setIdMesa(resultadoSentenca.getInt("IdMesa"));
                    obj.setIdUsuario(resultadoSentenca.getString("IdUsuario"));
                    obj.setIdProduto(resultadoSentenca.getInt("IdProduto"));
                    obj.setQtProduto(resultadoSentenca.getInt("qtProduto"));
                    obj.setVlPedido(resultadoSentenca.getFloat("vlPedido"));
                    obj.setDtHoraPedido(String.valueOf(resultadoSentenca.getString("dtHoraPedido")));
                    obj.setDtHoraPedido1(" ");
                    
                    
                   
                    //adiciona cada tupla na listaUsuarios que será retornada para a janela Usuario
                   listaPedidos.add(obj);
                   
            }
        
                sentenca.close();
        }
        catch(SQLException ex)
        {
      
        }finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
         return listaPedidos;
    }
    
    public ArrayList<Pedido> consultarMesa(int idMesa) {
        
        ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        String sql = "SELECT * FROM Pedido where IdMesa = " + idMesa;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sentenca = null;
        
        try
        {
       
            
                sentenca = con.prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela de Usuarios
                    Pedido obj = new Pedido();
                    obj.setIdPedido(resultadoSentenca.getInt("IdPedido"));
                    obj.setIdMesa(resultadoSentenca.getInt("IdMesa"));
                    obj.setIdUsuario(resultadoSentenca.getString("IdUsuario"));
                    obj.setIdProduto(resultadoSentenca.getInt("IdProduto"));
                    obj.setQtProduto(resultadoSentenca.getInt("qtProduto"));
                    obj.setVlPedido(resultadoSentenca.getFloat("vlPedido"));
                    obj.setDtHoraPedido(String.valueOf(resultadoSentenca.getDate("dtHoraPedido")));
                    obj.setDtHoraPedido1(resultadoSentenca.getString("dtHoraPedido"));
                    
                    
                    listaPedidos.add(obj);
            }
                sentenca.close();
            
           
        }
        catch(SQLException ex)
        {
         
        }finally {
            ConnectionFactory.closeConnection(con, sentenca);
        }
         return listaPedidos;
    }
    
     public String consultaHora(int IdMesa) {

        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT Max(dtHoraPedido) FROM Pedido where IdMesa = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String hora = "";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, IdMesa);

            rs = stmt.executeQuery();

            if (rs.next()) {

                hora = rs.getString("Max(dtHoraPedido)");

            }

        } catch (SQLException ex) {
            System.out.print(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return hora;

    }
     
      public String consultaNumeroPedidos(int IdMesa) {

        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT count(*) FROM Pedido where IdMesa = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String num = "";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, IdMesa);

            rs = stmt.executeQuery();

            if (rs.next()) {

                num = rs.getString("count(*)");

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return num;

    }

    @Override
    public void excluir() {
       
    }
    
    public float consultaValor(int idmesa) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "SELECT sum(vlPedido) FROM Pedido where idMesa = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        float num = 0;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idmesa);

            rs = stmt.executeQuery();

            if (rs.next()) {

                num = rs.getFloat("sum(vlPedido)");

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return num;

    }
    
     public float consultaValor() {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "SELECT sum(vlPedido) FROM Pedido";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        float num = 0;

        try {

            stmt = con.prepareStatement(sql);
            

            rs = stmt.executeQuery();

            if (rs.next()) {

                num = rs.getFloat("sum(vlPedido)");

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return num;

    }
     public String primeiroPedidoDtHora(int idMesa) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM Pedido where IdMesa = ? ORDER BY dtHoraPedido ASC LIMIT 1";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String dataHora = null;

        try {

         stmt = con.prepareStatement(sql);
            stmt.setInt(1, idMesa);

            rs = stmt.executeQuery();

            if (rs.next()) {

                dataHora = rs.getString("dtHoraPedido");

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dataHora;

    }
}
