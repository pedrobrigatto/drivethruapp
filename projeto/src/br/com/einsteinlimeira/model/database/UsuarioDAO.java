package br.com.einsteinlimeira.model.database;

import java.sql.ResultSet;

import br.com.einsteinlimeira.model.Usuario;
import br.com.einsteinlimeira.view.TelaCadastroAlimentos;
import br.com.einsteinlimeira.view.TelaCadastroAlimentos;
import br.com.einsteinlimeira.view.TelaLogin;

/**
 * Classe que representa objetos de acesso a dados de usuário. Inicialmente, estamos considerando
 * que a aplicação não tem um banco de dados associado, e as informações estão todas em memória,
 * em uma lista mantida em uma classe que representa o repositório de dados. 
 * 
 * @author WillOliverio
 */
public class UsuarioDAO {
	
	private dados dados;
	
	public UsuarioDAO () {
		dados = new dados();
		dados.conecta("127.0.0.1","projeto","root","");
	}
	
	public boolean validarUsuario(Usuario usuario) {
		
		Usuario usuarioAtual = null;
		
		String usernameTela = null;
		String senhaTela = null;
		
		ResultSet rs = dados.consulta("SELECT * FROM usuarios WHERE usuario='"+usernameTela+"' and senha='"+senhaTela+"'");
			  try
			  {
	            if (rs.next())
	            {
	                    TelaCadastroAlimentos i = new TelaCadastroAlimentos();
	                    i.setVisible(true);
	                    setVisible(false);
	             }
			  }
			  catch(Exception e)
			    {
			        System.out.println("ERRO");
			    }
			return false;
	}


	private void setVisible(boolean b) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
		
	}
}

