package negocio;

import java.util.ArrayList;
import dados.*;
import exceptions.*;

public class ControladorCancelamento {
	private IRepositorioCancelamentos repCancelamentos;
	
	public ControladorCancelamento(IRepositorioCancelamentos repCancelamentos){
		this.repCancelamentos= repCancelamentos;
	}	

	public void inserir(Cancelamento cancelamento) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(cancelamento==null||cancelamento.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repCancelamentos.verificarExistencia(cancelamento.getIdCancelamento())){
				this.repCancelamentos.inserir(cancelamento);
			}else{
				throw new ExcecaoElementoJaExistente();
			}			
		}
	}



	public void alterar(Cancelamento cancelamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(cancelamento==null||cancelamento.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repCancelamentos.verificarExistencia(cancelamento.getIdCancelamento())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repCancelamentos.alterar(cancelamento);

			}

		}
	}


	public void remover(String idCancelamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(idCancelamento==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repCancelamentos.verificarExistencia(idCancelamento)){
				this.repCancelamentos.remover(idCancelamento);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}


	public Cancelamento buscar(String idCancelamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Cancelamento cancelamento = new Cancelamento();
		if(idCancelamento==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repCancelamentos.verificarExistencia(idCancelamento)){
				cancelamento=this.repCancelamentos.buscar(idCancelamento);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return cancelamento;
	}


	public boolean verificarExistencia(String idCancelamento){
		return this.repCancelamentos.verificarExistencia(idCancelamento);
	}


	public String imprimir(String idCancelamento) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(idCancelamento==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repCancelamentos.verificarExistencia(idCancelamento)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repCancelamentos.imprimir(idCancelamento);
	}


	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		return this.repCancelamentos.listar();
	}
}