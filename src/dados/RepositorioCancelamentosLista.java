package dados;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class RepositorioCancelamentosLista implements IRepositorioCancelamentos{
	private Cancelamento cancelamento;
	private RepositorioCancelamentosLista proximo;
	private static RepositorioCancelamentosLista instance;
    
    public static RepositorioCancelamentosLista getInstance(){
		if (RepositorioCancelamentosLista.instance == null){
			RepositorioCancelamentosLista.instance = new RepositorioCancelamentosLista ();
		}
		return RepositorioCancelamentosLista.instance;
	}
		
	
	public RepositorioCancelamentosLista getProximo(){
		return proximo;
	}
	
	public void inserir(Cancelamento cancelamento)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.cancelamento == null){
			this.cancelamento = cancelamento;
            proximo = new RepositorioCancelamentosLista();
        }else{
            proximo.inserir(cancelamento);
        }
		
	}


	public void alterar(Cancelamento cancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.cancelamento.getIdCancelamento().equals(cancelamento.getIdCancelamento())){
			this.cancelamento=cancelamento;
		}else{
			proximo.alterar(cancelamento);
		}
		
	}

	
	public void remover(String idCancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.cancelamento!=null){
			if(this.cancelamento.getIdCancelamento().equals(idCancelamento)){
				this.cancelamento=proximo.cancelamento;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(idCancelamento);
			}
		}
		
	}

	public boolean verificarExistencia(String idCancelamento) {
		boolean retorno = false;
		RepositorioCancelamentosLista auxiliar = new RepositorioCancelamentosLista();
		auxiliar.cancelamento=this.cancelamento;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.cancelamento!=null){
			if(auxiliar.cancelamento.getIdCancelamento().equals(idCancelamento)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Cancelamento buscar(String idCancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Cancelamento cancelamento = new Cancelamento();
		RepositorioCancelamentosLista auxiliar = new RepositorioCancelamentosLista();
		auxiliar.cancelamento=this.cancelamento;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.cancelamento!=null){
			if(auxiliar.cancelamento.getIdCancelamento().equals(idCancelamento)){
				cancelamento=auxiliar.cancelamento;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return cancelamento;
	}

	
	public String imprimir(String idCancelamento) {

		Cancelamento cancelamento = new Cancelamento();
		RepositorioCancelamentosLista auxiliar = new RepositorioCancelamentosLista();
		auxiliar.cancelamento=this.cancelamento;
		auxiliar.proximo=this.proximo;

		while(auxiliar.cancelamento!=null){
			if(auxiliar.cancelamento.getIdCancelamento().equals(idCancelamento)){
				cancelamento=auxiliar.cancelamento;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = cancelamento.toString();

		return impressao;
	}

	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		if(this.cancelamento==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaCancelamentos = new ArrayList<String> ();
			RepositorioCancelamentosLista auxiliar = new RepositorioCancelamentosLista();
			String cancelamento = null;

			auxiliar.cancelamento=this.cancelamento;
			auxiliar.proximo=this.proximo;

			while(auxiliar.cancelamento!=null){
				cancelamento = imprimir(auxiliar.cancelamento.getIdCancelamento());
				listaCancelamentos.add(cancelamento);
				auxiliar=auxiliar.proximo;				

			}		

			return listaCancelamentos;
		}
	}
	}