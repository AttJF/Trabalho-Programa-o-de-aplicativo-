package entities;

public class Especialidade {
	private int id;
	private String nome;

	public Especialidade(String nome) {
		this.nome = nome;
	}
	
	public Especialidade() {

	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
