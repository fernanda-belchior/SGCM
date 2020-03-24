package dados;

import java.util.ArrayList;

import exceptions.*;
import negocio.*;

public class RepositorioPacientesLista implements IRepositorioPacientes{
	private Paciente paciente;
	private RepositorioPacientesLista proximo;
	private static RepositorioPacientesLista instance;
		
	public static RepositorioPacientesLista getInstance(){
		if (RepositorioPacientesLista.instance == null){
			RepositorioPacientesLista.instance = new RepositorioPacientesLista();
		}
		return RepositorioPacientesLista.instance;
	}
	
	public RepositorioPacientesLista getProximo(){
		return proximo;
	}
	
	public void inserir(Paciente paciente)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.paciente == null){
			this.paciente = paciente;
            proximo = new RepositorioPacientesLista();
        }else{
            proximo.inserir(paciente);
        }
		
	}


	public void alterar(Paciente paciente)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.paciente.getCpf()==paciente.getCpf()){
			this.paciente=paciente;
		}else{
			proximo.alterar(paciente);
		}
		
	}

	
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.paciente!=null){
			if(this.paciente.getCpf().equals(cpf)){
				this.paciente=proximo.paciente;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(cpf);
			}
		}
				
	}

	public boolean verificarExistencia(String cpf) {
		boolean retorno = false;
		RepositorioPacientesLista auxiliar = new RepositorioPacientesLista();
		auxiliar.paciente=this.paciente;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.paciente!=null){
			if(auxiliar.paciente.getCpf().equals(cpf)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Paciente buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Paciente paciente = new Paciente();
		RepositorioPacientesLista auxiliar = new RepositorioPacientesLista();
		auxiliar.paciente=this.paciente;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.paciente!=null){
			if(auxiliar.paciente.getCpf().equals(cpf)){
				paciente=auxiliar.paciente;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return paciente;
	}

	
	public String imprimir(String cpf) {
		Paciente paciente = new Paciente();
		RepositorioPacientesLista auxiliar = new RepositorioPacientesLista();
		auxiliar.paciente=this.paciente;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.paciente!=null){
			if(auxiliar.paciente.getCpf().equals(cpf)){
				paciente=auxiliar.paciente;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = "\nDADOS:\nNome: "+paciente.getNome()+", CPF: "+paciente.getCpf()+
            	", Telefone: "+paciente.getTelefone()+"\n"+paciente.imprimirEndereco()+"\n";
		
		return impressao;
	}

	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		if(this.paciente==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaPacientes = new ArrayList<String> ();
			RepositorioPacientesLista auxiliar = new RepositorioPacientesLista();
			String paciente = null;

			auxiliar.paciente=this.paciente;
			auxiliar.proximo=this.proximo;

			while(auxiliar.paciente!=null){
				paciente = imprimir(auxiliar.paciente.getCpf());
				listaPacientes.add(paciente);
				auxiliar=auxiliar.proximo;				

			}
				
		return listaPacientes;
		}
	}

}
