package negocio;

public class Paciente extends Pessoa{
	
    private Endereco endereco;

	public Paciente(String nome, String cpf, String telefone, Endereco endereco) {
		super(nome, cpf, telefone);
		this.endereco = endereco;
	}


	public Paciente() {
		super();
	}


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String imprimirEndereco(){
		String end = "Endereço - Rua: "+this.endereco.getRua()+", Número: "+this.endereco.getNum()+"\nBairro: "
	+this.endereco.getBairro()+", Cidade:  "+this.endereco.getCidade()+", CEP: "+this.endereco.getCep();
		return end;
		
	}
	
	@Override
	public String toString() {
		return "Paciente [getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getTelefone()=" + getTelefone() + "]";
	}
    
}
    
   