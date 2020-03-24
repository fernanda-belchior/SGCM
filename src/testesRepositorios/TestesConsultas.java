package testesRepositorios;

import static java.lang.System.out;

import java.util.ArrayList;

import negocio.*;
import dados.*;
import exceptions.*;

public class TestesConsultas {
		static RepositorioConsultasArray repConsultas = new RepositorioConsultasArray();
		static RepositorioConsultasLista repConsultasLista = new RepositorioConsultasLista();
		
		//Criado para testar o metodo verificarExistencia do repositorio:
		public static void verificar(String cpfPaciente){
			if(repConsultas.verificarExistencia(cpfPaciente)==true){
				out.println("Existe");
			}else{
				out.println("Não existe");
			}
		}

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {
		Consulta consulta01= new Consulta ("079", "427","657","19/06/2017","10:00","1235","Realizada");
		Consulta consulta02= new Consulta ("058", "427","657","19/06/2017","08:00","1236","Realizada");
		Consulta consulta03= new Consulta ("562", "543","657","19/06/2017","09:00","1237","Não realizada");
		
		//Testes RepositorioConsultasArray
		System.out.println("Testes Repositorio Array:\n");
		
		
		
		//Insere três consultas:
		repConsultas.inserir(consulta01);
		repConsultas.inserir(consulta02);
		repConsultas.inserir(consulta03);
		
		//Imprime os dados dos três consultas inseridos:
		out.println(repConsultas.imprimir("1235"));
		out.println(repConsultas.imprimir("1236"));
		out.println(repConsultas.imprimir("1237"));
		
				
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois consultas
		verificar("079");
		verificar("123");
		
			
		out.println("-----------------------------------------------------");
		
		//Altera dados de uma consulta (status), busca o objeto e imprime o antes e o depois da alteração:
		Consulta consulta04 = new Consulta ("562", "543","657","19/06/2017","09:00","1237","Realizada");
		out.println("status: "+repConsultas.buscar("1237").getStatus());
		repConsultas.alterar(consulta04);
		out.println("status: "+repConsultas.buscar("1237").getStatus());
		
		out.println("-----------------------------------------------------");
		
		//Lista todos as consultas por especialidade
		ArrayList<String> consultas01 = repConsultas.listar("427");	
		for(int j=0; j<consultas01.size(); j++){
			out.println(consultas01.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um consulta e lista todos os consultas novamente:
		repConsultas.remover("1235");
		ArrayList<String> consultas02 = repConsultas.listar();	
		for(int j=0; j<consultas02.size(); j++){
			out.println(consultas02.get(j));			
		}
		out.println("\n-----------------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Testes RepositorioConsultasLista
		System.out.println("Testes Repositorio Lista:\n");
		
		//Insere três consultas:
		repConsultasLista.inserir(consulta01);
		repConsultasLista.inserir(consulta02);
		repConsultasLista.inserir(consulta03);
				
		//Imprime os dados dos três consultas inseridos:
		out.println(repConsultasLista.imprimir("1235"));
		out.println(repConsultasLista.imprimir("1236"));
		out.println(repConsultasLista.imprimir("1237"));			
				
						
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois consultas
		System.out.println(repConsultasLista.verificarExistencia("079"));
		System.out.println(repConsultasLista.verificarExistencia("123"));
		
			
		out.println("-----------------------------------------------------");
		
		//Altera dados de um consulta (idAgenda), busca o objeto e imprime o antes e o depois da alteração:
		Consulta consulta05 = new Consulta ("562", "543","657","19/06/2017","09:00","1237","Realizada");
		out.println("status: "+repConsultasLista.buscar("1237").getStatus());
		repConsultasLista.alterar(consulta05);
		out.println("status: "+repConsultasLista.buscar("1237").getStatus());
		
			
		out.println("-----------------------------------------------------");
		
		//Lista todos as consultas por especialidade
		ArrayList<String> consultas03 = repConsultasLista.listar("427");	
		for(int j=0; j<consultas03.size(); j++){
			out.println(consultas03.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um consulta e lista todos os consultas novamente:
		repConsultasLista.remover("1236");
		ArrayList<String> consultas04 = repConsultasLista.listar();	
		for(int j=0; j<consultas04.size(); j++){
			out.println(consultas04.get(j));			
		}
		out.println("\n-----------------------------------------------------");
				
		
	}
		
	
	
	
}
			
			
			
			
			
			


