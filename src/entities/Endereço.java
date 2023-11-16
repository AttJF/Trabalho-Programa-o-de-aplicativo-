package entities;

public class Endereço {
	
	private int id;
	private String rua;
	private String bairro;
	private String cidade;
	private String complemento;
	private int numero;
	private String uniãoFederativa;
	
	public Endereço(int id, String rua, String bairro, String cidade, String complemento, int numero,
			String uniãoFederativa) {
		super();
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.numero = numero;
		this.uniãoFederativa = uniãoFederativa;
						
}

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

	public String getUniãoFederativa() {
		return uniãoFederativa;
	}

	public void setUniãoFederativa(String uniãoFederativa) {
		this.uniãoFederativa = uniãoFederativa;
	}
	
	
}
