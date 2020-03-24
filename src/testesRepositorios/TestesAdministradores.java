package testesRepositorios;

import static java.lang.System.out;

import java.util.ArrayList;

import negocio.*;
import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

public class TestesAdministradores {
	static RepositorioAdministradoresArray repAdministradores = RepositorioAdministradoresArray.getInstance();
	static RepositorioAdministradoresLista repAdministradoresLista = new RepositorioAdministradoresLista();
	
	//Criado para testar o método verificar do repositório:
	public static void verificar(String cpf){
		if(repAdministradores.verificarExistencia(cpf)==true){
			out.println("Existe");
		}else{
			out.println("Não existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido, ExcecaoElementoJaExistente, ExcecaoRepositorioVazio {
		
			
		Administrador a1 = new Administrador("Fernanda","079","081","ad11");
		Administrador a2 = new Administrador("Heleno","058","081","ad12");
		Administrador a3 = new Administrador("Ana","427","081","ad13");
		
		//Testes Repositorios Array
		System.out.println("Testes Repositorio Array");
		
		//Inserção três administradores no array:
		repAdministradores.inserir(a1);
		repAdministradores.inserir(a2);
		repAdministradores.inserir(a3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repAdministradores.imprimir(a1.getCpf()));	
		out.println(repAdministradores.imprimir(a2.getCpf()));
		out.println(repAdministradores.imprimir(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois administradores através do cpf:
		verificar("079");
		verificar("123");
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de administrador pelo cpf e exibe o nome na tela:
		Administrador a4 = repAdministradores.buscar("079");
		out.println(a4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um administrador (p1) através do cpf:
		repAdministradores.remover(a1.getCpf());	
		
		
		//Lista os dados de todos os administradores cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> administradores = repAdministradores.listar();		
		for(int i=0; i<administradores.size(); i++){
			out.println(administradores.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de administrador com cpf 079:
		verificar("079");
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do administrador e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repAdministradores.imprimir("058"));
		Administrador a5 = new Administrador("Cesar","058","657","ad12");
		repAdministradores.alterar(a5);		
		out.println(repAdministradores.imprimir("058"));
		
		
		
		
		
		
		
		
		
		//Testes Repositorios Lista
		System.out.println("Testes Repositorio Lista");
		
		
		//Inserção três administradores no array:
		repAdministradoresLista.inserir(a1);
		repAdministradoresLista.inserir(a2);
		repAdministradoresLista.inserir(a3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repAdministradoresLista.imprimir(a1.getCpf()));	
		out.println(repAdministradoresLista.imprimir(a2.getCpf()));
		out.println(repAdministradoresLista.imprimir(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois administradores através do cpf:
		System.out.println(repAdministradoresLista.verificarExistencia("079"));
		System.out.println(repAdministradoresLista.verificarExistencia("123"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de administrador pelo cpf e exibe o nome na tela:
		Administrador a6 = repAdministradoresLista.buscar("079");
		out.println(a6.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um administrador (p1) através do cpf:
		repAdministradoresLista.remover(a1.getCpf());	
		
		
		//Lista os dados de todos os administradores cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> administradores2 = repAdministradoresLista.listar();		
		for(int i=0; i<administradores2.size(); i++){
			out.println(administradores2.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de administrador com cpf 079:
		System.out.println(repAdministradoresLista.verificarExistencia("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do administrador e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repAdministradoresLista.imprimir("058"));
		Administrador a7 = new Administrador("Cesar","058","657","ad12");
		repAdministradoresLista.alterar(a7);		
		out.println(repAdministradoresLista.imprimir("058"));				
				
				
	}

		
		
	

}



