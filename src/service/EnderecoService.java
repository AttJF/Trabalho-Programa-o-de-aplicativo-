package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import dao.EnderecoDAO;
import entities.Endereco;

public class EnderecoService {
	public void cadastrar(Endereco endereco) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		new EnderecoDAO(conn).cadastrar(endereco);
	}
}
