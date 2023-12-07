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

public class ConsultaService {
	 Validacao validacao = new Validacao();
	public void cadastrar(Consulta consulta) throws SQLException, IOException, Exception{
		try {
			Connection conn = BancoDados.conectar();
		
			 validacao.verificaNaoVazio(consulta.getMedico());
			 validacao.verificaNaoVazio(consulta.getHorario());
			 validacao.verificaNaoVazio(consulta.getPaciente());
			 validacao.verificaNaoVazio(consulta.isPago());
			 validacao.verificaNaoVazio(consulta.getData());
			

			new ConsultaDAO(conn).cadastrar(consulta);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public  List<Consulta> buscarTodos(Medico medico) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			 validacao.verificaNaoVazio(medico.getNome());
			 validacao.verificaNaoVazio(medico.getCRM());
	         validacao.verificaNaoVazio(medico.getEndereco().getCidade());
	         validacao.verificaPositivo(medico.getEndereco().getNumero());
	         validacao.verificaNaoVazio(medico.getEndereco().getComplemento());
	         validacao.verificaNaoVazio(medico.getEndereco().getUniaoFederativa());
	         validacao.verificaNaoVazio(medico.getEndereco().getBairro());
	         validacao.verificaNaoVazio(medico.getEndereco().getRua());
			 validacao.verificaNaoVazio(medico.getEspecialidade());
			 validacao.verificaNaoVazio(medico.getTelefone());
			 validacao.verificarNaoVazio(medico.getEspecialidade().getNome());
			 validacao.verificarNaoVazio(medico.getEspecialidade().getCodigo());
			return new ConsultaDAO(conn).buscarTodosPorMedico(medico.getId());
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<Consulta> buscarTodosPorPaciente(Paciente paciente) throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			alidacao.verificaNaoVazio(paciente.getNome());
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
