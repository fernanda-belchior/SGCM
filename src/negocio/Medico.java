package negocio;

public class Medico extends Pessoa {
	String especialidade;
	

	public Medico() {
		super();
	}

	public Medico(String nome, String cpf, String telefone,
		String senha, String especialidade) {
		super(nome, cpf, telefone, senha);
		this.especialidade = especialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	
	

}