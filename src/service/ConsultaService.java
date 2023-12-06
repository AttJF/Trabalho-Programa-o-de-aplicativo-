package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ConsultaDAO;
import entities.Consulta;
import entities.Medico;
import entities.Paciente;

public class ConsultaService {
	public void cadastrar(Consulta consulta) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
		
			new ConsultaDAO(conn).cadastrar(consulta);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public  List<Consulta> buscarTodos(Medico medico) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
		
			return new ConsultaDAO(conn).buscarTodosPorMedico(medico.getId());
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<Consulta> buscarTodosPorPaciente(Paciente paciente) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
		
			return new ConsultaDAO(conn).buscarTodosPorPaciente(paciente.getId());
		} finally {
			BancoDados.desconectar();
		}
	}
}
