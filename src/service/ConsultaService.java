package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.BancoDados;
import dao.ConsultaDAO;
import entities.Consulta;
import entities.Medico;
import entities.Paciente;
import utils.Validacao;

public class ConsultaService {
	 Validacao validacao = new Validacao();
	 
	public void cadastrar(Consulta consulta) throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
		
			validacao.verificaNaoVazio(consulta.getMedico().getNome());
            validacao.verificaPositivo(consulta.getMedico().getCRM());
            validacao.verificaNaoVazio(consulta.getMedico().getEndereco().getCidade());
            validacao.verificaPositivo(consulta.getMedico().getEndereco().getNumero());
            validacao.verificaNaoVazio(consulta.getMedico().getEndereco().getComplemento());
            validacao.verificaNaoVazio(consulta.getMedico().getEndereco().getUniaoFederativa());
            validacao.verificaNaoVazio(consulta.getMedico().getEndereco().getBairro());
            validacao.verificaNaoVazio(consulta.getMedico().getEndereco().getRua());
            validacao.verificaNaoVazio(consulta.getMedico().getTelefone());
            validacao.verificaNaoVazio(consulta.getMedico().getEspecialidade().getNome());
            validacao.verificaNaoVazio(consulta.getMedico().getEspecialidade().getCodigo());
            
			validacao.verificaNaoVazio(consulta.getHorario());
			validacao.verificaNaoVazio(consulta.getData());
			 
			validacao.verificaNaoVazio(consulta.getPaciente().getNome());
			validacao.verificaNaoVazio(consulta.getPaciente().getSexo());
			validacao.verificaNaoVazio(consulta.getPaciente().getDataNascimento());
			validacao.verificaNaoVazio(consulta.getPaciente().getTelefone());
				
			validacao.verificaNaoVazio(consulta.getPaciente().getEndereco().getCidade());
	        validacao.verificaPositivo(consulta.getPaciente().getEndereco().getNumero());
	        validacao.verificaNaoVazio(consulta.getPaciente().getEndereco().getComplemento());
	        validacao.verificaNaoVazio(consulta.getPaciente().getEndereco().getUniaoFederativa());
	        validacao.verificaNaoVazio(consulta.getPaciente().getEndereco().getBairro());
	        validacao.verificaNaoVazio(consulta.getPaciente().getEndereco().getRua());
			

			new ConsultaDAO(conn).cadastrar(consulta);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public  List<Consulta> buscarTodos(Medico medico) throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
			
			validacao.verificaNaoVazio(medico.getNome());
            validacao.verificaPositivo(medico.getCRM());
            validacao.verificaNaoVazio(medico.getEndereco().getCidade());
            validacao.verificaPositivo(medico.getEndereco().getNumero());
            validacao.verificaNaoVazio(medico.getEndereco().getComplemento());
            validacao.verificaNaoVazio(medico.getEndereco().getUniaoFederativa());
            validacao.verificaNaoVazio(medico.getEndereco().getBairro());
            validacao.verificaNaoVazio(medico.getEndereco().getRua());
            validacao.verificaNaoVazio(medico.getTelefone());
            validacao.verificaNaoVazio(medico.getEspecialidade().getNome());
            validacao.verificaNaoVazio(medico.getEspecialidade().getCodigo());
			 
			return new ConsultaDAO(conn).buscarTodosPorMedico(medico.getId());
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<Consulta> buscarTodosPorPaciente(Paciente paciente) throws SQLException, IOException, Exception {
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
		
			return new ConsultaDAO(conn).buscarTodosPorPaciente(paciente.getId());
		} finally {
			BancoDados.desconectar();
		}
	}
}
