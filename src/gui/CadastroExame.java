package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Endereco;
import entities.Exame;
import entities.Paciente;
import service.ExameService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroExame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTextPane txtOrientacoes;

	/**
	 * Launch the application.
	 */
	
	ExameService exameService = new ExameService();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroExame frame = new CadastroExame();
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
	
	private void cadastrarExame() {
		try {
			Exame exame = new Exame();
			exame.setCustoExame(Double.parseDouble(this.txtValor.getText()));
			exame.setNomeExame(this.txtNome.getText());
			exame.setOrientacoes(this.txtOrientacoes.getText());
			exame.setCodigo(this.txtCodigo.getText());
		
			exameService.cadastrar(exame);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public CadastroExame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de exame\r\n");
		lblNewLabel.setBounds(10, 11, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código\r\n");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor R$");
		lblNewLabel_3.setBounds(215, 61, 65, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Orientações");
		lblNewLabel_4.setBounds(10, 86, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		txtOrientacoes = new JTextPane();
		txtOrientacoes.setBounds(91, 86, 281, 103);
		contentPane.add(txtOrientacoes);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(57, 58, 117, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(56, 33, 316, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(274, 58, 98, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarExame();
			}
		});
		btnNewButton.setBounds(10, 201, 362, 23);
		contentPane.add(btnNewButton);
	}
}
