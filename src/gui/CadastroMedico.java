package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Endereco;
import entities.Especialidade;
import entities.Medico;
import entities.Paciente;
import service.EnderecoService;
import service.EspecialidadeService;
import service.MedicoService;
import service.PacienteService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastroMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNome;
	/**
	 * @wbp.nonvisual location=-40,359
	 */
	private final JSeparator separator = new JSeparator();
	private JTextField txtCrm;
	private JTextField txtUf;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JEditorPane txtComplemento;
	private JFormattedTextField txtTelefone;
	private JComboBox cbEspecialidades;

	/**
	 * Launch the application.
	 */
	
	MedicoService medicoService = new MedicoService();
	EnderecoService enderecoService = new EnderecoService();
	EspecialidadeService especialidadeService = new EspecialidadeService();
	List<Especialidade> especialidades;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMedico frame = new CadastroMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String[] buscarTodasEspecialidades() {
		try {
			especialidades = especialidadeService.buscarTodos();
			return especialidades.stream().map(Especialidade::getNome).toArray(String[]::new);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao buscar Especialidades.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	private void cadastrarMedico() {
		try {
			Medico medico = new Medico();
			Endereco endereco = new Endereco();
			
			endereco.setBairro(this.txtBairro.getText());
			endereco.setCidade(this.txtCidade.getText());
			endereco.setComplemento(this.txtComplemento.getText());
			endereco.setNumero(Integer.parseInt(this.txtNumero.getText()));
			endereco.setRua(this.txtRua.getText());
			endereco.setUniaoFederativa(this.txtUf.getText());
			
			this.enderecoService.cadastrar(endereco);
			
			medico.setEndereco(endereco);
			medico.setNome(this.txtNome.getText());
			medico.setTelefone(this.txtTelefone.getText());
			medico.setCRM(Integer.parseInt(this.txtCrm.getText()));
			medico.setEspecialidade(especialidades.get(cbEspecialidades.getSelectedIndex()));
			
			this.medicoService.cadastrar(medico);
			System.out.println(medico.toString());
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo médico.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public CadastroMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Medico");
		lblNewLabel_1.setBounds(10, 0, 168, 30);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(49, 47, 404, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarMedico();
			}
		});
		btnNewButton.setBounds(168, 387, 130, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone :");
		lblNewLabel_4.setBounds(10, 81, 60, 14);
		contentPane.add(lblNewLabel_4);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(68, 78, 385, 20);
		contentPane.add(txtTelefone);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 301, 454, 4);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("Registro do Conselho Federal de Medicina");
		lblNewLabel_5.setBounds(10, 316, 204, 14);
		contentPane.add(lblNewLabel_5);
		
		txtCrm = new JTextField();
		txtCrm.setBounds(223, 316, 241, 20);
		contentPane.add(txtCrm);
		txtCrm.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Endereço\r\n");
		lblNewLabel_6.setBounds(10, 120, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cidade\r\n");
		lblNewLabel_7.setBounds(168, 145, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Unidade federativa\r\n");
		lblNewLabel_8.setBounds(10, 145, 106, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(186, 239, 46, 0);
		contentPane.add(lblNewLabel_9);
		
		txtUf = new JTextField();
		txtUf.setBounds(112, 142, 42, 20);
		contentPane.add(txtUf);
		txtUf.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(206, 142, 149, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 192, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(20, 109, 454, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_10 = new JLabel("Rua\r\n");
		lblNewLabel_10.setBounds(10, 205, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		txtRua = new JTextField();
		txtRua.setBounds(49, 200, 415, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(10, 174, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(48, 170, 416, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Número\r\n");
		lblNewLabel_12.setBounds(365, 145, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(413, 142, 51, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Complemento\r\n");
		lblNewLabel_13.setBounds(10, 250, 71, 14);
		contentPane.add(lblNewLabel_13);
		
		txtComplemento = new JEditorPane();
		txtComplemento.setBounds(91, 239, 373, 51);
		contentPane.add(txtComplemento);
		
		JLabel lblNewLabel_14 = new JLabel("Especialidade");
		lblNewLabel_14.setBounds(10, 352, 88, 14);
		contentPane.add(lblNewLabel_14);
		
		cbEspecialidades = new JComboBox();
		cbEspecialidades.setModel(new DefaultComboBoxModel(buscarTodasEspecialidades()));
		cbEspecialidades.setBounds(100, 348, 364, 22);
		contentPane.add(cbEspecialidades);
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
}
