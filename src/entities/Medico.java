package entities;

public class Medico {
	private int id, CRM;
	private String telefone, nome;
	private Endereco endereco;
	private Especialidade especialidade;

	public Medico(int id, int CRM, String telefone, String nome, Endereco endereco, Especialidade especialidade) {
		this.id = id;
		this.CRM = CRM;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
		this.especialidade = especialidade;
	}

	public Medico() { }

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCRM() {
		return CRM;
	}


	public void setCRM(int cRM) {
		CRM = cRM;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Especialidade getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}


	@Override
	public String toString() {
		return "[id=" + id + ", CRM=" + CRM + ", telefone=" + telefone + ", nome=" + nome + ", especialidade="
				+ especialidade.getNome() + "]";
	}
}
