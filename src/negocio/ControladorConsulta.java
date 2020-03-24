package negocio;

import java.util.ArrayList;
import dados.*;
import exceptions.*;

public class ControladorConsulta {
	private IRepositorioConsultas repConsultas;

	public ControladorConsulta(IRepositorioConsultas repConsultas){
		this.repConsultas= repConsultas;
	}	

	public void inserir(Consulta consulta) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(consulta==null||consulta.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repConsultas.verificarExistencia(consulta.getIdConsulta())){
				this.repConsultas.inserir(consulta);
			}else{
				throw new ExcecaoElementoJaExistente();
			}			
		}
	}



	public void alterar(Consulta consulta) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(consulta==null||consulta.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repConsultas.verificarExistencia(consulta.getIdConsulta())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repConsultas.alterar(consulta);

			}

		}
	}


	public void remover(String idConsulta) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(idConsulta==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repConsultas.verificarExistencia(idConsulta)){
				this.repConsultas.remover(idConsulta);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}


	public Consulta buscar(String idConsulta) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Consulta consulta = new Consulta();
		if(idConsulta==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repConsultas.verificarExistencia(idConsulta)){
				consulta=this.repConsultas.buscar(idConsulta);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return consulta;
	}


	public boolean verificarExistencia(String idConsulta){
		return this.repConsultas.verificarExistencia(idConsulta);
	}


	public String imprimir(String idConsulta) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(idConsulta==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repConsultas.verificarExistencia(idConsulta)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repConsultas.imprimir(idConsulta);
	}


	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		return this.repConsultas.listar();
	}
	
	public ArrayList<String> listar(String cpfMedico) throws ExcecaoRepositorioVazio{
		return this.repConsultas.listar(cpfMedico);
	}
	
	
}