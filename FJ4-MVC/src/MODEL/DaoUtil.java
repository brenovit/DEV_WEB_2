package MODEL;

import Recursos.InOut;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author solaris
 */
abstract public class DaoUtil {

    //usando conceito parecido com o singleton
    //singleton é um conceito de criacao, pode ser aplicado tanto a classe quando atributos da mesma
    private Connection con = null;  //controle da conexao

    public Connection getConnection() {
        if (con == null) {
            // TODO Conectar no banco
            //String URL = "jdbc:sqlite:G:\\Private\\Estudo\\Unijorge\\DEV-WEB\\Banco\\aula.db";	//URL where the database is
            String URL = "jdbc:sqlite:C:\\Banco\\aula.db";
            String user = "";								//main user
            String pass = "";								//main user password
            String driver = "org.sqlite.JDBC";			//database controller
            try {
                Class.forName(driver);											//Registering the controller
                con = DriverManager.getConnection(URL, user, pass);	//Establishing connection whith the database
                return con;
            } catch (Exception e) {
                InOut.OutMessage("Erro: \n" + e.getMessage(), "ERROR - CONNECT", 0);
                return null;
            }
        }
        return con;
    }

    public void Disconnect() {
        try {
            if(con != null){
                con.close();
                con = null;
            }            
        } catch (Exception e) {
            InOut.OutMessage("Erro: \n" + e.getMessage(), "ERROR - DISCONNECT", 0);
        }
    }
    
    public PreparedStatement getPreparedStatement(String sql){
        try {
            return this.getConnection().prepareStatement(sql);
        } catch (Exception e) {
            InOut.OutMessage("Erro: \n" + e.getMessage(), "ERROR - QUERY", 0);
            return null;
        }
    }
    
    public  Statement getStatement(){
        try {
            return this.getConnection().createStatement();
        } catch (Exception e) {
            InOut.OutMessage("Erro: \n" + e.getMessage(), "ERROR - QUERY", 0);
            return null;
        }
    }

}
