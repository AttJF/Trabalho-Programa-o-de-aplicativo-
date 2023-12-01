package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Exame;

public class ExameDAOTeste {

	public static void buscarPorIdTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		Exame exame = new ExameDAO(conn).buscarPorId(id);
		
		if(exame != null) {
			System.out.println(exame);
		}
		else {
			System.out.println("Nenhum exame encontrado");
		}
	}
	
	public static void cadastrarTeste() throws SQLException, IOException {
		double custo = 100;
		String nome = "Raio X";
		String orientacoes = "Tomar cuidado";
		
		Exame exame = new Exame();
		exame.setCustoExame(custo);
		//exame.setIdExame(id);
		exame.setNomeExame(nome);
		exame.setOrientacoes(orientacoes);
		
		Connection conn = BancoDados.conectar();
		new ExameDAO(conn).cadastrar(exame);
		System.out.println("Exame cadastrado com sucesso");
	}
	
	public static void main(String[] args) {
		try {
			cadastrarTeste();
			buscarPorIdTeste();
		} catch (IOException | SQLException e) {
			e.getMessage();
		}
		
	}
}
