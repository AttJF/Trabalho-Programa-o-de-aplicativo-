package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.PedidoExameDAO;
import entities.Exame;
import entities.Paciente;
import entities.PedidoExame;

public class PedidoExameService {
	public void cadastrar(PedidoExame pedidoExame) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			new PedidoExameDAO(conn).cadastrar(pedidoExame);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<PedidoExame> buscarTodosPorPaciente(Paciente paciente) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			return new PedidoExameDAO(conn).buscarTodosPorPaciente(paciente.getId());
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<PedidoExame> buscarTodosPorExame(Exame exame) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			return new PedidoExameDAO(conn).buscarTodosPorExame(exame.getIdExame());
		} finally {
			BancoDados.desconectar();
		}
	}
}
