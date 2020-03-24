package testesControlesEFachada;

import static java.lang.System.out;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class TestesAgenda {
	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente {
		Fachada fachada = Fachada.getInstance();
				
		Agenda ag1 = new Agenda("20/06/2017","08:00","427","ag11","disponivel");
		Agenda ag2 = new Agenda("20/06/2017","09:00","427","ag12","disponivel");
		Agenda ag3 = new Agenda("21/06/2017","14:00","543","ag13","disponivel");
		Agenda ag4 = new Agenda("21/06/2017","15:00","543","ag14","disponivel");	
		
				
		//Insere quatro agendas:
		fachada.inserir(ag1);
		fachada.inserir(ag2);
		fachada.inserir(ag3);
		fachada.inserir(ag4);
		
		//Imprime os dados das agendas inseridas:
		out.println(fachada.imprimirAgenda(ag1.getIdAgenda()));
		out.println(fachada.imprimirAgenda(ag2.getIdAgenda()));
		out.println(fachada.imprimirAgenda(ag3.getIdAgenda()));
		out.println(fachada.imprimirAgenda(ag4.getIdAgenda()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de duas agendas através do idAgenda:
		System.out.println(fachada.verificarExistenciaAgenda("ag12"));
		System.out.println(fachada.verificarExistenciaAgenda("123"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de agenda pelo idAgenda e exibe a data.
		Agenda ag5 = fachada.buscarAgenda("ag12");
		out.println("Data: "+ag5.getData());
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de uma agenda (ag1) atraves do id e verifica a existencia:
		fachada.removerAgenda(ag1.getIdAgenda());
		System.out.println(fachada.verificarExistenciaAgenda(ag1.getIdAgenda()));
		out.println("\n-----------------------------------------------------");
		
		
		//Lista os dados de todas as agendas cadastradas através da busca no arraylist 
		//retornado do método listarAgendas		
		ArrayList<String> agendas = fachada.listarAgendas();		
		for(int i=0; i<agendas.size(); i++){
			out.println(agendas.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//Altera dados de uma agenda e mostra o antes e o depois atraves do metodo buscarAgenda:
		out.println("Data: "+fachada.buscarAgenda("ag12").getData());
		Agenda ag6 = new Agenda("23/06/2017","09:00","427","ag12","disponivel");
		fachada.alterar(ag6);		
		out.println("Data: "+fachada.buscarAgenda("ag12").getData());		
		
		out.println("\n-----------------------------------------------------");

			
		//Teste listar horarios de agendas por médico
		ArrayList<Agenda> agendas5 = fachada.listarAgendas("427");	
		for(int i=0; i<agendas5.size(); i++){
			out.println(agendas5.get(i).getHora());			
		}
	}
}
			
		


