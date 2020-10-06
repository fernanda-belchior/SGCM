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
	
	//Criado para testar o m�todo verificar do reposit�rio:
	public static void verificar(String cpf){
		if(repAdministradores.verificarExistencia(cpf)==true){
			out.println("Existe");
		}else{
			out.println("N�o existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido, ExcecaoElementoJaExistente, ExcecaoRepositorioVazio {
		
			
		Administrador a1 = new Administrador("Fernanda","079","081","ad11");
		Administrador a2 = new Administrador("Heleno","058","081","ad12");
		Administrador a3 = new Administrador("Ana","427","081","ad13");
		
		//Testes Repositorios Array
		System.out.println("Testes Repositorio Array");
		
		//Inser��o tr�s administradores no array:
		repAdministradores.inserir(a1);
		repAdministradores.inserir(a2);
		repAdministradores.inserir(a3);
		
		//Impress�o de dados dos tr�s elementos inseridos:
		out.println(repAdministradores.imprimir(a1.getCpf()));	
		out.println(repAdministradores.imprimir(a2.getCpf()));
		out.println(repAdministradores.imprimir(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois administradores atrav�s do cpf:
		verificar("079");
		verificar("123");
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de administrador pelo cpf e exibe o nome na tela:
		Administrador a4 = repAdministradores.buscar("079");
		out.println(a4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remo��o de um administrador (p1) atrav�s do cpf:
		repAdministradores.remover(a1.getCpf());	
		
		
		//Lista os dados de todos os administradores cadastrados atrav�s da busca no arraylist 
		//retornado do m�todo listar		
		ArrayList<String> administradores = repAdministradores.listar();		
		for(int i=0; i<administradores.size(); i++){
			out.println(administradores.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a exist�ncia de administrador com cpf 079:
		verificar("079");
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do administrador e ap�s a altera��o do nome e telefone
		//imprime novamente na tela
		out.println(repAdministradores.imprimir("058"));
		Administrador a5 = new Administrador("Cesar","058","657","ad12");
		repAdministradores.alterar(a5);		
		out.println(repAdministradores.imprimir("058"));
		
		
		
		
		
		
		
		
		
		//Testes Repositorios Lista
		System.out.println("Testes Repositorio Lista");
		
		
		//Inser��o tr�s administradores no array:
		repAdministradoresLista.inserir(a1);
		repAdministradoresLista.inserir(a2);
		repAdministradoresLista.inserir(a3);
		
		//Impress�o de dados dos tr�s elementos inseridos:
		out.println(repAdministradoresLista.imprimir(a1.getCpf()));	
		out.println(repAdministradoresLista.imprimir(a2.getCpf()));
		out.println(repAdministradoresLista.imprimir(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois administradores atrav�s do cpf:
		System.out.println(repAdministradoresLista.verificarExistencia("079"));
		System.out.println(repAdministradoresLista.verificarExistencia("123"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de administrador pelo cpf e exibe o nome na tela:
		Administrador a6 = repAdministradoresLista.buscar("079");
		out.println(a6.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remo��o de um administrador (p1) atrav�s do cpf:
		repAdministradoresLista.remover(a1.getCpf());	
		
		
		//Lista os dados de todos os administradores cadastrados atrav�s da busca no arraylist 
		//retornado do m�todo listar		
		ArrayList<String> administradores2 = repAdministradoresLista.listar();		
		for(int i=0; i<administradores2.size(); i++){
			out.println(administradores2.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a exist�ncia de administrador com cpf 079:
		System.out.println(repAdministradoresLista.verificarExistencia("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do administrador e ap�s a altera��o do nome e telefone
		//imprime novamente na tela
		out.println(repAdministradoresLista.imprimir("058"));
		Administrador a7 = new Administrador("Cesar","058","657","ad12");
		repAdministradoresLista.alterar(a7);		
		out.println(repAdministradoresLista.imprimir("058"));				
				
				
	}

		
		
	

}



