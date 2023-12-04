package entities;

public class PedidoExame {

	private int idPedidoExame;
	private Medico medico;
	private Paciente paciente;
	private Exame exame;
	private double valorPago;
	private String dataRealizacao;
	
	public PedidoExame(int idPedidoExame, Medico medico, Paciente paciente, Exame exame, String dataRealizacao) {
		this.idPedidoExame = idPedidoExame;
		this.medico = medico;
		this.paciente = paciente;
		this.exame = exame;
		this.valorPago = 0;
		this.dataRealizacao = dataRealizacao;
	}
	
	public PedidoExame() { }
	
	public void pagarExame() {
		this.valorPago = this.exame.getCustoExame();
	}

	public int getIdPedidoExame() {
		return idPedidoExame;
	}

	public void setIdPedidoExame(int idPedidoExame) {
		this.idPedidoExame = idPedidoExame;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
}
