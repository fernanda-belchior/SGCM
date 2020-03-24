package testesExceptions;

import negocio.Consulta;
import negocio.Fachada;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

public class TestesConsulta {
	public static void main(String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		Fachada fachada = Fachada.getInstance();
		
		Consulta consulta01= new Consulta ("079", "427","657","19/06/2017","10:00","1235","Realizada");
		Consulta consulta02= new Consulta ();
		Consulta consulta03= new Consulta ("562", "543","657","19/06/2017","09:00",null,"Não realizada");
		Consulta consulta04= new Consulta ("562", "543","657","19/06/2017","09:00","1237","Não realizada");
		
		//Teste listar consultas
		try{
			fachada.listarConsultas();	
		}
		catch(ExcecaoRepositorioVazio e){	
			System.out.println(e.getMessage());
		}
		
		

		System.out.println("-----------------------------------------------------------\n");
		
		//Teste imprimir consulta		
		try{
			fachada.imprimirConsulta("1235");
		}			                                                                                                                                                                                                                                                             	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}		
		

		System.out.println("-----------------------------------------------------------\n");
		

		//Testes inserir consultas

		try{
			fachada.inserir(consulta01);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}



		try{
			fachada.inserir(consulta01);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());	
		}



		try{
			fachada.inserir(consulta02);
			System.out.println("INSERIDO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoJaExistente e){	
			System.out.println(e.getMessage());
		}
		

		System.out.println("-----------------------------------------------------------\n");
		


		//Alteração de consulta
		try{
			fachada.alterar(consulta03);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}
		
		
		try{
			fachada.alterar(consulta04);
			System.out.println("ATUALIZADO COM SUCESSO!");
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){	
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------\n");
		
		
		//Remoção de Consulta
		try{
			fachada.removerConsulta(null);	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		try{
			fachada.removerConsulta("123");	
			System.out.println("REMOVIDO COM SUCESSO!");
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		// Testes buscar consulta

		try{
			Consulta consulta05 = new Consulta();
			consulta05 = fachada.buscarConsulta(consulta01.getIdConsulta());	
			System.out.println(consulta05.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		

		try{
			Consulta consulta06 = new Consulta();
			consulta06 = fachada.buscarConsulta(null);	
			System.out.println(consulta06.toString());
		}

		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println("-----------------------------------------------------------\n");
		
		
		//Testes imprimir consulta

		try{
			fachada.imprimirConsulta(null);
		}                                                                                                                                                                                                                                                              	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}	
		
		
		try{
			fachada.imprimirConsulta("123");
		}		
		                                                                                                                                                                                                                                                           	
		catch(ExcecaoDadoInvalido e){	
			System.out.println(e.getMessage());
		}
		catch(ExcecaoElementoInexistente e){
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----------------------------------------------------------\n");

	}

}




