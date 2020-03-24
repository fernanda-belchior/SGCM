package testesControlesEFachada;

import static java.lang.System.out;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;


public class TestesCancelamento {
	
	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente {
		Fachada fachada= Fachada.getInstance();
			
				
		Cancelamento ca1 = new Cancelamento ("079","427","657","1234","19/06/2017","1234");
		Cancelamento ca2 = new Cancelamento  ("058","427","657","1235","19/06/2017","1235");
		Cancelamento ca3 = new Cancelamento  ("562","427","657","1236","19/06/2017","1236");
		
		//Insere três cancelamentos:
		fachada.inserir(ca1);
		fachada.inserir(ca2);
		fachada.inserir(ca3);
		
		//Imprime os dados dos três cancelamentos inseridos:
		out.println(fachada.imprimirCancelamento("1234"));
		out.println(fachada.imprimirCancelamento("1235"));
		out.println(fachada.imprimirCancelamento("1236"));
		
				
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois cancelamentos
		System.out.print(fachada.imprimirCancelamento("1234"));
		System.out.print(fachada.imprimirCancelamento("123"));
		
				
		out.println("-----------------------------------------------------");
		
		//Altera dados de um cancelamento (data de cancelamento), busca o objeto e imprime o antes e o depois da alteração:
		Cancelamento ca4= new Cancelamento ("058", "427","657","1235","20/06/2017","1235");
		out.println("Data de cancelamento: "+fachada.buscarCancelamento("1235").getDataCancelamento());
		fachada.alterar(ca4);
		out.println("Data de cancelamento: "+fachada.buscarCancelamento("1235").getDataCancelamento());
		
		out.println("-----------------------------------------------------");
		
		//Lista os cancelamentos de todas as especialidades:
		ArrayList<String> cancelamentos2 = fachada.listarCancelamentos();	
		for(int j=0; j<cancelamentos2.size(); j++){
			out.println(cancelamentos2.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um cancelamento e lista todos os cancelamentos novamente:
		fachada.removerCancelamento("1234");
		ArrayList<String> cancelamentos21 = fachada.listarCancelamentos();	
		for(int j=0; j<cancelamentos21.size(); j++){
			out.println(cancelamentos21.get(j));			
		}
		
		
		
	}
}		
		
		
		
		
		
