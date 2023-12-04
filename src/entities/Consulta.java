package entities;

public class Consulta {
	private int id; 
	private Medico medico;
	private int dia, horario;
	private Paciente paciente;
	private boolean pago;
	
	public Consulta(int id, Medico medico, int dia, int horario, Paciente paciente, boolean pago) {
		super();
		this.id = id;
		this.medico = medico;
		this.horario = horario;
		this.paciente = paciente;
		this.pago = pago;
		this.dia = dia;
	}
	
	public Consulta() { }
	
	private void pagar(int valor, String forma) {
		if(this.pago) {
			System.out.println("pagamento ja realizado");
		}
	}
	
	private void remarcar(int novo) {
		if(novo==1) {
		this.setHorario(novo);
		}
		else
		System.out.println("Horario nao disponivel para consulta");
	}
	private void buscar() {
		
	}
	
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
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
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
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", medico=" + medico + ", dia=" + dia + ", horario=" + horario + ", paciente="
				+ paciente + ", pago=" + pago + "]";
	}
	
}