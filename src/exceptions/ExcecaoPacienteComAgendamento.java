package exceptions;

public class ExcecaoPacienteComAgendamento extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoPacienteComAgendamento() {
		super("PACIENTE JÁ POSSUI UM AGENDAMENTO!");
	}

}
