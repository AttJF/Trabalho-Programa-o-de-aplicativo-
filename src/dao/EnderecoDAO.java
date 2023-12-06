package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Endereco;

public class EnderecoDAO {
	
	private Connection conn;
	
	public EnderecoDAO(Connection conn) {
		this.conn = conn;
	}

	public Endereco buscarPorId(int id) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from endereco where IDendereco = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Endereco endereco = new Endereco();

				endereco.setId(rs.getInt("IDendereco"));
				endereco.setRua(rs.getString("rua"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setUniaoFederativa(rs.getString("uniaofederativa"));
				
				return endereco;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public void atualizar(Endereco endereco) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("update endereco set rua = ?, bairro = ?, cidade = ?, complemento = ?, numero = ?, uniaofederativa = ? where IDendereco = ?");

			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getComplemento());
			ps.setInt(5, endereco.getNumero());
			ps.setString(6, endereco.getUniaoFederativa());
			ps.setInt(7, endereco.getId());

			ps.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
	
	public void cadastrar(Endereco endereco) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("insert into endereco (rua, bairro, cidade, complemento, numero, uniaofederativa) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getComplemento());
			ps.setInt(5, endereco.getNumero());
			ps.setString(6, endereco.getUniaoFederativa());

			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if (rs.next()) endereco.setId(rs.getInt(1));
	        
		} finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int id) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("delete from endereco where IDendereco = ?");
			ps.setInt(1, id);
			int linhasManipuladas = ps.executeUpdate();
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
}
