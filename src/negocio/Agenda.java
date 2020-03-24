package negocio;


public class Agenda {
	private String data, hora, cpfMedico, idAgenda, status;
	
	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agenda(String data, String hora, String cpfMedico, String idAgenda,
			String status) {
		super();
		this.data = data;
		this.hora = hora;
		this.cpfMedico = cpfMedico;
		this.idAgenda = idAgenda;
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCpfMedico() {
		return cpfMedico;
	}

	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}

	public String getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(String idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\n\nAgenda [data=" + data + ", hora=" + hora + ", cpfMedico="
				+ cpfMedico + "\n idAgenda=" + idAgenda + ", status=" + status
				+ "]";
	}

	
}