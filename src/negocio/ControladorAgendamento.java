package negocio;

import java.util.ArrayList;

import dados.*;
import exceptions.*;

public class ControladorAgendamento {
	
	private IRepositorioAgendamentos repAgendamentos;
	
	public ControladorAgendamento(IRepositorioAgendamentos repAgendamentos){
		this.repAgendamentos= repAgendamentos;
	}	

	public void inserir(Agendamento agendamento) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(agendamento==null||agendamento.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repAgendamentos.verificarExistencia(agendamento.getCpfPaciente())){
				this.repAgendamentos.inserir(agendamento);
			}else{
				throw new ExcecaoElementoJaExistente();
			}			
		}
	}
	
	

	public void alterar(Agendamento agendamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(agendamento==null||agendamento.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repAgendamentos.verificarExistencia(agendamento.getIdAgendamento())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repAgendamentos.alterar(agendamento);

			}
						
		}
	}
	

	public void remover(String idAgendamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(idAgendamento==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repAgendamentos.verificarExistencia(idAgendamento)){
				this.repAgendamentos.remover(idAgendamento);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}
	
	
	public Agendamento buscar(String idAgendamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Agendamento agendamento = new Agendamento();
		if(idAgendamento==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repAgendamentos.verificarExistencia(idAgendamento)){
				agendamento=this.repAgendamentos.buscar(idAgendamento);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return agendamento;
	}
	
	
	public boolean verificarExistencia(String idAgendamento){
		return this.repAgendamentos.verificarExistencia(idAgendamento);
	}
	
	
	public String imprimir(String idAgendamento) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(idAgendamento==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repAgendamentos.verificarExistencia(idAgendamento)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repAgendamentos.imprimir(idAgendamento);
	}
	
	
	public ArrayList<Agendamento> listar() throws ExcecaoRepositorioVazio{
		return this.repAgendamentos.listar();
	}
	
	public ArrayList<String> listar(String cpfMedico) throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido{
		if(cpfMedico==null){
			throw new ExcecaoDadoInvalido();
		}else{
			return this.repAgendamentos.listar(cpfMedico);
		}
	}
	
	public ArrayList<Agendamento> listarAgendamentos(String cpfMedico) throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido{
		if(cpfMedico==null){
			throw new ExcecaoDadoInvalido();
		}else{
			return this.repAgendamentos.listarAgendamentos(cpfMedico);
		}
	}
	
	public boolean verificarExistenciaAgendamento(String cpfPaciente){
		return this.repAgendamentos.verificarExistenciaAgendamento(cpfPaciente);
		
	}
	
	 
}