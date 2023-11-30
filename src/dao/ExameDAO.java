package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Exame;

public class ExameDAO {

	private Connection conn;
	
	public ExameDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Exame exame) throws SQLException {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("insert into exame (nome, custo, orientacao) values (?, ?, ?)");

			ps.setString(1, exame.getNomeExame());
			ps.setDouble(2, exame.getCustoExame());
			ps.setString(3, exame.getOrientacoes());

			ps.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	
	public Exame buscarPorId(int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select * from exame where IDexame = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Exame exame = new Exame();
				
				exame.setIdExame(rs.getInt("IDexame"));
				exame.setCustoExame(rs.getDouble("custo"));
				exame.setNomeExame(rs.getString("nome"));
				exame.setOrientacoes(rs.getString("orientacao"));
				
				return exame;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
}
