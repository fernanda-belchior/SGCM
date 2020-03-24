package negocio;

import java.util.ArrayList;

import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

public class ControladorAtendente {
	
	private IRepositorioAtendentes repAtendentes;

	public ControladorAtendente(IRepositorioAtendentes repAtendentes){
		this.repAtendentes= repAtendentes;
	}	

	public void inserir(Atendente atendente) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(atendente==null||atendente.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repAtendentes.verificarExistencia(atendente.getCpf())){
				this.repAtendentes.inserir(atendente);
			}else{
				throw new ExcecaoElementoJaExistente();
			}			
		}
	}



	public void alterar(Atendente atendente) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(atendente==null||atendente.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repAtendentes.verificarExistencia(atendente.getCpf())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repAtendentes.alterar(atendente);

			}

		}
	}


	public void remover(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(cpf==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repAtendentes.verificarExistencia(cpf)){
				this.repAtendentes.remover(cpf);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}


	public Atendente buscar(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Atendente atendente = new Atendente();
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repAtendentes.verificarExistencia(cpf)){
				atendente=this.repAtendentes.buscar(cpf);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return atendente;
	}


	public boolean verificarExistencia(String cpf){
		return this.repAtendentes.verificarExistencia(cpf);
	}


	public String imprimir(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repAtendentes.verificarExistencia(cpf)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repAtendentes.imprimir(cpf);
	}


	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		return this.repAtendentes.listar();
	}



}


