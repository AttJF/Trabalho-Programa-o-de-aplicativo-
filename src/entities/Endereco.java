package entities;

public class Endereco {
	
	private int id;
	private String rua;
	private String bairro;
	private String cidade;
	private String complemento;
	private int numero;
	private String uniaoFederativa;
	
	public Endereco(int id, String rua, String bairro, String cidade, String complemento, int numero,
			String uniaoFederativa) {
		super();
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.numero = numero;
		this.uniaoFederativa = uniaoFederativa;
						
}
	
	public Endereco() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUniaoFederativa() {
		return uniaoFederativa;
	}

	public void setUniaoFederativa(String uniaoFederativa) {
		this.uniaoFederativa = uniaoFederativa;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", complemento="
				+ complemento + ", numero=" + numero + ", uniãoFederativa=" + uniaoFederativa + "]";
	}
	
	
}
