package testesExceptions;

import static java.lang.System.out;

import java.util.ArrayList;

import negocio.*;
import exceptions.*;

public class TestesAgendamento {
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		Fachada fachada = Fachada.getInstance();
		
		Agendamento ag1= new Agendamento ("079", "1234","657","427","19/06/2017","1235");
		Agendamento ag2= new Agendamento ();
		Agendamento ag3= new Agendamento ("562", "1236",null,"543","19/06/2017","1237");
		Agendamento ag4= new Agendamento ("562", "1236","657","543","19/06/2017","1236");
		
		//Teste listar agendamentos
		try{
			fachada.listarAgendamentos();	
		}
		catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}



		System.out.println("-----------------------------------------------------------\n");

		//Teste imprimir agendamento		
		try{
			fachada.imprimirAgendamento("1235");
		}			                                                                                                                                                                                                                                                             	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}		


		System.out.println("-----------------------------------------------------------\n");


		//Testes inserir agendamentos

		try{
			fachada.inserir(ag1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}



		try{
			fachada.inserir(ag1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());	
		}



		try{
			fachada.inserir(ag2);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");



		//Alteração de agendamento
		try{
			fachada.alterar(ag3);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}


		try{
			fachada.alterar(ag4);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");


		//Remoção de Agendamento
		try{
			fachada.removerAgendamento(null);	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}

		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}



		try{
			fachada.removerAgendamento("123");	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");

		// Testes buscar agendamento

		try{
			Agendamento agendamento05 = new Agendamento();
			agendamento05 = fachada.buscarAgendamento(ag1.getIdAgendamento());	
			System.out.println(agendamento05.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		

		try{
			Agendamento agendamento06 = new Agendamento();
			agendamento06 = fachada.buscarAgendamento(null);	
			System.out.println(agendamento06.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		System.out.println("-----------------------------------------------------------\n");


		//Testes imprimir agendamento

		try{
			fachada.imprimirAgendamento(null);
		}                                                                                                                                                                                                                                                              	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}	


		try{
			fachada.imprimirAgendamento("123");
		}		

		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");
		
		//Testes listar agendamentos:
		try{
			ArrayList<String> agendamentos8 = fachada.listarAgendamentos("427");	
			for(int i=0; i<agendamentos8.size(); i++){
				out.println(agendamentos8.get(i));			
			}
		}catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}

		out.println("\n-----------------------------------------------------");


		try{
			ArrayList<Agendamento> agendamentos8 = fachada.listarAgendamentos2("427");	
			for(int i=0; i<agendamentos8.size(); i++){
				out.println(agendamentos8.get(i));			
			}
		}catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}	



	}

}




