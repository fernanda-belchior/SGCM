package dados;

import java.util.ArrayList;
import exceptions.*;
import negocio.*;

public interface IRepositorioMedicos {
	
	public void inserir(Medico especialidade)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;
	public void alterar(Medico especialidade)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String cpf);
	public Medico buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String cpf);
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio;
	public ArrayList<Medico> listar(String especialidade)throws ExcecaoRepositorioVazio;	
	
}
