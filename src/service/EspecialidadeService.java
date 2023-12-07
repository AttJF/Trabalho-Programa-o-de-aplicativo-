package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.EspecialidadeDAO;
import entities.Especialidade;

public class EspecialidadeService {
		
	public List<Especialidade> buscarTodos() throws SQLException, IOException {
		try {
		Connection conn = BancoDados.conectar();

		return new EspecialidadeDAO(conn).buscarTodos();
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public Especialidade buscarPorId(int id) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			return new EspecialidadeDAO(conn).buscarPorId(id);
		} finally {
			BancoDados.desconectar();
		}		
	}
	
	public void cadastrar(Especialidade especialidade) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			new EspecialidadeDAO(conn).cadastrar(especialidade);
			 validacao.verificaNaoVazio(especialidade.getNome());
			 validacao.verificaNaoVazio(especialidade.getCodigo());
			 
			 
		} finally {
			BancoDados.desconectar();
		}		
	}
}
