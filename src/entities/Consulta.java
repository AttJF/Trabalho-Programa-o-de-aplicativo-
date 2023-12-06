package entities;

public class Consulta {
	private int id; 
	private Medico medico;
	private String data, horario;
	private Paciente paciente;
	private boolean pago;
	
	public Consulta(int id, Medico medico, String dia, String horario, Paciente paciente, boolean pago) {
		super();
		this.id = id;
		this.medico = medico;
		this.horario = horario;
		this.paciente = paciente;
		this.pago = pago;
		this.data = dia;
	}
	
	public Consulta() { }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public String getData() {
		return data;
	}
	public void setData(String dia) {
		this.data = dia;
	}

	@Override
	public String toString() {
		return "id=" + id + ", medico=" + medico.toString() + ", data=" + data + ", horario=" + horario + ", paciente="
				+ paciente.toString() + ", pago=" + pago + "\n";
	}
	
}