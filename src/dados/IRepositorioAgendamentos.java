package dados;

import java.util.ArrayList;
import exceptions.*;
import negocio.*;

public interface IRepositorioAgendamentos {
	
	public void inserir(Agendamento agendamento)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;
	public void alterar(Agendamento agendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String idAgendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String idAgendamento);
	public boolean verificarExistenciaAgendamento(String cpfPaciente);
	public Agendamento buscar(String idAgendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String idAgendamento);
	public ArrayList<Agendamento> listar()throws ExcecaoRepositorioVazio;
	public ArrayList<String> listar(String cpfMedico)throws ExcecaoRepositorioVazio,ExcecaoDadoInvalido;
	public ArrayList<Agendamento> listarAgendamentos(String cpfMedico)throws ExcecaoRepositorioVazio,ExcecaoDadoInvalido;

}
