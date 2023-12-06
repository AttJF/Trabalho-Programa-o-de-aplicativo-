package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void abrirNovaJanela(JFrame window) {
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                window.setVisible(false);
            }
        });

        window.setVisible(true);
    }

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar\r\n");
		lblNewLabel.setBounds(110, 11, 123, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 244, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Medico\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new CadastroMedico());
			}
		});
		btnNewButton_2.setBounds(129, 11, 115, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Paciente\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new CadastroPaciente());
			}
		});
		btnNewButton_1.setBounds(8, 11, 115, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Especialidade\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new CadastroEspecialidade());
			}
		});
		btnNewButton.setBounds(129, 54, 115, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Exame\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new CadastroExame());
			}
		});
		btnNewButton_3.setBounds(8, 54, 115, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Agendar\r\n");
		lblNewLabel_1.setBounds(322, 11, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(288, 30, 112, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Consulta\r\n");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new Agendamento());
			}
		});
		btnNewButton_4.setBounds(10, 11, 89, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Exame");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new AgendarExame());
			}
		});
		btnNewButton_5.setBounds(10, 54, 89, 23);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("Consultar");
		lblNewLabel_2.setBounds(179, 142, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 156, 390, 120);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_7_1 = new JButton("Agenda do Exame\r\n");
		btnNewButton_7_1.setBounds(25, 11, 155, 40);
		panel_2.add(btnNewButton_7_1);
		
		JButton btnNewButton_7 = new JButton("Agenda do Medico\r\n");
		btnNewButton_7.setBounds(206, 11, 155, 40);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("Historico do Paciente");
		btnNewButton_6.setBounds(120, 62, 155, 40);
		panel_2.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new HistoricoPaciente());
			}
		});
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new AgendaMedico());
			}
		});
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNovaJanela(new AgendaExame());
			}
		});
	}
}
