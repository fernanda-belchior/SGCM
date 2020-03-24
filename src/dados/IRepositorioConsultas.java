package dados;

import java.util.ArrayList;

import negocio.*;
import exceptions.*;

public interface IRepositorioConsultas {
	public void inserir(Consulta consulta)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido;
	public void alterar(Consulta consulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public void remover(String idConsulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public boolean verificarExistencia(String cpfPaciente);
	public Consulta buscar(String idConsulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido;
	public String imprimir(String idConsulta);
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio;
	public ArrayList<String> listar(String cpfMedico)throws ExcecaoRepositorioVazio;


}
