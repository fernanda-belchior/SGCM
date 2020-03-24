package testesRepositorios;

import static java.lang.System.out;

import java.util.ArrayList;

import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class TestesAgendas {
	static RepositorioAgendasArray repAgendas = new RepositorioAgendasArray();
	static RepositorioAgendasLista repAgendasLista = new RepositorioAgendasLista();
	
	//Criado para testar o método verificarExistencia do repositorio:
	public static void verificar(String cpf){
		if(repAgendas.verificarExistencia(cpf)==true){
			out.println("Existe");
		}else{
			out.println("Não existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {
			
		
		Agenda ag1 = new Agenda("20/06/2017","08:00","427","ag11","disponivel");
		Agenda ag2 = new Agenda("20/06/2017","09:00","427","ag12","disponivel");
		Agenda ag3 = new Agenda("21/06/2017","14:00","543","ag13","disponivel");
		Agenda ag4 = new Agenda("21/06/2017","15:00","543","ag14","disponivel");	
		
		
		//Testes Repositorio Array
		System.out.println("Testes Repositoio Arrayn\n");
				
		//Insere quatro agendas:
		repAgendas.inserir(ag1);
		repAgendas.inserir(ag2);
		repAgendas.inserir(ag3);
		repAgendas.inserir(ag4);
		
		//Imprime os dados das agendas inseridas:
		out.println(repAgendas.imprimir(ag1.getIdAgenda()));
		out.println(repAgendas.imprimir(ag2.getIdAgenda()));
		out.println(repAgendas.imprimir(ag3.getIdAgenda()));
		out.println(repAgendas.imprimir(ag4.getIdAgenda()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de duas agendas através do idAgenda:
		verificar("ag12");
		verificar("123");
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de agenda pelo idAgenda e exibe a data.
		Agenda ag5 = repAgendas.buscar("ag12");
		out.println("Data: "+ag5.getData());
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de uma agenda (ag1) atraves do id e verifica a existencia:
		repAgendas.remover(ag1.getIdAgenda());
		verificar(ag1.getIdAgenda());
		out.println("\n-----------------------------------------------------");
		
		
		//Lista os dados de todas as agendas cadastradas através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> agendas = repAgendas.listar();		
		for(int i=0; i<agendas.size(); i++){
			out.println(agendas.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//Altera dados de uma agenda e mostra o antes e o depois atraves do metodo buscar:
		out.println("Data: "+repAgendas.buscar("ag12").getData());
		Agenda ag6 = new Agenda("23/06/2017","09:00","427","ag12","disponivel");
		repAgendas.alterar(ag6);		
		out.println("Data: "+repAgendas.buscar("ag12").getData());	
		
		out.println("\n-----------------------------------------------------");
		
		//Teste listar horarios de agendas por médico		
		ArrayList<Agenda> agendas5 = repAgendas.listar("427");	
		for(int i=0; i<agendas5.size(); i++){
			out.println(agendas5.get(i).getHora());			
		}	

		
		
		
		
		
		
		
	
		//Testes Repositorio Lista
		out.println("Testes Repositoio Lista\n\n");
		
		//Insere quatro agendas:
		repAgendasLista.inserir(ag1);
		repAgendasLista.inserir(ag2);
		repAgendasLista.inserir(ag3);
		repAgendasLista.inserir(ag4);
		
		//Imprime os dados das agendas inseridas:
		out.println(repAgendasLista.imprimir(ag1.getIdAgenda()));
		out.println(repAgendasLista.imprimir(ag2.getIdAgenda()));
		out.println(repAgendasLista.imprimir(ag3.getIdAgenda()));
		out.println(repAgendasLista.imprimir(ag4.getIdAgenda()));
		
		out.println("-----------------------------------------------------");				
				
		// Verifica a existencia de duas agendas através do idAgenda:
		System.out.println(repAgendasLista.verificarExistencia("ag12"));
		System.out.println(repAgendasLista.verificarExistencia("123"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de agenda pelo idAgenda e exibe a data.
		Agenda ag8 = repAgendasLista.buscar("ag12");
		out.println("Data: "+ag8.getData());
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de uma agenda (ag1) atraves do id e verifica a existencia:
		repAgendasLista.remover(ag1.getIdAgenda());
		System.out.println(repAgendasLista.verificarExistencia(ag1.getIdAgenda()));
		out.println("\n-----------------------------------------------------");
		
		
		//Lista os dados de todas as agendas cadastradas através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> agendas2 = repAgendasLista.listar();		
		for(int i=0; i<agendas2.size(); i++){
			out.println(agendas2.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//Altera dados de uma agenda e mostra o antes e o depois atraves do metodo buscar:
		out.println("Data: "+repAgendasLista.buscar("ag12").getData());
		Agenda ag7 = new Agenda("23/06/2017","09:00","427","ag12","disponivel");
		repAgendasLista.alterar(ag7);		
		out.println("Data: "+repAgendasLista.buscar("ag12").getData());		
		
		out.println("\n-----------------------------------------------------");
		
		//Teste listar horarios de agendas por médico		
		ArrayList<Agenda> agendas6 = repAgendasLista.listar("427");	
		for(int i=0; i<agendas6.size(); i++){
			out.println(agendas6.get(i).getHora());			
		}			

	}
}
			
		