package dados;

import java.util.ArrayList;






import exceptions.*;
import negocio.*;

public class RepositorioAtendentesLista implements IRepositorioAtendentes{
	private Atendente atendente;
	private RepositorioAtendentesLista proximo;
	private static RepositorioAtendentesLista instance;
	    
	    public static RepositorioAtendentesLista getInstance(){
	    	if (RepositorioAtendentesLista.instance == null){
	    		RepositorioAtendentesLista.instance = new RepositorioAtendentesLista ();
	    	}
	    	return RepositorioAtendentesLista.instance;
	    }
		
	
	public RepositorioAtendentesLista getProximo(){
		return proximo;
	}
	
	public void inserir(Atendente atendente)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.atendente == null){
			this.atendente = atendente;
            proximo = new RepositorioAtendentesLista();
        }else{
            proximo.inserir(atendente);
        }
		
	}


	public void alterar(Atendente atendente)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.atendente.getCpf().equals(atendente.getCpf())){
			this.atendente=atendente;
		}else{
			proximo.alterar(atendente);
		}
		
	}

	
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.atendente!=null){
			if(this.atendente.getCpf().equals(cpf)){
				this.atendente=proximo.atendente;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(cpf);
			}
		}
				
	}

	public boolean verificarExistencia(String cpf) {
		boolean retorno = false;
		RepositorioAtendentesLista auxiliar = new RepositorioAtendentesLista();
		auxiliar.atendente=this.atendente;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.atendente!=null){
			if(auxiliar.atendente.getCpf().equals(cpf)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Atendente buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Atendente atendente = new Atendente();
		RepositorioAtendentesLista auxiliar = new RepositorioAtendentesLista();
		auxiliar.atendente=this.atendente;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.atendente!=null){
			if(auxiliar.atendente.getCpf().equals(cpf)){
				atendente=auxiliar.atendente;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return atendente;
	}

	
	public String imprimir(String cpf) {
		negocio.Atendente atendente = new Atendente();
		RepositorioAtendentesLista auxiliar = new RepositorioAtendentesLista();
		auxiliar.atendente=this.atendente;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.atendente!=null){
			if(auxiliar.atendente.getCpf().equals(cpf)){
				atendente=auxiliar.atendente;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = "\nNome: "+atendente.getNome()+"\nCPF: "+atendente.getCpf()+
            	"\nTelefone: "+atendente.getTelefone()+"\n";
		
		return impressao;
	}

	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		if(this.atendente==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaAtendentes = new ArrayList<String> ();
			RepositorioAtendentesLista auxiliar = new RepositorioAtendentesLista();
			String atendente = null;

			auxiliar.atendente=this.atendente;
			auxiliar.proximo=this.proximo;

			while(auxiliar.atendente!=null){
				atendente = imprimir(auxiliar.atendente.getCpf());
				listaAtendentes.add(atendente);
				auxiliar=auxiliar.proximo;				

			}
				
		return listaAtendentes;
		}
	}
	
}
	


