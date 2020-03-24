package dados;

import java.util.ArrayList;
import exceptions.*;
import negocio.*;

public interface IRepositorioCancelamentos {
	
	public void inserir(Cancelamento Cancelamento)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;
	public void alterar(Cancelamento Cancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String idCancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String idCancelamento);
	public Cancelamento buscar(String idCancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String idCancelamento);
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio;	
}
