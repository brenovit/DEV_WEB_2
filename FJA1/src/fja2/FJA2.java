package fja2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FJA2 {

    public void teste (String[] args) throws ClassNotFoundException,
                                                    SQLException {
        // TODO code application logic here
       /* Pessoa pessoa1 = Pessoa.getInstancia();  
        Pessoa pessoa2 = Pessoa.getInstancia();
        
        pessoa1.setNome("Zé");
        pessoa1.setCpf("123456789");
        System.out.println("Nome = " + pessoa1.getNome() + "; Cpf = " + pessoa1.getCpf());
    
        pessoa2.setNome("Maria");
        pessoa2.setCpf("789456");
        System.out.println("Nome = " + pessoa1.getNome() + "; Cpf = " + pessoa1.getCpf());
        
        System.out.println(pessoa1);     //Posição do 1 objeto na memoria
        System.out.println(pessoa2);     //Posição do 2 objeto na memoria  
         */
        
        String login = "";
        String senha = "";
        String url = "jdbc:sqlite:C:\\Banco";           //local em que o banco esta
        String sql = "SELECT nome, descricao, preco FROM tbProduto";        //uma consulta sql
        
        Connection conect = null;           //variavel para conexão com o banco
        Class.forName("org.sqlite.JDBC");   //Buscar serviço no servidor banco de dados
        
        conect = DriverManager.getConnection(url);  //Conexão segura usando o login e senha
        
        //Montar uma Objeto para criar uma consulta SQL
        PreparedStatement pst = conect.prepareStatement(sql);   
 
        ResultSet rs = pst.executeQuery();          //Contém agora toda a lista encadeada do banco
        
      
        while(rs.next()){
            System.out.println("Produto.: " + rs.getString("nome") + 
                               "\nDescrição.: " + rs.getString("descricao") + 
                               "\nPreço.: " + rs.getFloat("preco"));
            System.out.println("\n");   
        }
        rs.close();
        pst.close();
        conect.close();
    }
    
}
