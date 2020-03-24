package dados;

import java.util.ArrayList;











import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import negocio.*;

public class RepositorioAgendamentosLista implements IRepositorioAgendamentos{
	private Agendamento agendamento;
	private RepositorioAgendamentosLista proximo;
	private static RepositorioAgendamentosLista instance;

	public static RepositorioAgendamentosLista getInstance(){
		if (RepositorioAgendamentosLista.instance == null){
			RepositorioAgendamentosLista.instance = new RepositorioAgendamentosLista ();
		}
		return RepositorioAgendamentosLista.instance;
	}


	public RepositorioAgendamentosLista getProximo(){
		return proximo;
	}
	
	public void inserir (Agendamento agendamento)throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido {
		if(this.agendamento == null){
			this.agendamento = agendamento;
            proximo = new RepositorioAgendamentosLista();
        }else{
            proximo.inserir(agendamento);
        }
		
	}


	public void alterar(Agendamento agendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.agendamento.getIdAgendamento().equals(agendamento.getIdAgendamento())){
			this.agendamento=agendamento;
		}else{
			proximo.alterar(agendamento);
		}
		
	}

	
	public void remover(String idAgendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		if(this.agendamento!=null){
			if(this.agendamento.getIdAgendamento().equals(idAgendamento)){
				this.agendamento=proximo.agendamento;
				proximo=proximo.getProximo();
			}else{
				proximo.remover(idAgendamento);
			}
		}
	}

	public boolean verificarExistencia(String idAgendamento) {
		boolean retorno = false;
		RepositorioAgendamentosLista auxiliar = new RepositorioAgendamentosLista();
		auxiliar.agendamento=this.agendamento;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.agendamento!=null){
			if(auxiliar.agendamento.getIdAgendamento().equals(idAgendamento)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	


	public Agendamento buscar(String idAgendamento)throws ExcecaoElementoInexistente, ExcecaoDadoInvalido {
		Agendamento agendamento = new Agendamento();
		RepositorioAgendamentosLista auxiliar = new RepositorioAgendamentosLista();
		auxiliar.agendamento=this.agendamento;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.agendamento!=null){
			if(auxiliar.agendamento.getIdAgendamento().equals(idAgendamento)){
				agendamento=auxiliar.agendamento;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return agendamento;
	}

	
	public String imprimir(String idAgendamento) {
		Agendamento agendamento = new Agendamento();
		RepositorioAgendamentosLista auxiliar = new RepositorioAgendamentosLista();
		auxiliar.agendamento=this.agendamento;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.agendamento!=null){
			if(auxiliar.agendamento.getIdAgendamento().equals(idAgendamento)){
				agendamento=auxiliar.agendamento;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		String impressao = agendamento.toString();
		
		return impressao;
	}

	
	public ArrayList<Agendamento> listar()throws ExcecaoRepositorioVazio {
		if(this.agendamento==null){
			throw new ExcecaoRepositorioVazio();
		}else{
	
			ArrayList<Agendamento> listaAgendamentos = new ArrayList<Agendamento> ();
			RepositorioAgendamentosLista auxiliar = new RepositorioAgendamentosLista();
			
			auxiliar.agendamento=this.agendamento;
			auxiliar.proximo=this.proximo;

			while(auxiliar.agendamento!=null){
				listaAgendamentos.add(auxiliar.agendamento);
				auxiliar=auxiliar.proximo;				

			}		
			if(listaAgendamentos.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendamentos;
		}
	}

	public ArrayList<String> listar(String cpfMedico) throws ExcecaoRepositorioVazio{
		if(this.agendamento==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<String> listaAgendamentos = new ArrayList<String> ();
			RepositorioAgendamentosLista auxiliar = new RepositorioAgendamentosLista();
			String agendamento = null;

			auxiliar.agendamento=this.agendamento;
			auxiliar.proximo=this.proximo;

			while(auxiliar.agendamento!=null){
				if(auxiliar.agendamento.getCpfMedico().equals(cpfMedico)){
					agendamento = imprimir(auxiliar.agendamento.getIdAgendamento());
					listaAgendamentos.add(agendamento);
				}
				auxiliar=auxiliar.proximo;
			}	
			if(listaAgendamentos.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendamentos;

		}

	}
	
	@Override
	public ArrayList<Agendamento> listarAgendamentos(String cpfMedico) throws ExcecaoRepositorioVazio{
		if(this.agendamento==null){
			throw new ExcecaoRepositorioVazio();
		}else{
			ArrayList<Agendamento> listaAgendamentos = new ArrayList<Agendamento> ();
			RepositorioAgendamentosLista auxiliar = new RepositorioAgendamentosLista();
			auxiliar.agendamento=this.agendamento;
			auxiliar.proximo=this.proximo;

			while(auxiliar.agendamento!=null){
				if(auxiliar.agendamento.getCpfMedico().equals(cpfMedico)){
					listaAgendamentos.add(auxiliar.agendamento);
				}
				auxiliar=auxiliar.proximo;
			}	
			if(listaAgendamentos.size()==0){
				throw new ExcecaoRepositorioVazio();
			}
			return listaAgendamentos;
		}
	}


	@Override
	public boolean verificarExistenciaAgendamento(String cpfPaciente) {
		boolean retorno = false;
		RepositorioAgendamentosLista auxiliar = new RepositorioAgendamentosLista();
		auxiliar.agendamento=this.agendamento;
		auxiliar.proximo=this.proximo;
		
		while(auxiliar.agendamento!=null){
			if(auxiliar.agendamento.getCpfPaciente().equals(cpfPaciente)){
				retorno=true;
				break;
			}else{
				auxiliar=auxiliar.proximo;				
			}
		}
		
		return retorno;
	}
	
}


