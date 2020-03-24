package gui;

//falta adicionar o cpf do atendente no agendamento
//pegar cpf do login.

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
import negocio.Fachada;
import negocio.Medico;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import exceptions.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAgendamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Fachada fachada = Fachada.getInstance();
	private JComboBox<String> jComboBoxMedicoEspecialidade;
	private JComboBox<String> jComboBoxAgendaData;
	private JComboBox<String> jComboBoxAgendaHorario;
	private JComboBox<String> jComboBoxMedicoNome;
	private JTextArea textArea;
	private JTextArea textArea_2;
	private JTextField cpf01;


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgendamento frame = new TelaAgendamento();
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
	public TelaAgendamento() {
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
		
		JLabel lblMenuCadastro = new JLabel(" MENU - CONSULTA - AGENDAMENTO");
		lblMenuCadastro.setBounds(10, 0, 360, 14);
		contentPane.add(lblMenuCadastro);
		
		JLabel lblConsultarDisponibilidade = new JLabel("CONSULTAR DISPONIBILIDADE:");
		lblConsultarDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarDisponibilidade.setBounds(10, 136, 243, 14);
		contentPane.add(lblConsultarDisponibilidade);
		
		jComboBoxMedicoEspecialidade = new JComboBox<String>();
		jComboBoxMedicoEspecialidade.setModel(new DefaultComboBoxModel<String>(new String[] {"Psicologia", "Psiquiatria"}));
		jComboBoxMedicoEspecialidade.setBounds(10, 177, 159, 20);
		contentPane.add(jComboBoxMedicoEspecialidade);
		
		jComboBoxAgendaData = new JComboBox<String>();
		jComboBoxAgendaData.setBounds(10, 239, 159, 20);
		contentPane.add(jComboBoxAgendaData);
		
		jComboBoxAgendaHorario = new JComboBox<String>();
		jComboBoxAgendaHorario.setBounds(410, 239, 159, 20);
		contentPane.add(jComboBoxAgendaHorario);
		
		JButton listarAgendamentos = new JButton("LISTAR AGENDAMENTOS");
		listarAgendamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textArea_2.setText("");
					listarAgendamentos();												
				} catch (ExcecaoRepositorioVazio | ExcecaoDadoInvalido
						| ExcecaoElementoInexistente e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}


		});
		listarAgendamentos.setBounds(540, 345, 174, 23);
		contentPane.add(listarAgendamentos);
		
		JButton limpar = new JButton("LIMPAR");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cpf01.setText("");
				textArea.setText("");
			}
		});
		limpar.setBounds(310, 600, 89, 23);
		contentPane.add(limpar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 466, 389, 123);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel label_1 = new JLabel("CARREGAR DADOS DO PACIENTE:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 388, 243, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setBounds(10, 430, 46, 14);
		contentPane.add(label_2);
		
		cpf01 = new JTextField();
		cpf01.setColumns(10);
		cpf01.setBounds(57, 427, 196, 20);
		contentPane.add(cpf01);
		
		JButton buscarPaciente = new JButton("BUSCAR");
		buscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				try{
					imprimirPaciente();
				}catch(ExcecaoDadoInvalido|ExcecaoElementoInexistente e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ExcecaoRepositorioVazio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		buscarPaciente.setBounds(295, 426, 104, 23);
		contentPane.add(buscarPaciente);
		
		JButton button_1 = new JButton("AGENDAR CONSULTA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					verificarComboBoxesVazios();
					try{
						verificarCamposVazios();
						try{
							textArea_2.setText("");
							cadastrar();														
						}catch(ExcecaoDadoInvalido e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						} catch (ExcecaoRepositorioVazio e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						} catch (ExcecaoElementoJaExistente e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						} catch (ExcecaoElementoInexistente e) {
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
		button_1.setBounds(10, 600, 159, 23);
		contentPane.add(button_1);
		
		JButton button = new JButton("CARREGAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jComboBoxMedicoNome.removeAllItems();
				try{
					carregarJComboBoxMedicoNome();
				}catch (ExcecaoRepositorioVazio e) {
					JOptionPane.showMessageDialog(null, e.getMessage());					

				}
			}
		});
		button.setBounds(204, 176, 122, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(540, 377, 440, 279);
		contentPane.add(scrollPane);
		
		textArea_2 = new JTextArea();
		scrollPane.setViewportView(textArea_2);
		
		JLabel lblNewLabel = new JLabel("ESPECIALIDADE:");
		lblNewLabel.setBounds(10, 161, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label_5 = new JLabel("M\u00C9DICO(A):");
		label_5.setBounds(410, 159, 69, 14);
		contentPane.add(label_5);
		
		jComboBoxMedicoNome = new JComboBox<String>();
		jComboBoxMedicoNome.setBounds(410, 177, 405, 20);
		contentPane.add(jComboBoxMedicoNome);
		
		JButton button_4 = new JButton("CARREGAR");
		button_4.addActionListener(new ActionListener() {
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
		button_4.setBounds(858, 176, 122, 23);
		contentPane.add(button_4);
		
		JLabel lblNewLabel_1 = new JLabel("DATA:");
		lblNewLabel_1.setBounds(10, 222, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton button_2 = new JButton("CARREGAR");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jComboBoxAgendaHorario.removeAllItems();
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
		button_2.setBounds(204, 238, 122, 23);
		contentPane.add(button_2);
		
		JLabel lblHorrio = new JLabel("HOR\u00C1RIO:");
		lblHorrio.setBounds(409, 222, 70, 14);
		contentPane.add(lblHorrio);
		
		JButton btnLimparTudpo = new JButton("LIMPAR TUDO");
		btnLimparTudpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();				
			}
		});
		btnLimparTudpo.setBounds(832, 345, 148, 23);
		contentPane.add(btnLimparTudpo);
		
		JLabel label_3 = new JLabel("(PARA LISTAR AGENDAMENTOS DE UM M\u00C9DICO \u00C9 NECESS\u00C1RIO \r\n");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_3.setBounds(540, 657, 243, 10);
		contentPane.add(label_3);
		
		JLabel lblPreencherOsCampos = new JLabel("PREENCHER OS CAMPOS ESPECIALIDADE E M\u00C9DICO(A))");
		lblPreencherOsCampos.setForeground(Color.RED);
		lblPreencherOsCampos.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblPreencherOsCampos.setBounds(540, 667, 229, 14);
		contentPane.add(lblPreencherOsCampos);
		
		JButton button_3 = new JButton("CONSULTAR DISPONIBILIDADE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					verificarComboBoxesVazios();
					try{
						consultarDisponibilidade();						
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
		button_3.setBounds(737, 238, 243, 23);
		contentPane.add(button_3);
		
		//jComboxMedicoEspecialidade.addActionListener(acaoSelecao);
	}
	
		
	public void carregarJComboBoxMedicoNome() throws ExcecaoRepositorioVazio{
		ArrayList<Medico> medicos = listaMedicos();
		for(int i = 0; i<=medicos.size()-1;i++){
			jComboBoxMedicoNome.addItem(medicos.get(i).getNome());
		}
	}	
	
	public void imprimirPaciente() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{	
		textArea.append(this.fachada.imprimirPaciente(cpf01.getText()));
	}
	
	
	public void imprimirAgendamento() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String nome = jComboBoxMedicoNome.getSelectedItem().toString();
		String cpfMedico= buscarCpfMedico();
		String impressao=null;
		
		ArrayList<Agendamento> agendamentos = this.fachada.listarAgendamentos2(cpfMedico);
		String dataA = jComboBoxAgendaData.getSelectedItem()+"";
		String horaA = jComboBoxAgendaHorario.getSelectedItem()+"";
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
		ArrayList<Agenda> agendas= this.fachada.listarAgendas(cpfMedico);
		for(int i = 0; i<=agendas.size()-1;i++){
			if(!datas.contains(agendas.get(i).getData())){
				datas.add(agendas.get(i).getData());
			}
		}
		for(int i=0; i<datas.size();i++){
			jComboBoxAgendaData.addItem(datas.get(i));			
		}
		return datas;
	}
	
	
	public void listarHorarios() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String data = jComboBoxAgendaData.getSelectedItem()+"";
		ArrayList<String> horarios = new ArrayList<String>();
		String cpfMedico = buscarCpfMedico();
		ArrayList<Agenda> agendas= this.fachada.listarAgendas(cpfMedico);
		
		for(int i = 0; i<=agendas.size()-1;i++){
			if(agendas.get(i).getData().equals(data)){
				horarios.add(agendas.get(i).getHora());
			}
		}
		for(int i=0; i<horarios.size();i++){
			jComboBoxAgendaHorario.addItem(horarios.get(i));			
		}
		
	}
	
	
	
	
	public void consultarDisponibilidade() throws ExcecaoRepositorioVazio, ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		String dataA = jComboBoxAgendaData.getSelectedItem()+"";
		String horaA = jComboBoxAgendaHorario.getSelectedItem()+"";
		String cpfMedico =  buscarCpfMedico();
		String idAgenda = cpfMedico+dataA+horaA;
		
		Agenda agenda= this.fachada.buscarAgenda(idAgenda);
		JOptionPane.showMessageDialog(null, agenda.getStatus()+"!".toUpperCase());		
		
	}
	
	public void listarAgendamentos() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String cpfMedico =  buscarCpfMedico();
		ArrayList<String> agendamentos = this.fachada.listarAgendamentos(cpfMedico);
		for(int i=0; i<agendamentos.size();i++){
			textArea_2.append(agendamentos.get(i).toString());
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
		String horario = jComboBoxAgendaHorario.getSelectedItem()+"";
		
		if(nome.equals("null")||data.equals("null")||horario.equals("null")){
			throw new ExcecaoDadoInvalido();	
						
		}
	}
	
	public void verificarCamposVazios() throws ExcecaoDadoInvalido{
		if(cpf01.equals("")||textArea.equals("")){
			throw new ExcecaoDadoInvalido();	
		}
	}
	
	public void limpar(){
		cpf01.setText("");
		textArea .setText("");
		textArea_2.setText("");
		jComboBoxMedicoNome.setSelectedItem(null);
		jComboBoxAgendaData.setSelectedItem(null);
		jComboBoxAgendaHorario.setSelectedItem(null);
		jComboBoxMedicoEspecialidade.setSelectedIndex(0);
		
	}
	
	public void agendarConsulta() throws ExcecaoRepositorioVazio, ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoPacienteComAgendamento{
			boolean resposta = false;
			String cpfPaciente = cpf01.getText();
			String cpfMedico = buscarCpfMedico();
			
			ArrayList<Agendamento> agendamentos = this.fachada.listarAgendamentos2(cpfMedico);
			for(int i=0; i<agendamentos.size();i++){
				if(agendamentos.get(i).getCpfPaciente().equals(cpfPaciente)){
					resposta=true;						
				}
			}
			if(resposta==true){
				throw new ExcecaoPacienteComAgendamento();				
			}else{
				cadastrar();
			}
			
			
			
		
	}
	
	public void cadastrar() throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoElementoInexistente{
		try{
			verificarAgenda();
			try{
				verificarAgendamentoPaciente();
				String dataA = jComboBoxAgendaData.getSelectedItem()+"";
				String horaA = jComboBoxAgendaHorario.getSelectedItem()+"";
				String cpfPaciente= cpf01.getText(); 
				String cpfMedico = buscarCpfMedico();
				String idAgenda = cpfMedico+ dataA+horaA;
				String cpfAtendente=Programa.getCpfEntrar();
				String dataAgendamento ="14/08/2017";//Faltou pegar a data do dia.
				String idAgendamento = idAgenda+cpfPaciente;

				Agendamento agendamento = new Agendamento(cpfPaciente, idAgenda, cpfAtendente, cpfMedico, dataAgendamento, idAgendamento);
				Agenda agenda = this.fachada.buscarAgenda(idAgenda);
				agenda.setStatus("indisponível");
				this.fachada.inserir(agendamento);
				this.fachada.alterar(agenda);
				JOptionPane.showMessageDialog(null, "AGENDADO COM SUCESSO!");
				imprimirAgendamento();
				limpar1();
			}catch(ExcecaoPacienteComAgendamento e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}catch(ExcecaoElementoInexistente|ExcecaoDadoInvalido|ExcecaoRepositorioVazio|ExcecaoAgendaNaoDisponivel e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
	}

	public void verificarAgendamentoPaciente() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoPacienteComAgendamento{
		String cpfPaciente = cpf01.getText();
		boolean resposta = this.fachada.verificarExistenciaAgendamentoPaciente(cpfPaciente);
		if(resposta==true){
			throw new ExcecaoPacienteComAgendamento();
		}
	}
	
	public void verificarAgenda() throws ExcecaoElementoInexistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio, ExcecaoAgendaNaoDisponivel{
		String dataA = jComboBoxAgendaData.getSelectedItem()+"";
		String horaA = jComboBoxAgendaHorario.getSelectedItem()+"";
		String cpfMedico = buscarCpfMedico();
		String idAgenda = cpfMedico+ dataA+horaA;
		String status= this.fachada.buscarAgenda(idAgenda).getStatus();
		
		if(status.equals("indisponível")){
			throw new ExcecaoAgendaNaoDisponivel();
		}
		
		
	}
	
	
	
	public void limpar1(){
		cpf01.setText("");
		textArea .setText("");
		jComboBoxMedicoNome.setSelectedItem(null);
		jComboBoxAgendaData.setSelectedItem(null);
		jComboBoxAgendaHorario.setSelectedItem(null);
		jComboBoxMedicoEspecialidade.setSelectedIndex(0);
		
	}
	
	
		
}

