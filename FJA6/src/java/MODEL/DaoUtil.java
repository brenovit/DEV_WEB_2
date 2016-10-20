
package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


abstract public class DaoUtil {
    private Connection cx = null;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        if(cx == null){
            String url="jdbc:sqlite:F:\\Private\\Estudo\\Unijorge\\DEV-WEB\\App_web\\libs\\aula.db";
            String usr="";
            String psw="";
            Class.forName("org.sqlite.JDBC");
            cx=DriverManager.getConnection(url, usr, psw);
        }        
        return cx;
    }
    
    public void getFechaTudo() throws SQLException{
        if(cx != null){
            cx.close();
            cx=null;
        }
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        return this.getConnection().prepareStatement(sql);
    }
    
    public Statement getStatement() throws ClassNotFoundException, SQLException{
        return this.getConnection().createStatement();
    }    
}
