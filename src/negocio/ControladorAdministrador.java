package negocio;

import java.util.ArrayList;

import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

public class ControladorAdministrador {
	private IRepositorioAdministradores repAdministradores;

	public ControladorAdministrador(IRepositorioAdministradores repAdministradores){
		this.repAdministradores= repAdministradores;
	}	

	public void inserir(Administrador administrador) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		if(administrador==null||administrador.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repAdministradores.verificarExistencia(administrador.getCpf())){
				this.repAdministradores.inserir(administrador);
			}else{
				throw new ExcecaoElementoJaExistente();
			}			
		}
	}



	public void alterar(Administrador administrador) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(administrador==null||administrador.toString().contains("null")){
			throw new ExcecaoDadoInvalido();
		}else{			
			if(!this.repAdministradores.verificarExistencia(administrador.getCpf())){
				throw new ExcecaoElementoInexistente();
			}else{
				this.repAdministradores.alterar(administrador);

			}

		}
	}


	public void remover(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(cpf==null){
			throw new ExcecaoDadoInvalido();

		}else{
			if(this.repAdministradores.verificarExistencia(cpf)){
				this.repAdministradores.remover(cpf);
			}else{
				throw new ExcecaoElementoInexistente();

			}
		}
	}


	public Administrador buscar(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Administrador administrador = new Administrador();
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(this.repAdministradores.verificarExistencia(cpf)){
				administrador=this.repAdministradores.buscar(cpf);
			}else{
				throw new ExcecaoElementoInexistente();
			}
		}
		return administrador;
	}


	public boolean verificarExistencia(String cpf){
		return this.repAdministradores.verificarExistencia(cpf);
	}


	public String imprimir(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente {
		if(cpf==null){
			throw new ExcecaoDadoInvalido();
		}else{
			if(!this.repAdministradores.verificarExistencia(cpf)){
				throw new ExcecaoElementoInexistente();
			}
		}
		return this.repAdministradores.imprimir(cpf);
	}


	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		return this.repAdministradores.listar();
	}



}


