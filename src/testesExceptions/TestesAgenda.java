package testesExceptions;

import static java.lang.System.out;

import java.util.ArrayList;

import negocio.*;
import exceptions.*;

public class TestesAgenda {
	
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		Fachada fachada = Fachada.getInstance();
		
		Agenda agenda1 = new Agenda("20/06/2017","08:00","427","ag11","disponivel");
		Agenda agenda2 = new Agenda();
		Agenda agenda3 = new Agenda("21/06/2017",null,"543","ag13","disponivel");
		Agenda agenda4 = new Agenda("21/06/2017","15:00","543","ag14","disponivel");
		
		//Teste listar agendas
		try{
			fachada.listarAgendas();	
		}
		catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}
		
		

		System.out.println("-----------------------------------------------------------\n");
		
		//Teste imprimir agenda		
		try{
			fachada.imprimirAgenda("ag10");
		}			                                                                                                                                                                                                                                                             	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}		
		

		System.out.println("-----------------------------------------------------------\n");
		

		//Testes inserir agendas

		try{
			fachada.inserir(agenda1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}



		try{
			fachada.inserir(agenda1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());	
		}



		try{
			fachada.inserir(agenda2);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}
		

		System.out.println("-----------------------------------------------------------\n");
		


		//Alteração de agenda
		try{
			fachada.alterar(agenda3);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}
		
		
		try{
			fachada.alterar(agenda4);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");
		
		
		//Remoção de Agenda
		try{
			fachada.removerAgenda(null);	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		try{
			fachada.removerAgenda("123");	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		// Testes buscar agenda

		try{
			Agenda agenda05 = new Agenda();
			agenda05 = fachada.buscarAgenda(agenda1.getIdAgenda());	
			System.out.println(agenda05.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		

		try{
			Agenda agenda06 = new Agenda();
			agenda06 = fachada.buscarAgenda(null);	
			System.out.println(agenda06.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		
		//Testes imprimir agenda

		try{
			fachada.imprimirAgenda(null);
		}                                                                                                                                                                                                                                                              	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}	
		
		
		try{
			fachada.imprimirAgenda("123");
		}		
		                                                                                                                                                                                                                                                           	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		//Teste listar horarios de agendas por médico
		try{
			ArrayList<Agenda> agendas5 = fachada.listarAgendas("427");	
			for(int i=0; i<agendas5.size(); i++){
				out.println(agendas5.get(i).getHora());			
			}
		}catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
		}
	}

}



