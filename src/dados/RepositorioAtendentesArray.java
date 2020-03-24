package dados;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class RepositorioAtendentesArray implements IRepositorioAtendentes {
	
	private static Atendente[] atendentes; 
    private int indice;
    private final static int TAMANHO =100;
    private static RepositorioAtendentesArray instance;
    
    public static RepositorioAtendentesArray getInstance(){
    	if (RepositorioAtendentesArray.instance == null){
    		RepositorioAtendentesArray.instance = new RepositorioAtendentesArray ();
    	}
    	return RepositorioAtendentesArray.instance;
    }
    
    
    public RepositorioAtendentesArray() {
    	RepositorioAtendentesArray.atendentes = new Atendente[TAMANHO];
    	this.indice=0;
    }

    

    public void inserir(Atendente atendente)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
    	atendentes[indice]= atendente;
    	this.indice+=1;

    }

    public void alterar(Atendente atendente)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
    	for(int i=0; i<indice;i++){
    		if(atendentes[i].getCpf().equals(atendente.getCpf())){
    			atendentes[i]=atendente;
    			break;
    		}
    	}
    }

    public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
    	for (int i=0; i<indice; i++){
    		if (atendentes[i].getCpf().equals(cpf)){
    			this.indice-=1;
    			while(i<=98 && atendentes[i]!=null){
    				atendentes[i]=atendentes[i+1];
    				i+=1;                
    			}
    			break;
    		}            
    	}		
    }

    public boolean verificarExistencia(String cpf) {
    	boolean resposta = false;	    
    	for (int i=0; i<indice; i++){
    		if (atendentes[i].getCpf().equals(cpf)){
    			resposta = true;
    			break;
    		}else{
    			continue;            		
    		}            	
    	}
    	return resposta;   		
    }

    public Atendente buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {	
    	Atendente atendente= new Atendente();		
    	for (int i=0; i<indice; i++){
    		if (atendentes[i].getCpf().equals(cpf)){
    			atendente=atendentes[i];
    		}else{
    			if(atendentes[i]==null){
    				break;
    			}
    		}
    	}
    	return atendente;
    }


    public String imprimir(String cpf) {  
    	String atendente = null;
    	for (int i=0; i<indice; i++){
    		if (atendentes[i].getCpf().equals(cpf)){
    			atendente = "\nNome: "+atendentes[i].getNome()+"\nCPF: "+atendentes[i].getCpf()+
    					"\nTelefone: "+atendentes[i].getTelefone()+"\n"+atendentes[i].toString()+"\n";
    		}else{
    			if(atendentes[i]==null){
    				break;
    			}
    		}
    	}
    	return atendente;
    }
		


    public ArrayList<String> listar()throws ExcecaoRepositorioVazio {
    	if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
    	}else{
    		ArrayList<String> listaAtendentes = new ArrayList<String> ();
    		for (int i=0; i<indice; i++){
    			if (atendentes[i]!=null){
    				listaAtendentes.add(this.imprimir(atendentes[i].getCpf()));
    			}else{
    				break;
    			}
    		}
    		return listaAtendentes;		
    	}


    }	
}




