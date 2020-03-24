package dados;


import java.util.ArrayList;
import exceptions.*;
import negocio.*;

public class RepositorioPacientesArray implements IRepositorioPacientes {
	private static Paciente[] pacientes; 	
    private int indice;
    private final static int TAMANHO =100;
    private static RepositorioPacientesArray instance;
    
   	public RepositorioPacientesArray() {
		RepositorioPacientesArray.pacientes = new Paciente[TAMANHO];
		this.indice=0;
	}   
   	
   	public static RepositorioPacientesArray getInstance(){
		if (RepositorioPacientesArray.instance == null){
			RepositorioPacientesArray.instance = new RepositorioPacientesArray ();
		}
		return RepositorioPacientesArray.instance;
	}
	
   	public void inserir(Paciente paciente)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
   			pacientes[indice]= paciente;
   			this.indice+=1;
   		  		
	}

	public void alterar(Paciente paciente)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for(int i=0; i<indice;i++){
    		if(pacientes[i].getCpf().equals(paciente.getCpf())){
    			pacientes[i]=paciente;
    			break;
    		}
    	}
	}

	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for (int i=0; i<indice; i++){
            if (pacientes[i].getCpf().equals(cpf)){
                this.indice-=1;
                while(i<=98 && pacientes[i]!=null){
                	pacientes[i]=pacientes[i+1];
                	i+=1;                
                }
                break;
            }            
		}		
	}

	public boolean verificarExistencia(String cpf) {
		boolean resposta = false;	    
        for (int i=0; i<indice; i++){
            if (pacientes[i].getCpf().equals(cpf)){
                resposta = true;
                break;
            }else{
            	continue;            		
            }            	
        }
        return resposta;   		
	}
	
	public Paciente buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {	
		
		Paciente paciente= new Paciente();		
		for (int i=0; i<indice; i++){
            if (pacientes[i].getCpf().equals(cpf)){
            	paciente=pacientes[i];
            }else{
            	if(pacientes[i]==null){
            		break;
            	}
            }
		}
		return paciente;
	}

	
	public String imprimir(String cpf) {		
		String paciente = null;
		for (int i=0; i<indice; i++){
			if (pacientes[i].getCpf().equals(cpf)){
				paciente = "\nDADOS:\nNome: "+pacientes[i].getNome()+", CPF: "+pacientes[i].getCpf()+
						", Telefone: "+pacientes[i].getTelefone()+"\n"+pacientes[i].imprimirEndereco()+"\n";
			}else{
				if(pacientes[i]==null){
					break;
				}
			}
		}
		return paciente;
	}
		

	
	public ArrayList<String> listar()throws ExcecaoRepositorioVazio {
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaPacientes = new ArrayList<String> ();
			for (int i=0; i<indice; i++){
				if (pacientes[i]!=null){
					listaPacientes.add(this.imprimir(pacientes[i].getCpf()));
				}else{
					break;
				}
			}
			return listaPacientes;		
		}


	}	
}
