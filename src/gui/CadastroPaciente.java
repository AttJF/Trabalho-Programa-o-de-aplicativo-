package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.Endereco;
import entities.FormaDePagamento;
import entities.Paciente;
import service.EnderecoService;
import service.PacienteService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class CadastroPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNome;
	private JTextField txtUf;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JFormattedTextField txtTelefone;
	private JEditorPane txtComplemento;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JRadioButton rbOutro;
	private JSpinner diaNascimento;
	private JSpinner mesNascimento;
	private JSpinner anoNascimento;
	private JComboBox cbFormasPagamento;

	/**
	 * Launch the application.
	 */
	
	PacienteService pacienteService = new PacienteService();
	EnderecoService enderecoService = new EnderecoService();
	byte[] imagemEmBytes;
	
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
	
	private void buscarFoto() {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolher Foto");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();

            try (FileInputStream fis = new FileInputStream(arquivoSelecionado)) {
            	imagemEmBytes = new byte[(int) arquivoSelecionado.length()];
                fis.read(imagemEmBytes);

                System.out.println("Tamanho da imagem em bytes: " + imagemEmBytes.length);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao processar Imagem", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
		
	}
	
	private String[] formasDePagamento() {
		return Arrays.stream(FormaDePagamento.values())
                .map(Enum::name)
                .toArray(String[]::new);
	}
	
	private void cadastrarPaciente() {
		try {
			Paciente paciente = new Paciente();
			Endereco endereco = new Endereco();
			
			endereco.setBairro(this.txtBairro.getText());
			endereco.setCidade(this.txtCidade.getText());
			endereco.setComplemento(this.txtComplemento.getText());
			endereco.setNumero(Integer.parseInt(this.txtNumero.getText()));
			endereco.setRua(this.txtRua.getText());
			endereco.setUniaoFederativa(this.txtUf.getText());
			
			this.enderecoService.cadastrar(endereco);
			
			String str = this.diaNascimento.getValue().toString() + "/" + this.mesNascimento.getValue().toString() + "/" + this.anoNascimento.getValue().toString();
			paciente.setDataNascimento(str);
			paciente.setEndereco(endereco);
			paciente.setFormaPagamento(FormaDePagamento.values()[cbFormasPagamento.getSelectedIndex()]);
			paciente.setNome(this.txtNome.getText());
			paciente.setSexo(verificarSelecaoRadioButtonSexo());
			paciente.setTelefone(this.txtTelefone.getText());
			paciente.setFoto(imagemEmBytes);
			
			this.pacienteService.cadastrar(paciente);
			System.out.println(paciente);

		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private String verificarSelecaoRadioButtonSexo() {

		if (this.rbMasculino.isSelected()) {
			return this.rbMasculino.getText();
		} else if (this.rbFeminino.isSelected()) {
			return this.rbFeminino.getText();
		} else {
			return this.rbOutro.getText();
		}
	}

	/**
	 * Create the frame.
	 */
	public CadastroPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Paciente");
		lblNewLabel_1.setBounds(10, 0, 168, 30);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 28, 389, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(139, 96, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		diaNascimento = new JSpinner();
		diaNascimento.setBounds(265, 93, 47, 20);
		contentPane.add(diaNascimento);
		
		mesNascimento = new JSpinner();
		mesNascimento.setBounds(322, 93, 46, 20);
		contentPane.add(mesNascimento);
		
		anoNascimento = new JSpinner();
		anoNascimento.setBounds(378, 93, 77, 20);
		contentPane.add(anoNascimento);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 82, 116, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(6, 21, 109, 23);
		panel.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(6, 45, 109, 23);
		panel.add(rbFeminino);
		
		rbOutro = new JRadioButton("Outro");
		rbOutro.setBounds(6, 71, 109, 23);
		panel.add(rbOutro);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(36, 2, 40, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPaciente();
			}
		});
		btnNewButton.setBounds(186, 379, 108, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setBounds(139, 133, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(196, 130, 259, 20);
		contentPane.add(txtTelefone);
		
		JButton btnFoto = new JButton("Carregar photo");
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarFoto();
			}
		});
		btnFoto.setBounds(139, 158, 316, 23);
		contentPane.add(btnFoto);
		
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
		
		txtUf = new JTextField();
		txtUf.setBounds(118, 229, 46, 20);
		contentPane.add(txtUf);
		txtUf.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(209, 229, 149, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 192, 1, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 192, 454, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_10 = new JLabel("Rua\r\n");
		lblNewLabel_10.setBounds(270, 263, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		txtRua = new JTextField();
		txtRua.setBounds(299, 260, 165, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(10, 263, 51, 14);
		contentPane.add(lblNewLabel_11);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(52, 260, 203, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Numero\r\n");
		lblNewLabel_12.setBounds(367, 232, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(413, 229, 51, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Complemento\r\n");
		lblNewLabel_13.setBounds(10, 302, 93, 14);
		contentPane.add(lblNewLabel_13);
		
		txtComplemento = new JEditorPane();
		txtComplemento.setBounds(110, 288, 354, 51);
		contentPane.add(txtComplemento);
		
		JLabel lblNewLabel_5 = new JLabel("Forma de Pagamento");
		lblNewLabel_5.setBounds(10, 57, 148, 14);
		contentPane.add(lblNewLabel_5);
		
		cbFormasPagamento = new JComboBox();
		cbFormasPagamento.setModel(new DefaultComboBoxModel(formasDePagamento()));
		cbFormasPagamento.setBounds(142, 55, 313, 22);
		contentPane.add(cbFormasPagamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 350, 457, 2);
		contentPane.add(separator);
	}
}
