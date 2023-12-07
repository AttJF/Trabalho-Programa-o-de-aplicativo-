package utils;

public class Validacao {
	public void verificaPositivo(int num) throws Exception {
		if(num <= 0) throw new Exception("Numero igual ou menor que zero");
	}
	
	public void verificaPositivo(double num) throws Exception {
		if(num <= 0) throw new Exception("Numero igual ou menor que zero");
	}
	
	public void verificaNaoVazio(String str) throws Exception {
		if(str.isEmpty()) throw new Exception("String vazia");
	}
}
