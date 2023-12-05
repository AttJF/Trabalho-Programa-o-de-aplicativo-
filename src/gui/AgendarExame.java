package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class AgendarExame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendarExame frame = new AgendarExame();
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
	public AgendarExame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agendar Exame");
		lblNewLabel.setBounds(10, 11, 123, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Exame");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Paciente\r\n");
		lblNewLabel_2.setBounds(10, 85, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(54, 82, 257, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(54, 43, 257, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data ");
		lblNewLabel_3.setBounds(10, 181, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hora\r\n");
		lblNewLabel_4.setBounds(107, 181, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(43, 178, 54, 20);
		contentPane.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(156, 178, 60, 20);
		contentPane.add(formattedTextField_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(226, 162, 89, 52);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Medico Requisitando Exame\r\n");
		lblNewLabel_5.setBounds(10, 110, 170, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(11, 135, 300, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
