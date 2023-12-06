package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Endereco;
import entities.Especialidade;
import entities.Exame;
import entities.FormaDePagamento;
import entities.Medico;
import entities.Paciente;
import entities.PedidoExame;

public class PedidoExameDAOTeste {

	public static void cadastrarTeste() throws SQLException, IOException {
		String dataRealizacao = "01/01/1990";
		double valorPago = 100;
		double custo = 100;
		String nomeExame = "Raio X";
		String orientacoes = "Tomar cuidado";
		int crm = 123;
		String nome = "Danilo";
		String nomeEspecialidade = "Pediatra";
		String telefone = "(42)99999-9999";
		String bairro = "Jd Carvalho";
		String cidade = "Ponta Grossa";
		String complemento = "Casa";
		int numero = 1000;
		String rua = "Monteiro Lobato";
		String UF = "PR";
		String dataNascimento = "01/01/2000";
		String sexo = "Masculino";
		FormaDePagamento formaPagamento = FormaDePagamento.Cartao;
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUniaoFederativa(UF);
		//endereco.setId(idEndereco);
		
		Especialidade especialidade = new Especialidade();
		especialidade.setNome(nomeEspecialidade);
		//especialidade.setId(idEspecialidade);
		
		Medico medico = new Medico();
		medico.setCRM(crm);
		medico.setEndereco(endereco);
		medico.setEspecialidade(especialidade);
		//medico.setId(idMedico);
		medico.setNome(nome);
		medico.setTelefone(telefone);
		
		Paciente paciente = new Paciente();
		paciente.setDataNascimento(dataNascimento);
		paciente.setEndereco(endereco);
		paciente.setFormaPagamento(formaPagamento);
		//paciente.setId(idPaciente);
		paciente.setNome(nome);
		paciente.setSexo(sexo);
		paciente.setTelefone(telefone);	
		
		Exame exame = new Exame();
		exame.setCustoExame(custo);
		//exame.setIdExame(id);
		exame.setNomeExame(nomeExame);
		exame.setOrientacoes(orientacoes);
		
		PedidoExame pedidoExame = new PedidoExame();
		pedidoExame.setDataRealizacao(dataRealizacao);
		pedidoExame.setExame(exame);
		pedidoExame.setMedico(medico);
		pedidoExame.setPaciente(paciente);
		pedidoExame.setValorPago(valorPago);
		
		Connection conn = BancoDados.conectar();
		new PedidoExameDAO(conn).cadastrar(pedidoExame);
		System.out.println("Pedido de exame cadastrado com sucesso");
	}
	
	public static void buscarPorIdTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		PedidoExame pedidoExame = new PedidoExameDAO(conn).buscarPorId(id);
		
		if(pedidoExame != null) {
			System.out.println(pedidoExame);
		}
		else {
			System.out.println("Nenhum registro encontrado");
		}
	}
	
	public static void atualizarTeste() throws SQLException, IOException {
		int id = 0;
		String dataRealizacao = "01/01/1990";
		double valorPago = 100;
		int idExame = 0;
		double custo = 100;
		String nomeExame = "Raio X";
		String orientacoes = "Tomar cuidado";
		int idMedico = 0;
		int crm = 123;
		String nome = "Danilo";
		int idEspecialidade = 0;
		String nomeEspecialidade = "Pediatra";
		String telefone = "(42)99999-9999";
		int idEndereco = 0;
		String bairro = "Jd Carvalho";
		String cidade = "Ponta Grossa";
		String complemento = "Casa";
		int numero = 1000;
		String rua = "Monteiro Lobato";
		String UF = "PR";
		int idPaciente = 0;
		String dataNascimento = "01/01/2000";
		String sexo = "Masculino";
		FormaDePagamento formaPagamento = FormaDePagamento.Cartao;
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUniaoFederativa(UF);
		endereco.setId(idEndereco);
		
		Especialidade especialidade = new Especialidade();
		especialidade.setNome(nomeEspecialidade);
		especialidade.setId(idEspecialidade);
		
		Medico medico = new Medico();
		medico.setCRM(crm);
		medico.setEndereco(endereco);
		medico.setEspecialidade(especialidade);
		medico.setId(idMedico);
		medico.setNome(nome);
		medico.setTelefone(telefone);
		
		Paciente paciente = new Paciente();
		paciente.setDataNascimento(dataNascimento);
		paciente.setEndereco(endereco);
		paciente.setFormaPagamento(formaPagamento);
		paciente.setId(idPaciente);
		paciente.setNome(nome);
		paciente.setSexo(sexo);
		paciente.setTelefone(telefone);
		
		Exame exame = new Exame();
		exame.setCustoExame(custo);
		exame.setIdExame(idExame);
		exame.setNomeExame(nomeExame);
		exame.setOrientacoes(orientacoes);
		
		PedidoExame pedidoExame = new PedidoExame();
		pedidoExame.setIdPedidoExame(id);
		pedidoExame.setDataRealizacao(dataRealizacao);
		pedidoExame.setExame(exame);
		pedidoExame.setMedico(medico);
		pedidoExame.setPaciente(paciente);
		pedidoExame.setValorPago(valorPago);
		
		Connection conn = BancoDados.conectar();
		new PedidoExameDAO(conn).atualizar(pedidoExame);
		System.out.println("Pedido de exame atualizado com sucesso");
	}
	
	public static void main(String[] args) {
		try {
			cadastrarTeste();
			atualizarTeste();
			buscarPorIdTeste();
		}
		catch (IOException | SQLException e) {
			e.getMessage();
		}
	}
}
