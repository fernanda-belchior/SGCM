package testesControlesEFachada;

import static java.lang.System.out;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.Administrador;
import negocio.Fachada;

public class TestesAdministrador {
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente{
		Fachada fachada = Fachada.getInstance();
		
		Administrador a1 = new Administrador("Fernanda","079","081","ad11");
		Administrador a2 = new Administrador("Heleno","058","081","ad12");
		Administrador a3 = new Administrador("Ana","427","081","ad13");
		
		//Inser��o tr�s administradores
		fachada.inserir(a1);
		fachada.inserir(a2);
		fachada.inserir(a3);
		
		//Impress�o de dados dos tr�s elementos inseridos:
		out.println(fachada.imprimirAdministrador(a1.getCpf()));	
		out.println(fachada.imprimirAdministrador(a2.getCpf()));
		out.println(fachada.imprimirAdministrador(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois administradores atrav�s do cpf:
		System.out.println(fachada.verificarExistenciaAdministrador("079"));
		System.out.println(fachada.verificarExistenciaAdministrador("123"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de administrador pelo cpf e exibe o nome na tela:
		Administrador a4 = fachada.buscarAdministrador("079");
		out.println(a4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remo��o de um administrador (a1) atrav�s do cpf:
		fachada.removerAdministrador(a1.getCpf());	
		
		
		//Lista os dados de todos os fachada cadastrados atrav�s da busca no arraylist 
		//retornado do m�todo listarAdministradores		
		ArrayList<String> administradores = fachada.listarAdministradores();		
		for(int i=0; i<administradores.size(); i++){
			out.println(administradores.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a exist�ncia de administrador com cpf 079:
		System.out.println(fachada.verificarExistenciaAdministrador("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do administrador e ap�s a altera��o do nome e telefone
		//imprime novamente na tela
		out.println(fachada.imprimirAdministrador("058"));
		Administrador a5 = new Administrador("Cesar","058","657","ad12");
		fachada.alterar(a5);		
		out.println(fachada.imprimirAdministrador("058"));
		
		
	}

}
