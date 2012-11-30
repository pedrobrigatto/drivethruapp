package br.com.einsteinlimeira.view;

/**
 * Tela de cadastro de atendente. 
 * 
 * @author Rafael
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.*;  
import javax.swing.*;  

public class TelaAtendente extends JFrame implements ActionListener {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Inicialização dos botões
	
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnConsultar;
	
	// Inicialização do Método
	
	public TelaAtendente() {  
        super("Tela de Atendente");  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  // Para fechar aplicação
          
        this.getContentPane().setLayout(new GridBagLayout());  
         
        // Criação dos Label e TextField 
        
        add("Código: ", new JTextField(), "Nascimento: ", new JTextField());  
        add("Nome: ", new JTextField());  
        add("Depar.: ", new JTextField(), "Turno: ", new JTextField());  
        add("Login: ", new JTextField(), "Senha: ", new JPasswordField(10)); 
        
        // Definindo Tamanho da Tela
          
        this.setSize(400,400);     
        
      // Bloco construtor para criação dos botões na tela. 
        
        btnInserir = new JButton("Inserir");
    	btnInserir.addActionListener(this);
    	    
    	btnAlterar = new JButton("Alterar");
    	btnAlterar.addActionListener(this);
    	
    	btnExcluir = new JButton("Excluir");
    	btnExcluir.addActionListener(this);
    	
    	btnConsultar = new JButton("Consultar");
    	btnConsultar.addActionListener(this);
    	
    	// Inicialização dos botões na Tela.
    	
    	getContentPane().add(btnInserir);
    	getContentPane().add(btnAlterar);
    	getContentPane().add(btnExcluir);
    	getContentPane().add(btnConsultar);
    	

    }  
	
	//Bloco construtor para criação dos botões na tela 
  
    /** 
     * Adicionando um Label e TextField, e configurando suas posições 
     */  
    public void add(String label, JComponent componente ) {  
        GridBagConstraints grid = new GridBagConstraints();  
        grid.fill = GridBagConstraints.NONE;  
        grid.anchor = GridBagConstraints.NORTHWEST;  
        grid.insets = new Insets(4,4,4,4);  
  
        grid.weightx = 0;  
        grid.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label), grid);  
          
        grid.fill = GridBagConstraints.BOTH;  
        grid.weightx = 1;  
        grid.gridwidth = GridBagConstraints.REMAINDER;  
        this.getContentPane().add(componente, grid); 
        
    }  
      
  
    /** 
     * Adicionando um Label e TextField, e configurando suas posições 
     */   
    public void add(String label, JScrollPane componente ) {  
        GridBagConstraints grid = new GridBagConstraints();  
        grid.fill = GridBagConstraints.NONE;  
        grid.anchor = GridBagConstraints.NORTHWEST;  
        grid.insets = new Insets(4,4,4,4);  
        grid.weighty = 1;  
        grid.gridheight = GridBagConstraints.REMAINDER;  
          
        grid.weightx = 0;  
        grid.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label), grid);  
          
        grid.fill = GridBagConstraints.BOTH;  
        grid.weightx = 1;  
        grid.gridwidth = GridBagConstraints.REMAINDER;  
        this.getContentPane().add(componente, grid);  
    }      
      
    /** 
     * Adiciona um label, um componente de edição, mais um label e outro componente de edição. Todos  
     * na mesma linha 
     */  
    public void add(String label, JComponent componente, String label2, JComponent componente2) {  
    	
    	GridBagConstraints grid = new GridBagConstraints();  
        grid.fill = GridBagConstraints.BOTH;  
        grid.insets = new Insets(4,4,4,4);  
  
        grid.fill = GridBagConstraints.NONE;  
        grid.anchor = GridBagConstraints.NORTHWEST;  
        grid.weightx = 0;  
        grid.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label), grid);  
          
        grid.weightx = 1;  
        grid.gridwidth = 1;  
        grid.fill = GridBagConstraints.BOTH;  
        this.getContentPane().add(componente, grid);  
  
        grid.fill = GridBagConstraints.NONE;  
        grid.weightx = 0;  
        grid.gridwidth = 1;  
        this.getContentPane().add(new JLabel(label2), grid);  
          
        grid.weightx = 1;  
        grid.fill = GridBagConstraints.BOTH;  
        grid.gridwidth = GridBagConstraints.REMAINDER;  
        this.getContentPane().add(componente2, grid);  
        
        }
    
    // ActionEvent criado para os botões
    
	public void actionPerformed(ActionEvent evento) {
		

		if (evento.getSource() == btnInserir) {

			JOptionPane.showMessageDialog(this, "Produto cadastrado!!!");

		} else if (evento.getSource() == btnAlterar) {

			JOptionPane.showMessageDialog(this, "Produto Alterado!!!");
		}

		else if (evento.getSource() == btnExcluir) {

			JOptionPane.showMessageDialog(this, "Produto Excluido com sucesso!!!");
		}
	}
          
	
	 // Método Principal para execução da Tela.
	
    public static void main(String[] args ) {  
    	TelaAtendente tela = new TelaAtendente();  
        tela.show();
        tela.setVisible(true);
    }  
}  

