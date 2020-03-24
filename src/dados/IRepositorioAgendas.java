package dados;

import java.util.ArrayList;

import exceptions.*;
import negocio.*;

public interface IRepositorioAgendas {
	
	public void inserir(Agenda agenda)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;
	public void alterar(Agenda agenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String idAgenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String idAgenda);
	public Agenda buscar(String idAgenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String idAgenda);
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio;
	public ArrayList<Agenda> listar(String cpfMedico)throws ExcecaoRepositorioVazio,ExcecaoElementoInexistente, ExcecaoDadoInvalido;


}
