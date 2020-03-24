package testesExceptions;

import exceptions.*;

public class TesteGeral {
	public static void teste(int num) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente{
		
		switch (num){
			case 0:
				ExcecaoRepositorioVazio e = new ExcecaoRepositorioVazio();
				throw e;
			
			case 1:
				ExcecaoElementoInexistente f = new ExcecaoElementoInexistente();
				throw f;
				
			case 2:
				ExcecaoElementoJaExistente g = new ExcecaoElementoJaExistente();
				throw g;
				
			case 3: 
				ExcecaoDadoInvalido h = new ExcecaoDadoInvalido();
				throw h;
		}
	}
		
	public static void main (String args[]) throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		
		try{
			teste(0);
		}
		
		catch(ExcecaoRepositorioVazio e){
			e.getMessage();
		}
		
		try{
			teste(1);
		}
		
		catch(ExcecaoElementoInexistente e){
			e.getMessage();
		}
		
		try{
			teste(2);
		}
		
		catch(ExcecaoElementoJaExistente e){
			e.getMessage();
		}
		
		try{
			teste(3);
		}
		
		catch(ExcecaoDadoInvalido e){
			e.getMessage();
		}
		
		
	}

}
