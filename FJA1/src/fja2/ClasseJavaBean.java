/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fja2;
import java.sql.*;

/**
 *
 * @author solaris
 */
public class ClasseJavaBean {
        // Configuração do DSN do ODBC.	
	private String dsn     = null;
	private String usuario = null;
	private String senha   = null;
	
	// Objetos utlizados para manipulação de dados.
	private Connection conexao = null;
	private Statement comandoSQL = null;
	private ResultSet resultadoConsulta = null;
	
	// Strings utilizadas para compor comando sql.
	private String sql     = null;
	private String sqlCodigo = null;
	private String sqlNome = null;
	
	/**
	 * Construtor de classe.
	 */
	public ClasseJavaBean()
	{
		this.dsn = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:/clientes.mdb";
		this.usuario = "";
		this.senha = "";
		this.sql = "";
	}
	
	/**
	 * Pega a conexão com banco de dados.
	 */
	private void getConexao()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			this.conexao = DriverManager.getConnection(dsn,usuario,senha);
			this.comandoSQL = conexao.createStatement();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(InstantiationException e)
		{
			e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Finaliza a conexão com o banco de dados.
	 */
	public void finalizaConexao()
	{
		try 
		{
			this.comandoSQL.close();
			this.conexao.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Recebe uma string SQL com a consulta a ser realizada no banco de dados.
	 * @param pSql String com os comandos SQL.
	 */
	public void setSql(String pSql) 
	{
		this.sql = pSql;
	}
	
	/**
	 * Atribui o nome do cliente que será pesquisado na base de dados.
	 * @param pSqlNome Nome do cliente a ser pesquisado na base de dados.
	 */
	public void setSqlNome(String pSqlNome) 
	{
		this.sqlNome = "select * from clientes where nome like '%"+pSqlNome+"%' order by nome";
		this.sql = this.sqlNome;
	}
	
	/**
	 * Atribui o código do cliente que será pesquisado na base de dados.
	 * @param pSqlCodigo Código do cliente a ser pesquisado.
	 */
	public void setSqlCodigo(String pSqlCodigo) 
	{		
		this.sqlCodigo = "select * from clientes where CODIGO="+ pSqlCodigo;
		this.sql = sqlCodigo;
	}
	
	/**
	 * Método responsável por pegar o resultado da ocnuslta.
	 * @return ResultSet Retorna um ResultSet com o resultado da com consulta.
	 */
	public ResultSet getRestultadoConsulta()
	{
		try 
		{
			this.getConexao();
			this.resultadoConsulta = this.comandoSQL.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return this.resultadoConsulta;
	}
	
	public String getDsn() 
	{
		return dsn;
	}

	public void setDsn(String dsn) 
	{
		this.dsn = dsn;
	}

	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}

	public String getSenha() 
	{
		return senha;
	}

	public void setSenha(String senha) 
	{
		this.senha = senha;
	}

	public String getSql() 
	{
		return sql;
	}
	
	public String getSqlNome()
	{
		return sqlNome;
	}

	public Statement getComandoSQL()
	{
		return comandoSQL;
	}

	public void setComandoSQL(Statement comandoSQL) 
	{
		this.comandoSQL = comandoSQL;
	}	

	public void setConexao(Connection conexao) 
	{
		this.conexao = conexao;
	}
}
