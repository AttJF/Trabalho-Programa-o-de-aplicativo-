package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Medico;

public class MedicoDAO {
	
	private Connection conn;
	
	public MedicoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Medico medico) throws SQLException { 
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("insert into medico (crm, nome, telefone, IDespecialidade, IDendereco) values (?, ?, ?, ?, ?)");

			ps.setInt(1, medico.getCRM());
			ps.setString(2, medico.getNome());
			ps.setString(3, medico.getTelefone());
			ps.setInt(4, medico.getEspecialidade().getId());
			ps.setInt(5, medico.getEndereco().getId());

			ps.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	
	public void editar(Medico medico) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("update medico set  crm = ?, nome = ?, telefone = ? , IDespecialidade = ?, IDendereco = ? where IDmedico = ?");
			ps.setInt(1, medico.getCRM());
			ps.setString(2, medico.getNome());
			ps.setString(3, medico.getTelefone());
			ps.setInt(4, medico.getEspecialidade().getId());
			ps.setInt(5, medico.getEndereco().getId());
			ps.setInt(6, medico.getId());

			ps.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	
	public int excluir(int id) throws SQLException { 
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("delete from medico where IDmedico = ?");
			ps.setInt(1, id);
			int linhasManipuladas = ps.executeUpdate();
			return linhasManipuladas;

		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	
	public Medico buscarPorId(int id) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		EnderecoDAO enderecoDao = new EnderecoDAO(conn);
		EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(conn);

		try {
			st = conn.prepareStatement("select * from medico where IDmedico = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Medico medico = new Medico();

				medico.setId(rs.getInt("IDmedico"));
				medico.setNome(rs.getString("nome"));
				medico.setCRM(rs.getInt("crm"));
				medico.setEspecialidade(especialidadeDAO.buscarPorId(rs.getInt("IDespecialidade")));
				medico.setTelefone(rs.getString("telefone"));
				medico.setEndereco(enderecoDao.buscarPorId(rs.getInt("IDendereco")));
				
				return medico;
			}
			
			return null;
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public List<Medico> buscarPorNome(String nome) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Medico> listaMedicos = new ArrayList<>();
		EnderecoDAO enderecoDao = new EnderecoDAO(conn);
		EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(conn);

		try {
			ps = conn.prepareStatement("select * from medico where nome = ?");
			ps.setString(1, nome);
			rs = ps.executeQuery();

			while (rs.next()) {
				Medico medico = new Medico();

				medico.setId(rs.getInt("IDmedico"));
				medico.setNome(rs.getString("nome"));
				medico.setCRM(rs.getInt("crm"));
				medico.setEspecialidade(especialidadeDAO.buscarPorId(rs.getInt("IDespecialidade")));
				medico.setTelefone(rs.getString("telefone"));
				medico.setEndereco(enderecoDao.buscarPorId(rs.getInt("IDendereco")));
				
				listaMedicos.add(medico);
			}

			return listaMedicos;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public List<Medico> buscarTodos() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Medico> listaMedicos = new ArrayList<>();
		EnderecoDAO enderecoDao = new EnderecoDAO(conn);
		EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(conn);
		
		try {
			ps = conn.prepareStatement("select * from medico order by nome");
			rs = ps.executeQuery();

			while (rs.next()) {
				Medico medico = new Medico();
				
				medico.setId(rs.getInt("IDmedico"));
				medico.setNome(rs.getString("nome"));
				medico.setCRM(rs.getInt("crm"));
				medico.setEspecialidade(especialidadeDAO.buscarPorId(rs.getInt("IDespecialidade")));
				medico.setTelefone(rs.getString("telefone"));
				medico.setEndereco(enderecoDao.buscarPorId(rs.getInt("IDendereco")));
				
				listaMedicos.add(medico);
			}
			
			return listaMedicos;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
}
