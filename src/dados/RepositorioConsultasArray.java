package dados;

import java.util.ArrayList;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class RepositorioConsultasArray implements IRepositorioConsultas {
	private static Consulta[] consultas; 
    private int indice;
    private final static int TAMANHO =100;
    private static RepositorioConsultasArray instance;
    
    public static RepositorioConsultasArray getInstance(){
		if (RepositorioConsultasArray.instance == null){
			RepositorioConsultasArray.instance = new RepositorioConsultasArray ();
		}
		return RepositorioConsultasArray.instance;
	}
   
    
   	public RepositorioConsultasArray() {
		RepositorioConsultasArray.consultas = new Consulta[TAMANHO];
		this.indice=0;
		
	}       	
	  	
   	   	
	public void inserir (Consulta consulta)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {		
		consultas[indice]= consulta;
		this.indice+=1;	
		
	}

	public void alterar(Consulta consulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for(int i=0; i<indice;i++){
    		if(consultas[i].getIdConsulta().equals(consulta.getIdConsulta())){
    			consultas[i]=consulta;
    			break;
    		}
    	}
		
		
	}

	public void remover(String idConsulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for (int i=0; i<indice; i++){
            if (consultas[i].getIdConsulta().equals(idConsulta)){
                this.indice-=1;
                while(i<=98 && consultas[i]!=null){
                	consultas[i]=consultas[i+1];
                	i+=1;                
                }
                break;
            }
            
		}
		
	}

	public boolean verificarExistencia(String idConsulta) {
		boolean resposta = false;	    
        for (int i=0; i<indice; i++){
            if (consultas[i].getIdConsulta().equals(idConsulta)){
                resposta = true;
                break;
            }else{
            	continue;            		
            }            	
            
        }
        return resposta;   
		
	}
	
	public Consulta buscar(String idConsulta)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {		
		Consulta a1= new Consulta();		
		for (int i=0; i<indice; i++){
            if (consultas[i].getIdConsulta().equals(idConsulta)){
            	a1=consultas[i];
            }else{
            	if(consultas[i]==null){
            	break;
            	}
            }
		}
		return a1;
	}

	
	
	public String imprimir(String idConsulta) {
		String consulta = null;						
		for (int i=0; i<indice; i++){
			if(consultas[i]==null){
				break;				
			}else{
				if(consultas[i].getIdConsulta().equals(idConsulta)){
					consulta=consultas[i].toString();
				}else{
					continue;
				}
			}
		}
		return consulta;
	}
	

	public ArrayList<String> listar()throws ExcecaoRepositorioVazio {
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaConsultas = new ArrayList<String> (); 
			String consulta = null;		

			for (int i=0; i<indice; i++){
				if(consultas[i]==null){
					break;				
				}else{
					consulta= imprimir(consultas[i].getIdConsulta());
					listaConsultas.add(consulta);
				}
			}
			return listaConsultas;
		}
	}

	
	
	public ArrayList<String> listar(String cpfMedico) throws ExcecaoRepositorioVazio{
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaConsultas = new ArrayList<String> (); 
			String consulta = null;		

			for (int i=0; i<indice; i++){
				if(consultas[i]==null){
					break;				
				}else{
					if(consultas[i].getCpfMedico().equals(cpfMedico)){
						consulta= imprimir(consultas[i].getIdConsulta());
					listaConsultas.add(consulta);
					}
				}
			}
			return listaConsultas;
		}
	}
}


		

