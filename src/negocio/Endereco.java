package negocio;

public class Endereco {
	
	private String rua, num, bairro, cidade, cep;

	public Endereco(String rua, String num, String bairro, String cidade,
			String cep) {
		super();
		this.rua = rua;
		this.num = num;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}
	
	

	public Endereco() {
		super();
	}



	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String toString(){
		return rua+", "+num+", "+bairro+", "+cidade+", "+cep;
	}
	
	
}
