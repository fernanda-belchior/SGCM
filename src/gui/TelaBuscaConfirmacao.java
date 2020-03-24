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
import negocio.Consulta;
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

public class TelaBuscaConfirmacao extends JFrame {

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
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;

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
	public TelaBuscaConfirmacao() {
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
		
		JLabel lblMenuCadastro = new JLabel(" MENU - CONSULTA - BUSCA/CONFIRMA\u00C7\u00C3O");
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
		lblBu.setBounds(10, 156, 425, 14);
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
		
		JButton btnNewButton_1 = new JButton("CONFIRMAR CONSULTA");
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
		btnNewButton_1.setBounds(10, 380, 190, 23);
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
		
		JButton btnConfirmarConsulta = new JButton("CONFIRMAR CONSULTA");
		btnConfirmarConsulta.addActionListener(new ActionListener() {
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
		btnConfirmarConsulta.setBounds(10, 598, 190, 23);
		contentPane.add(btnConfirmarConsulta);
		
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
		
		JButton btnListarCancelamentos = new JButton("LISTAR CONSULTAS");
		btnListarCancelamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				try{
					listarConsultas();
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
		jComboBoxAgendaHoraPaciente  = new JComboBox<String>();
		jComboBoxAgendaHoraPaciente.setBounds(411, 252, 451, 20);
		contentPane.add(jComboBoxAgendaHoraPaciente);
		
		JLabel lblexibeTodasAs = new JLabel("(EXIBE TODAS AS  CONSULTAS POR M\u00C9DICO)");
		lblexibeTodasAs.setForeground(Color.RED);
		lblexibeTodasAs.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblexibeTodasAs.setBounds(654, 652, 190, 14);
		contentPane.add(lblexibeTodasAs);
		
		JLabel lblNewLabel = new JLabel("(SELECIONAR ESPECIALIDADE E O M\u00C9DICO )");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(411, 667, 184, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("(SELECIONAR ESPECIALIDADE E O M\u00C9DICO )");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_4.setBounds(654, 666, 184, 14);
		contentPane.add(label_4);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Realizada", "N\u00E3o Realizada (Paciente N\u00E3o Compareceu)", "N\u00E3o Realizada (M\u00E9dico N\u00E3o Compareceu)"}));
		comboBox.setBounds(99, 331, 211, 20);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Realizada", "N\u00E3o Realizada (Paciente N\u00E3o Compareceu)", "N\u00E3o Realizada (M\u00E9dico N\u00E3o Compareceu)"}));
		comboBox_1.setBounds(99, 540, 211, 20);
		contentPane.add(comboBox_1);
		
		
		JButton button = new JButton("BUSCAR");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(898, 251, 100, 23);
		contentPane.add(button);
		
		JLabel lblSituao = new JLabel("SITUA\u00C7\u00C3O:");
		lblSituao.setBounds(10, 337, 100, 14);
		contentPane.add(lblSituao);
		
		JLabel label_5 = new JLabel("ESPECIALIDADE:");
		label_5.setBounds(10, 191, 122, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("M\u00C9DICO(A):");
		label_6.setBounds(411, 191, 69, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("DATA:");
		label_7.setBounds(10, 235, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("HOR\u00C1RIO - PACIENTE");
		label_8.setBounds(411, 235, 174, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("SITUA\u00C7\u00C3O:");
		label_9.setBounds(10, 543, 100, 14);
		contentPane.add(label_9);
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
	
	public void listarConsultas() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String cpfMedico =  buscarCpfMedico();
		ArrayList<String> consultas = this.fachada.listarConsultas(cpfMedico);
		for(int i=0; i<consultas.size();i++){
			textArea_2.append(consultas.get(i).toString());
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
			String status = comboBox.getSelectedItem()+"";
			String idAgendamento = null;
			String cpfPaciente=null;
			String cpfMedico= buscarCpfMedico();
			String cpfAtendente=Programa.getCpfEntrar();			
			String idConsulta= null;
			ArrayList<Agendamento> agendamentos = this.fachada.listarAgendamentos2(cpfMedico);
			String dataConsulta = jComboBoxAgendaData.getSelectedItem()+"";
			
			String horaPaciente = jComboBoxAgendaHoraPaciente.getSelectedItem()+"";
			String array[]=horaPaciente.split("-");
			String horaConsulta=array[0];
			
			String idAgenda = cpfMedico+dataConsulta+horaConsulta;
			for(int i = 0; i<agendamentos.size();i++){			
				if(agendamentos.get(i).getIdAgenda().equals(idAgenda)){			
					idAgendamento=agendamentos.get(i).getIdAgendamento();
					idConsulta=idAgendamento;
					cpfPaciente=agendamentos.get(i).getCpfPaciente();	
					break;
				}else{
					continue;
				}		
			}
			Consulta consulta = new Consulta(cpfPaciente, cpfMedico,cpfAtendente, dataConsulta, horaConsulta, idConsulta, status);
			this.fachada.inserir(consulta);
			this.fachada.removerAgendamento(idAgendamento);
			this.fachada.removerAgenda(idAgenda);
			JOptionPane.showMessageDialog(null, "CONSULTA CONFIRMADA COM SUCESSO!SITUAÇÃO: "+status.toUpperCase());
		}else{
			JOptionPane.showMessageDialog(this,"NÃO CONFIRMADA!");
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
				String status = comboBox_1.getSelectedItem()+"";
				String cpfAtendente=Programa.getCpfEntrar();
				String idConsulta= agendamento.getIdAgendamento();
				String idAgenda = agendamento.getIdAgenda();
				Agenda agenda= this.fachada.buscarAgenda(idAgenda);
				String dataConsulta=agenda.getData();
				String horaConsulta=agenda.getHora();
				String cpfMedico = agendamento.getCpfMedico();
				
				Consulta consulta = new Consulta(cpfPaciente, cpfMedico,cpfAtendente, dataConsulta, horaConsulta, idConsulta, status);
				this.fachada.inserir(consulta);
				this.fachada.removerAgendamento(agendamento.getIdAgendamento());
				this.fachada.removerAgenda(idAgenda);
				JOptionPane.showMessageDialog(null, "CONSULTA CONFIRMADA COM SUCESSO! SITUAÇÃO: "+status.toUpperCase());
			}else{
				JOptionPane.showMessageDialog(this,"NÃO CONFIRMADA!");
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
