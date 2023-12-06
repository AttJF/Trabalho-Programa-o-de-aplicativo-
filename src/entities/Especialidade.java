package entities;

public class Especialidade {
	private int id;
	private String nome;
	private String codigo;

	public Especialidade(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
