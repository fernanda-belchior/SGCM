package negocio;

public class Consulta {
	private String cpfPaciente, cpfMedico,cpfAtendente, dataConsulta, horaConsulta, idConsulta, status;

	public Consulta() {
		super();
	}

	public Consulta(String cpfPaciente, String cpfMedico, String cpfAtendente,
			String dataConsulta, String horaConsulta, String idConsulta,
			String status) {
		super();
		this.cpfPaciente = cpfPaciente;
		this.cpfMedico = cpfMedico;
		this.cpfAtendente = cpfAtendente;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.idConsulta = idConsulta;
		this.status = status;
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

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public String getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\n\nConsulta [cpfPaciente=" + cpfPaciente + ", cpfMedico="
				+ cpfMedico + "\n cpfAtendente=" + cpfAtendente
				+ ", dataConsulta=" + dataConsulta + "\n\n horaConsulta="
				+ horaConsulta + ", idConsulta=" + idConsulta + ", status="
				+ status + "]";
	}

	
	
	
	
	

}
