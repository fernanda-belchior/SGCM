package testesRepositorios;
import negocio.*;
import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

import java.util.*;

import static java.lang.System.out; 

public class TestesAgendamentos {
	static RepositorioAgendamentosArray repAgendamentos = RepositorioAgendamentosArray.getInstance();
	static RepositorioAgendamentosLista repAgendamentosLista = new RepositorioAgendamentosLista();
	
	//Criado para testar o metodo verificarExistencia do repositorio:
	public static void verificar(String cpfPaciente){
		if(repAgendamentos.verificarExistencia(cpfPaciente)==true){
			out.println("Existe");
		}else{
			out.println("Não existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {				
		Agendamento ag1= new Agendamento ("079", "1234","657","427","19/06/2017","1235");
		Agendamento ag2= new Agendamento ("058", "1235","657","427","19/06/2017","1236");
		Agendamento ag3= new Agendamento ("562", "1236","657","543","19/06/2017","1237");
		
		//Testes RepositorioAgendamentosArray
		System.out.println("Testes Repositorio Array:\n");
		
		
		
		//Insere três agendamentos:
		repAgendamentos.inserir(ag1);
		repAgendamentos.inserir(ag2);
		repAgendamentos.inserir(ag3);
		
		//Imprime os dados dos três agendamentos inseridos:
		out.println(repAgendamentos.imprimir("1235"));
		out.println(repAgendamentos.imprimir("1236"));
		out.println(repAgendamentos.imprimir("1237"));
		
				
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois agendamentos
		verificar("1235");
		verificar("123");
		
			
		out.println("-----------------------------------------------------");
		
		//Altera dados de um agendamento (idAgenda), busca o objeto e imprime o antes e o depois da alteração:
		Agendamento ag4= new Agendamento ("058", "2164","657","427","19/06/2017","1236");
		out.println("idAgenda: "+repAgendamentos.buscar("1236").getIdAgenda());
		repAgendamentos.alterar(ag4);
		out.println("idAgenda: "+repAgendamentos.buscar("1236").getIdAgenda());
		
		out.println("-----------------------------------------------------");
		
		//Lista  os agendamentos por especialidade
		ArrayList<String> agendamentos2 = repAgendamentos.listar("427");	
		for(int j=0; j<agendamentos2.size(); j++){
			out.println(agendamentos2.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um agendamento e lista todos os agendamentos:
		repAgendamentos.remover("1235");
		ArrayList<Agendamento> agendamentos21 = repAgendamentos.listar();	
		for(int j=0; j<agendamentos21.size(); j++){
			out.println(agendamentos21.get(j).toString());			
		}
		out.println("\n-----------------------------------------------------");
		//Testes listar agendamentos:

		ArrayList<Agendamento> agendamentos6 = repAgendamentos.listar();	
		for(int i=0; i<agendamentos6.size(); i++){
			out.println(agendamentos6.get(i).toString());			
		}	

		out.println("\n-----------------------------------------------------");


		ArrayList<Agendamento> agendamentos7 = repAgendamentos.listarAgendamentos("427");	
		for(int i=0; i<agendamentos7.size(); i++){
			out.println(agendamentos7.get(i).getDataAgendamento());			
		}	


		
		
		
		
		
		
		
		
		
		
		
		//Testes RepositorioAgendamentosLista
		System.out.println("Testes Repositorio Lista:\n");
		
		//Insere três agendamentos:
		repAgendamentosLista.inserir(ag1);
		repAgendamentosLista.inserir(ag2);
		repAgendamentosLista.inserir(ag3);
				
		//Imprime os dados dos três agendamentos inseridos:
		out.println(repAgendamentosLista.imprimir("1235"));
		out.println(repAgendamentosLista.imprimir("1236"));
		out.println(repAgendamentosLista.imprimir("1237"));			
				
						
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois agendamentos
		System.out.println(repAgendamentosLista.verificarExistencia("1235"));
		System.out.println(repAgendamentosLista.verificarExistencia("123"));
		
			
		out.println("-----------------------------------------------------");
		
		//Altera dados de um agendamento (idAgenda), busca o objeto e imprime o antes e o depois da alteração:
		Agendamento ag8= new Agendamento ("058", "2164","657","427","19/06/2017","1236");
		out.println("idAgenda: "+repAgendamentosLista.buscar("1236").getIdAgenda());
		repAgendamentosLista.alterar(ag8);
		out.println("idAgenda: "+repAgendamentosLista.buscar("1236").getIdAgenda());
		
		out.println("-----------------------------------------------------");
		
		//Lista todos os agendamentos por especialidade
		ArrayList<String> agendamentos = repAgendamentosLista.listar("427");	
		for(int j=0; j<agendamentos.size(); j++){
			out.println(agendamentos.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um agendamento e lista todos os agendamentos:
		repAgendamentosLista.remover("1235");
		ArrayList<Agendamento> agendamentos3 = repAgendamentosLista.listar();	
		for(int j=0; j<agendamentos3.size(); j++){
			out.println(agendamentos3.get(j).toString());			
		}
		out.println("\n-----------------------------------------------------");
			
		//Testes listar agendamentos:

		ArrayList<Agendamento> agendamentos8 = repAgendamentosLista.listar();	
		for(int i=0; i<agendamentos8.size(); i++){
			out.println(agendamentos8.get(i).toString());			
		}	
		
		out.println("\n-----------------------------------------------------");

		
		ArrayList<Agendamento> agendamentos9 = repAgendamentosLista.listarAgendamentos("427");	
		for(int i=0; i<agendamentos9.size(); i++){
			out.println(agendamentos9.get(i).getDataAgendamento());			
		}	
		
		
	}
}		
		
		
		
		
		