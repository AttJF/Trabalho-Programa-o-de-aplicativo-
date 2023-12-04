package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Endereco;

public class EnderecoDAOTeste {

	public static void buscarPorIdTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		Endereco endereco = new EnderecoDAO(conn).buscarPorId(id);
		
		if(endereco != null) {
			System.out.println(endereco);
		}
		else {
			System.out.println("Endereço não encontrado");
		}
	}
	
	public static void atualizarTeste() throws SQLException, IOException {
		int id = 0;
		String bairro = "Jd Carvalho";
		String cidade = "Ponta Grossa";
		String complemento = "Casa";
		int numero = 1000;
		String rua = "Monteiro Lobato";
		String UF = "PR";
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setId(id);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUniaoFederativa(UF);
		
		Connection conn = BancoDados.conectar();
		new EnderecoDAO(conn).atualizar(endereco);
		System.out.println("Endereço atualizado com sucesso");
	}
	
	public static void cadastrarTeste() throws SQLException, IOException {
		String bairro = "Jd Carvalho";
		String cidade = "Ponta Grossa";
		String complemento = "Casa";
		int numero = 1000;
		String rua = "Monteiro Lobato";
		String UF = "PR";
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		//endereco.setId(id);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUniaoFederativa(UF);
		
		Connection conn = BancoDados.conectar();
		new EnderecoDAO(conn).cadastrar(endereco);
		System.out.println("Endereço cadastrado com sucesso");
	}
	
	public static void excluirTeste() throws SQLException, IOException {
		int id = 0;
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new EnderecoDAO(conn).excluir(id);
		
		if(linhasManipuladas > 0) {
			System.out.println("Endereço excluído com sucesso");
		}
		else {
			System.out.println("Nenhum registro encontrado");
		}
	}
	
	public static void main(String[] args) {
		try {
			cadastrarTeste();
			buscarPorIdTeste();
			atualizarTeste();
			excluirTeste();
		}
		catch (SQLException | IOException e) {
			e.getMessage();
		}
		
	}
}
