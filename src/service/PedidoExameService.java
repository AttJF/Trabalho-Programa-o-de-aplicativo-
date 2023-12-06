package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import dao.PedidoExameDAO;
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
}
