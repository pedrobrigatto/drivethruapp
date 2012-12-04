package br.com.einsteinlimeira.view;

// @ Criado por Wesley Risso - Parte de BD: Will

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.einsteinlimeira.model.database.ProdutoDAO;
import br.com.einsteinlimeira.model.database.UsuarioDAO;
import br.com.einsteinlimeira.model.database.dados;

public class TelaCadastroAlimentos extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -2327113851583573335L;
	
	// Criação dos Jlabel
	private JLabel labelProduto;
	private JLabel labelCodigo;
	private JLabel labelQtidade;

	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnConsultar;

	//Criação do Jtextfield
	private JTextField txtProduto;
	private JTextField txtCodigoProduto;
	private JTextField txtQtidade;
	private JTextField Qtde;

	//Criação da tela

	public TelaCadastroAlimentos() {
		montarTela();
	}

	private void montarTela(){
		GridBagLayout gerenciadorLayout = new GridBagLayout();
		this.setLayout(gerenciadorLayout);

		//Chamando o bloco Construtor para criar os Jlabel no layout da tela

		labelProduto = new JLabel("Produto: ");
		labelCodigo = new JLabel("Codigo: ");
		labelQtidade = new JLabel("Quantidade");

		//Definindo o tamanho dos Jtextfield

		txtProduto = new JTextField(10);
		txtCodigoProduto = new JTextField(10);
		txtQtidade = new JTextField(3);
		Qtde = new JTextField(3);

		//Bloco construtor para criação dos botões na tela 

		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(this);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		
		// --------------------------------
		//Criando posicionamento dos Jbutton e Jlabel;

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0 ;
		gbc.gridy = 0;
		gbc.insets = new Insets(6, 6, 6, 6);

		//Posição do label produto

		this.add(labelProduto, gbc);

		gbc.gridx = 1;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.VERTICAL;

		//Posição do txt Produto

		this.add(txtProduto, gbc);

		gbc.gridx = 2;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.VERTICAL;

		//Posição do label Quantidade

		this.add(labelQtidade, gbc);

		gbc.gridx = 3;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.VERTICAL;

		this.add(Qtde, gbc);

		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.NONE;

		//Posição do label Codigo
		this.add(labelCodigo, gbc);

		gbc.gridx = 1;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(txtCodigoProduto, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(txtCodigoProduto, gbc);

		//Criando posicionamentos de bot�es
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelBotoes.add(btnInserir);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnExcluir);
		panelBotoes.add(btnConsultar);

		gbc.gridy ++;
		gbc.gridx = 0;
		gbc.gridwidth = 0;
		add(panelBotoes, gbc);

		// Setando o tamanho da tela
		this.setSize (360,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		//---------------------------------------------------------------
	}

	// Mensagem dada após apertar os botões Inserir, Alterar e Excluir  
	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() == btnInserir) {
			//POR ENQUANTO TÁ GRAVANDO AQUI. PRECISA ALTERAR PRO PRODUTODAO
			dados d = new dados();
			d.conecta("127.0.0.1","projeto","root","");
			
			//Após a conexão com sucesso, ele pega os dados inseridos nos campos do form e envia pra função de inserir produto
			d.insereProduto("produto",txtProduto.getText(),txtCodigoProduto.getText(),Qtde.getText());
			
			//Cadastrado com sucesso, então é mostrado a mensagem.
			JOptionPane.showMessageDialog(this, "Produto cadastrado!!!");

		} else if (evento.getSource() == btnAlterar) {

			JOptionPane.showMessageDialog(this, "Produto Alterado!!!");
		}

		else if (evento.getSource() == btnExcluir) {

			JOptionPane.showMessageDialog(this, "Produto Excluido com sucesso!!!");
		}
	}

	private boolean camposVazios(){
		String valorProduto = txtProduto.getText();
		String valorCodigo = new String(getCodigo());
		
		if (valorProduto != null && !"".equals(valorProduto) && 
				valorCodigo != null && !"".equals(valorCodigo)){
		} else{
			JOptionPane.showMessageDialog(this, "Preencha os dados e tente novamente");
		}
		return false;
	}

	private String getCodigo() {
		return null;
	}
	
	public static void main (String [] args) {
		TelaCadastroAlimentos tela = new TelaCadastroAlimentos();
		tela.setVisible(true);
	}
}
