package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.PedidoExameDAO;
import entities.Exame;
import entities.Paciente;
import entities.PedidoExame;
import utils.Validacao;

public class PedidoExameService {
	Validacao validacao = new Validacao();
	
	public void cadastrar(PedidoExame pedidoExame) throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
			
			validacao.verificaNaoVazio(pedidoExame.getDataRealizacao());
			
			validacao.verificaNaoVazio(pedidoExame.getExame().getNomeExame());
			validacao.verificaNaoVazio(pedidoExame.getExame().getOrientacoes());
			validacao.verificaPositivo(pedidoExame.getExame().getCustoExame());
			validacao.verificaNaoVazio(pedidoExame.getExame().getCodigo());
			
			validacao.verificaNaoVazio(pedidoExame.getMedico().getNome());
            validacao.verificaPositivo(pedidoExame.getMedico().getCRM());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getEndereco().getCidade());
            validacao.verificaPositivo(pedidoExame.getMedico().getEndereco().getNumero());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getEndereco().getComplemento());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getEndereco().getUniaoFederativa());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getEndereco().getBairro());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getEndereco().getRua());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getTelefone());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getEspecialidade().getNome());
            validacao.verificaNaoVazio(pedidoExame.getMedico().getEspecialidade().getCodigo());

            validacao.verificaNaoVazio(pedidoExame.getPaciente().getNome());
			validacao.verificaNaoVazio(pedidoExame.getPaciente().getSexo());
			validacao.verificaNaoVazio(pedidoExame.getPaciente().getDataNascimento());
			validacao.verificaNaoVazio(pedidoExame.getPaciente().getTelefone());
			validacao.verificaNaoVazio(pedidoExame.getPaciente().getEndereco().getCidade());
            validacao.verificaPositivo(pedidoExame.getPaciente().getEndereco().getNumero());
            validacao.verificaNaoVazio(pedidoExame.getPaciente().getEndereco().getComplemento());
            validacao.verificaNaoVazio(pedidoExame.getPaciente().getEndereco().getUniaoFederativa());
            validacao.verificaNaoVazio(pedidoExame.getPaciente().getEndereco().getBairro());
            validacao.verificaNaoVazio(pedidoExame.getPaciente().getEndereco().getRua());
            
            validacao.verificaNaoVazio(pedidoExame.getExame().getNomeExame());
			validacao.verificaNaoVazio(pedidoExame.getExame().getOrientacoes());
			validacao.verificaPositivo(pedidoExame.getExame().getCustoExame());
			validacao.verificaNaoVazio(pedidoExame.getExame().getCodigo());
			
			new PedidoExameDAO(conn).cadastrar(pedidoExame);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<PedidoExame> buscarTodosPorPaciente(Paciente paciente) throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
			
			validacao.verificaNaoVazio(paciente.getNome());
			validacao.verificaNaoVazio(paciente.getSexo());
			validacao.verificaNaoVazio(paciente.getDataNascimento());
			validacao.verificaNaoVazio(paciente.getTelefone());
			
			validacao.verificaNaoVazio(paciente.getEndereco().getCidade());
            validacao.verificaPositivo(paciente.getEndereco().getNumero());
            validacao.verificaNaoVazio(paciente.getEndereco().getComplemento());
            validacao.verificaNaoVazio(paciente.getEndereco().getUniaoFederativa());
            validacao.verificaNaoVazio(paciente.getEndereco().getBairro());
            validacao.verificaNaoVazio(paciente.getEndereco().getRua());
			
			return new PedidoExameDAO(conn).buscarTodosPorPaciente(paciente.getId());
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<PedidoExame> buscarTodosPorExame(Exame exame) throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
			
			validacao.verificaNaoVazio(exame.getNomeExame());
			validacao.verificaNaoVazio(exame.getOrientacoes());
			validacao.verificaPositivo(exame.getCustoExame());
			validacao.verificaNaoVazio(exame.getCodigo());
			
			return new PedidoExameDAO(conn).buscarTodosPorExame(exame.getIdExame());
		} finally {
			BancoDados.desconectar();
		}
	}
}
