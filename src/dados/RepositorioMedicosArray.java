package dados;

import java.util.ArrayList;

import exceptions.*;
import negocio.*;

public class RepositorioMedicosArray implements IRepositorioMedicos {
	private static Medico[] medicos; 
	private int indice;
	private final static int TAMANHO =100;
	private static RepositorioMedicosArray instance;
	

	public static RepositorioMedicosArray getInstance(){
		if (RepositorioMedicosArray.instance == null){
			RepositorioMedicosArray.instance = new RepositorioMedicosArray ();
		}
		return RepositorioMedicosArray.instance;
	}



	public RepositorioMedicosArray() {
		RepositorioMedicosArray.medicos = new Medico[TAMANHO];
		this.indice=0;
	}


	public void inserir(Medico medico)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		medicos[indice]= medico;
		this.indice+=1;

	}

	public void alterar(Medico medico)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for(int i=0; i<indice;i++){
			if(medicos[i].getCpf().equals(medico.getCpf())){
				medicos[i]=medico;
				break;
			}
		}
	}

	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		for (int i=0; i<indice; i++){
			if (medicos[i].getCpf().equals(cpf)){
				this.indice-=1;
				while(i<=98 && medicos[i]!=null){
					medicos[i]=medicos[i+1];
					i+=1;                
				}
				break;
			}            
		}		
	}

	public boolean verificarExistencia(String cpf) {
		boolean resposta = false;	    
		for (int i=0; i<indice; i++){
			if (medicos[i].getCpf().equals(cpf)){
				resposta = true;
				break;
			}else{
				continue;            		
			}            	
		}
		return resposta;   		
	}

	public Medico buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {	

		Medico medico= new Medico();		
		for (int i=0; i<indice; i++){
			if (medicos[i].getCpf().equals(cpf)){
				medico=medicos[i];
			}else{
				if(medicos[i]==null){
					break;
				}
			}
		}
		return medico;
	}


	public String imprimir(String cpf) {
		String medico = null;
		for (int i=0; i<indice; i++){
			if (medicos[i].getCpf().equals(cpf)){
				medico = "\nDADOS: Nome: "+medicos[i].getNome()+", CPF: "+medicos[i].getCpf()+
						"\nTelefone: "+medicos[i].getTelefone()+", Especialidade: "+medicos[i].getEspecialidade()+"\n"
						+medicos[i].toString()+"\n";
			}else{
				if(medicos[i]==null){
					break;
				}
			}
		}
		return medico;
	}
	


	public ArrayList<String> listar()throws ExcecaoRepositorioVazio {
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaMedicos = new ArrayList<String> ();
			for (int i=0; i<indice; i++){
				if (medicos[i]!=null){
					listaMedicos.add(this.imprimir(medicos[i].getCpf()));
				}else{
					break;
				}
			}
			if(listaMedicos.size()==0){
				throw new ExcecaoRepositorioVazio(); 
			}
			return listaMedicos;		
		}


	}



	@Override
	public ArrayList<Medico> listar(String especialidade) throws ExcecaoRepositorioVazio{
		if(this.indice==0){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<Medico> listaMedicos = new ArrayList<Medico> ();
			for (int i=0; i<indice; i++){
				if (medicos[i]!=null){
					if (medicos[i].getEspecialidade().equals(especialidade)){
						listaMedicos.add(medicos[i]);
					}else{
						continue;
					}
				}else{
					break;
				}
			}
			if(listaMedicos.size()==0){
				throw new ExcecaoRepositorioVazio(); 
			}
				
			
			return listaMedicos;		
		}
	}

}
