package dados;

import java.util.ArrayList;

import exceptions.*;
import negocio.*;

	public class RepositorioAdministradoresArray implements IRepositorioAdministradores {
		private Administrador[] administradores; 
	    private int indice;
	    private final static int TAMANHO =100;
	    private static RepositorioAdministradoresArray instance;
	    
	    public static RepositorioAdministradoresArray getInstance(){
			if (RepositorioAdministradoresArray.instance == null){
				RepositorioAdministradoresArray.instance = new RepositorioAdministradoresArray ();
			}
			return RepositorioAdministradoresArray.instance;
		}
	    
	   	public RepositorioAdministradoresArray() {
			this.administradores = new Administrador[TAMANHO];
			this.indice=0;
		}
	   	
			   	
	 	public void inserir(Administrador administrador)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
   			administradores[indice]= administrador;
   			this.indice+=1;
   		  		
	}

	public void alterar(Administrador administrador)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for(int i=0; i<indice;i++){
    		if(administradores[i].getCpf().equals(administrador.getCpf())){
    			administradores[i]=administrador;
    			break;
    		}
    	}
	}

	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for (int i=0; i<indice; i++){
            if (administradores[i].getCpf().equals(cpf)){
                this.indice-=1;
                while(i<=98 && administradores[i]!=null){
                	administradores[i]=administradores[i+1];
                	i+=1;                
                }
                break;
            }            
		}		
	}

	public boolean verificarExistencia(String cpf) {
		boolean resposta = false;	    
        for (int i=0; i<indice; i++){
            if (administradores[i].getCpf().equals(cpf)){
                resposta = true;
                break;
            }else{
            	continue;            		
            }            	
        }
        return resposta;   		
	}
	
	public Administrador buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {	
		
		Administrador administrador= new Administrador();		
		for (int i=0; i<indice; i++){
            if (administradores[i].getCpf().equals(cpf)){
            	administrador=administradores[i];
            }else{
            	if(administradores[i]==null){
            	break;
            	}
            }
		}
		return administrador;
	}

	
	public String imprimir(String cpf) {
		String administrador = null;
		for (int i=0; i<indice; i++){
			if (administradores[i].getCpf().equals(cpf)){
				administrador = "\nNome: "+administradores[i].getNome()+"\nCPF: "+administradores[i].getCpf()+
						"\nTelefone: "+administradores[i].getTelefone()+"\n"+administradores[i].toString()+"\n";
			}else{
				if(administradores[i]==null){
					break;
				}
			}
		}
		return administrador;
	}
			

	
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio {
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaAdministradores = new ArrayList<String> ();
			for (int i=0; i<indice; i++){
				if (administradores[i]!=null){
					listaAdministradores.add(this.imprimir(administradores[i].getCpf()));
				}else{
					break;
				}
			}
			return listaAdministradores;		
		}


	}	
}
