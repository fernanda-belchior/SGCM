package negocio;



public class Agendamento {
	
	private String cpfPaciente, idAgenda, cpfAtendente, cpfMedico, dataAgendamento, idAgendamento;
	
	

	public Agendamento() {
		super();
	}



	public Agendamento(String cpfPaciente, String idAgenda,
			String cpfAtendente, String cpfMedico, String dataAgendamento,
			String idAgendamento) {
		super();
		this.cpfPaciente = cpfPaciente;
		this.idAgenda = idAgenda;
		this.cpfAtendente = cpfAtendente;
		this.cpfMedico = cpfMedico;
		this.dataAgendamento = dataAgendamento;
		this.idAgendamento = idAgendamento;
	}



	public String getCpfPaciente() {
		return cpfPaciente;
	}



	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}



	public String getIdAgenda() {
		return idAgenda;
	}



	public void setIdAgenda(String idAgenda) {
		this.idAgenda = idAgenda;
	}



	public String getCpfAtendente() {
		return cpfAtendente;
	}



	public void setCpfAtendente(String cpfAtendente) {
		this.cpfAtendente = cpfAtendente;
	}



	public String getCpfMedico() {
		return cpfMedico;
	}



	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}



	public String getDataAgendamento() {
		return dataAgendamento;
	}



	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}



	public String getIdAgendamento() {
		return idAgendamento;
	}



	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}



	@Override
	public String toString() {
		return "\n\nAgendamento [cpfPaciente=" + cpfPaciente + ", idAgenda="
				+ idAgenda + ", cpfAtendente=" + cpfAtendente + "\ncpfMedico="
				+ cpfMedico + ", dataAgendamento=" + dataAgendamento
				+ "\n idAgendamento=" + idAgendamento + "]";
	}
	
	

	
	

}