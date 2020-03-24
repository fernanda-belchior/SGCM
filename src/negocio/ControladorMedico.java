package negocio;

import java.util.ArrayList;
import dados.*;
import exceptions.*;

public class ControladorMedico {
	
	private IRepositorioMedicos repMedicos;
	
	public ControladorMedico(IRepositorioMedicos repMedicos){
		this.repMedicos= repMedicos;
	}	

	public void inserir(Medico medico) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(medico==null||medico.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
				if(!this.repMedicos.verificarExistencia(medico.getCpf())){
					this.repMedicos.inserir(medico);
				}else{
					throw new ExcecaoElementoJaExistente();
				}			
			}
	}
	
	

	public void alterar(Medico medico) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(medico==null||medico.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repMedicos.verificarExistencia(medico.getCpf())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repMedicos.alterar(medico);

			}
						
		}
	}
	

	public void remover(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(cpf==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repMedicos.verificarExistencia(cpf)){
				this.repMedicos.remover(cpf);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}
	
	
	public Medico buscar(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Medico medico = new Medico();
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repMedicos.verificarExistencia(cpf)){
				medico=this.repMedicos.buscar(cpf);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return medico;
	}
	
	
	public boolean verificarExistencia(String cpf){
		return this.repMedicos.verificarExistencia(cpf);
	}
	
	
	public String imprimir(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repMedicos.verificarExistencia(cpf)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repMedicos.imprimir(cpf);
	}
	
	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		return this.repMedicos.listar();
	}
	
	public ArrayList<Medico> listar(String especialidade) throws ExcecaoRepositorioVazio{
		return this.repMedicos.listar(especialidade);
	}
	
			

}


