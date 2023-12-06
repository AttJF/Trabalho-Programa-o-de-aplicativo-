package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import entities.PedidoExame;
import service.ConsultaService;
import service.MedicoService;
import service.PacienteService;
import service.PedidoExameService;
import utils.FileHandler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AgendaMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;
	private JComboBox cbMedicos;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	
	ConsultaService consultaService = new ConsultaService();
	MedicoService medicoService = new MedicoService();
	List<Medico> medicos;
	List<Consulta> consultas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaMedico frame = new AgendaMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void preencherTabelas() {
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	    model.setRowCount(0);

	    if (consultas != null) {
	        for (Consulta consulta : consultas) {
	            model.addRow(new Object[]{
	                    consulta.getPaciente().getNome(),
	                    consulta.getData(),
	                    consulta.getHorario()
	            });
	        }
	    }
	}
	
	private String[] buscarTodosMedicos() {
		try {
			medicos = medicoService.buscarTodos();
			return medicos.stream().map(Medico::getNome).toArray(String[]::new);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Pacientes.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	private void buscarDados() {
		try {
			consultas = consultaService.buscarTodos(medicos.get(cbMedicos.getSelectedIndex()));
		} catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Consultas/Exames", "Histórico", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void gerarArquivo() {
		try {
			new FileHandler<Consulta>().salvarArquivo(consultas, "agenda_medico");
			
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo.", "Histórico", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public AgendaMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Médico\r\n");
		lblNewLabel.setBounds(10, 22, 58, 14);
		contentPane.add(lblNewLabel);
		
		cbMedicos = new JComboBox();
		cbMedicos.setModel(new DefaultComboBoxModel(buscarTodosMedicos()));
		cbMedicos.setBounds(78, 18, 229, 22);
		contentPane.add(cbMedicos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 420, 230);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paciente", "Data", "Hor\u00E1rio"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(2).setResizable(false);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarDados();
				preencherTabelas();
			}
		});
		btnNewButton.setBounds(341, 18, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Gerar Arquivo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarArquivo();
			}
		});
		btnNewButton_2.setBounds(151, 298, 141, 23);
		contentPane.add(btnNewButton_2);
	}
}
