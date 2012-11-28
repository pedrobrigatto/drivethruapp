package br.com.einsteinlimeira.model.database;

import java.util.ArrayList;
import java.util.List;

import br.com.einsteinlimeira.model.Usuario;

/**
 * Como não temos banco de dados associado, esta classe representa o repositório de users.
 * 
 * @author WillOliverio
 */
public class Repositorio {
	
	private List<Usuario> TABELA_USUARIOS = new ArrayList<Usuario>();
	
	public Repositorio() {
		carregarTabelaUsuarios();
	}

	private void carregarTabelaUsuarios() {
		TABELA_USUARIOS.add(new Usuario("william", "pwdwilliam"));
		TABELA_USUARIOS.add(new Usuario("rafael", "pwdrafael"));
		TABELA_USUARIOS.add(new Usuario("ricardo", "pwdricardo"));
		TABELA_USUARIOS.add(new Usuario("wesley", "pwdwesley"));
		TABELA_USUARIOS.add(new Usuario("renan", "pwdrenan"));
		TABELA_USUARIOS.add(new Usuario("pedro", "pwdpedro"));
	}
	
	public List<Usuario> baixarTabelaUsuarios() {
		return this.TABELA_USUARIOS;
	}
}
