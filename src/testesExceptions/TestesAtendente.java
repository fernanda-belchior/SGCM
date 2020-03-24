package testesExceptions;

import negocio.*;
import exceptions.*;

public class TestesAtendente {
	
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		Fachada fachada = Fachada.getInstance();
		
		Atendente atendente1 = new Atendente("Fernanda","079","081","at1234");
		Atendente atendente2 = new Atendente();
		Atendente atendente3 = new Atendente(null,"079","081","at1234");
		Atendente atendente4 = new Atendente("Ana","456","081","at1234");
		
		//Teste listar atendentes
		try{
			fachada.listarAtendentes();	
		}
		catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}
		
		

		System.out.println("-----------------------------------------------------------\n");
		
		//Teste imprimir atendente		
		try{
			fachada.imprimirAtendente("079");
		}		
		                                                                                                                                                                                                                                                              	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}		
		

		System.out.println("-----------------------------------------------------------\n");
		

		//Testes inserir atendentes

		try{
			fachada.inserir(atendente1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}



		try{
			fachada.inserir(atendente1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());	
		}



		try{
			fachada.inserir(atendente2);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}
		

		System.out.println("-----------------------------------------------------------\n");
		


		//Alteração de atendente
		try{
			fachada.alterar(atendente3);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}
		
		
		try{
			fachada.alterar(atendente4);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");
		
		
		//Remoção de Atendente
		try{
			fachada.removerAtendente(null);	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		try{
			fachada.removerAtendente("123");	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		// Testes buscar atendente
		
		try{
			Atendente atendente05 = new Atendente();
			atendente05 = fachada.buscarAtendente(atendente1.getCpf());	
			System.out.println(atendente05.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		

		try{
			Atendente atendente06 = new Atendente();
			atendente06 = fachada.buscarAtendente(null);	
			System.out.println(atendente06.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		
		//Testes imprimir atendente

		try{
			fachada.imprimirAtendente(null);
		}		
		                                                                                                                                                                                                                                                              	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}	
		
		
		try{
			fachada.imprimirAtendente("123");
		}		
		                                                                                                                                                                                                                                                               	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");

	}

}



