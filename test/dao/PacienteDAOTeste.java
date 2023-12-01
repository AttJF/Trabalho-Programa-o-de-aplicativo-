package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Endereco;
import entities.FormaDePagamento;
import entities.Paciente;

public class PacienteDAOTeste {

	public static void cadastrarTeste() throws SQLException, IOException {
		String nome = "Vinicius";
		String telefone = "(42)99999-9999";
		String dataNascimento = "01/01/2000";
		String sexo = "Masculino";
		FormaDePagamento formaPagamento = FormaDePagamento.Cartao;
		String bairro = "Jd Carvalho";
		String cidade = "Ponta Grossa";
		String complemento = "Casa";
		int numero = 1000;
		String rua = "Monteiro Lobato";
		String UF = "PR";
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUniaoFederativa(UF);
		//endereco.setId(idEndereco);
		
		Paciente paciente = new Paciente();
		paciente.setDataNascimento(dataNascimento);
		paciente.setEndereco(endereco);
		paciente.setFormaPagamento(formaPagamento);
		//paciente.setId(id);
		paciente.setNome(nome);
		paciente.setSexo(sexo);
		paciente.setTelefone(telefone);
		
		Connection conn = BancoDados.conectar();
		new PacienteDAO(conn).cadastrar(paciente);
		System.out.println("Paciente cadastrado com sucesso");
	}
	
	public static void editarTeste() throws SQLException, IOException {
		int id = 0;
		String nome = "Vinicius";
		String telefone = "(42)99999-9999";
		String dataNascimento = "01/01/2000";
		String sexo = "Masculino";
		FormaDePagamento formaPagamento = FormaDePagamento.Cartao;
		int idEndereco = 0;
		String bairro = "Jd Carvalho";
		String cidade = "Ponta Grossa";
		String complemento = "Casa";
		int numero = 1000;
		String rua = "Monteiro Lobato";
		String UF = "PR";
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUniaoFederativa(UF);
		endereco.setId(idEndereco);
		
		Paciente paciente = new Paciente();
		paciente.setDataNascimento(dataNascimento);
		paciente.setEndereco(endereco);
		paciente.setFormaPagamento(formaPagamento);
		paciente.setId(id);
		paciente.setNome(nome);
		paciente.setSexo(sexo);
		paciente.setTelefone(telefone);
		
		Connection conn = BancoDados.conectar();
		new PacienteDAO(conn).editar(paciente);
		System.out.println("Paciente atualizado com sucesso");
	}
	
	public static void buscarPorIdTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		Paciente paciente = new PacienteDAO(conn).buscarPorId(id);
		
		if(paciente != null) {
			System.out.println(paciente);
		}
		else {
			System.out.println("Nenhum registro encontrado");
		}
	}
	
	public static void buscarPorNomeTeste() throws SQLException, IOException {
		String nome = "Vinicius";
		
		Connection conn = BancoDados.conectar();
		List<Paciente> listaPacientes = new PacienteDAO(conn).buscarPorNome(nome);
		
		for(Paciente paciente : listaPacientes) {
			System.out.println(paciente);
		}
	}
	
	public static void buscarTodosTeste() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<Paciente> listaPacientes = new PacienteDAO(conn).buscarTodos();
		
		for(Paciente paciente : listaPacientes) {
			System.out.println(paciente);
		}
	}
	
	public static void main(String[] args) {
		try {
			cadastrarTeste();
			cadastrarTeste();
			editarTeste();
			buscarPorIdTeste();
			buscarPorNomeTeste();
			buscarTodosTeste();
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
	}
}
