package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.FormaDePagamento;
import entities.Paciente;
import entities.PedidoExame;

public class PedidoExameDAO {
	
	private Connection conn;
	
	public PedidoExameDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(PedidoExame pedidoExame) throws SQLException {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("insert into pedidoexame (datarealizacao, valorpago, IDmedico, IDpaciente, IDexame) values (?, ?, ?, ?, ?)");

			ps.setString(1, pedidoExame.getDataRealizacao());
			ps.setDouble(2, pedidoExame.getValorPago());
			ps.setInt(3, pedidoExame.getMedico().getId());
			ps.setInt(4, pedidoExame.getPaciente().getId());
			ps.setInt(5, pedidoExame.getExame().getIdExame());

			ps.executeUpdate();
		} finally {
			BancoDados.finalizarStatement(ps);
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
				pedidoExame.setMedico(medicoDao.buscarPorId(rs.getInt("IDmedico")));
				pedidoExame.setPaciente(pacienteDao.buscarPorId(rs.getInt("IDpaciente")));
				
				return pedidoExame;
			}

			return null;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public List<PedidoExame> buscarTodosPorPaciente(int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PedidoExame> listaPedidoExames = new ArrayList<>();
		MedicoDAO medicoDAO = new MedicoDAO(conn);
		PacienteDAO pacienteDAO = new PacienteDAO(conn);
		ExameDAO exameDAO = new ExameDAO(conn);

		try {
			ps = conn.prepareStatement("select * from pedidoexame where IDpaciente = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				PedidoExame pedidoExame = new PedidoExame();

				pedidoExame.setDataRealizacao(rs.getString("datarealizacao"));
				pedidoExame.setExame(exameDAO.buscarPorId(rs.getInt("IDexame")));
				pedidoExame.setIdPedidoExame(rs.getInt("IDpedidoexame"));
				pedidoExame.setMedico(medicoDAO.buscarPorId(rs.getInt("IDmedico")));
				pedidoExame.setPaciente(pacienteDAO.buscarPorId(rs.getInt("IDpaciente")));
				pedidoExame.setValorPago(exameDAO.buscarPorId(rs.getInt("IDexame")).getCustoExame());
				
				listaPedidoExames.add(pedidoExame);
			}

			return listaPedidoExames;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	public List<PedidoExame> buscarTodosPorExame(int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PedidoExame> listaPedidoExames = new ArrayList<>();
		MedicoDAO medicoDAO = new MedicoDAO(conn);
		PacienteDAO pacienteDAO = new PacienteDAO(conn);
		ExameDAO exameDAO = new ExameDAO(conn);

		try {
			ps = conn.prepareStatement("select * from pedidoexame where IDexame = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				PedidoExame pedidoExame = new PedidoExame();

				pedidoExame.setDataRealizacao(rs.getString("datarealizacao"));
				pedidoExame.setExame(exameDAO.buscarPorId(rs.getInt("IDexame")));
				pedidoExame.setIdPedidoExame(rs.getInt("IDpedidoexame"));
				pedidoExame.setMedico(medicoDAO.buscarPorId(rs.getInt("IDmedico")));
				pedidoExame.setPaciente(pacienteDAO.buscarPorId(rs.getInt("IDpaciente")));
				pedidoExame.setValorPago(exameDAO.buscarPorId(rs.getInt("IDexame")).getCustoExame());
				
				listaPedidoExames.add(pedidoExame);
			}

			return listaPedidoExames;
		} finally {
			BancoDados.finalizarStatement(ps);
			BancoDados.finalizarResultSet(rs);
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
		}
	}
}
