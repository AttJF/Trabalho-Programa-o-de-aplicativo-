package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Consulta;
import entities.Exame;
import entities.Medico;
import entities.PedidoExame;
import service.ConsultaService;
import service.ExameService;
import service.MedicoService;
import service.PedidoExameService;
import utils.FileHandler;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AgendaExame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JComboBox cbExames;

	/**
	 * Launch the application.
	 */
	
	ExameService exameService = new ExameService();
	PedidoExameService pedidoExameService = new PedidoExameService();
	List<Exame> exames;
	List<PedidoExame> pedidoExames;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaExame frame = new AgendaExame();
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

	    if (exames != null) {
	        for (PedidoExame pedidoExame : pedidoExames) {
	            model.addRow(new Object[]{
	            		pedidoExame.getPaciente().getNome(),
	            		pedidoExame.getMedico().getNome(),
	            		pedidoExame.getDataRealizacao(),
	            });
	        }
	    }
	}
	
	private String[] buscarTodosExames() {
		try {
			exames = exameService.buscarTodos();
			return exames.stream().map(Exame::getNomeExame).toArray(String[]::new);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Pacientes.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	private void buscarDados() {
		try {
			pedidoExames = pedidoExameService.buscarTodosPorExame(exames.get(cbExames.getSelectedIndex()));
		} catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Exames", "Histórico", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void gerarArquivo() {
		try {
			new FileHandler<PedidoExame>().salvarArquivo(pedidoExames, "agendaExame");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo.", "Histórico", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public AgendaExame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Exame");
		lblNewLabel.setBounds(10, 22, 55, 14);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 414, 193);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paciente", "Médico", "Data"
			}
		));
		
		cbExames = new JComboBox();
		cbExames.setModel(new DefaultComboBoxModel(buscarTodosExames()));
		cbExames.setBounds(75, 18, 238, 22);
		contentPane.add(cbExames);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarDados();
				preencherTabelas();
			}
		});
		btnNewButton.setBounds(335, 18, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gerar Arquivo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarArquivo();
			}
		});
		btnNewButton_1.setBounds(151, 274, 137, 23);
		contentPane.add(btnNewButton_1);
	}
}
