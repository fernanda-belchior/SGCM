package gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import negocio.Agenda;
import negocio.Agendamento;
import negocio.Cancelamento;
import negocio.Fachada;
import negocio.Medico;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCancelamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea textArea_2 = new JTextArea();
	Fachada fachada = Fachada.getInstance();
	private JTextField cpf01;
	private JComboBox<String> jComboBoxMedicoEspecialidade;
	private JComboBox<String> jComboBoxMedicoNome;
	private JComboBox<String> jComboBoxAgendaData;
	private JComboBox<String> jComboBoxAgendaHoraPaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCancelamento frame = new TelaCancelamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCancelamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAtendente.class.getResource("/imagens/HC.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 0, 1024, 730);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("HCENTER");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 60));
		label.setBackground(Color.WHITE);
		label.setBounds(351, 19, 309, 54);
		contentPane.add(label);
		
		JLabel lblMenuCadastro = new JLabel(" MENU - CONSULTA - CANCELAMENTO");
		lblMenuCadastro.setBounds(10, 0, 360, 14);
		contentPane.add(lblMenuCadastro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 294, 587, 327);
		contentPane.add(scrollPane);
		
		
		textArea_2.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea_2);
		textArea_2.setBounds(589, 201, 409, 286);
		
		JLabel lblBu = new JLabel("BUSCAR AGENDAMENTO POR ESPECIALIDADE:");
		lblBu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBu.setBounds(10, 167, 425, 14);
		contentPane.add(lblBu);
		
		jComboBoxMedicoEspecialidade = new JComboBox<String>();
		jComboBoxMedicoEspecialidade.setModel(new DefaultComboBoxModel<String>(new String[] {"Psicologia", "Psiquiatria"}));
		jComboBoxMedicoEspecialidade.setBounds(10, 204, 211, 20);
		contentPane.add(jComboBoxMedicoEspecialidade);
		
		jComboBoxMedicoNome = new JComboBox<String>();
		jComboBoxMedicoNome.setBounds(411, 204, 451, 20);
		contentPane.add(jComboBoxMedicoNome);
		
		jComboBoxAgendaData = new JComboBox<String>();
		jComboBoxAgendaData.setBounds(10, 252, 211, 20);
		contentPane.add(jComboBoxAgendaData);
		
		JButton btnNewButton_1 = new JButton("CANCELAR AGENDAMENTO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					verificarComboBoxesVazios();
					try{						
						cancelarAgendamentoEspecialidade();
						limpar();
					}catch(ExcecaoDadoInvalido|ExcecaoElementoJaExistente
							|ExcecaoElementoInexistente|ExcecaoRepositorioVazio e){
						JOptionPane.showMessageDialog(null,e.getMessage());					
					}
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null,e.getMessage());					
				}
					
			}	
		});
		btnNewButton_1.setBounds(10, 305, 190, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setBounds(909, 632, 89, 23);
		contentPane.add(btnLimpar);
		
		JLabel label_1 = new JLabel("BUSCAR AGENDAMENTO POR PACIENTE:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 459, 425, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setBounds(10, 498, 46, 14);
		contentPane.add(label_2);
		
		cpf01 = new JTextField();
		cpf01.setColumns(10);
		cpf01.setBounds(69, 495, 184, 20);
		contentPane.add(cpf01);
		
		JButton button = new JButton("CANCELAR AGENDAMENTO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					cpfIsEmpty();
					try{
						cancelarAgendamentoPaciente();
						limpar();
					}catch(ExcecaoDadoInvalido|ExcecaoRepositorioVazio e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ExcecaoElementoJaExistente e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ExcecaoElementoInexistente e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		button.setBounds(10, 547, 190, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("BUSCAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					cpfIsEmpty();
					try{
						buscarAgendamentoPaciente();
					}catch (ExcecaoRepositorioVazio e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		button_1.setBounds(281, 494, 89, 23);
		contentPane.add(button_1);
		
		JButton btnListarCancelamentos = new JButton("LISTAR CANCELAMENTOS");
		btnListarCancelamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				try{
					listarCancelamentos();
				}catch (ExcecaoRepositorioVazio | ExcecaoDadoInvalido
						| ExcecaoElementoInexistente e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnListarCancelamentos.setBounds(654, 632, 190, 23);
		contentPane.add(btnListarCancelamentos);
		
		JButton btnNewButton = new JButton("CARREGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jComboBoxMedicoNome.removeAllItems();
				try{
					carregarJComboBoxMedicoNome();
				}catch (ExcecaoRepositorioVazio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());					

				}
			}
		});
		
		btnNewButton.setBounds(270, 203, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton button_2 = new JButton("CARREGAR");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jComboBoxAgendaData.removeAllItems();
				try{
					medicoVazio();
					try{
						listarDatas();
					}catch(ExcecaoDadoInvalido|ExcecaoElementoInexistente e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ExcecaoRepositorioVazio e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		button_2.setBounds(898, 203, 100, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("CARREGAR");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jComboBoxAgendaHoraPaciente.removeAllItems();
				try{
					medicoVazio();
					try{
						dataVazia();
						try{
							listarHorarios();
						}catch(ExcecaoDadoInvalido|ExcecaoElementoInexistente e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						} catch (ExcecaoRepositorioVazio e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}catch(ExcecaoDadoInvalido e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
			
		});
		button_3.setBounds(270, 251, 100, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("LISTAR AGENDAMENTOS");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				try{
					listarAgendamentos();
				}catch (ExcecaoRepositorioVazio | ExcecaoDadoInvalido
						| ExcecaoElementoInexistente e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			
			}
		});
		button_4.setBounds(411, 632, 190, 23);
		contentPane.add(button_4);
		
		JLabel label_3 = new JLabel("(EXIBE TODOS OS  AGENDAMENTOS POR M\u00C9DICO)");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_3.setBounds(411, 653, 190, 14);
		contentPane.add(label_3);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				try{
					verificarComboBoxesVazios();
					try{
						imprimirAgendamento();
					}catch(ExcecaoDadoInvalido e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ExcecaoRepositorioVazio e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (ExcecaoElementoInexistente e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnBuscar.setBounds(898, 251, 100, 23);
		contentPane.add(btnBuscar);
		jComboBoxAgendaHoraPaciente  = new JComboBox<String>();
		jComboBoxAgendaHoraPaciente.setBounds(411, 252, 451, 20);
		contentPane.add(jComboBoxAgendaHoraPaciente);
		
		JLabel label_4 = new JLabel("ESPECIALIDADE:");
		label_4.setBounds(10, 192, 122, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("M\u00C9DICO(A):");
		label_5.setBounds(411, 192, 69, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("DATA:");
		label_6.setBounds(10, 238, 46, 14);
		contentPane.add(label_6);
		
		JLabel lblHorrioPaciente = new JLabel("HOR\u00C1RIO - PACIENTE");
		lblHorrioPaciente.setBounds(410, 235, 174, 14);
		contentPane.add(lblHorrioPaciente);
		
		JLabel label_7 = new JLabel("(PARA LISTAR AGENDAMENTOS DE UM M\u00C9DICO \u00C9 NECESS\u00C1RIO \r\n");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_7.setBounds(411, 666, 243, 10);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("PREENCHER OS CAMPOS ESPECIALIDADE E M\u00C9DICO(A))");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_8.setBounds(411, 676, 229, 14);
		contentPane.add(label_8);
		
		JLabel lblexibeTodosOs = new JLabel("(EXIBE TODOS OS  CANCELAMENTOS)");
		lblexibeTodosOs.setForeground(Color.RED);
		lblexibeTodosOs.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblexibeTodosOs.setBounds(654, 652, 190, 14);
		contentPane.add(lblexibeTodosOs);
	}
	
	public void jComboBoxMedicoEspecialidadeNaoSelecionado() throws ExcecaoDadoInvalido{
		String especialidade = jComboBoxMedicoEspecialidade.getSelectedItem()+"";		
		if(especialidade.equals("<ESPECIALIDADE>")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	public void carregarJComboBoxMedicoNome() throws ExcecaoRepositorioVazio{
		ArrayList<Medico> medicos = listaMedicos();
		for(int i = 0; i<=medicos.size()-1;i++){
			jComboBoxMedicoNome.addItem(medicos.get(i).getNome());
		}
	}
	
	public void imprimirAgendamento() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String nome = jComboBoxMedicoNome.getSelectedItem().toString();
		String cpfMedico= buscarCpfMedico();
		String impressao=null;
		
		ArrayList<Agendamento> agendamentos = this.fachada.listarAgendamentos2(cpfMedico);
		String dataA = jComboBoxAgendaData.getSelectedItem()+"";
		String horaPaciente = jComboBoxAgendaHoraPaciente.getSelectedItem()+"";
		String array[]=horaPaciente.split("-");
		String horaA=array[0];
		String idAgenda = cpfMedico+dataA+horaA;
		for(int i = 0; i<agendamentos.size();i++){			
			if(agendamentos.get(i).getIdAgenda().equals(idAgenda)){
			
				String dadosPaciente=this.fachada.imprimirPaciente(agendamentos.get(i).getCpfPaciente());
				Agenda agenda = this.fachada.buscarAgenda(agendamentos.get(i).getIdAgenda());
				String data = agenda.getData();
				String hora = agenda.getHora();

				impressao = "\n\nAGENDAMENTO: "+dadosPaciente+"\nMédico: "+nome+", Especialidade: "+
						jComboBoxMedicoEspecialidade.getSelectedItem()+""+"\nData da Consulta: "+data+", Horario da Consulta: "+hora+"\n"
						+agendamentos.get(i).toString();

				textArea_2.append(impressao);
			}
		}
	}
	
	public ArrayList<Medico> listaMedicos() throws ExcecaoRepositorioVazio{
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		String especialidade = jComboBoxMedicoEspecialidade.getSelectedItem().toString();		
		medicos = this.fachada.listarMedicos( especialidade);
		return medicos;
	}
	
	
	
	public void cpfIsEmpty()throws ExcecaoDadoInvalido{
		if(cpf01.getText().equals("")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	
	public ArrayList<Medico> buscarMedicos() throws ExcecaoRepositorioVazio{
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		String especialidade = jComboBoxMedicoEspecialidade.getSelectedItem().toString();		
		medicos = this.fachada.listarMedicos( especialidade);
		return medicos;
	}
	
	
	public String buscarCpfMedico() throws ExcecaoRepositorioVazio{
		String nome = jComboBoxMedicoNome.getSelectedItem()+"";
		ArrayList<Medico> medicos = buscarMedicos();		
		String cpfMedico = null;
		
		for(int i = 0; i<=medicos.size()-1;i++){
			if(medicos.get(i).getNome().equals(nome)){
				cpfMedico = medicos.get(i).getCpf();
			}
		} 
		return cpfMedico;
		
	}
	
	
	public ArrayList<String> listarDatas() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		ArrayList<String> datas = new ArrayList<String>();
		String cpfMedico = buscarCpfMedico();
		ArrayList<Agendamento> agendamentos= this.fachada.listarAgendamentos2(cpfMedico);
		for(int i = 0; i<agendamentos.size();i++){	
			String idAgenda =agendamentos.get(i).getIdAgenda();
			Agenda agenda = this.fachada.buscarAgenda(idAgenda);
			String data = agenda.getData();
			if(!datas.contains(data)){				
				datas.add(data);
			}
		}
		for(int i=0; i<datas.size();i++){
			jComboBoxAgendaData.addItem(datas.get(i));			
		}
		return datas;
	}
	
	
	public void listarHorarios() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		ArrayList<String> horarios = new ArrayList<String>();
		String cpfMedico = buscarCpfMedico();
		ArrayList<Agendamento> agendamentos= this.fachada.listarAgendamentos2(cpfMedico);
		for(int i = 0; i<agendamentos.size();i++){
			String nomePaciente = this.fachada.buscarPaciente(agendamentos.get(i).getCpfPaciente()).getNome();
			String idAgenda =agendamentos.get(i).getIdAgenda();
			Agenda agenda = this.fachada.buscarAgenda(idAgenda);
			String hora = agenda.getHora();
			if(!horarios.contains(hora)){				
				horarios.add(hora+"-"+nomePaciente);
			}
		}
		for(int i=0; i<horarios.size();i++){
			jComboBoxAgendaHoraPaciente.addItem(horarios.get(i));			
		}
		
	}
	
	
	public void listarAgendamentos() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String cpfMedico =  buscarCpfMedico();
		ArrayList<String> agendamentos = this.fachada.listarAgendamentos(cpfMedico);
		for(int i=0; i<agendamentos.size();i++){
			textArea_2.append(agendamentos.get(i).toString());
		}						
		
		
	}
	
	public void listarCancelamentos() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		ArrayList<String> cancelamentos = this.fachada.listarCancelamentos();
		for(int i=0; i<cancelamentos.size();i++){
			textArea_2.append(cancelamentos.get(i).toString());
		}						
		
		
	}
	
	
		
	public void medicoVazio() throws ExcecaoDadoInvalido{
		String nome = jComboBoxMedicoNome.getSelectedItem()+"";
		if(nome.equals("null")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	
	public void dataVazia() throws ExcecaoDadoInvalido{
		String data = jComboBoxAgendaData.getSelectedItem()+"";
		if(data.equals("null")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	
	public void verificarComboBoxesVazios() throws ExcecaoDadoInvalido{
		String nome = jComboBoxMedicoNome.getSelectedItem()+"";
		String data = jComboBoxAgendaData.getSelectedItem()+"";
		String horario = jComboBoxAgendaHoraPaciente.getSelectedItem()+"";
		
		if(nome.equals("null")||data.equals("null")||horario.equals("null")){
			throw new ExcecaoDadoInvalido();	
						
		}	
		
	}
	
	
	public void limpar(){
		cpf01.setText("");
		textArea_2.setText("");
		jComboBoxMedicoNome.setSelectedItem(null);
		jComboBoxAgendaData.setSelectedItem(null);
		jComboBoxAgendaHoraPaciente.setSelectedItem(null);
		jComboBoxMedicoEspecialidade.setSelectedIndex(0);
	}
	
	public void cancelarAgendamentoEspecialidade() throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, 
	ExcecaoElementoInexistente, ExcecaoRepositorioVazio{
		Object[] options = { "SIM", "NÃO" };
		int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, 
				JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(opcao==0){
			String idAgendamento = null;
			String cpfPaciente=null;
			String cpfMedico= buscarCpfMedico();
			String cpfAtendente=Programa.getCpfEntrar();
			String dataCancelamento = "12/082017";//Faltou pegar a data do dia.
			String idCancelamento= null;
			ArrayList<Agendamento> agendamentos = this.fachada.listarAgendamentos2(cpfMedico);
			String dataA = jComboBoxAgendaData.getSelectedItem()+"";
			
			String horaPaciente = jComboBoxAgendaHoraPaciente.getSelectedItem()+"";
			String array[]=horaPaciente.split("-");
			String horaA=array[0];
			
			String idAgenda = cpfMedico+dataA+horaA;
			for(int i = 0; i<agendamentos.size();i++){			
				if(agendamentos.get(i).getIdAgenda().equals(idAgenda)){			
					idAgendamento=agendamentos.get(i).getIdAgendamento();
					idCancelamento=idAgendamento;
					cpfPaciente=agendamentos.get(i).getCpfPaciente();	
					break;
				}else{
					continue;
				}		
			}
			Cancelamento cancelamento = new Cancelamento(cpfPaciente,cpfMedico,cpfAtendente,idAgenda,
					dataCancelamento,idCancelamento );
			this.fachada.inserir(cancelamento);
			this.fachada.removerAgendamento(idAgendamento);
			Agenda agenda = this.fachada.buscarAgenda(idAgenda);
			agenda.setStatus("disponível");
			this.fachada.alterar(agenda);

			JOptionPane.showMessageDialog(null, "CANCELADO COM SUCESSO!");
		}else{
			JOptionPane.showMessageDialog(this,"NÃO CANCELADO!");
			textArea_2.setText("");
		}
		
	}
	
	
	public void cancelarAgendamentoPaciente() throws ExcecaoRepositorioVazio, ExcecaoElementoJaExistente,
	ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String cpfPaciente = cpf01.getText();
		boolean resposta = this.fachada.verificarExistenciaAgendamentoPaciente(cpfPaciente);
		if(resposta==true){
			Object[] options = { "SIM", "NÃO" };
			int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(opcao==0){
				Agendamento agendamento = this.buscarAgendamentoPaciente();
				String cpfAtendente=Programa.getCpfEntrar();
				String dataCancelamento = "12/08/2017";//Faltou pegar a data do dia.
				String idCancelamento= agendamento.getIdAgendamento();
				String idAgenda = agendamento.getIdAgenda();
				String cpfMedico = agendamento.getCpfMedico();
				Cancelamento cancelamento = new Cancelamento(cpfPaciente,cpfMedico,cpfAtendente,idAgenda,dataCancelamento,
						idCancelamento );

				this.fachada.inserir(cancelamento);
				this.fachada.removerAgendamento(agendamento.getIdAgendamento());
				Agenda agenda = this.fachada.buscarAgenda(idAgenda);
				agenda.setStatus("disponível");
				this.fachada.alterar(agenda);

				JOptionPane.showMessageDialog(null, "CANCELADO COM SUCESSO!");
			}else{
				JOptionPane.showMessageDialog(this,"NÃO CANCELADO!");
				textArea_2.setText("");
			}
		}else{
			JOptionPane.showMessageDialog(null, "NÃO HÁ AGENDAMENTOS PARA ESTE PACIENTE!");
		}
		


		
	}
	
	
	public Agendamento buscarAgendamentoPaciente() throws ExcecaoRepositorioVazio {
		String cpfPaciente= cpf01.getText();
		ArrayList<Agendamento> agendamentos = this.fachada.listarAgendamentos();
		Agendamento agendamento = new Agendamento();
		for(int i=0; i<agendamentos.size();i++){
			if(agendamentos.get(i).getCpfPaciente().equals(cpfPaciente)){
				agendamento = agendamentos.get(i);
				break;
				
			}else{
				continue;
			}
		}
		textArea_2.setText(agendamento.toString());
		return agendamento;
	}
	

	
	
}
