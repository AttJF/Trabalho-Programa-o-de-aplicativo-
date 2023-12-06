package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Consulta;
import entities.Exame;
import entities.Medico;
import entities.Paciente;
import entities.PedidoExame;
import service.ConsultaService;
import service.ExameService;
import service.MedicoService;
import service.PacienteService;
import service.PedidoExameService;
import utils.FileHandler;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class HistoricoPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JComboBox cbPacientes;
	
	/**
	 * Launch the application.
	 */
	
	ConsultaService consultaService = new ConsultaService();
	PedidoExameService pedidoExameService = new PedidoExameService();
	PacienteService pacienteService = new PacienteService();
	List<Paciente> pacientes;
	List<Consulta> consultas;
	List<PedidoExame> pedidoExames;
	
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
	
	private void preencherTabelas() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    
	    if(consultas != null)
		    for (Consulta consulta : consultas) {
		        Object[] rowData = {consulta.getData(), consulta.getHorario(), consulta.getMedico().getNome()};
		        model.addRow(rowData);
		    }

	    DefaultTableModel modelExames = (DefaultTableModel) table_1.getModel();
	    modelExames.setRowCount(0);
	    
	    if(pedidoExames != null)
		    for (PedidoExame pedido : pedidoExames) {
		        Object[] rowData = {pedido.getDataRealizacao(), pedido.getMedico().getNome(), pedido.getExame().getNomeExame()};
		        modelExames.addRow(rowData);
		    }
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
	
	private void buscarDados() {
		try {
			consultas = consultaService.buscarTodosPorPaciente(pacientes.get(cbPacientes.getSelectedIndex()));
			pedidoExames = pedidoExameService.buscarTodosPorPaciente(pacientes.get(cbPacientes.getSelectedIndex()));
		} catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Consultas/Exames", "Histórico", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void gerarArquivo() {
		try {
			new FileHandler<PedidoExame>().salvarArquivo(pedidoExames, "historico_paciente_exames");
			new FileHandler<Consulta>().salvarArquivo(consultas, "historico_paciente_consultas");
			
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo.", "Histórico", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public HistoricoPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		cbPacientes = new JComboBox();
		cbPacientes.setModel(new DefaultComboBoxModel(buscarTodosPacientes()));
		cbPacientes.setBounds(50, 8, 317, 20);
		contentPane.add(cbPacientes);
		
		JLabel lblNewLabel_1 = new JLabel("Exames\r\n");
		lblNewLabel_1.setBounds(219, 181, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Consultas\r\n");
		lblNewLabel_2.setBounds(219, 37, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 471, 108);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Hora", "Medico"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 202, 460, 121);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Hora", "Exame"
			}
		));
		
		JButton btnNewButton = new JButton("Gerar Arquivo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarArquivo();
			}
		});
		btnNewButton.setBounds(185, 367, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarDados();
				preencherTabelas();
			}
		});
		btnNewButton_1.setBounds(392, 7, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
