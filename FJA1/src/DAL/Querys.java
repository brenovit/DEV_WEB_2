package DAL;

import java.sql.*;
import java.util.Date;
/**
 * @author Breno nunes
 */
public class Querys {

    private String login = "";
    private String pass = "";
    private String drive = "";

    //private String url = "jdbc:sqlite:F://Private/Unijorge/DEV-WEB/Banco/aula.db";
    private String url;
    private Connection conn = null;         //responsavel por se connectar com o banco
    private PreparedStatement pst = null;    //responsavel por execultar os comandos sql 
    private ResultSet rs = null;            //responsavel por armazenar os dados retornados do banco

    String select = "SELECT nome, descricao, preco FROM tbProduto";
    String insert = "INSERT INTO tbProduto (nome, preco, validade, descricao) VALUES (?, ?, ?, ?)";
    
    public Querys(){
        this.url= "jdbc:sqlite:G:\\Private\\Unijorge\\DEV-WEB\\Banco\\aula.db";        
    }
    
    public void Select() {
        //rollback <- retornar uma ação no sql 
        try {
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection(url, login, pass);            
            pst = conn.prepareStatement(select);
            //pst.setString(1, "%o%");
            rs = pst.executeQuery();          //Contém agora toda a lista encadeada do banco
                        
            while (rs.next()) {
                System.out.println("Produto.: " + rs.getString("nome")
                        + "\nDescrição.: " + rs.getString("descricao")
                        + "\nPreço.: " + rs.getFloat("preco"));
                System.out.println("\n");                
            }
            
            rs.close();
            pst.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }      
    }
    
    public void Insert(String nome, float preco, String descricao){
        try {
            
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection(url, login, pass);            
            
            pst = conn.prepareStatement(insert);
            pst.setString(1, nome);
            pst.setFloat(2, preco);            
            pst.setDate(3, new java.sql.Date(new Date().getTime()));
            pst.setString(4, descricao);
                        
            int qtd = pst.executeUpdate();

            conn.close();
            pst.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
