package br.com.einsteinlimeira.model;

/**
 * Representação dos usuários do sistema. 
 * 
 * @author Will
 */
public class Usuario {
	//Define as variáveis
	private String username;
	private String senha;
	
	//Seta o tipo de variável e o que será inserido nela
	public Usuario (String username, String senha) {
		this.username = username;
		this.senha = senha;
	}

	//Pega o que foi inserido no campo
	public String getUsername() {
		return username;
	}

	//Seta o que foi inserido no campo pra devida variável
	public void setUsername(String username) {
		this.username = username;
	}
	
	//Pega o que foi inserido no campo
	public String getSenha() {
		return senha;
	}

	//Seta o que foi inserido no campo pra devida variável
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
