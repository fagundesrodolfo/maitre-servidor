package inicio.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
		private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String SERVIDOR = "localhost:3306/maitre";	             
	    private static final String URL = "jdbc:mysql://"+SERVIDOR;
	    private static final String USER = "root";
	    private static final String PASS = "1234";
	    
	//BD_URL = "jdbc:mysql://localhost:port/bd_name?useTimezone=true&serverTimezone=UTC"
	
	   /* private static final String DRIVER = "com.mysql.jdbc.Driver";
	    private static final String SERVIDOR = "tcc-maitre-rant.mysql.uhserver.com/"
	                + "tcc_maitre_rant?useTimezone=true&serverTimezone=UTC";
	    private static final String URL = "jdbc:mysql://"+SERVIDOR;
//	    private static final String URL = "jdbc:mysql://127.0.0.1/tabelas_restaurante?useTimezone=true&serverTimezone=UTC";
	    private static final String USER = "tcc_maitre_rant";
	    private static final String PASS = "Tcc-2018";
	    */
	    /**/
	    
	    public static Connection getConnection() {
	        try {
	            Class.forName(DRIVER);
	            return DriverManager.getConnection(URL, USER, PASS);
	        } catch (ClassNotFoundException | SQLException ex) {
	            throw new RuntimeException("Erro na conexão: ", ex);
	        }
	    }

	    public static void closeConnection(Connection con) {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public static void closeConnection(Connection con, PreparedStatement stmt) {

	        closeConnection(con);

	        try {

	            if (stmt != null) {
	                stmt.close();
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

	        closeConnection(con, stmt);

	        try {

	            if (rs != null) {
	                rs.close();
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
}