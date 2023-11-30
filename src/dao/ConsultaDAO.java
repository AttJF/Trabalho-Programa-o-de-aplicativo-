package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Consulta;

public class ConsultaDAO {
	Connection conn;
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Consulta buscarPorId(int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		PacienteDAO pacienteDao = new PacienteDAO(conn);
		MedicoDAO medicoDao = new MedicoDAO(conn);

		try {
			ps = conn.prepareStatement("select * from consulta where IDconsulta = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Consulta consulta = new Consulta();

				consulta.setId(rs.getInt("IDconsulta"));
				consulta.setDia(rs.getInt("dia"));
				consulta.setHorario(rs.getInt("horario"));
				consulta.setPago(rs.getBoolean("pago"));
				consulta.setMedico(medicoDao.buscarPorId(rs.getInt("IDmedico")));
				consulta.setPaciente(pacienteDao.buscarPorId(rs.getInt("IDmedico")));
				
				return consulta;
			}
			
			return null;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public void atualizar(Consulta consulta) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("update consulta set IDmedico = ?, dia = ?, horario = ? , IDpaciente = ? , pago = ? where IDconsulta = ?");

			ps.setInt(1, consulta.getMedico().getId());
			ps.setInt(2, consulta.getDia());
			ps.setInt(3, consulta.getHorario());
			ps.setInt(4, consulta.getPaciente().getId());
			ps.setBoolean(5, consulta.isPago());
			ps.setInt(6, consulta.getId());

			ps.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
	
	public void cadastrar(Consulta consulta) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("insert into consulta (IDmedico, dia, horario, IDpaciente, pago) values (?, ?, ?, ?, ?)");

			ps.setInt(1, consulta.getMedico().getId());
			ps.setInt(2, consulta.getDia());
			ps.setInt(3, consulta.getHorario());
			ps.setInt(4, consulta.getPaciente().getId());
			ps.setBoolean(5, consulta.isPago());

			ps.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}	

	public void excluir(int id) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("delete from consulta where IDconsulta = ?");
			ps.setInt(1, id);		
		} finally {
			BancoDados.finalizarStatement(ps);
		}
	}
}
