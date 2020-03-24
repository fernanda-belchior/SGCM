package dados;
import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class RepositorioCancelamentosArray implements IRepositorioCancelamentos {
	private static Cancelamento[] cancelamentos; 
    private int indice;
    private final static int TAMANHO =100;
    private static RepositorioCancelamentosArray instance;
    
    public static RepositorioCancelamentosArray getInstance(){
		if (RepositorioCancelamentosArray.instance == null){
			RepositorioCancelamentosArray.instance = new RepositorioCancelamentosArray ();
		}
		return RepositorioCancelamentosArray.instance;
	}
  	   
    
   	public RepositorioCancelamentosArray() {
		RepositorioCancelamentosArray.cancelamentos = new Cancelamento[TAMANHO];
		this.indice=0;
	}
   	
   	public static Cancelamento[] getCancelamentos(){
   		return cancelamentos;
   	}
   	
 	
   	   	
	public void inserir(Cancelamento cancelamento)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		cancelamentos[indice]= cancelamento;
		this.indice+=1;	
	}

	public void alterar(Cancelamento cancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for(int i=0; i<indice;i++){
    		if(cancelamentos[i].getIdCancelamento().equals(cancelamento.getIdCancelamento())){
    			cancelamentos[i]=cancelamento;
    			break;
    		}
    	}
		
		
	}

	public void remover(String idCancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for (int i=0; i<indice; i++){
            if (cancelamentos[i].getIdCancelamento().equals(idCancelamento)){
                this.indice-=1;
                while(i<=98 && cancelamentos[i]!=null){
                	cancelamentos[i]=cancelamentos[i+1];
                	i+=1;                
                }
                break;
            }
            
		}
		
	}

	public boolean verificarExistencia(String idCancelamento) {
		boolean resposta = false;	    
        for (int i=0; i<indice; i++){
            if (cancelamentos[i].getIdCancelamento().equals(idCancelamento)){
                resposta = true;
                break;
            }else{
            	continue;            		
            }            	
            
        }
        return resposta;   
		
	}
	
	public Cancelamento buscar(String idCancelamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {		
		Cancelamento c1= new Cancelamento();		
		for (int i=0; i<indice; i++){
            if (cancelamentos[i].getIdCancelamento().equals(idCancelamento)){
            	c1=cancelamentos[i];
            }else{
            	if(cancelamentos[i]==null){
            	break;
            	}
            }
		}
		return c1;
	}
	


	
	public String imprimir(String idCancelamento) {
		String cancelamento = null;		
				
		for (int i=0; i<indice; i++){
			if(cancelamentos[i]==null){
				break;
			}else{
            	if (cancelamentos[i].getIdCancelamento().equals(idCancelamento)){            		
            		cancelamento=cancelamentos[i].toString();
            	}else{
            		continue;
            	}
            		
			} 		
		}
		return cancelamento;
	}


	public ArrayList<String> listar()throws ExcecaoRepositorioVazio {
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();			 
		}else{
			ArrayList<String> listaCancelamentos = new ArrayList<String> ();
			for (int i=0; i<indice; i++){
				if (cancelamentos[i]!=null){
					listaCancelamentos.add(imprimir(cancelamentos[i].getIdCancelamento()));
				}else{
					break;
				}
			}
			return listaCancelamentos;		
		}
	}
}
	

		

	
	


	


		


