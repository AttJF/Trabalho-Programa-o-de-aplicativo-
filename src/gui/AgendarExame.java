package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Endereco;
import entities.Especialidade;
import entities.Exame;
import entities.Medico;
import entities.Paciente;
import entities.PedidoExame;
import service.ExameService;
import service.MedicoService;
import service.PacienteService;
import service.PedidoExameService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AgendarExame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cbExames;
	private JComboBox cbMedicos;
	private JComboBox cbPacientes;
	private JFormattedTextField txtData;
	private JFormattedTextField txtHorario;
	

	/**
	 * Launch the application.
	 */
	
	PedidoExameService pedidoExameService = new PedidoExameService();
	MedicoService medicoService = new MedicoService();
	PacienteService pacienteService = new PacienteService();
	ExameService exameService = new ExameService();
	List<Exame> exames;
	List<Medico> medicos;
	List<Paciente> pacientes;
	
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
	
	private String[] buscarTodosExames() {
		try {
			exames = exameService.buscarTodos();
			return exames.stream().map(Exame::getNomeExame).toArray(String[]::new);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Exames.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
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
	
	private void agendarNovoExame() {
		try {
			PedidoExame pedidoExame = new PedidoExame();
			
			pedidoExame.setDataRealizacao(this.txtData.getText() + this.txtHorario.getText());
			pedidoExame.setExame(exames.get(cbExames.getSelectedIndex()));
			pedidoExame.setMedico(medicos.get(cbMedicos.getSelectedIndex()));
			pedidoExame.setPaciente(pacientes.get(cbPacientes.getSelectedIndex()));
			pedidoExame.setValorPago(exames.get(cbExames.getSelectedIndex()).getCustoExame());
			
			pedidoExameService.cadastrar(pedidoExame);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo médico.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public AgendarExame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 267);
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
		
		JLabel lblNewLabel_3 = new JLabel("Data ");
		lblNewLabel_3.setBounds(10, 181, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hora\r\n");
		lblNewLabel_4.setBounds(107, 181, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtData = new JFormattedTextField();
		txtData.setBounds(43, 178, 54, 20);
		contentPane.add(txtData);
		
		txtHorario = new JFormattedTextField();
		txtHorario.setBounds(156, 178, 60, 20);
		contentPane.add(txtHorario);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendarNovoExame();
			}
		});
		btnNewButton.setBounds(226, 162, 89, 52);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Medico Requisitando Exame\r\n");
		lblNewLabel_5.setBounds(10, 110, 170, 14);
		contentPane.add(lblNewLabel_5);
		
		cbExames = new JComboBox();
		cbExames.setModel(new DefaultComboBoxModel(buscarTodosExames()));
		cbExames.setBounds(58, 42, 257, 22);
		contentPane.add(cbExames);
		
		cbMedicos = new JComboBox();
		cbMedicos.setModel(new DefaultComboBoxModel(buscarTodosMedicos()));
		cbMedicos.setBounds(10, 129, 305, 22);
		contentPane.add(cbMedicos);
		
		cbPacientes = new JComboBox();
		cbPacientes.setModel(new DefaultComboBoxModel(buscarTodosPacientes()));
		cbPacientes.setBounds(58, 81, 257, 22);
		contentPane.add(cbPacientes);
	}
}
