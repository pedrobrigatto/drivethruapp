package br.com.einsteinlimeira.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.einsteinlimeira.controller.ControladorLogin;

/**
 * Tela de login.
 * 
 * @author WillOliverio
 */
public class TelaLogin extends JFrame implements ActionListener {
	
	// Número que controla a versão da classe
	private static final long serialVersionUID = -3202720881747750437L;
	
	// Campos usados para compor a tela.
	private JLabel labelUsername;
	private JLabel labelSenha;
	private JButton btnLogin;
	private JButton btnLimpar;
	private JTextField txtUsername;
	private JPasswordField pwdUsuario;
	
	// Construção da Tela.
	public TelaLogin () {
		montarTela();
	}
	
	// Método onde será implementada a montagem da tela.
	private void montarTela() {
		
		// Organiza o layout da tela.
		GridLayout gerenciadorLayout = new GridLayout(3, 2);
		this.setLayout(gerenciadorLayout);
		
		// Cria os componentes
		labelUsername = new JLabel("Username:");
		labelSenha = new JLabel("Senha:");
		
		txtUsername = new JTextField(10);
		pwdUsuario = new JPasswordField(10);
		
		btnLogin = new JButton("Entrar");
		btnLogin.setActionCommand("Entrar");
		btnLogin.addActionListener(this);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setActionCommand("Limpar");
		btnLimpar.addActionListener(this);
		
		// Adiciona esses componentes à tela.
		this.add(labelUsername);
		this.add(txtUsername);
		this.add(labelSenha);
		this.add(pwdUsuario);
		this.add(btnLimpar);
		this.add(btnLogin);
		
		// Modificação dos atributos da tela
		this.setSize(220, 100);
		this.setLocationRelativeTo(null);
		this.setTitle("Tela de Login");
	}

	// Captura os eventos gerados por botões.
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if ("Entrar".equals(evento.getActionCommand())) {
			
			// Verificar se os campos estão preenchidos. Se estiverem, entramos no sistema. Senão, avisamos o usuário.
			if (camposVazios()) {
				// Avisa o usuário
				JOptionPane.showMessageDialog(this, "Preencha os dados e tente novamente");
			} else {
				boolean existe = ControladorLogin.pegarControlador().
				    verificarUsuario(txtUsername.getText(), 
				    		new String(pwdUsuario.getPassword()));
				
				if (existe) {
					JOptionPane.showMessageDialog(this, "Abriria a tela home, próxima aula!!");
				} else {
					JOptionPane.showMessageDialog(this, "Usuário inválido!! ");
				}
			}
			
		} else if ("Limpar".equals(evento.getActionCommand())) {
			 
			this.txtUsername.setText("");
			this.pwdUsuario.setText("");			
		}
		
		// Evento para saber sua origem.
		if (evento.getSource() == btnLimpar) {
			
		} else if (evento.getSource() == btnLogin) { 
			
		}
	}
	
	private boolean camposVazios() {
		
		// inicialmente, caso os campos estejam vazios.
		boolean camposEstaoVazios = true;
		
		String valorUsername = txtUsername.getText();
		String valorSenha = new String(pwdUsuario.getPassword());
		
		// Checando se está vazio ou não. 
		if (valorUsername != null && !"".equals(valorUsername)  && 
				valorSenha != null && !"".equals(valorSenha)) {
			camposEstaoVazios = false;			
		} 
		return camposEstaoVazios;
	}
	
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
}
}
