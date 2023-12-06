package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.MedicoDAO;

import entities.Medico;

public class MedicoService {
	public void cadastrar(Medico medico) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			new MedicoDAO(conn).cadastrar(medico);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<Medico> buscarTodos() throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			return new MedicoDAO(conn).buscarTodos();
		} finally {
			BancoDados.desconectar();
		}
	}
}
