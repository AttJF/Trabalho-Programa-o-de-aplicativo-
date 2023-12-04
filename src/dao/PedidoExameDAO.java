package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.PedidoExame;

public class PedidoExameDAO {
	
	private Connection conn;
	
	public PedidoExameDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(PedidoExame pedidoExame) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("insert into pedidoexame (datarealizacao, valorpago, IDmedico, IDpaciente, IDexame) values (?, ?, ?, ?)");

			ps.setString(1, pedidoExame.getDataRealizacao());
			ps.setDouble(2, pedidoExame.getValorPago());
			ps.setInt(3, pedidoExame.getMedico().getId());
			ps.setInt(4, pedidoExame.getPaciente().getId());
			ps.setInt(5, pedidoExame.getExame().getIdExame());

			ps.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
	
	public PedidoExame buscarPorId(int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ExameDAO exameDao = new ExameDAO(conn);
		MedicoDAO medicoDao = new MedicoDAO(conn);
		PacienteDAO pacienteDao = new PacienteDAO(conn);

		try {
			ps = conn.prepareStatement("select * from pedidoexame where IDpedidoexame = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				PedidoExame pedidoExame = new PedidoExame();

				pedidoExame.setIdPedidoExame(rs.getInt("IDpedidoexame"));
				pedidoExame.setDataRealizacao(rs.getString("datarealizacao"));
				pedidoExame.setValorPago(rs.getDouble("valorpago"));
				pedidoExame.setExame(exameDao.buscarPorId(rs.getInt("IDexame")));
				pedidoExame.setMedico(medicoDao.buscarPorId(rs.getInt("IDexame")));
				pedidoExame.setPaciente(pacienteDao.buscarPorId(rs.getInt("IDexame")));
				
				return pedidoExame;
			}

			return null;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public void atualizar(PedidoExame pedidoExame) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("update pedidoexame set datarealizacao = ?, valorpago = ?, IDmedico = ?, IDpaciente = ?, IDexame = ? where IDpedidoexame = ?");

			ps.setString(1, pedidoExame.getDataRealizacao());
			ps.setDouble(2, pedidoExame.getValorPago());
			ps.setInt(3, pedidoExame.getMedico().getId());
			ps.setInt(4, pedidoExame.getPaciente().getId());
			ps.setInt(5, pedidoExame.getExame().getIdExame());
			ps.setInt(6, pedidoExame.getIdPedidoExame());

			ps.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.desconectar();
		}
	}
}
