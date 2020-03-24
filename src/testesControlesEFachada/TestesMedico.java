package testesControlesEFachada;

import static java.lang.System.out;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.Medico;
import negocio.Fachada;

public class TestesMedico {
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente{
		Fachada fachada = Fachada.getInstance();
		
		Medico medico1 = new Medico("Fernanda","079","081","e111","Psiquiatria");
		Medico medico2 = new Medico("Heleno","058","081","e112","Psicologia");
		Medico medico3 = new Medico("Ana","427","081","e113","Psicologia");
		
		//Inserção três medicos no array:
		fachada.inserir(medico1);
		fachada.inserir(medico2);
		fachada.inserir(medico3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(fachada.imprimirMedico(medico1.getCpf()));	
		out.println(fachada.imprimirMedico(medico2.getCpf()));
		out.println(fachada.imprimirMedico(medico3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois medicos através do cpf:
		System.out.println(fachada.verificarExistenciaMedico("079"));
		System.out.println(fachada.verificarExistenciaMedico("123"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de medico pelo cpf e exibe o nome na tela:
		Medico medico4 = fachada.buscarMedico("079");
		out.println(medico4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um medico (p1) através do cpf:
		fachada.removerMedico(medico1.getCpf());	
		
		
		//Lista os dados de todos os medicos cadastrados através da busca no arraylist 
		//retornado do método listarMedicos		
		ArrayList<String> medicos = fachada.listarMedicos();		
		for(int i=0; i<medicos.size(); i++){
			out.println(medicos.get(i));			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de medico com cpf 079:
		System.out.println(fachada.verificarExistenciaMedico("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do medico e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(fachada.imprimirMedico("058"));
		Medico medico5 = new Medico("Cesar","058","657","e113","Psicologia");
		fachada.alterar(medico5);		
		out.println(fachada.imprimirMedico("058"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Teste listar medicos por especialidade
		ArrayList<Medico> medicos5 = fachada.listarMedicos("Psicologia");		
		for(int i=0; i<medicos5.size(); i++){
			out.println(medicos5.get(i).getNome());			
		}
		
	}

}
