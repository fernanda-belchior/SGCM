package testesExceptions;

import exceptions.*;
import negocio.*;

public class TestesPaciente {
	
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		Fachada fachada = Fachada.getInstance();
		
		Endereco e1 = new Endereco("Rua Maria","304","Bairro Novo","Recife","54367-987");
		Paciente paciente1 = new Paciente("Fernanda","079","081",e1);
		Paciente paciente2 = new Paciente();
		Paciente paciente3 = new Paciente(null,"079","081",e1);
		Paciente paciente4 = new Paciente("Ana","456","081",e1);
		
		//Teste listar pacientes
		try{
			fachada.listarPacientes();	
		}
		catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}
		
		

		System.out.println("-----------------------------------------------------------\n");
		
		//Teste imprimir paciente		
		try{
			fachada.imprimirPaciente("079");
		}		
		catch(ExcecaoDadoInvalido|ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}		
		

		System.out.println("-----------------------------------------------------------\n");
		

		//Testes inserir pacientes

		try{
			fachada.inserir(paciente1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoElementoJaExistente|ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}



		try{
			fachada.inserir(paciente1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoElementoJaExistente|ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		
		}


		try{
			fachada.inserir(paciente2);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoElementoJaExistente|ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		

		System.out.println("-----------------------------------------------------------\n");
		


		//Alteração de paciente
		try{
			fachada.alterar(paciente3);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}
		
		
		try{
			fachada.alterar(paciente4);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");
		
		
		//Remoção de Paciente
		try{
			fachada.removerPaciente(null);	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		try{
			fachada.removerPaciente("123");	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		// Testes buscar paciente

		try{
			Paciente paciente05 = new Paciente();
			paciente05 = fachada.buscarPaciente(paciente1.getCpf());	
			System.out.println(paciente05.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		

		try{
			Paciente paciente06 = new Paciente();
			paciente06 = fachada.buscarPaciente(null);	
			System.out.println(paciente06.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		
		//Testes imprimir paciente

		try{
			fachada.imprimirPaciente(null);
		}		
		                                                                                                                                                                                                                                                              	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}	
		
		
		try{
			fachada.imprimirPaciente("123");
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
