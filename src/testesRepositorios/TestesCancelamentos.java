package testesRepositorios;

import static java.lang.System.out;

import java.util.ArrayList;

import negocio.*;
import dados.*;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

public class TestesCancelamentos {
	static RepositorioCancelamentosArray repCancelamentos = new RepositorioCancelamentosArray();
	static RepositorioCancelamentosLista repCancelamentosLista = new RepositorioCancelamentosLista();
	
	//Criado para testar o metodo verificarExistencia do repositorio:
	public static void verificar(String cpfPaciente){
		if(repCancelamentos.verificarExistencia(cpfPaciente)==true){
			out.println("Existe");
		}else{
			out.println("Não existe");
		}
	}

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {
		
		Cancelamento ca1 = new Cancelamento ("079","427","657","1234","19/06/2017","1234");
		Cancelamento ca2 = new Cancelamento  ("058","427","657","1235","19/06/2017","1235");
		Cancelamento ca3 = new Cancelamento  ("562","427","657","1236","19/06/2017","1236");
		
		//Testes Repositorio Array
		System.out.println("Testes Repositorio Array\n\n");
		
		//Insere três cancelamentos:
		repCancelamentos.inserir(ca1);
		repCancelamentos.inserir(ca2);
		repCancelamentos.inserir(ca3);
		
		//Imprime os dados dos três cancelamentos inseridos:
		out.println(repCancelamentos.imprimir("1234"));
		out.println(repCancelamentos.imprimir("1235"));
		out.println(repCancelamentos.imprimir("1236"));
		
				
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois cancelamentos
		verificar("1234");
		verificar("123");
		
				
		out.println("-----------------------------------------------------");
		
		//Altera dados de um cancelamento (data de cancelamento), busca o objeto e imprime o antes e o depois da alteração:
		Cancelamento ca4= new Cancelamento ("058", "427","657","1235","20/06/2017","1235");
		out.println("Data de cancelamento: "+repCancelamentos.buscar("1235").getDataCancelamento());
		repCancelamentos.alterar(ca4);
		out.println("Data de cancelamento: "+repCancelamentos.buscar("1235").getDataCancelamento());
		
		out.println("-----------------------------------------------------");
		
		//Lista os cancelamentos de todas as especialidades:
		ArrayList<String> cancelamentos2 = repCancelamentos.listar();	
		for(int j=0; j<cancelamentos2.size(); j++){
			out.println(cancelamentos2.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um cancelamento e lista todos os cancelamentos novamente:
		repCancelamentos.remover("1234");
		ArrayList<String> cancelamentos21 = repCancelamentos.listar();	
		for(int j=0; j<cancelamentos21.size(); j++){
			out.println(cancelamentos21.get(j));			
		}

		out.println("-----------------------------------------------------");
		
		
		
		
		
		//Testes Repositorio Lista
		System.out.println("Testes Repositorio Lista\n\n");
		
		
		//Insere três cancelamentos:
		repCancelamentosLista.inserir(ca1);
		repCancelamentosLista.inserir(ca2);
		repCancelamentosLista.inserir(ca3);
		
		//Imprime os dados dos três cancelamentos inseridos:
		out.println(repCancelamentosLista.imprimir("1234"));
		out.println(repCancelamentosLista.imprimir("1235"));
		out.println(repCancelamentosLista.imprimir("1236"));
		
				
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois cancelamentos
		System.out.println(repCancelamentosLista.verificarExistencia("1234"));
		System.out.println(repCancelamentosLista.verificarExistencia("123"));
				
		out.println("-----------------------------------------------------");
		
		//Altera dados de um cancelamento (data de cancelamento), busca o objeto e imprime o antes e o depois da alteração:
		Cancelamento ca5= new Cancelamento ("058", "427","657","1235","20/06/2017","1235");
		out.println("Data de cancelamento: "+repCancelamentosLista.buscar("1235").getDataCancelamento());
		repCancelamentosLista.alterar(ca5);
		out.println("Data de cancelamento: "+repCancelamentosLista.buscar("1235").getDataCancelamento());
		
		out.println("-----------------------------------------------------");
		
		//Lista os cancelamentos de todas as especialidades:
		ArrayList<String> cancelamentos3 = repCancelamentosLista.listar();	
		for(int j=0; j<cancelamentos3.size(); j++){
			out.println(cancelamentos3.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um cancelamento e lista todos os cancelamentos novamente:
		repCancelamentosLista.remover("1234");
		ArrayList<String> cancelamentos4 = repCancelamentosLista.listar();	
		for(int j=0; j<cancelamentos4.size(); j++){
			out.println(cancelamentos4.get(j));			
		}
		
		
		
	}
}		
		
		
		
		
		