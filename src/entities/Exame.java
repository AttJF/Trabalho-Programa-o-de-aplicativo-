package entities;

public class Exame {
	
	private int idExame;
	private String nomeExame;
	private double custoExame;
	private String orientacoes;
	
	public Exame(int idExame, String nomeExame, double custoExame, String orientacoes) {
		this.idExame = idExame;
		this.nomeExame = nomeExame;
		this.custoExame = custoExame;
		this.orientacoes = orientacoes;
	}
	
	public Exame() { }
	
	public int getIdExame() {
		return idExame;
	}

	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public double getCustoExame() {
		return custoExame;
	}

	public void setCustoExame(double custoExame) {
		this.custoExame = custoExame;
	}

	public String getOrientacoes() {
		return orientacoes;
	}

	public void setOrientacoes(String orientacoes) {
		this.orientacoes = orientacoes;
	}
}
