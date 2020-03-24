package dados;

import java.util.ArrayList;

import exceptions.*;
import negocio.*;

public class RepositorioAgendasLista implements IRepositorioAgendas{
	private Agenda agenda;
	private RepositorioAgendasLista proximo;
	private static RepositorioAgendasLista instance;

    public static RepositorioAgendasLista getInstance(){
    	if (RepositorioAgendasLista.instance == null){
    		RepositorioAgendasLista.instance = new RepositorioAgendasLista ();
    	}
    	return RepositorioAgendasLista.instance;
    }
		
	
	public RepositorioAgendasLista getProximo(){
		return proximo;
	}
	
	public void inserir(Agenda agenda)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.agenda == null){
			this.agenda = agenda;
            proximo = new RepositorioAgendasLista();
        }else{
            proximo.inserir(agenda);
        }
		
	}


	public void alterar(Agenda agenda) throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		if(this.agenda.getIdAgenda().equals(agenda.getIdAgenda())){
			this.agenda=agenda;
		}else{
			proximo.alterar(agenda);
		}
		
	}

	
	public void remover(String idAgenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.agenda!=null){
			if(this.agenda.getIdAgenda().equals(idAgenda)){
				this.agenda=proximo.agenda;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(idAgenda);
			}
		}
		
	}

	public boolean verificarExistencia(String idAgenda) {
		boolean retorno = false;
		RepositorioAgendasLista auxiliar = new RepositorioAgendasLista();
		auxiliar.agenda=this.agenda;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.agenda!=null){
			if(auxiliar.agenda.getIdAgenda().equals(idAgenda)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Agenda buscar(String idAgenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Agenda agenda = new Agenda();
		RepositorioAgendasLista auxiliar = new RepositorioAgendasLista();
		auxiliar.agenda=this.agenda;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.agenda!=null){
			if(auxiliar.agenda.getIdAgenda().equals(idAgenda)){
				agenda=auxiliar.agenda;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return agenda;
	}

	
	public String imprimir(String idAgenda) {
		Agenda agenda = new Agenda();
		RepositorioAgendasLista auxiliar = new RepositorioAgendasLista();
		auxiliar.agenda=this.agenda;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.agenda!=null){
			if(auxiliar.agenda.getIdAgenda().equals(idAgenda)){
				agenda=auxiliar.agenda;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = agenda.toString();
		
		return impressao;
	}


	
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio {
		if(this.agenda==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaAgendas = new ArrayList<String> ();
			RepositorioAgendasLista auxiliar = new RepositorioAgendasLista();
			String agenda = null;

			auxiliar.agenda=this.agenda;
			auxiliar.proximo=this.proximo;

			while(auxiliar.agenda!=null){
				agenda = imprimir(auxiliar.agenda.getIdAgenda());
				listaAgendas.add(agenda);
				auxiliar=auxiliar.proximo;				

			}		
			if(listaAgendas.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendas;
		}
	}
	
	public ArrayList<Agenda> listar(String cpfMedico)throws ExcecaoRepositorioVazio {
		if(this.agenda==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<Agenda> listaAgendas = new ArrayList<Agenda> ();
			RepositorioAgendasLista auxiliar = new RepositorioAgendasLista();
			ArrayList<String> listaDatas = new ArrayList<String>();

			auxiliar.agenda=this.agenda;
			auxiliar.proximo=this.proximo;

			while(auxiliar.agenda!=null){
				if(auxiliar.agenda.getCpfMedico().equals(cpfMedico)){
					listaAgendas.add(auxiliar.agenda);
					listaDatas.add(auxiliar.agenda.getData());
					auxiliar=auxiliar.proximo;
				}


			}		
			if(listaAgendas.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendas;
		}
	
	}


}