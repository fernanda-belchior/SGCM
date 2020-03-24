package testesControlesEFachada;

import static java.lang.System.out;
import java.util.ArrayList;
import negocio.*;
import exceptions.*;

public class TestesConsulta {

	

	public static void main(String[] args) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {

		Fachada fachada = Fachada.getInstance();
		
		
		Consulta consulta01= new Consulta ("079", "427","657","19/06/2017","10:00","1235","Realizada");
		Consulta consulta02= new Consulta ("058", "427","657","19/06/2017","08:00","1236","Realizada");
		Consulta consulta03= new Consulta ("562", "543","657","19/06/2017","09:00","1237","Não realizada");
		
			
		
		//Insere três consultas:
		fachada.inserir(consulta01);
		fachada.inserir(consulta02);
		fachada.inserir(consulta03);
		
		//Imprime os dados dos três consultas inseridos:
		out.println(fachada.imprimirConsulta("1235"));
		out.println(fachada.imprimirConsulta("1236"));
		out.println(fachada.imprimirConsulta("1237"));
		
				
		out.println("-----------------------------------------------------");
		
		//Verifica de existência de dois consultas
		fachada.verificarExistenciaConsulta("1236");
		fachada.verificarExistenciaConsulta("123");
		
			
		out.println("-----------------------------------------------------");
		
		//Altera dados de uma consulta (status), busca o objeto e imprime o antes e o depois da alteração:
		Consulta consulta04 = new Consulta ("562", "543","657","19/06/2017","09:00","1237","Realizada");
		out.println("status: "+fachada.buscarConsulta("1237").getStatus());
		fachada.alterar(consulta04);
		out.println("status: "+fachada.buscarConsulta("1237").getStatus());
		
		out.println("-----------------------------------------------------");
		
		//Lista todos os consultas
		ArrayList<String> consultas01 = fachada.listarConsultas();	
		for(int j=0; j<consultas01.size(); j++){
			out.println(consultas01.get(j));			
		}
		
		out.println("-----------------------------------------------------");
		
		//Remove um consulta e lista todas as consultas novamente:
		fachada.removerConsulta("1235");
		ArrayList<String> consultas02 = fachada.listarConsultas();	
		for(int j=0; j<consultas02.size(); j++){
			out.println(consultas02.get(j));			
		}
		out.println("\n-----------------------------------------------------");
		

	}
}
