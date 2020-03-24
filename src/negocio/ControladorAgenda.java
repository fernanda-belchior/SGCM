package negocio;

import java.util.ArrayList;

import dados.*;
import exceptions.*;

public class ControladorAgenda {
		
	private IRepositorioAgendas repAgendas;
	
	public ControladorAgenda(IRepositorioAgendas repAgendas){
		this.repAgendas= repAgendas;
	}	

	public void inserir(Agenda agenda) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(agenda==null||agenda.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
				if(!this.repAgendas.verificarExistencia(agenda.getIdAgenda())){
					this.repAgendas.inserir(agenda);
				}else{
					throw new ExcecaoElementoJaExistente();
				}			
			}
	}
	
	

	public void alterar(Agenda agenda) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(agenda==null||agenda.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repAgendas.verificarExistencia(agenda.getIdAgenda())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repAgendas.alterar(agenda);

			}
						
		}
	}
	

	public void remover(String idAgenda) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(idAgenda==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repAgendas.verificarExistencia(idAgenda)){
				this.repAgendas.remover(idAgenda);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}
	
	
	public Agenda buscar(String idAgenda) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Agenda agenda = new Agenda();
		if(idAgenda==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repAgendas.verificarExistencia(idAgenda)){
				agenda=this.repAgendas.buscar(idAgenda);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return agenda;
	}
	
	
	public boolean verificarExistencia(String idAgenda){
		return this.repAgendas.verificarExistencia(idAgenda);
	}
	
	
	public String imprimir(String idAgenda)throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(idAgenda==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repAgendas.verificarExistencia(idAgenda)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repAgendas.imprimir(idAgenda);
	}
	
	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		return this.repAgendas.listar();
	}
	
	public ArrayList<Agenda> listar(String cpfMedico) throws ExcecaoRepositorioVazio,  ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		if(cpfMedico==null){
			throw new ExcecaoDadoInvalido();
		}
		return this.repAgendas.listar(cpfMedico);
	}

}