package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import dao.ConsultaDAO;
import entities.Consulta;

public class ConsultaService {
	public void cadastrar(Consulta consulta) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
		
			new ConsultaDAO(conn).cadastrar(consulta);
		} finally {
			BancoDados.desconectar();
		}
	}
}
