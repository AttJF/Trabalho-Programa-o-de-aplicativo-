package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Especialidade;

public class EspecialidadeDAO {
	
	private Connection conn;
	
	public EspecialidadeDAO(Connection conn) {
		this.conn = conn;
	}
	
	public Especialidade buscarPorId(int id) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from especialidade where IDespecialidade = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Especialidade especialidade = new Especialidade();
				
				especialidade.setNomeEspecialidade(rs.getString("nome"));
				especialidade.setId(rs.getInt("IDespecialidade"));
				
				return especialidade;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public void atualizar(Especialidade especialidade) throws SQLException {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update especialidade set nome = ? where IDendereco = ?");

			ps.setString(1, especialidade.getNomeEspecialidade());
			ps.setInt(2, especialidade.getIdEspecialidade());

			ps.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
	
	public void cadastrar(Especialidade especialidade) throws SQLException {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("insert into especialidade (IDespecialidade, nome) values (?, ?)");

			ps.setString(1, especialidade.getNomeEspecialidade());
			ps.setInt(2, especialidade.getIdEspecialidade());

			ps.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int id) throws SQLException {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("delete from especialidade where IDespecialidade = ?");
			ps.setInt(1, id);
			int linhasManipuladas = ps.executeUpdate();
			return linhasManipuladas;
		}
		finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
}
