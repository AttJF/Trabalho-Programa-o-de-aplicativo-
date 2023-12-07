package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.MedicoDAO;

import entities.Medico;
import utils.Validacao;

public class MedicoService {
	Validacao validacao = new Validacao();
	
	public void cadastrar(Medico medico) throws SQLException, IOException, Exception {
		
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
			
			new MedicoDAO(conn).cadastrar(medico);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<Medico> buscarTodos() throws SQLException, IOException {
		try {
			Connection conn = BancoDados.conectar();
			
			return new MedicoDAO(conn).buscarTodos();
		} finally {
			BancoDados.desconectar();
		}
	}
}
