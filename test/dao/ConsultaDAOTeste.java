package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Consulta;
import entities.Endereco;
import entities.Especialidade;
import entities.FormaDePagamento;
import entities.Medico;
import entities.Paciente;

public class ConsultaDAOTeste {
	
	public static void buscarPorIdTeste() throws SQLException, IOException {
		int id = 0;
		
		Connection conn = BancoDados.conectar();
		Consulta consulta = new ConsultaDAO(conn).buscarPorId(id);
		
		if(consulta != null) {
			System.out.println(consulta);
		}
		else {
			System.out.println("Id da consulta não encontrado");
		}
	}
	
	public static void atualizarTeste() throws SQLException, IOException {
		int id = 0;
		int dia = 25;
		int horario = 10;
		boolean pago = true;
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
		especialidade.setNomeEspecialidade(nomeEspecialidade);
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
		
		Consulta consulta = new Consulta();
		consulta.setDia(dia);
		consulta.setHorario(horario);
		consulta.setId(id);
		consulta.setMedico(null);
		consulta.setPaciente(null);
		consulta.setPago(pago);
		
		Connection conn = BancoDados.conectar();
		new ConsultaDAO(conn).atualizar(consulta);
		System.out.println("Consulta atualizada com sucesso");
	}

	public static void cadastrarConsultaTeste() throws SQLException, IOException {
		int dia = 25;
		int horario = 10;
		boolean pago = true;
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
		especialidade.setNomeEspecialidade(nomeEspecialidade);
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
		
		Consulta consulta = new Consulta();
		consulta.setDia(dia);
		consulta.setHorario(horario);
		//consulta.setId(id);
		consulta.setMedico(null);
		consulta.setPaciente(null);
		consulta.setPago(pago);
		
		Connection conn = BancoDados.conectar();
		new ConsultaDAO(conn).atualizar(consulta);
		System.out.println("Consulta cadastrada com sucesso");
	}
	
	public static void main(String[] args) {
		try {
			cadastrarConsultaTeste();
			atualizarTeste();
			buscarPorIdTeste();
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
	}
}
