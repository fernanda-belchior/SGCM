package dados;

import java.util.ArrayList;
import exceptions.*;
import negocio.*;

public interface IRepositorioAtendentes {
	
	public void inserir(Atendente atendente)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;
	public void alterar(Atendente atendente)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String cpf);
	public Atendente buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String cpf);
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio;
	

}
