package br.com.einsteinlimeira.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe que cuida da conexão com o Banco de Dados.
 * 
 * @author Will
 */

public class dados {
	
	   Connection con;
	   //Aqui, ele pega os dados informados quando chama essa função de conectar
	    public boolean conecta(String local,String banco, String usuario, String senha)
	    {
	        boolean retorno = false;
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection ("jdbc:mysql://" + local + "/" + banco, usuario, senha);
	            retorno = true;
	        }
	        catch (ClassNotFoundException e)
	        {
	            System.err.println("Erro de conexao:\n" + e);
	        }
	        catch (SQLException e)
	        {
	            System.err.println("Erro de conexao:\n" + e);
	        }
	        return retorno;
	    }
	    
	    public ResultSet consulta(String consulta)
	    {
	        ResultSet rs = null;
	        try
	        {
	            PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(consulta);
	            rs = stmt.executeQuery();
	        }
	        catch (Exception e)
	        {
	            System.err.println("Erro CONSULTA: " + e);
	        }
	        return rs;
	    }
	    
	    //Função responsável por inserir um novo usuário na tabela do BD
	    public boolean insereUsuario (String tabela, String username, String senha)
	    {
	        boolean retorno=false;
	        try{
	        	//Ele executa a query par inserção no BD, pegando a tabela informada pela classe que chamou e os dados repassados por ela
	            PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement("insert into "+ tabela + "(usuario,senha) values ('"+username+"','"+senha+"');");
	            stmt.execute();
	            //Após executar, ele fecha a função acima
	            stmt.close();
	            retorno=true;
	        }
	        catch (SQLException ex){
	        	//Caso não consiga inserir o usuário, ele mostra no Console qual o erro de Insert
	            retorno=false;
	            System.err.println("Erro INSERT:" + ex);
	        }
	        return retorno;
	    }
	    
	    //Função responsável por inserir um novo produto na tabela do BD	    
	    public boolean insereProduto (String tabela, String nome, String codigo, String qtde)
	    {
	        boolean retorno=false;
	        try{
	        	//Ele executa a query par inserção no BD, pegando a tabela informada pela classe que chamou e os dados repassados por ela
	            PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement("insert into "+ tabela + "(nome,codigo,qtde) values ('"+nome+"','"+codigo+"','"+qtde+"');");
	            stmt.execute();
	            //Após executar, ele fecha a função acima
	            stmt.close();
	            retorno=true;
	        }
	        catch (SQLException ex){
	        	//Caso não consiga inserir o usuário, ele mostra no Console qual o erro de Insert
	            retorno=false;
	            System.err.println("Erro INSERT:" + ex);
	        }
	        return retorno;
	    }
	    
	    //Função responsável por inserir um novo pedido na tabela do BD	    	    
	    public boolean inserePedido (String tabela, String nomeCliente, String codeCompra, String codeProduto, String qtd, String valor)
	    {
	        boolean retorno=false;
	        try{
	        	//Ele executa a query par inserção no BD, pegando a tabela informada pela classe que chamou e os dados repassados por ela
	            PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement("insert into "+ tabela + "(nomeCliente,codeCompra,codeProduto,qtd,valor) values ('"+nomeCliente+"','"+codeCompra+"','"+codeProduto+"','"+qtd+"','"+valor+"');");
	            stmt.execute();
	            //Após executar, ele fecha a função acima	            
	            stmt.close();
	            retorno=true;
	        }
	        catch (SQLException ex){
	        	//Caso não consiga inserir o usuário, ele mostra no Console qual o erro de Insert	        	
	            retorno=false;
	            System.err.println("Erro INSERT:" + ex);
	        }
	        return retorno;
	    }

}
