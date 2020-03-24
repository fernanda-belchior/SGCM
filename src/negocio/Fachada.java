package negocio;
import java.util.ArrayList;

import dados.*;
import exceptions.*;

public class Fachada {
	private ControladorAdministrador controladorAdministrador;
	private ControladorAgenda controladorAgenda;
	private ControladorAgendamento controladorAgendamento;
	private ControladorAtendente controladorAtendente;
	private ControladorCancelamento controladorCancelamento;
	private ControladorConsulta controladorConsulta;
	private ControladorMedico controladorMedico;	
	private ControladorPaciente controladorPaciente;
	private static Fachada instance;
	
	public Fachada() {	
		IRepositorioAdministradores repAdministradores = new RepositorioAdministradoresArray();
		IRepositorioAgendas repAgendas = new RepositorioAgendasArray();
		IRepositorioAgendamentos repAgendamentos = new RepositorioAgendamentosArray();
		IRepositorioAtendentes repAtendentes = new RepositorioAtendentesArray();
		IRepositorioCancelamentos repCancelamentos = new RepositorioCancelamentosArray();
		IRepositorioConsultas repConsultas = new RepositorioConsultasArray();
		IRepositorioMedicos repMedicos = new RepositorioMedicosArray();
		IRepositorioPacientes repPacientes = new RepositorioPacientesArray();
		
			
		controladorAdministrador = new ControladorAdministrador(repAdministradores);
		controladorAgenda = new ControladorAgenda(repAgendas);
		controladorAgendamento = new ControladorAgendamento(repAgendamentos);
		controladorAtendente = new ControladorAtendente(repAtendentes);
		controladorCancelamento = new ControladorCancelamento(repCancelamentos);
		controladorConsulta = new ControladorConsulta (repConsultas);
		controladorMedico = new ControladorMedico(repMedicos);		
		controladorPaciente = new ControladorPaciente(repPacientes);
	}
	
	public static Fachada getInstance(){
		if (Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	
	
	
	
	public void inserir(Administrador administrador) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		this.controladorAdministrador.inserir(administrador);
	}
	
	public void alterar(Administrador administrador) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAdministrador.alterar(administrador);
	}
	
	public void removerAdministrador(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAdministrador.remover(cpf);
	}
	
	public boolean verificarExistenciaAdministrador(String cpf){
		return this.controladorAdministrador.verificarExistencia(cpf);
	}
	
	public Administrador buscarAdministrador(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorAdministrador.buscar(cpf);
		
	}
	
	public String imprimirAdministrador(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorAdministrador.imprimir(cpf);
		
	}
	
	public ArrayList<String> listarAdministradores() throws ExcecaoRepositorioVazio{
		return this.controladorAdministrador.listar();
		
	}

	
	
	
	
	
	
	
	
	
	
