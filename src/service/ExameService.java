package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ExameDAO;
import entities.Exame;
import utils.Validacao;

public class ExameService {
	Validacao validacao = new Validacao();
	
	public void cadastrar(Exame exame) throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
			
			validacao.verificaNaoVazio(exame.getNomeExame());
			validacao.verificaNaoVazio(exame.getOrientacoes());
			validacao.verificaPositivo(exame.getCustoExame());
			validacao.verificaNaoVazio(exame.getCodigo());
			
			new ExameDAO(conn).cadastrar(exame);
		} finally {
			BancoDados.desconectar();
		}
	}
	
	public List<Exame> buscarTodos() throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
			
			return new ExameDAO(conn).buscarTodos();
		} finally {
			BancoDados.desconectar();
		}		
	}
}
