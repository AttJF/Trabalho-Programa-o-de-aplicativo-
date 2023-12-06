package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.FormaDePagamento;
import entities.Paciente;

public class PacienteDAO {
	
	private Connection conn;
	
	public PacienteDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Paciente paciente) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("insert into paciente (nome, datanascimento, sexo, telefone, formapagamento, IDendereco) values (?, ?, ?, ?, ?, ?)");

			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getDataNascimento());
			ps.setString(3, paciente.getSexo());
			ps.setString(4, paciente.getTelefone());
			ps.setString(5, paciente.getFormaPagamento().toString());
			ps.setInt(6, paciente.getEndereco().getId());

			ps.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	public void editar(Paciente paciente) throws SQLException { 
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("update paciente set nome = ?, datanascimento = ?, sexo = ?, telefone = ?, formapagamento = ?, IDendereco = ? where IDpaciente = ?");
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getDataNascimento());
			ps.setString(3, paciente.getSexo());
			ps.setString(4, paciente.getTelefone());
			ps.setString(5, paciente.getFormaPagamento().toString());
			ps.setInt(6, paciente.getEndereco().getId());
			ps.setInt(7, paciente.getId());

			ps.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	
	public Paciente buscarPorId(int id) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		EnderecoDAO enderecoDao = new EnderecoDAO(conn);

		try {
			st = conn.prepareStatement("select * from paciente where IDpaciente = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Paciente paciente = new Paciente();

				paciente.setId(rs.getInt("IDpaciente"));
				paciente.setNome(rs.getString("nome"));
				paciente.setDataNascimento(rs.getString("datanascimento"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setFormaPagamento(FormaDePagamento.valueOf(rs.getString("formapagamento")));
				paciente.setEndereco(enderecoDao.buscarPorId(rs.getInt("IDendereco")));
				
				return paciente;
			}
			
			return null;
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	
	public List<Paciente> buscarPorNome(String nome) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Paciente> listaPacientes = new ArrayList<>();
		EnderecoDAO enderecoDao = new EnderecoDAO(conn);

		try {
			ps = conn.prepareStatement("select * from paciente where nome = ?");
			ps.setString(1, nome);
			rs = ps.executeQuery();

			while (rs.next()) {
				Paciente paciente = new Paciente();

				paciente.setId(rs.getInt("IDpaciente"));
				paciente.setNome(rs.getString("nome"));
				paciente.setDataNascimento(rs.getString("datanascimento"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setFormaPagamento(FormaDePagamento.valueOf(rs.getString("formapagamento")));
				paciente.setEndereco(enderecoDao.buscarPorId(rs.getInt("IDendereco")));
				
				listaPacientes.add(paciente);
			}

			return listaPacientes;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public List<Paciente> buscarTodos() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Paciente> listaPacientes = new ArrayList<>();
		EnderecoDAO enderecoDao = new EnderecoDAO(conn);

		try {
			ps = conn.prepareStatement("select * from paciente order by nome");
			rs = ps.executeQuery();

			while (rs.next()) {
				Paciente paciente = new Paciente();

				paciente.setId(rs.getInt("IDpaciente"));
				paciente.setNome(rs.getString("nome"));
				paciente.setDataNascimento(rs.getString("datanascimento"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setFormaPagamento(FormaDePagamento.valueOf(rs.getString("formapagamento")));
				paciente.setEndereco(enderecoDao.buscarPorId(rs.getInt("IDendereco")));
				
				listaPacientes.add(paciente);
			}

			return listaPacientes;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
}
