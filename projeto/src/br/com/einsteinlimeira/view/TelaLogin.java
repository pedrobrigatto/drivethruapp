package br.com.einsteinlimeira.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.einsteinlimeira.controller.ControladorLogin;
import br.com.einsteinlimeira.model.database.dados;

/**
 * Tela de login.
 * 
 * @author Will
 */
public class TelaLogin extends JFrame implements ActionListener {
	
	//Número que controla a versão da classe
	private static final long serialVersionUID = -3202720881747750437L;
	
	//Campos usados para compor a tela.
	private JLabel labelUsername;
	private JLabel labelSenha;
	private JButton btnLogin;
	private JButton btnLimpar;
	private JTextField txtUsername;
	private JPasswordField pwdUsuario;
	
	//Construção da Tela.
	public TelaLogin () {
		montarTela();
	}
	
	//Método onde será implementada a montagem da tela.
	private void montarTela() {
		
		//Organiza o layout da tela.
		GridLayout gerenciadorLayout = new GridLayout(3, 2);
		this.setLayout(gerenciadorLayout);
		
		//Cria os componentes
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
		
		//Adiciona esses componentes à tela.
		this.add(labelUsername);
		this.add(txtUsername);
		this.add(labelSenha);
		this.add(pwdUsuario);
		this.add(btnLimpar);
		this.add(btnLogin);
		
		//Modificação dos atributos da tela
		this.setSize(220, 100);
		this.setLocationRelativeTo(null);
		this.setTitle("Tela de Login");
	}

	//Captura os eventos gerados por botões.
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if ("Entrar".equals(evento.getActionCommand())) {
			
			//Verificar se os campos estão preenchidos. Se estiverem, entramos no sistema. Senão, avisamos o usuário.
			if (camposVazios()) {
				// Avisa o usuário
				JOptionPane.showMessageDialog(this, "Preencha os dados e tente novamente");
			} else {
			    //Conecta no Banco de Dados
				dados d = new dados();
			    d.conecta("127.0.0.1","projeto","root","");
			    
			    //Efetua a pesquisa no banco de dados		    
			    ResultSet rs = d.consulta("usuario",txtUsername.getText(),pwdUsuario.getPassword());
			       try
			        {
			            if (rs.next())
			            {
			                   TelaCadastroAlimentos i = new TelaCadastroAlimentos();
			                    i.setVisible(true);
			                    setVisible(false);
			                }
			            
			            
			            else
			            	JOptionPane.showMessageDialog(this, "Usuário e/ou senha inválidos!!");
			            }

			            catch(Exception e)
			            {
			                System.out.println("ERRO");
			            }

			    }                                     

				/*boolean existe = ControladorLogin.pegarControlador().
						//CONECTA COM O BANCO DE DADOS
						dados d = new dados();
						d.conecta("127.0.0.1","projeto","root","");
						
						ResultSet rs = d.consulta("usuario",txtUsername.getText(),pwdUsuario.getPassword());
					    
					       try
					        {
					            if (rs.next())
					            {
					                    TelaCadastroAlimentos tela = new TelaCadastroAlimentos();
					                    tela.setVisible(true);
					                    //setVisible(false);
					                }
						
				    //verificarUsuario(txtUsername.getText(), 
				    		//new String(pwdUsuario.getPassword()));
				
				/*if (existe) {
					//JOptionPane.showMessageDialog(this, "Abriria a tela home, próxima aula!!");
						TelaCadastroAlimentos tela = new TelaCadastroAlimentos();
						tela.setVisible(true);
						TelaLogin.setVisible(false);
					}
				 else {
					JOptionPane.showMessageDialog(this, "Usuário inválido!! ");
				}
					        }
					        catch (Exception e)
					        {
					            System.err.println("Erro CONSULTA: " + e);
					        }*/
			
			
		} else if ("Limpar".equals(evento.getActionCommand())) {
			 
			this.txtUsername.setText("");
			this.pwdUsuario.setText("");			
		}
		
		//Evento para saber sua origem.
		if (evento.getSource() == btnLimpar) {
			
		} else if (evento.getSource() == btnLogin) { 
			
		}
	}
	
	private boolean camposVazios() {
		
		//Inicialmente, caso os campos estejam vazios.
		boolean camposEstaoVazios = true;
		
		String valorUsername = txtUsername.getText();
		String valorSenha = new String(pwdUsuario.getPassword());
		
		//Checa se está vazio ou não. 
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
