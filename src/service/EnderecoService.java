package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import dao.EnderecoDAO;
import entities.Endereco;
import utils.Validacao;

public class EnderecoService {
	Validacao validacao = new Validacao();
	
	public void cadastrar(Endereco endereco) throws SQLException, IOException, Exception {
		try {
			Connection conn = BancoDados.conectar();
			
			 validacao.verificaNaoVazio(endereco.getCidade());
			 validacao.verificaPositivo(endereco.getNumero());
			 validacao.verificaNaoVazio(endereco.getComplemento());
			 validacao.verificaNaoVazio(endereco.getUniaoFederativa());
			 validacao.verificaNaoVazio(endereco.getBairro());
			 validacao.verificaNaoVazio(endereco.getRua());
			 
			new EnderecoDAO(conn).cadastrar(endereco);
		} finally {
			BancoDados.desconectar();
		}		
	}
}