	public void inserir(Agenda agenda) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		this.controladorAgenda.inserir(agenda);
	}
	
	public void alterar(Agenda agenda) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAgenda.alterar(agenda);
	}
	
	public void removerAgenda(String idAgenda) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAgenda.remover(idAgenda);
	}
	
	public boolean verificarExistenciaAgenda(String idAgenda){
		return this.controladorAgenda.verificarExistencia(idAgenda);
	}
	
	public Agenda buscarAgenda(String idAgenda) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorAgenda.buscar(idAgenda);
	}
	
	public String imprimirAgenda(String idAgenda) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorAgenda.imprimir(idAgenda);
	}	
	
	public ArrayList<String> listarAgendas() throws ExcecaoRepositorioVazio{
		return this.controladorAgenda.listar();
	}
	
	public ArrayList<Agenda> listarAgendas(String cpfMedico) throws ExcecaoRepositorioVazio,  ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorAgenda.listar(cpfMedico);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void inserir (Agendamento agendamento) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		this.controladorAgendamento.inserir(agendamento);
	}
	
	public void alterar(Agendamento agendamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAgendamento.alterar(agendamento);
	}
	
	public void removerAgendamento(String idAgendamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAgendamento.remover(idAgendamento);
	}
	
	public boolean verificarExistenciaAgendamento(String idAgendamento){
		return this.controladorAgendamento.verificarExistencia(idAgendamento);
	}
	
	public Agendamento buscarAgendamento(String idAgendamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorAgendamento.buscar(idAgendamento);
	}
	
	public String imprimirAgendamento(String idAgendamento) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorAgendamento.imprimir(idAgendamento);
	}
			
	public ArrayList<Agendamento> listarAgendamentos() throws ExcecaoRepositorioVazio{
		return this.controladorAgendamento.listar();		
	}
	
	public ArrayList<String> listarAgendamentos(String cpfMedico) throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido{
		return this.controladorAgendamento.listar(cpfMedico);		
	}
	
	public ArrayList<Agendamento> listarAgendamentos2(String cpfMedico) throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido{
		return this.controladorAgendamento.listarAgendamentos(cpfMedico);		
	}
	public boolean verificarExistenciaAgendamentoPaciente(String cpfPaciente){
		return this.controladorAgendamento.verificarExistenciaAgendamento(cpfPaciente);		
	}
	
	
	
	
	
	
	
	
	
	
	public void inserir(Atendente atendente) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		this.controladorAtendente.inserir(atendente);
	}
	
	public void alterar(Atendente atendente) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAtendente.alterar(atendente);
	}
	
	public void removerAtendente(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorAtendente.remover(cpf);
	}
	
	public boolean verificarExistenciaAtendente(String cpf){
		return this.controladorAtendente.verificarExistencia(cpf);
	}
	
	public Atendente buscarAtendente(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorAtendente.buscar(cpf);
	}
	
	public String imprimirAtendente(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorAtendente.imprimir(cpf);
	}
	
	public ArrayList<String> listarAtendentes() throws ExcecaoRepositorioVazio{
		return this.controladorAtendente.listar();
	}
	
	
	
	
	
	
	
	
	
	
	
	public void inserir(Cancelamento cancelamento) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		this.controladorCancelamento.inserir(cancelamento);
	}
	
	public void alterar(Cancelamento cancelamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorCancelamento.alterar(cancelamento);
	}
	
	public void removerCancelamento(String idCancelamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorCancelamento.remover(idCancelamento);
	}
	
	public boolean verificarExistenciaCancelamento(String idCancelamento){
		return this.controladorCancelamento.verificarExistencia(idCancelamento);
	}
	
	public Cancelamento buscarCancelamento(String idCancelamento) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorCancelamento.buscar(idCancelamento);
	}
	
	public String imprimirCancelamento(String idCancelamento) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorCancelamento.imprimir(idCancelamento);
	}
	
	public ArrayList<String> listarCancelamentos() throws ExcecaoRepositorioVazio{
		return this.controladorCancelamento.listar();
	}
	
	
	
	
	
	
	
	
	
	public void inserir (Consulta consulta) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		this.controladorConsulta.inserir(consulta);
	}
	
	public void alterar(Consulta consulta) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorConsulta.alterar(consulta);
	}
	
	public void removerConsulta(String idConsulta) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorConsulta.remover(idConsulta);
	}
	
	public boolean verificarExistenciaConsulta(String idConsulta){
		return this.controladorConsulta.verificarExistencia(idConsulta);
	}
	
	public Consulta buscarConsulta(String idConsulta) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorConsulta.buscar(idConsulta);
	}
	
	public String imprimirConsulta(String idConsulta) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorConsulta.imprimir(idConsulta);
	}
			
	public ArrayList<String> listarConsultas() throws ExcecaoRepositorioVazio{
		return this.controladorConsulta.listar();		
	}
	public ArrayList<String> listarConsultas(String cpfMedico) throws ExcecaoRepositorioVazio{
		return this.controladorConsulta.listar(cpfMedico);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void inserir(Medico medico) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		this.controladorMedico.inserir(medico);
	}
	
	public void alterar(Medico medico) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorMedico.alterar(medico);
	}
	
	public void removerMedico(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorMedico.remover(cpf);
	}
	
	public boolean verificarExistenciaMedico(String cpf){
		return this.controladorMedico.verificarExistencia(cpf);
	}
	
	public Medico buscarMedico(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorMedico.buscar(cpf);
	}
	
	public String imprimirMedico(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorMedico.imprimir(cpf);
	}
		
	public ArrayList<String> listarMedicos() throws ExcecaoRepositorioVazio{
		return this.controladorMedico.listar();
	}
	
	public ArrayList<Medico> listarMedicos(String especialidade) throws ExcecaoRepositorioVazio{
		return this.controladorMedico.listar(especialidade);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void inserir(Paciente paciente) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{		
   			this.controladorPaciente.inserir(paciente);   		
	}
	
	public void alterar(Paciente paciente) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorPaciente.alterar(paciente);
	}
	
	public void removerPaciente(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		this.controladorPaciente.remover(cpf);
	}
	
	public boolean verificarExistenciaPaciente(String cpf){
		return this.controladorPaciente.verificarExistencia(cpf);
	}
	
	public Paciente buscarPaciente(String cpf) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		return this.controladorPaciente.buscar(cpf);
	}
	
	public String imprimirPaciente(String cpf) throws ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		return this.controladorPaciente.imprimir(cpf);
	}
	
	public ArrayList<String> listarPacientes() throws ExcecaoRepositorioVazio{
		return this.controladorPaciente.listar();
	}
	
	
}
