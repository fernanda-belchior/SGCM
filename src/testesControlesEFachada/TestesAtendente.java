package testesControlesEFachada;

import static java.lang.System.out;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.Atendente;
import negocio.Fachada;

public class TestesAtendente {
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente{
		Fachada fachada = Fachada.getInstance();
		
		
		Atendente a1 = new Atendente("Fernanda","079","081","a111");
		Atendente a2 = new Atendente("Heleno","058","081","a112");
		Atendente a3 = new Atendente("Ana","427","081","a113");
		
		//Inser��o tr�s atendentes:
		fachada.inserir(a1);
		fachada.inserir(a2);
		fachada.inserir(a3);
		
		//Impress�o de dados dos tr�s elementos inseridos:
		out.println(fachada.imprimirAtendente(a1.getCpf()));	
		out.println(fachada.imprimirAtendente(a2.getCpf()));
		out.println(fachada.imprimirAtendente(a3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois atendentes atrav�s do cpf:
		System.out.println(fachada.verificarExistenciaAtendente("079"));
		System.out.println(fachada.verificarExistenciaAtendente("079"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de atendente pelo cpf e exibe o nome na tela:
		Atendente a4 = fachada.buscarAtendente("079");
		out.println(a4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remo��o de um atendente (a1) atrav�s do cpf:
		fachada.removerAtendente(a1.getCpf());	
		
		
		//Lista os dados de todos os atendentes cadastrados atrav�s da busca no arraylist 
		//retornado do m�todo listarAtendentes		
		ArrayList<String> atendentes = fachada.listarAtendentes();		
		for(int i=0; i<atendentes.size(); i++){
			out.println(atendentes.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a exist�ncia de atendente com cpf 079:
		System.out.println(fachada.verificarExistenciaAtendente("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do atendente e ap�s a altera��o do nome e telefone
		//imprime novamente na tela
		out.println(fachada.imprimirAtendente("058"));
		Atendente a5 = new Atendente("Cesar","058","657","a112");
		fachada.alterar(a5);		
		out.println(fachada.imprimirAtendente("058"));
	}
	

}
