package testesRepositorios;

import static java.lang.System.out;

import java.util.ArrayList;

import negocio.*;
import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

public class TestesMedicos {
	static RepositorioMedicosArray repMedicos = new RepositorioMedicosArray();
	static RepositorioMedicosLista repMedicosLista = new RepositorioMedicosLista();
	
	//Criado para testar o método verificarExistencia do repositório:
	public static void verificar(String cpf){
		if(repMedicos.verificarExistencia(cpf)==true){
			out.println("Existe");
		}else{
			out.println("Não existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {
		
			
		Medico medico1 = new Medico("Fernanda","079","081","e111","Psiquiatria");
		Medico medico2 = new Medico("Heleno","058","081","e112","Psicologia");
		Medico medico3 = new Medico("Ana","427","081","e113","Psicologia");
		
		
		//Testes Repositorio Array
		System.out.println("Testes Repositorio Array\n\n");
		
		//Inserção três medicos no array:
		repMedicos.inserir(medico1);
		repMedicos.inserir(medico2);
		repMedicos.inserir(medico3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repMedicos.imprimir(medico1.getCpf()));	
		out.println(repMedicos.imprimir(medico2.getCpf()));
		out.println(repMedicos.imprimir(medico3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois medicos através do cpf:
		verificar("079");
		verificar("123");
		
		out.println("\n-----------------------------------------------------");		
		
		
		//Efetua uma busca de medico pelo cpf e exibe o nome na tela:
		Medico medico4 = repMedicos.buscar("079");
		out.println(medico4.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um medico (p1) através do cpf:
		repMedicos.remover(medico1.getCpf());	
		
		
		//Lista os dados de todos os medicos cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> medicos = repMedicos.listar();		
		for(int i=0; i<medicos.size(); i++){
			out.println(medicos.get(i));			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de medico com cpf 079:
		verificar("079");
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do medico e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repMedicos.imprimir("058"));
		Medico medico5 = new Medico("Cesar","058","657","e113","Psicologia");
		repMedicos.alterar(medico5);		
		out.println(repMedicos.imprimir("058"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Teste listar medicos por especialidade
		ArrayList<Medico> medicos4 = repMedicos.listar("Psicologia");		
		for(int i=0; i<medicos4.size(); i++){
			out.println(medicos4.get(i).getNome());			
		}

		out.println("\n-----------------------------------------------------");

		
		
		
		
		
		
		
		//Testes Repositorio Lista
		System.out.println("Testes Repositorio Lista\n\n");
		
		//Inserção três medicos no array:
		repMedicosLista.inserir(medico1);
		repMedicosLista.inserir(medico2);
		repMedicosLista.inserir(medico3);
		
		//Impressão de dados dos três elementos inseridos:
		out.println(repMedicosLista.imprimir(medico1.getCpf()));	
		out.println(repMedicosLista.imprimir(medico2.getCpf()));
		out.println(repMedicosLista.imprimir(medico3.getCpf()));
		
		out.println("-----------------------------------------------------");
		
		// Verifica a existencia de dois medicos através do cpf:
		System.out.println(repMedicosLista.verificarExistencia("079"));
		System.out.println(repMedicosLista.verificarExistencia("123"));
		
		out.println("\n-----------------------------------------------------");		
						
				
		//Efetua uma busca de medico pelo cpf e exibe o nome na tela:
		Medico medico6 = repMedicosLista.buscar("079");
		out.println(medico6.getNome());
		
		
		
		out.println("\n-----------------------------------------------------");
		
		//Remoção de um medico (p1) através do cpf:
		repMedicosLista.remover(medico1.getCpf());	
		
		
		//Lista os dados de todos os medicos cadastrados através da busca no arraylist 
		//retornado do método listar		
		ArrayList<String> medicos2 = repMedicosLista.listar();		
		for(int i=0; i<medicos2.size(); i++){
			out.println(medicos2.get(i));			
		}
		
		out.println("\n-----------------------------------------------------");
		
		//verifica novamente a existência de medico com cpf 079:
		System.out.println(repMedicosLista.verificarExistencia("079"));
		
		
		out.println("\n-----------------------------------------------------");
		
		//Imprime os dados do medico e após a alteração do nome e telefone
		//imprime novamente na tela
		out.println(repMedicosLista.imprimir("058"));
		Medico medico7 = new Medico("Cesar","058","657","e113","Psicologia");
		repMedicosLista.alterar(medico7);		
		out.println(repMedicosLista.imprimir("058"));
		
		
		out.println("\n-----------------------------------------------------");
								
		//Teste listar medicos por especialidade
		ArrayList<Medico> medicos5 = repMedicosLista.listar("Psicologia");		
		for(int i=0; i<medicos5.size(); i++){
			out.println(medicos5.get(i).getNome());			
		}
		
	}

}



