package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.EspecialidadeDAO;
import dao.ExameDAO;
import entities.Especialidade;
import entities.Exame;

public class ExameService {
	public void cadastrar(Exame exame) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			new ExameDAO(conn).cadastrar(exame);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<Exame> buscarTodos() throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			return new ExameDAO(conn).buscarTodos();
		} finally {
			BancoDados.desconectar();
		}		
	}
}
