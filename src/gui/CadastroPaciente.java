package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JMenuBar;

public class CadastroPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	/**
	 * @wbp.nonvisual location=-40,359
	 */
	private final JSeparator separator = new JSeparator();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
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
		
		textField = new JTextField();
		textField.setBounds(49, 47, 406, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(152, 96, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(265, 93, 47, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(322, 93, 46, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(378, 93, 77, 20);
		contentPane.add(spinner_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 82, 116, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setBounds(6, 21, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Feminino");
		rdbtnNewRadioButton_1.setBounds(6, 45, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Outro");
		rdbtnNewRadioButton_2.setBounds(6, 71, 109, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(45, 0, 24, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(347, 130, 108, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setBounds(152, 133, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(208, 130, 121, 20);
		contentPane.add(formattedTextField);
		
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 229, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(208, 229, 149, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 192, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 192, 454, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_10 = new JLabel("Rua\r\n");
		lblNewLabel_10.setBounds(266, 260, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(299, 257, 165, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(10, 263, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_5 = new JTextField();
		textField_5.setBounds(40, 257, 216, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Numero\r\n");
		lblNewLabel_12.setBounds(367, 232, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_6 = new JTextField();
		textField_6.setBounds(413, 229, 51, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Complemento\r\n");
		lblNewLabel_13.setBounds(10, 302, 71, 14);
		contentPane.add(lblNewLabel_13);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(91, 288, 362, 51);
		contentPane.add(editorPane);
		
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
