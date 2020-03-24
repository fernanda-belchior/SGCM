package negocio;


public class Cancelamento {
	
	private String cpfPaciente, cpfMedico, cpfAtendente,idAgenda, dataCancelamento, idCancelamento;
	
	public Cancelamento() {
		super();
	}

	public Cancelamento(String cpfPaciente, String cpfMedico,
			String cpfAtendente, String idAgenda, String dataCancelamento,
			String idCancelamento) {
		super();
		this.cpfPaciente = cpfPaciente;
		this.cpfMedico = cpfMedico;
		this.cpfAtendente = cpfAtendente;
		this.idAgenda = idAgenda;
		this.dataCancelamento = dataCancelamento;
		this.idCancelamento = idCancelamento;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getCpfMedico() {
		return cpfMedico;
	}

	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}

	public String getCpfAtendente() {
		return cpfAtendente;
	}

	public void setCpfAtendente(String cpfAtendente) {
		this.cpfAtendente = cpfAtendente;
	}

	public String getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(String idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(String dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public String getIdCancelamento() {
		return idCancelamento;
	}

	public void setIdCancelamento(String idCancelamento) {
		this.idCancelamento = idCancelamento;
	}

	@Override
	public String toString() {
		return "\n\nCancelamento [cpfPaciente=" + cpfPaciente + ", cpfMedico="
				+ cpfMedico + "\n cpfAtendente=" + cpfAtendente + ", idAgenda="
				+ idAgenda + "\n dataCancelamento=" + dataCancelamento
				+ ", idCancelamento=" + idCancelamento + "]";
	}

	

	

}