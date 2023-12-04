package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Especialidade;

public class EspecialidadeDAOTeste {

	public static void buscarPorIdTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		Especialidade especialidade = new EspecialidadeDAO(conn).buscarPorId(id);
		
		if(especialidade != null) {
			System.out.println(especialidade);
		}
		else {
			System.out.println("Especialidade não encontrada");
		}
	}
	
	public static void atualizarTeste() throws SQLException, IOException {
		int id = 0;
		String nome = "Cardiologista";
		
		Especialidade especialidade = new Especialidade();
		especialidade.setId(id);
		especialidade.setNomeEspecialidade(nome);
		
		Connection conn = BancoDados.conectar();
		new EspecialidadeDAO(conn).atualizar(especialidade);
		System.out.println("Especialidade atualizada com sucesso");
	}
	
	public static void cadastrarTeste() throws SQLException, IOException {
		String nome = "Pediatra";
		
		Especialidade especialidade = new Especialidade();
		//especialidade.setId(id);
		especialidade.setNomeEspecialidade(nome);
		
		Connection conn = BancoDados.conectar();
		new EspecialidadeDAO(conn).cadastrar(especialidade);
		System.out.println("Especialidade cadastrada com sucesso");
	}
	
	public static void excluirTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new EspecialidadeDAO(conn).excluir(id);
		
		if(linhasManipuladas > 0) {
			System.out.println("Especialidade excluída com sucesso");
		}
		else {
			System.out.println("Nenhum registro encontrado");
		}
	}
	
	public static void main(String[] args) {
		try {
			cadastrarTeste();
			atualizarTeste();
			buscarPorIdTeste();
			excluirTeste();
		}
		catch (IOException | SQLException e) {
			e.getMessage();
		}
	}
}
