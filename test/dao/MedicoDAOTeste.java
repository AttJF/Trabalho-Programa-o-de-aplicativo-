package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Endereco;
import entities.Especialidade;
import entities.Medico;

public class MedicoDAOTeste {

	public static void cadastrarTeste() throws SQLException, IOException {
		int crm = 123;
		String nome = "Danilo";
		String nomeEspecialidade = "Pediatra";
		String telefone = "(42)99999-9999";
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
		//endereco.setId(id);
		
		Especialidade especialidade = new Especialidade();
		especialidade.setNome(nomeEspecialidade);
		//especialidade.setId(id);
		
		Medico medico = new Medico();
		medico.setCRM(crm);
		medico.setEndereco(endereco);
		medico.setEspecialidade(especialidade);
		//medico.setId(id);
		medico.setNome(nome);
		medico.setTelefone(telefone);
		
		Connection conn = BancoDados.conectar();
		new MedicoDAO(conn).cadastrar(medico);
		System.out.println("Médico cadastrado com sucesso");
	}
	
	public static void editarTeste() throws SQLException, IOException {
		int crm = 123;
		String nome = "Danilo";
		String nomeEspecialidade = "Pediatra";
		String telefone = "(42)99999-9999";
		String bairro = "Jd Carvalho";
		String cidade = "Ponta Grossa";
		String complemento = "Casa";
		int numero = 1000;
		String rua = "Monteiro Lobato";
		String UF = "PR";
		int id = 0;
		int idEspecialidade = 0;
		int idEndereco = 0;
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUniaoFederativa(UF);
		endereco.setId(idEndereco);
		
		Especialidade especialidade = new Especialidade();
		especialidade.setNome(nomeEspecialidade);
		especialidade.setId(idEspecialidade);
		
		Medico medico = new Medico();
		medico.setCRM(crm);
		medico.setEndereco(endereco);
		medico.setEspecialidade(especialidade);
		medico.setId(id);
		medico.setNome(nome);
		medico.setTelefone(telefone);
		
		Connection conn = BancoDados.conectar();
		new MedicoDAO(conn).editar(medico);
		System.out.println("Médico atualizado com sucesso");
	}
	
	public static void excluirTeste() throws SQLException, IOException {
		int id = 0;
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new MedicoDAO(conn).excluir(id);
		
		if(linhasManipuladas > 0) {
			System.out.println("Médico excluído com sucesso");
		}
		else {
			System.out.println("Nenhum registro encontrado");
		}
	}
	
	public static void buscarPorIdTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		Medico medico = new MedicoDAO(conn).buscarPorId(id);
		
		if(medico != null) {
			System.out.println(medico);
		}
		else {
			System.out.println("Nenhum registro encontrado");
		}
	}
	
	public static void buscarPorNomeTeste() throws SQLException, IOException {
		String nome = "Vinicius";
		
		Connection conn = BancoDados.conectar();
		List<Medico> listaMedicos = new MedicoDAO(conn).buscarPorNome(nome);
		
		for(Medico medico : listaMedicos) {
			System.out.println(medico);
		}
	}
	
	public static void buscarTodosTeste() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<Medico> listaMedicos = new MedicoDAO(conn).buscarTodos();
		
		for(Medico medico : listaMedicos) {
			System.out.println(medico);
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
			excluirTeste();
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
	}
}
