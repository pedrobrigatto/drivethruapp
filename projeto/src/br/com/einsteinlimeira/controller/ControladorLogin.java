package br.com.einsteinlimeira.controller;

import br.com.einsteinlimeira.model.services.ServicoLogin;
import br.com.einsteinlimeira.view.TelaLogin;

/**
 * Representa o controlador de operações relacionadas a login/logoff de usuário.
 * 
 * @author Will
 */
public class ControladorLogin {

	private static ControladorLogin controlador = new ControladorLogin();
	private TelaLogin telaLogin;

	private ControladorLogin() {}

	public static ControladorLogin pegarControlador() {
		return controlador;
	}

	/*public boolean verificarUsuario(String username, String senha) {
		ServicoLogin servico = new ServicoLogin();
		return servico.validarUsuario(username, senha);
	}*/

	public void iniciar() {
		telaLogin = new TelaLogin();
		telaLogin.setVisible(true);
	}

	public static void main (String [] argumentos) {
		controlador.iniciar();
	}
}
