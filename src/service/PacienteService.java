package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.PacienteDAO;
import entities.Paciente;
import utils.Validacao;

public class PacienteService {
	Validacao validacao = new Validacao();
	
	public List<Paciente> buscarTodos() throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			return new PacienteDAO(conn).buscarTodos();
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public void editar(Paciente paciente) throws SQLException, IOException, Exception {
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
			
			new PacienteDAO(conn).editar(paciente);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public void cadastrar(Paciente paciente) throws SQLException, IOException, Exception {
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
		
			new PacienteDAO(conn).cadastrar(paciente);
		} finally {
			BancoDados.desconectar();
		}
	}
}
