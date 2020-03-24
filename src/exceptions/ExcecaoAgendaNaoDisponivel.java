package exceptions;

public class ExcecaoAgendaNaoDisponivel extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcecaoAgendaNaoDisponivel() {
		super( "O HORÁRIO NÃO ESTÁ DISPONÍVEL, POR FAVOR ESCOLHA OUTRO!");		
	}
	

}
