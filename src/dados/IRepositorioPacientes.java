package dados;
import java.util.*;
import exceptions.*;
import negocio.*;

public interface IRepositorioPacientes {
	
	public void inserir(Paciente paciente)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;
	public void alterar(Paciente paciente)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String cpf);
	public Paciente buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String cpf);
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio;
	
}
