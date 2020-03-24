package dados;

import java.util.ArrayList;

import exceptions.*;
import negocio.*;

public class RepositorioAdministradoresLista implements IRepositorioAdministradores{
	private Administrador administrador;
	private RepositorioAdministradoresLista proximo;
	private static RepositorioAdministradoresLista instance;
    
    public static RepositorioAdministradoresLista getInstance(){
		if (RepositorioAdministradoresLista.instance == null){
			RepositorioAdministradoresLista.instance = new RepositorioAdministradoresLista ();
		}
		return RepositorioAdministradoresLista.instance;
	}
    
		
	
	public RepositorioAdministradoresLista getProximo(){
		return proximo;
	}
	
	public void inserir(Administrador administrador)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.administrador == null){
			this.administrador = administrador;
            proximo = new RepositorioAdministradoresLista();
        }else{
            proximo.inserir(administrador);
        }
		
	}


	public void alterar(Administrador administrador)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.administrador.getCpf().equals(administrador.getCpf())){
			this.administrador=administrador;
		}else{
			proximo.alterar(administrador);
		}
		
	}

	
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.administrador!=null){
			if(this.administrador.getCpf().equals(cpf)){
				this.administrador=proximo.administrador;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(cpf);
			}
		}
				
	}

	public boolean verificarExistencia(String cpf) {
		boolean retorno = false;
		RepositorioAdministradoresLista auxiliar = new RepositorioAdministradoresLista();
		auxiliar.administrador=this.administrador;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.administrador!=null){
			if(auxiliar.administrador.getCpf().equals(cpf)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Administrador buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Administrador administrador = new Administrador();
		RepositorioAdministradoresLista auxiliar = new RepositorioAdministradoresLista();
		auxiliar.administrador=this.administrador;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.administrador!=null){
			if(auxiliar.administrador.getCpf().equals(cpf)){
				administrador=auxiliar.administrador;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return administrador;
	}

	
	public String imprimir(String cpf) {
		negocio.Administrador administrador = new Administrador();
		RepositorioAdministradoresLista auxiliar = new RepositorioAdministradoresLista();
		auxiliar.administrador=this.administrador;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.administrador!=null){
			if(auxiliar.administrador.getCpf().equals(cpf)){
				administrador=auxiliar.administrador;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = "\nNome: "+administrador.getNome()+"\nCPF: "+administrador.getCpf()+
            	"\nTelefone: "+administrador.getTelefone()+"\n";
		
		return impressao;
	}

	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		ArrayList<String> listaAdministradores = new ArrayList<String> ();
		RepositorioAdministradoresLista auxiliar = new RepositorioAdministradoresLista();
		String administrador = null;
		
		if(this.administrador==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			auxiliar.administrador=this.administrador;
			auxiliar.proximo=this.proximo;

			while(auxiliar.administrador!=null){
				administrador = imprimir(auxiliar.administrador.getCpf());
				listaAdministradores.add(administrador);
				auxiliar=auxiliar.proximo;				

			}
				
		return listaAdministradores;
		}
	}
	
	
	
	

}