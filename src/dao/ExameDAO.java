package dao;

import java.sql.Connection;

public class ExameDAO {

	private Connection conn;
	
	public ExameDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrarExame() {
		//new Exame();
	}
	
	public void buscarExame(String nome) {
		
	}
}
