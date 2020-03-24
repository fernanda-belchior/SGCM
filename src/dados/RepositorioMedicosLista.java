package dados;

import java.util.ArrayList;

import exceptions.*;
import negocio.*;

public class RepositorioMedicosLista implements IRepositorioMedicos{
	private Medico medico;
	private RepositorioMedicosLista proximo;
	private static RepositorioMedicosLista instance;
		

	public static RepositorioMedicosLista getInstance(){
		if (RepositorioMedicosLista.instance == null){
			RepositorioMedicosLista.instance = new RepositorioMedicosLista ();
		}
		return RepositorioMedicosLista.instance;
	}

	
	public RepositorioMedicosLista getProximo(){
		return proximo;
	}
	
	public void inserir(Medico medico)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.medico == null){
			this.medico = medico;
            proximo = new RepositorioMedicosLista();
        }else{
            proximo.inserir(medico);
        }
		
	}


	public void alterar(Medico medico)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.medico.getCpf()==medico.getCpf()){
			this.medico=medico;
		}else{
			proximo.alterar(medico);
		}
		
	}

	
	public void remover(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.medico!=null){
			if(this.medico.getCpf().equals(cpf)){
				this.medico=proximo.medico;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(cpf);
			}
		}
				
	}

	public boolean verificarExistencia(String cpf) {
		boolean retorno = false;
		RepositorioMedicosLista auxiliar = new RepositorioMedicosLista();
		auxiliar.medico=this.medico;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.medico!=null){
			if(auxiliar.medico.getCpf().equals(cpf)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Medico buscar(String cpf)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Medico medico = new Medico();
		RepositorioMedicosLista auxiliar = new RepositorioMedicosLista();
		auxiliar.medico=this.medico;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.medico!=null){
			if(auxiliar.medico.getCpf().equals(cpf)){
				medico=auxiliar.medico;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return medico;
	}

	
	public String imprimir(String cpf) {
		negocio.Medico medico = new Medico();
		RepositorioMedicosLista auxiliar = new RepositorioMedicosLista();
		auxiliar.medico=this.medico;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.medico!=null){
			if(auxiliar.medico.getCpf().equals(cpf)){
				medico=auxiliar.medico;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = "\nDADOS: Nome: "+medico.getNome()+", CPF: "+medico.getCpf()+
            	"\nTelefone: "+medico.getTelefone()+", Especialidade: "+medico.getEspecialidade();
		
		return impressao;
	}

	
	public ArrayList<String> listar() throws ExcecaoRepositorioVazio{
		if(this.medico==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaMedicos = new ArrayList<String> ();
			RepositorioMedicosLista auxiliar = new RepositorioMedicosLista();
			String medico = null;

			auxiliar.medico=this.medico;
			auxiliar.proximo=this.proximo;

			while(auxiliar.medico!=null){
				medico = imprimir(auxiliar.medico.getCpf());
				listaMedicos.add(medico);
				auxiliar=auxiliar.proximo;				

			}
		
			if(listaMedicos.size()==0){
				throw new ExcecaoRepositorioVazio(); 
			}	
			return listaMedicos;
		}
	}


	@Override
	public ArrayList<Medico> listar(String especialidade) throws ExcecaoRepositorioVazio{
		if(this.medico==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<Medico> listaMedicos = new ArrayList<Medico> ();
			RepositorioMedicosLista auxiliar = new RepositorioMedicosLista();
			auxiliar.medico=this.medico;
			auxiliar.proximo=this.proximo;

			while(auxiliar.medico!=null){
				if(auxiliar.medico.getEspecialidade().equals(especialidade)){
					listaMedicos.add(auxiliar.medico);
					auxiliar=auxiliar.proximo;
				}else{
					auxiliar=auxiliar.proximo;
				}

			}
			if(listaMedicos.size()==0){
				throw new ExcecaoRepositorioVazio(); 
			}
			return listaMedicos;
		}
	
	
	}
}
