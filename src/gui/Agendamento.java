package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import service.ConsultaService;
import service.MedicoService;
import service.PacienteService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Agendamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cbMedicos;
	private JComboBox cbPacientes;
	private JFormattedTextField txtData;
	private JFormattedTextField txtHorario;

	/**
	 * Launch the application.
	 */
	
	MedicoService medicoService = new MedicoService();
	PacienteService pacienteService = new PacienteService();
	ConsultaService consultaService = new ConsultaService();
	List<Medico> medicos;
	List<Paciente> pacientes;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agendamento frame = new Agendamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String[] buscarTodosMedicos() {
		try {
			medicos = medicoService.buscarTodos();
			return medicos.stream().map(Medico::getNome).toArray(String[]::new);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Medicos.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	private String[] buscarTodosPacientes() {
		try {
			pacientes = pacienteService.buscarTodos();
			return pacientes.stream().map(Paciente::getNome).toArray(String[]::new);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Pacientes.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	private void agendarConsulta() {
		try {
			Consulta consulta = new Consulta();
			//TODO: FAZER A LOGICA DE VERIFICACAO DAS DATAS
			consulta.setData(this.txtData.getText());
			consulta.setHorario(this.txtHorario.getText());
			consulta.setMedico(medicos.get(cbMedicos.getSelectedIndex()));
			consulta.setPaciente(pacientes.get(cbPacientes.getSelectedIndex()));
			//TODO: consulta.setPago(rootPaneCheckingEnabled);
			
			consultaService.cadastrar(consulta);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo médico.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public Agendamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agendar consulta\r\n");
		lblNewLabel.setBounds(10, 11, 123, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Medico\r\n");
		lblNewLabel_1.setBounds(10, 46, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Paciente\r\n");
		lblNewLabel_2.setBounds(10, 85, 54, 14);
		contentPane.add(lblNewLabel_2);
		
		cbMedicos = new JComboBox();
		cbMedicos.setModel(new DefaultComboBoxModel(buscarTodosMedicos()));
		cbMedicos.setBounds(66, 43, 255, 20);
		contentPane.add(cbMedicos);
		
		cbPacientes = new JComboBox();
		cbPacientes.setModel(new DefaultComboBoxModel(buscarTodosPacientes()));
		cbPacientes.setBounds(66, 82, 255, 20);
		contentPane.add(cbPacientes);
		
		JLabel lblNewLabel_3 = new JLabel("Data ");
		lblNewLabel_3.setBounds(10, 128, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Horário");
		lblNewLabel_4.setBounds(10, 151, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtData = new JFormattedTextField();
		txtData.setBounds(59, 125, 65, 20);
		contentPane.add(txtData);
		
		txtHorario = new JFormattedTextField();
		txtHorario.setBounds(59, 148, 65, 20);
		contentPane.add(txtHorario);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendarConsulta();
			}
		});
		btnNewButton.setBounds(147, 128, 174, 37);
		contentPane.add(btnNewButton);
	}

}
