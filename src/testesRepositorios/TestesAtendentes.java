package testesRepositorios;

import static java.lang.System.out;

import java.util.ArrayList;

import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class TestesAtendentes {
	static RepositorioAtendentesArray repAtendentes = new RepositorioAtendentesArray();
	static RepositorioAtendentesLista repAtendentesLista = new RepositorioAtendentesLista();
	
	//Criado para testar o método verificarExistencia do repositório array:
	public static void verificar(String cpf){
		if(repAtendentes.verificarExistencia(cpf)==true){
			out.println("Existe");
		}else{
			out.println("Não existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {
				
		
		Atendente a1 = new Atendente("Fernanda","079","081","a111");
		Atendente a2 = new Atendente("Heleno","058","081","a112");
		Atendente a3 = new Atendente("Ana","427","081","a113");
		
		
		//Testes Repositorio lista
		System.out.println("Testes Repositorio lista:\n\n");
		
		//Inserção três atendentes no array:
		repAtendentes.inserir(a1);
		repAtendentes.inserir(a2);
		repAtendentes.inserir(a3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repAtendentes.imprimir(a1.getCpf()));	
		out.println(repAtendentes.imprimir(a2.getCpf()));
		out.println(repAtendentes.imprimir(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois atendentes através do cpf:
		verificar("079");
		verificar("123");
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de atendente pelo cpf e exibe o nome na tela:
		Atendente a4 = repAtendentes.buscar("079");
		out.println(a4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um atendente (a1) através do cpf:
		repAtendentes.remover(a1.getCpf());	
		
		
		//Lista os dados de todos os atendentes cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> atendentes = repAtendentes.listar();		
		for(int i=0; i<atendentes.size(); i++){
			out.println(atendentes.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de atendente com cpf 079:
		verificar("079");
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do atendente e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repAtendentes.imprimir("058"));
		Atendente a5 = new Atendente("Cesar","058","657","a112");
		repAtendentes.alterar(a5);		
		out.println(repAtendentes.imprimir("058"));
		
		out.println("\n-----------------------------------------------------");
		
		
		
		
		
		
		//Testes Repositorio lista
		System.out.println("Testes Repositorio lista:\n\n");
		
		//Inserção três atendentes no array:
		repAtendentesLista.inserir(a1);
		repAtendentesLista.inserir(a2);
		repAtendentesLista.inserir(a3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repAtendentesLista.imprimir(a1.getCpf()));	
		out.println(repAtendentesLista.imprimir(a2.getCpf()));
		out.println(repAtendentesLista.imprimir(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois atendentes através do cpf:
		System.out.println(repAtendentesLista.verificarExistencia("079"));
		System.out.println(repAtendentesLista.verificarExistencia("123"));
		
		out.println("\n-----------------------------------------------------");		
						
		//Efetua uma busca de atendente pelo cpf e exibe o nome na tela:
		Atendente a6 = repAtendentesLista.buscar("079");
		out.println(a6.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um atendente (a1) através do cpf:
		repAtendentesLista.remover(a1.getCpf());	
		
		
		//Lista os dados de todos os atendentes cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> atendentes2 = repAtendentesLista.listar();		
		for(int i=0; i<atendentes2.size(); i++){
			out.println(atendentes2.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de atendente com cpf 079:
		System.out.println(repAtendentesLista.verificarExistencia("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do atendente e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repAtendentesLista.imprimir("058"));
		Atendente a7 = new Atendente("Cesar","058","657","a112");
		repAtendentesLista.alterar(a7);		
		out.println(repAtendentesLista.imprimir("058"));
		
		out.println("\n-----------------------------------------------------");		
				
				
	
	}
}
			
		