package cep;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopIconUI;
import javax.swing.plaf.DesktopPaneUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Buscar CEP vers\u00E3o 1.0");
			lblNewLabel.setBounds(10, 10, 254, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("@Autores:");
			lblNewLabel_1.setForeground(SystemColor.textHighlight);
			lblNewLabel_1.setBackground(SystemColor.activeCaption);
			lblNewLabel_1.setBounds(10, 125, 59, 13);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Trabalho: Consumo de CEP com API, formul\u00E1rio e banco de dados ");
			lblNewLabel_3.setBounds(10, 102, 388, 13);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("IES: Col\u00E9gio T\u00E9cnico de Campinas- COTUCA/UNICAMP");
			lblNewLabel_4.setBounds(10, 33, 388, 13);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Disciplina: DS302 - Arquitetura orientada a servi\u00E7os");
			lblNewLabel_5.setBounds(10, 79, 367, 13);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Curso: 59 - T\u00E9cnico em Desenvolvimento de Sistemas Noturno");
			lblNewLabel_6.setBounds(10, 56, 388, 13);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Data de realiza\u00E7\u00E3o: 08 Maio 2022");
			lblNewLabel_7.setBounds(10, 171, 230, 13);
			contentPanel.add(lblNewLabel_7);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Leandro Freitas  - RA 21101 e Lunara Cunha - RA 21106");
			lblNewLabel_2.setForeground(SystemColor.textHighlight);
			lblNewLabel_2.setBounds(10, 148, 308, 13);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JButton btnCotuca = new JButton("");
			btnCotuca.setIcon(new ImageIcon(Sobre.class.getResource("/img/cotuca.png")));
			btnCotuca.setBackground(SystemColor.control);
			btnCotuca.setBorder(null);
			btnCotuca.setBounds(33, 194, 46, 48);
			contentPanel.add(btnCotuca);
		}
	}// fim do construtor

		
	}

