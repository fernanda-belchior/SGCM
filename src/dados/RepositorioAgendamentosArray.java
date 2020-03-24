package dados;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;


public class RepositorioAgendamentosArray implements IRepositorioAgendamentos {
	private static Agendamento[] agendamentos; 
    private int indice;
    private final static int TAMANHO =100;
    private static RepositorioAgendamentosArray instance;
    
    
    
    public static RepositorioAgendamentosArray getInstance(){
		if (RepositorioAgendamentosArray.instance == null){
			RepositorioAgendamentosArray.instance = new RepositorioAgendamentosArray ();
		}
		return RepositorioAgendamentosArray.instance;
	}
   
    
   	public RepositorioAgendamentosArray() {
		RepositorioAgendamentosArray.agendamentos = new Agendamento[TAMANHO];
		this.indice=0;		
	}        	
	  	
   	   	
	public void inserir (Agendamento agendamento)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {		
		agendamentos[indice]= agendamento;
		this.indice+=1;	
		
	}

	public void alterar(Agendamento agendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for(int i=0; i<indice;i++){
    		if(agendamentos[i].getIdAgendamento().equals(agendamento.getIdAgendamento())){
    			agendamentos[i]=agendamento;
    			break;
    		}
    	}
		
		
	}

	public void remover(String idAgendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for (int i=0; i<indice; i++){
            if (agendamentos[i].getIdAgendamento().equals(idAgendamento)){
                this.indice-=1;
                while(i<=98 && agendamentos[i]!=null){
                	agendamentos[i]=agendamentos[i+1];
                	i+=1;                
                }
                break;
            }
            
		}
		
	}

	public boolean verificarExistencia(String idAgendamento) {
		boolean resposta = false;	    
        for (int i=0; i<indice; i++){
            if (agendamentos[i].getIdAgendamento().equals(idAgendamento)){
                resposta = true;
                break;
            }else{
            	continue;            		
            }            	
            
        }
        return resposta;   
		
	}
	
	public Agendamento buscar(String idAgendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {		
		Agendamento a1= new Agendamento();		
		for (int i=0; i<indice; i++){
            if (agendamentos[i].getIdAgendamento().equals(idAgendamento)){
            	a1=agendamentos[i];
            }else{
            	if(agendamentos[i]==null){
            	break;
            	}
            }
		}
		return a1;
	}

	
	
	public String imprimir(String idAgendamento) {
		String agendamento = null;		
				
		for (int i=0; i<indice; i++){
			if(agendamentos[i]==null){
				break;				
			}else{
				if(agendamentos[i].getIdAgendamento().equals(idAgendamento)){
					agendamento=agendamentos[i].toString();
				}else{
					continue;
				}
			}
		}
		return agendamento;
	}
	

	public ArrayList<Agendamento> listar()throws ExcecaoRepositorioVazio {
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<Agendamento> listaAgendamentos = new ArrayList<Agendamento> (); 

			for (int i=0; i<indice; i++){
				if(agendamentos[i]==null){
					break;				
				}else{
					listaAgendamentos.add(agendamentos[i]);
				}
			}
			if(listaAgendamentos.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendamentos;
		}
	}

	public ArrayList<String> listar(String cpfMedico) throws ExcecaoRepositorioVazio {
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaAgendamentos = new ArrayList<String> (); 
			String agendamento = null;		

			for (int i=0; i<indice; i++){
				if(agendamentos[i]==null){
					break;				
				}else{
					if(agendamentos[i].getCpfMedico().equals(cpfMedico)){
						agendamento= imprimir(agendamentos[i].getIdAgendamento());
						listaAgendamentos.add(agendamento);
					}else{
						continue;
					}
				}
			}
			if(listaAgendamentos.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendamentos;
		}
	}


	@Override
	public ArrayList<Agendamento> listarAgendamentos(String cpfMedico) throws ExcecaoRepositorioVazio{
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<Agendamento> listaAgendamentos = new ArrayList<Agendamento> (); 
			for (int i=0; i<indice; i++){
				if(agendamentos[i]==null){
					break;				
				}else{
					if(agendamentos[i].getCpfMedico().equals(cpfMedico)){
						listaAgendamentos.add(agendamentos[i]);
					}else{
						continue;
					}
				}
			}
			if(listaAgendamentos.size()==0){
				throw new ExcecaoRepositorioVazio();
			}			
			return listaAgendamentos;
		}

	
	}


	@Override
	public boolean verificarExistenciaAgendamento(String cpfPaciente) {
		boolean resposta=false;
		for (int i=0; i<indice; i++){
			if(agendamentos[i]==null){
				break;	
			}else{
				if(agendamentos[i].getCpfPaciente().equals(cpfPaciente)){
					resposta=true;
					break;
				}else{
					continue;
				}
			}
		}
		return resposta;
	}

}




