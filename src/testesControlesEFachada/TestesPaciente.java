package testesControlesEFachada;

import static java.lang.System.out;
import java.util.ArrayList;
import exceptions.*;
import negocio.*;

public class TestesPaciente {
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente{
		Fachada fachada = Fachada.getInstance();
		
		Endereco e1 = new Endereco("Rua Maria","304","Bairro Novo","Recife","54367-987");
		Paciente p1 = new Paciente("Fernanda","079","081",e1);
		Paciente p2 = new Paciente("Heleno","058","081",e1);
		Paciente p3 = new Paciente("Ana","427","081",e1);
		
		fachada.inserir(p1);
		fachada.inserir(p2);
		fachada.inserir(p3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(fachada.imprimirPaciente(p1.getCpf()));	
		out.println(fachada.imprimirPaciente(p2.getCpf()));
		out.println(fachada.imprimirPaciente(p3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois pacientes através do cpf:
		out.println(fachada.verificarExistenciaPaciente("079"));
		out.println(fachada.verificarExistenciaPaciente("123"));
		
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de paciente pelo cpf e exibe o nome na tela:
		Paciente p4 = fachada.buscarPaciente("079");
		out.println(p4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um paciente (p1) através do cpf:
		fachada.removerPaciente(p1.getCpf());	
		
		
		//Lista os dados de todos os pacientes cadastrados através da busca no arraylist 
		//retornado do método listarPacientes		
		ArrayList<String> pacientes = fachada.listarPacientes();		
		for(int i=0; i<pacientes.size(); i++){
			out.println(pacientes.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de paciente com cpf 079:
		out.println(fachada.verificarExistenciaPaciente("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do paciente e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(fachada.imprimirPaciente("058"));
		Paciente p5 = new Paciente("Cesar","058","657",e1);
		fachada.alterar(p5);		
		out.println(fachada.imprimirPaciente("058"));
		
		
	}
	
	
}
