package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class HistoricoPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoPaciente frame = new HistoricoPaciente();
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
	public HistoricoPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(50, 8, 431, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(10, 208, 471, 115);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Exames\r\n");
		lblNewLabel_1.setBounds(219, 181, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JList list_1 = new JList();
		list_1.setBounds(10, 62, 471, 108);
		contentPane.add(list_1);
		
		JLabel lblNewLabel_2 = new JLabel("Consultas\r\n");
		lblNewLabel_2.setBounds(219, 37, 75, 14);
		contentPane.add(lblNewLabel_2);
	}

}
