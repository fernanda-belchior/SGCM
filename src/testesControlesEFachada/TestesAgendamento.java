package testesControlesEFachada;

import static java.lang.System.out;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class TestesAgendamento {
	
	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente {
		Fachada fachada = Fachada.getInstance();
		
					
		Agendamento ag1= new Agendamento ("079", "1234","657","427","19/06/2017","1235");
		Agendamento ag2= new Agendamento ("058", "1235","657","427","19/06/2017","1236");
		Agendamento ag3= new Agendamento ("562", "1236","657","543","19/06/2017","1237");
		
		
		//Insere três agendamentos:
		fachada.inserir(ag1);
		fachada.inserir(ag2);
		fachada.inserir(ag3);
		

		//imprime os três agendamentos:
		System.out.println(fachada.imprimirAgendamento("1235"));
		System.out.println(fachada.imprimirAgendamento("1236"));
		System.out.println(fachada.imprimirAgendamento("1237"));
		out.println("-----------------------------------------------------");

				
	
		//Verifica de existência de dois agendamentos
		System.out.println(fachada.verificarExistenciaAgendamento("079"));
		System.out.println(fachada.verificarExistenciaAgendamento("123"));
		
		out.println("-----------------------------------------------------");
								
		//Altera dados de um agendamento (idAgenda), busca o objeto e imprime o antes e o depois da alteração:
		Agendamento ag4= new Agendamento ("058", "2164","657","427","19/06/2017","1236");
		out.println("idAgenda: "+fachada.buscarAgendamento("1236").getIdAgenda());
		fachada.alterar(ag4);
		out.println("idAgenda: "+fachada.buscarAgendamento("1236").getIdAgenda());
		
		out.println("-----------------------------------------------------");
		
		
		//Remove um agendamento e verifica a existência:
		fachada.removerAgendamento("1235");
		System.out.println(fachada.verificarExistenciaAgendamento("079"));
		out.println("-----------------------------------------------------");
				
				
		//Lista todos os agendamentos por especialidade :
		ArrayList<String> agendamentos2 = fachada.listarAgendamentos("427");	
		for(int j=0; j<agendamentos2.size(); j++){
			out.println(agendamentos2.get(j));			
		}
		out.println("-----------------------------------------------------");
		
		//Lista todos os agendamentos:
			ArrayList<Agendamento> agendamentos3 = fachada.listarAgendamentos();	
			for(int j=0; j<agendamentos3.size(); j++){
				out.println(agendamentos3.get(j).toString());			
			}
			
		out.println("-----------------------------------------------------");	
		
		//Lista todos os agendamentos por especialidade :
		ArrayList<Agendamento> agendamentos4 = fachada.listarAgendamentos2("427");	
		for(int j=0; j<agendamentos4.size(); j++){
			out.println(agendamentos4.get(j));			
		}
	}

}
