package testesRepositorios;
import negocio.*;
import dados.*;
import exceptions.*;
import java.util.*;

import static java.lang.System.out; 

public class TestesPacientes {
	static RepositorioPacientesArray repPacientes = new RepositorioPacientesArray();
	static RepositorioPacientesLista repPacientesLista = new RepositorioPacientesLista();
	
	//Criado para testar o método verificarExistencia do repositório:
	public static void verificar(String cpf){
		if(repPacientes.verificarExistencia(cpf)==true){
			out.println("Existe");
		}else{
			out.println("Não existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente {		
		
		
		Endereco e1 = new Endereco("Rua Maria","304","Bairro Novo","Recife","54367-987");
		Paciente p1 = new Paciente("Fernanda","079","081",e1);
		Paciente p2 = new Paciente("Heleno","058","081",e1);
		Paciente p3 = new Paciente("Ana","427","081",e1);
		
		//Testes Repositorio Array
		System.out.println("Testes Repositorio Array\n\n");
		
		repPacientes.inserir(p1);
		repPacientes.inserir(p2);
		repPacientes.inserir(p3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repPacientes.imprimir(p1.getCpf()));	
		out.println(repPacientes.imprimir(p2.getCpf()));
		out.println(repPacientes.imprimir(p3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois pacientes através do cpf:
		verificar("079");
		verificar("123");
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de paciente pelo cpf e exibe o nome na tela:
		Paciente p4 = repPacientes.buscar("079");
		out.println(p4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um paciente (p1) através do cpf:
		repPacientes.remover(p1.getCpf());	
		
		
		//Lista os dados de todos os pacientes cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> pacientes = repPacientes.listar();		
		for(int i=0; i<pacientes.size(); i++){
			out.println(pacientes.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de paciente com cpf 079:
		verificar("079");
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do paciente e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repPacientes.imprimir("058"));
		Paciente p5 = new Paciente("Cesar","058","657",e1);
		repPacientes.alterar(p5);		
		out.println(repPacientes.imprimir("058"));
		out.println("\n-----------------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		//Testes Repositorio Lista
		System.out.println("Testes Repositorio Lista\n\n");
		
		
		//Inserção três pacientes na lista:
		repPacientesLista.inserir(p1);
		repPacientesLista.inserir(p2);
		repPacientesLista.inserir(p3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repPacientesLista.imprimir(p1.getCpf()));	
		out.println(repPacientesLista.imprimir(p2.getCpf()));
		out.println(repPacientesLista.imprimir(p3.getCpf()));
		
		out.println("-----------------------------------------------------");
						
		// Verifica a existencia de dois pacientes através do cpf:
		System.out.println(repPacientesLista.verificarExistencia("079"));
		System.out.println(repPacientesLista.verificarExistencia("123"));
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de paciente pelo cpf e exibe o nome na tela:
		Paciente p7 = repPacientesLista.buscar("079");
		out.println(p7.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um paciente (p1) através do cpf:
		repPacientesLista.remover(p1.getCpf());	
		
		
		
		//Lista os dados de todos os pacientes cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> pacientes2 = repPacientesLista.listar();		
		for(int i=0; i<pacientes2.size(); i++){
			out.println(pacientes2.get(i));
			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de paciente com cpf 079:
		System.out.println(repPacientesLista.verificarExistencia("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do paciente e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repPacientesLista.imprimir("058"));
		Paciente p6 = new Paciente("Cesar","058","657",e1);
		repPacientesLista.alterar(p6);		
		out.println(repPacientesLista.imprimir("058"));
				
		
	}

}
