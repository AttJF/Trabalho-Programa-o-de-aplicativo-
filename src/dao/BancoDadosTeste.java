package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Endereco;

public class BancoDadosTeste {

	public static void main(String[] args) {
		try {
			Connection conn = BancoDados.conectar();
			System.out.println("Conexão estabelecida com sucesso!");
		
			BancoDados.desconectar();
			System.out.println("Conexão finalizada com sucesso.");
		}
		catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
