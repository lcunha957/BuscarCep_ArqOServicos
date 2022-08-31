package cep;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class CadastroComCep extends JFrame {

	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox cboUf;
	private JLabel lblStatus;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtPrimeiroNome;
	private JTextField txtNomeDoMeio;
	private JTextField txtSobrenome;
	private JTextField txtRA;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroComCep frame = new CadastroComCep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroComCep() {
		setBackground(new Color(255, 250, 205));
		setForeground(new Color(255, 250, 205));
		setTitle("BuscarCep");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroComCep.class.getResource("/img/home.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setBounds(11, 132, 45, 13);
		contentPane.add(lblNewLabel);

		txtCep = new JTextField();
		txtCep.setBounds(60, 129, 124, 19);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(11, 161, 55, 13);
		contentPane.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(70, 158, 241, 19);
		contentPane.add(txtEndereco);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(11, 234, 49, 13);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(73, 231, 157, 19);
		contentPane.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(11, 262, 55, 13);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(73, 259, 157, 19);
		contentPane.add(txtCidade);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(277, 234, 27, 13);
		contentPane.add(lblUf);

		cboUf = new JComboBox();
		cboUf.setForeground(new Color(102, 102, 153));
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "-Selecione-", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
						"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(333, 230, 91, 21);
		contentPane.add(cboUf);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.PINK);
		btnLimpar.setForeground(new Color(0, 0, 0));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(99, 288, 85, 21);
		contentPane.add(btnLimpar);

		JButton btnCep = new JButton("BuscarCep");
		btnCep.setBackground(new Color(70, 130, 180));
		btnCep.setForeground(new Color(220, 220, 220));
		// cria o evento de quando clica no botão Buscar
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o cep");
					txtCep.requestFocus();

				} else {
					buscarCep();
				}
			}
		});
		btnCep.setBounds(204, 128, 100, 21);
		contentPane.add(btnCep);

		JButton btnSobre = new JButton("");
		btnSobre.setForeground(new Color(135, 206, 235));
		// criando o evento do clique para o botão Sobre
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(CadastroComCep.class.getResource("/img/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(new Color(173, 216, 230));
		btnSobre.setBounds(370, 43, 68, 48);
		contentPane.add(btnSobre);
		// Uso da bibioteca Atxy2k para validar txtCep
		// valida no txtCep se é um cep de 8 dígitos
		RestrictedTextField validar = new RestrictedTextField(txtCep);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(314, 100, 48, 48);
		contentPane.add(lblStatus);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(11, 194, 45, 13);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(60, 191, 96, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(166, 194, 91, 13);
		contentPane.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(252, 187, 124, 19);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblPrimeiroNome = new JLabel("Primeiro Nome");
		lblPrimeiroNome.setBounds(10, 55, 86, 13);
		contentPane.add(lblPrimeiroNome);

		txtPrimeiroNome = new JTextField();
		txtPrimeiroNome.setBounds(106, 52, 135, 19);
		contentPane.add(txtPrimeiroNome);
		txtPrimeiroNome.setColumns(10);

		JLabel lblNomeDoMeio = new JLabel("Nome do Meio");
		lblNomeDoMeio.setBounds(11, 78, 85, 13);
		contentPane.add(lblNomeDoMeio);

		txtNomeDoMeio = new JTextField();
		txtNomeDoMeio.setBounds(106, 75, 135, 19);
		contentPane.add(txtNomeDoMeio);
		txtNomeDoMeio.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(11, 101, 73, 13);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(96, 101, 157, 19);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblRA = new JLabel("RA");
		lblRA.setBounds(11, 20, 27, 13);
		contentPane.add(lblRA);

		txtRA = new JTextField();
		txtRA.setBounds(60, 17, 133, 19);
		contentPane.add(txtRA);
		txtRA.setColumns(10);


		

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				Statement st = null;

						try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjetoForm2110121106", "root",
							"");
					// cria permissão com a conexão ativa para executar comandos, pede permissão
					// diretamente
					st = conexao.createStatement();
					st.executeUpdate("insert into alunocadastro  values  ('" + txtRA.getText() + "', '"
							+ txtPrimeiroNome.getText() + "', '" + txtNomeDoMeio.getText() + "', '"
							+ txtSobrenome.getText() + "', '" + txtCep.getText() + "', '" + txtNumero.getText() + "', '"
							+ txtComplemento.getText() + "')");
					JOptionPane.showMessageDialog(null, "Dados enviados com sucesso ao banco de dados");
					limparCampos();
				} catch (ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Driver do banco de dados não encontrado na bibilioteca");
				}

				catch (SQLException ex) {
					int Erro = ex.getErrorCode();
					JOptionPane.showMessageDialog(null, "erro: " + ex.getErrorCode());
			         if (Erro == 1062) {
			        	 JOptionPane.showMessageDialog(null, "Preencha todos os campos do formulário antes de enviar e/ou o RA já foi cadastrado");
			         }
			         if (Erro == 1366) {
			        	 JOptionPane.showMessageDialog(null, "Digite primeiro os dados de RA com 5 números e após preencha todo o formulário antes de enviar"); 
			         }
			         if (Erro == 1264) {
			        	JOptionPane.showMessageDialog(null, "O limite de números já foi atingido, digite apenas 5 números de RA"); 
			         }
			         
			         if (Erro == 1265) {
			        		JOptionPane.showMessageDialog(null, "Não aceitamos letras, digite apenas 5 números de RA"); 	 
			         }

				}

			}
			
			private void  limparCampos() {
				txtRA.setText("");
				txtPrimeiroNome.setText("");
				txtNomeDoMeio.setText("");
				txtSobrenome.setText("");
				txtCep.setText("");
				txtEndereco.setText("");
				txtNumero.setText("");
				txtComplemento.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				cboUf.setSelectedItem("");
			    lblStatus.setIcon(null);
				txtRA.requestFocus();
				txtCep.requestFocus();

			}
			

		});
		
			
		btnEnviar.setBackground(new Color(154, 205, 50));
		btnEnviar.setBounds(263, 288, 85, 21);
		contentPane.add(btnEnviar);

		JLabel lblSobre = new JLabel("Clique no (?) para saber sobre o projeto");
		lblSobre.setBounds(204, 20, 234, 13);
		contentPane.add(lblSobre);
		validar.setOnlyNums(true);
		validar.setLimit(8);
	}// fim do construtor

	private void buscarCep() {
		String complemento = " ";
        String bairro = txtBairro.getText();
		String cidade = txtCidade.getText();
		String logradouro = " ";
		String cep = txtCep.getText();
		String resultado = null;
		String estado = " ";
	
		try {
			//URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			URL url = new URL ("https://api.postmon.com.br/v1/cep/" + cep + "?format=xml");
					
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("complemento")) {
				 complemento = element.getText();	
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}

				if (element.getQualifiedName().equals("cep")) {
					cep = element.getText();
				}
				if (element.getQualifiedName().equals("estado")) {
					estado = element.getText();
					cboUf.setSelectedItem(estado);
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					} else {
						JOptionPane.showMessageDialog(null, "Cep não encontrado, tente novamente");
					}
				}
						
			}
			// Setar o campo endereço
			txtEndereco.setText(logradouro + "\n" + complemento);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void limpar() {
		txtRA.setText(null);
		txtPrimeiroNome.setText(null);
		txtNomeDoMeio.setText(null);
		txtSobrenome.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem(null);
		txtCep.requestFocus();
		lblStatus.setIcon(null);
	}
	
   
     }

