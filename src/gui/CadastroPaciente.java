package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Endereco;
import entities.FormaDePagamento;
import entities.Paciente;
import service.EnderecoService;
import service.PacienteService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class CadastroPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNome;
	/**
	 * @wbp.nonvisual location=-40,359
	 */
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtUf;
	private JTextField textField_3;
	private JTextField txtCidade;
	private JTextField textField_4;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JFormattedTextField txtTelefone;
	private JEditorPane txtComplemento;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JRadioButton rbOutro;
	private JSpinner diaNascimento;
	private JSpinner mesNascimento;
	private JSpinner anoNascimento;

	/**
	 * Launch the application.
	 */
	
	PacienteService pacienteService = new PacienteService();
	EnderecoService enderecoService = new EnderecoService();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPaciente frame = new CadastroPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void cadastrarPaciente() {
		try {
			Paciente paciente = new Paciente();
			Endereco endereco = new Endereco();
			
			endereco.setBairro(this.txtBairro.getText());
			endereco.setCidade(this.txtCidade.getText());
			endereco.setComplemento(this.txtComplemento.getText());
			endereco.setNumero(Integer.parseInt(this.txtNumero.getText()));
			endereco.setRua(this.txtRua.getText());
			endereco.setUniaoFederativa(this.txtUf.getText());
			
			this.enderecoService.cadastrar(endereco);
			
			String str = this.diaNascimento.getValue().toString() + "/" + this.mesNascimento.getValue().toString() + "/" + this.anoNascimento.getValue().toString();
			paciente.setDataNascimento(str);
			paciente.setEndereco(endereco);
			// TODO: paciente.setFormaPagamento();
			paciente.setNome(this.txtNome.getText());
			paciente.setSexo(verificarSelecaoRadioButtonSexo());
			paciente.setTelefone(this.txtTelefone.getText());
			
			this.pacienteService.cadastrar(paciente);
			System.out.println(paciente.toString());

		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private String verificarSelecaoRadioButtonSexo() {

		if (this.rbMasculino.isSelected()) {
			return this.rbMasculino.getText();
		} else if (this.rbFeminino.isSelected()) {
			return this.rbFeminino.getText();
		} else {
			return this.rbOutro.getText();
		}
	}

	/**
	 * Create the frame.
	 */
	public CadastroPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Paciente");
		lblNewLabel_1.setBounds(10, 0, 168, 30);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(49, 47, 406, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(152, 96, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		diaNascimento = new JSpinner();
		diaNascimento.setBounds(265, 93, 47, 20);
		contentPane.add(diaNascimento);
		
		mesNascimento = new JSpinner();
		mesNascimento.setBounds(322, 93, 46, 20);
		contentPane.add(mesNascimento);
		
		anoNascimento = new JSpinner();
		anoNascimento.setBounds(378, 93, 77, 20);
		contentPane.add(anoNascimento);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 82, 116, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(6, 21, 109, 23);
		panel.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(6, 45, 109, 23);
		panel.add(rbFeminino);
		
		rbOutro = new JRadioButton("Outro");
		rbOutro.setBounds(6, 71, 109, 23);
		panel.add(rbOutro);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(45, 0, 24, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPaciente();
			}
		});
		btnNewButton.setBounds(347, 130, 108, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setBounds(152, 133, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(208, 130, 121, 20);
		contentPane.add(txtTelefone);
		
		JButton btnNewButton_1 = new JButton("Carregar photo");
		btnNewButton_1.setBounds(152, 158, 185, 23);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 375, 144, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Endereço\r\n:");
		lblNewLabel_6.setBounds(10, 207, 71, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cidade\r\n");
		lblNewLabel_7.setBounds(168, 232, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Unidade federativa\r\n");
		lblNewLabel_8.setBounds(10, 232, 106, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(186, 239, 46, 0);
		contentPane.add(lblNewLabel_9);
		
		txtUf = new JTextField();
		txtUf.setBounds(112, 229, 46, 20);
		contentPane.add(txtUf);
		txtUf.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(208, 229, 149, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 192, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 192, 454, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_10 = new JLabel("Rua\r\n");
		lblNewLabel_10.setBounds(266, 260, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		txtRua = new JTextField();
		txtRua.setBounds(299, 257, 165, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(10, 263, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(40, 257, 216, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Numero\r\n");
		lblNewLabel_12.setBounds(367, 232, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(413, 229, 51, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Complemento\r\n");
		lblNewLabel_13.setBounds(10, 302, 71, 14);
		contentPane.add(lblNewLabel_13);
		
		txtComplemento = new JEditorPane();
		txtComplemento.setBounds(91, 288, 362, 51);
		contentPane.add(txtComplemento);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 257, 190, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(294, 257, 161, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(406, 229, 49, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(208, 229, 151, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
}
