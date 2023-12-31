package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Especialidade;
import entities.FormaDePagamento;
import entities.Paciente;

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
				
				especialidade.setNome(rs.getString("nome"));
				especialidade.setId(rs.getInt("IDespecialidade"));
				especialidade.setCodigo(rs.getString("codigo"));
				
				return especialidade;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public List<Especialidade> buscarTodos() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Especialidade> listaEspecialidades = new ArrayList<>();

		try {
			ps = conn.prepareStatement("select * from especialidade order by nome");
			rs = ps.executeQuery();

			while (rs.next()) {
				Especialidade especialidade = new Especialidade();

				especialidade.setId(rs.getInt("IDespecialidade"));
				especialidade.setNome(rs.getString("nome"));
				especialidade.setCodigo(rs.getString("codigo"));
				
				listaEspecialidades.add(especialidade);
			}

			return listaEspecialidades;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public void atualizar(Especialidade especialidade) throws SQLException {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update especialidade set nome = ?, codigo = ? where IDendereco = ?");

			ps.setString(1, especialidade.getNome());
			ps.setInt(2, especialidade.getId());
			ps.setString(3, especialidade.getCodigo());

			ps.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	
	public void cadastrar(Especialidade especialidade) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("insert into especialidade (nome, codigo) values (?, ?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, especialidade.getNome());
			ps.setString(2, especialidade.getCodigo());

			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if (rs.next()) especialidade.setId(rs.getInt(1));

		} finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(ps);
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
		}
	}
}
