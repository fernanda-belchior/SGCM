package negocio;

import java.util.ArrayList;
import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

public class ControladorPaciente {
	
	private IRepositorioPacientes repPacientes;
		
	public ControladorPaciente(IRepositorioPacientes repPacientes){
		this.repPacientes= repPacientes;
	}	

	public void inserir(Paciente paciente) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(paciente==null||paciente.getEndereco()==null||paciente.toString().contains("null")
				||paciente.getEndereco().toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repPacientes.verificarExistencia(paciente.getCpf())){
				this.repPacientes.inserir(paciente);
			}else{
				throw new ExcecaoElementoJaExistente();
			}		
		}
	}
		
	

	public void alterar(Paciente paciente) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(paciente==null||paciente.getEndereco()==null||
			paciente.toString().contains("null")||paciente.getEndereco().toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repPacientes.verificarExistencia(paciente.getCpf())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repPacientes.alterar(paciente);

			}
						
		}
	}
	

	public void remover(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(cpf==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repPacientes.verificarExistencia(cpf)){
				this.repPacientes.remover(cpf);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}
	
	
	public Paciente buscar(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Paciente paciente = new Paciente();
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repPacientes.verificarExistencia(cpf)){
				paciente=this.repPacientes.buscar(cpf);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return paciente;
	}
	
	
	public boolean verificarExistencia(String cpf){
		return this.repPacientes.verificarExistencia(cpf);
	}
	
	
	public String imprimir(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repPacientes.verificarExistencia(cpf)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repPacientes.imprimir(cpf);
	}
	
	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		return this.repPacientes.listar();
	}
	
		

}


