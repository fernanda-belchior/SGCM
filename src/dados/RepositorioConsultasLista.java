package dados;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class RepositorioConsultasLista implements IRepositorioConsultas {
	private Consulta consulta;
	private RepositorioConsultasLista proximo;
	private static RepositorioConsultasLista instance;
    
    public static RepositorioConsultasLista getInstance(){
		if (RepositorioConsultasLista.instance == null){
			RepositorioConsultasLista.instance = new RepositorioConsultasLista ();
		}
		return RepositorioConsultasLista.instance;
	}
	
	public RepositorioConsultasLista getProximo(){
		return proximo;
	}
	
	public void inserir (Consulta consulta)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.consulta == null){
			this.consulta = consulta;
            proximo = new RepositorioConsultasLista();
        }else{
            proximo.inserir(consulta);
        }
		
	}


	public void alterar(Consulta consulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.consulta.getIdConsulta().equals(consulta.getIdConsulta())){
			this.consulta=consulta;
		}else{
			proximo.alterar(consulta);
		}
		
	}

	
	public void remover(String idConsulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.consulta!=null){
			if(this.consulta.getIdConsulta().equals(idConsulta)){
				this.consulta=proximo.consulta;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(idConsulta);
			}
		}
	}

	public boolean verificarExistencia(String idConsulta) {
		boolean retorno = false;
		RepositorioConsultasLista auxiliar = new RepositorioConsultasLista();
		auxiliar.consulta=this.consulta;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.consulta!=null){
			if(auxiliar.consulta.getIdConsulta().equals(idConsulta)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Consulta buscar(String idConsulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Consulta consulta = new Consulta();
		RepositorioConsultasLista auxiliar = new RepositorioConsultasLista();
		auxiliar.consulta=this.consulta;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.consulta!=null){
			if(auxiliar.consulta.getIdConsulta().equals(idConsulta)){
				consulta=auxiliar.consulta;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return consulta;
	}

	
	public String imprimir(String idConsulta){
		Consulta consulta = new Consulta();
		RepositorioConsultasLista auxiliar = new RepositorioConsultasLista();
		auxiliar.consulta=this.consulta;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.consulta!=null){
			if(auxiliar.consulta.getIdConsulta().equals(idConsulta)){
				consulta=auxiliar.consulta;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = consulta.toString();
		
		return impressao;
	}

	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		if(this.consulta==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaConsultas = new ArrayList<String> ();
			RepositorioConsultasLista auxiliar = new RepositorioConsultasLista();
			String consulta = null;

			auxiliar.consulta=this.consulta;
			auxiliar.proximo=this.proximo;

			while(auxiliar.consulta!=null){
				consulta = imprimir(auxiliar.consulta.getIdConsulta());
				listaConsultas.add(consulta);
				auxiliar=auxiliar.proximo;				

			}		

			return listaConsultas;
		}
	}
	
	public ArrayList<String> listar(String cpfMedico) throws ExcecaoRepositorioVazio{
		if(this.consulta==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaConsultas = new ArrayList<String> ();
			RepositorioConsultasLista auxiliar = new RepositorioConsultasLista();
			String consulta = null;

			auxiliar.consulta=this.consulta;
			auxiliar.proximo=this.proximo;

			while(auxiliar.consulta!=null){
				if (auxiliar.consulta.getCpfMedico().equals(cpfMedico)){
					consulta = imprimir(auxiliar.consulta.getIdConsulta());
					listaConsultas.add(consulta);
				}			
				auxiliar=auxiliar.proximo;	
			}		

			return listaConsultas;
		}
	}
}
