package br.com.einsteinlimeira.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dados {
	
	   Connection con;
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

}
