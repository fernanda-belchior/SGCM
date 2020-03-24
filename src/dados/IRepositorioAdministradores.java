package dados;

import java.util.ArrayList;


import exceptions.*;
import negocio.*;

public interface IRepositorioAdministradores {
	
	public void inserir(Administrador administrador)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;;
	public void alterar(Administrador administrador)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String cpf);
	public Administrador buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String cpf);
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio;
	
	
	

}
