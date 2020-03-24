package testesExceptions;

import static java.lang.System.out;

import java.util.ArrayList;

import negocio.*;
import exceptions.*;

public class TestesMedico {

	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		Fachada fachada = Fachada.getInstance();
		
		Medico medico1 = new Medico("Fernanda","079","081","me1234","Psicologia");
		Medico medico2 = new Medico();
		Medico medico3 = new Medico(null,"079","081","me1234","Psicologia");
		Medico medico4 = new Medico("Ana","456","081","me1234","Psicologia");
		
		//Teste listar medicos
		try{
			fachada.listarMedicos();	
		}
		catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}		

		
		System.out.println("-----------------------------------------------------------\n");
		
		

		//Teste listar medicos por especialidade
		try{
			ArrayList<Medico> medicos1 = fachada.listarMedicos("Psicologia");		
			for(int i=0; i<medicos1.size(); i++){
				out.println(medicos1.get(i).getNome());			
			}
		}catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}
	

		System.out.println("-----------------------------------------------------------\n");
		
		//Teste imprimir medico		
		try{
			fachada.imprimirMedico("079");
		}		
		                                                                                                                                                                                                                                                              	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}		
		

		System.out.println("-----------------------------------------------------------\n");
		

		//Testes inserir medicos

		try{
			fachada.inserir(medico1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}



		try{
			fachada.inserir(medico1);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());	
		}



		try{
			fachada.inserir(medico2);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}
		

		System.out.println("-----------------------------------------------------------\n");
		


		//Alteração de medico
		try{
			fachada.alterar(medico3);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}
		
		
		try{
			fachada.alterar(medico4);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");
		
		
		//Remoção de Medico
		try{
			fachada.removerMedico(null);	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		try{
			fachada.removerMedico("123");	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		// Testes buscar medico

		try{
			Medico medico05 = new Medico();
			medico05 = fachada.buscarMedico(medico1.getCpf());	
			System.out.println(medico05.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		

		try{
			Medico medico06 = new Medico();
			medico06 = fachada.buscarMedico(null);	
			System.out.println(medico06.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		
		//Testes imprimir medico

		try{
			fachada.imprimirMedico(null);
		}		
		                                                                                                                                                                                                                                                               	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}	
		
		
		try{
			fachada.imprimirMedico("123");
		}		
		                                                                                                                                                                                                                                                               	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		//Teste listar medicos por especialidade
		try{
			ArrayList<Medico> medicos5 = fachada.listarMedicos("Psicologia");		
			for(int i=0; i<medicos5.size(); i++){
				out.println(medicos5.get(i).getNome());			
			}
		}catch(ExcecaoRepositorioVazio e){	
				System.out.println(e.getMessage());
		}
	}
		

}


