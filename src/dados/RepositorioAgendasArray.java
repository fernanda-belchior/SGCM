package dados;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class RepositorioAgendasArray implements IRepositorioAgendas {
	private static Agenda[] agendas; 
    private int indice;
    private final static int TAMANHO =100;
    private static RepositorioAgendasArray instance;

    public static RepositorioAgendasArray getInstance(){
    	if (RepositorioAgendasArray.instance == null){
    		RepositorioAgendasArray.instance = new RepositorioAgendasArray ();
    	}
    	return RepositorioAgendasArray.instance;
    }
    
   	public RepositorioAgendasArray() {
		RepositorioAgendasArray.agendas = new Agenda[TAMANHO];
		this.indice=0;
	}   	
 	
	public void inserir(Agenda agenda)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		agendas[indice]= agenda;
		this.indice+=1;	
	}

	public void alterar(Agenda agenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for(int i=0; i<indice;i++){
    		if(agendas[i].getIdAgenda().equals(agenda.getIdAgenda())){
    			agendas[i]=agenda;
    			break;
    		}
    	}
	}

	public void remover(String idAgenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for (int i=0; i<indice; i++){
            if (agendas[i].getIdAgenda().equals(idAgenda)){
                this.indice-=1;
                while(i<=98 && agendas[i]!=null){
                	agendas[i]=agendas[i+1];
                	i+=1;                
                }
                break;
            }            
		}		
	}

	public boolean verificarExistencia(String idAgenda) {
		boolean resposta = false;	    
        for (int i=0; i<indice; i++){
            if (agendas[i].getIdAgenda().equals(idAgenda)){
                resposta = true;
                break;
            }else{
            	continue;            		
            }            	
        }
        return resposta;   		
	}
	
	public Agenda buscar(String idAgenda)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {		
		Agenda p1= new Agenda();		
		for (int i=0; i<indice; i++){
            if (agendas[i].getIdAgenda().equals(idAgenda)){
            	p1=agendas[i];
            }else{
            	if(agendas[i]==null){
            	break;
            	}
            }
		}
		return p1;
	}

	
	public String imprimir(String idAgenda) {
		String agenda = "null";
		for (int i=0; i<indice; i++){
			if (agendas[i]==null){
				break;
			}else{
				agenda = agendas[i].toString();
			}
		}
		return agenda;
	}



	
	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaAgendas = new ArrayList<String> (); 
			String agenda = "null";
			for (int i=0; i<indice; i++){
				if (agendas[i]==null){
					break;
				}else{
					agenda = imprimir(agendas[i].getIdAgenda());
					listaAgendas.add(agenda);
				}
			}
			if(listaAgendas.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendas;
		}
	}


	public ArrayList<Agenda> listar(String cpfMedico) throws  ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente{
		ArrayList<Agenda> listaAgendas = new ArrayList<Agenda> (); 
		Agenda agenda = new Agenda();
		
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{			
			for (int i=0; i<indice; i++){
				if (agendas[i]==null){
					break;
				}else{
					if(agendas[i].getCpfMedico().equals(cpfMedico)){
						agenda = buscar(agendas[i].getIdAgenda());
						listaAgendas.add(agenda);
					}
				}			

			}
		}
		if(listaAgendas.size()==0){
			throw new ExcecaoRepositorioVazio();
		}
		return listaAgendas;	
	
  }
}
	


	
	
		



	


		

