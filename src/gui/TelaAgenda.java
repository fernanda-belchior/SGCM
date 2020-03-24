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
import negocio.Fachada;
import negocio.Medico;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import exceptions.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAgenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Fachada fachada = Fachada.getInstance();
	private JComboBox<String> jComboBoxMedicoEspecialidade;
	private JComboBox<String> jComboBoxMedicoNome;
	private JTextField data;
	private JTextArea textArea_2;
	private JComboBox<String> jComboBoxAgendaHorario;


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgenda frame = new TelaAgenda();
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
	public TelaAgenda() {
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
		
		JLabel lblMenuCadastro = new JLabel(" MENU - CADASTRO - AGENDA");
		lblMenuCadastro.setBounds(10, 0, 360, 14);
		contentPane.add(lblMenuCadastro);
		
		JLabel lblConsultarDisponibilidade = new JLabel("CADASTRAR NOVA AGENDA");
		lblConsultarDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarDisponibilidade.setBounds(10, 136, 243, 14);
		contentPane.add(lblConsultarDisponibilidade);
		
		jComboBoxMedicoEspecialidade = new JComboBox<String>();
		jComboBoxMedicoEspecialidade.setModel(new DefaultComboBoxModel<String>(new String[] {"Psicologia", "Psiquiatria"}));
		jComboBoxMedicoEspecialidade.setBounds(10, 177, 211, 20);
		contentPane.add(jComboBoxMedicoEspecialidade);
		
		JButton listarAgendas = new JButton("LISTAR AGENDAS");
		listarAgendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				try{
					medicoVazio();
					try{
						imprimirAgendas();
					}catch(ExcecaoRepositorioVazio| ExcecaoDadoInvalido| ExcecaoElementoInexistente e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}	
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		listarAgendas.setBounds(10, 391, 159, 23);
		contentPane.add(listarAgendas);
		
		JButton consultarDisponibilidade = new JButton("CADASTRAR");
		consultarDisponibilidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					verificarCamposVazios();
					try{
						cadastrar();
						try{
							imprimir();
						}catch(ExcecaoRepositorioVazio| ExcecaoDadoInvalido| ExcecaoElementoInexistente e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}catch(ExcecaoDadoInvalido|ExcecaoRepositorioVazio|ExcecaoElementoJaExistente e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		consultarDisponibilidade.setBounds(10, 300, 159, 23);
		contentPane.add(consultarDisponibilidade);
		
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
		button.setBounds(273, 176, 139, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("ESPECIALIDADE:");
		lblNewLabel.setBounds(10, 161, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label_5 = new JLabel("M\u00C9DICO(A):");
		label_5.setBounds(454, 161, 69, 14);
		contentPane.add(label_5);
		
		jComboBoxMedicoNome = new JComboBox<String>();
		jComboBoxMedicoNome.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		jComboBoxMedicoNome.setBounds(456, 177, 359, 20);
		contentPane.add(jComboBoxMedicoNome);
		
		JLabel lblNewLabel_1 = new JLabel("DIGITE A DATA NO FORMATO dd/mm/aaaa:");
		lblNewLabel_1.setBounds(10, 222, 243, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton buscar = new JButton("BUSCAR");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				try{
					imprimir();
				}catch(ExcecaoRepositorioVazio| ExcecaoDadoInvalido| ExcecaoElementoInexistente e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		buscar.setBounds(456, 241, 122, 23);
		contentPane.add(buscar);
		
		JButton btnLimparTudpo = new JButton("LIMPAR TUDO");
		btnLimparTudpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparTudpo.setBounds(10, 438, 159, 23);
		contentPane.add(btnLimparTudpo);
		
		data = new JTextField();
		data.setBounds(10, 242, 211, 19);
		contentPane.add(data);
		data.setColumns(10);
		
		jComboBoxAgendaHorario = new JComboBox<String>();
		jComboBoxAgendaHorario.setModel(new DefaultComboBoxModel<String>(new String[] {"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"}));
		jComboBoxAgendaHorario.setBounds(273, 239, 139, 20);
		contentPane.add(jComboBoxAgendaHorario);
		
		JLabel lblEscolhaOHorrio = new JLabel("ESCOLHA O HOR\u00C1RIO:");
		lblEscolhaOHorrio.setBounds(273, 222, 139, 14);
		contentPane.add(lblEscolhaOHorrio);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					remover();
				}catch(ExcecaoRepositorioVazio| ExcecaoDadoInvalido| ExcecaoElementoInexistente e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		btnRemover.setBounds(10, 345, 159, 23);
		contentPane.add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 300, 572, 277);
		contentPane.add(scrollPane);
		
		textArea_2 = new JTextArea();
		scrollPane.setViewportView(textArea_2);
		
		JLabel lblparaListarAgendas = new JLabel("(PARA LISTAR AGENDAS DE UM M\u00C9DICO \u00C9 NECESS\u00C1RIO \r\n");
		lblparaListarAgendas.setForeground(Color.RED);
		lblparaListarAgendas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblparaListarAgendas.setBounds(243, 588, 243, 10);
		contentPane.add(lblparaListarAgendas);
		
		JLabel lblPreencherOsCampos = new JLabel("PREENCHER OS CAMPOS ESPECIALIDADE, M\u00C9DICO(A))");
		lblPreencherOsCampos.setForeground(Color.RED);
		lblPreencherOsCampos.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblPreencherOsCampos.setBounds(243, 598, 229, 14);
		contentPane.add(lblPreencherOsCampos);
		
	}

		
	public ArrayList<Medico> buscarMedicos() throws ExcecaoRepositorioVazio{
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		String especialidade = jComboBoxMedicoEspecialidade.getSelectedItem().toString();		
		medicos = this.fachada.listarMedicos( especialidade);
		return medicos;
	}
		
	

	public void carregarJComboBoxMedicoNome() throws ExcecaoRepositorioVazio{			
		ArrayList<Medico> medicos = buscarMedicos();
		for(int i = 0; i<=medicos.size()-1;i++){
			jComboBoxMedicoNome.addItem(medicos.get(i).getNome());
		}
	}	
	

	public void imprimirAgendas() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String cpfMedico = buscarCpfMedico();
		ArrayList<Agenda> agendas = this.fachada.listarAgendas(cpfMedico);
		for(int i = 0; i<=agendas.size()-1;i++){
			textArea_2.append(agendas.get(i).toString());
		}
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
	
	public void verificarCamposVazios() throws ExcecaoDadoInvalido{
		
		String nome = jComboBoxMedicoNome.getSelectedItem()+"";
		String horario = jComboBoxAgendaHorario.getSelectedItem()+"";
		if(nome.equals("null")||horario.equals("null")||data.getText().equals("")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	public void limpar(){
		data.setText("");
		textArea_2.setText("");
		jComboBoxMedicoNome.setSelectedItem(null);
		jComboBoxAgendaHorario.setSelectedItem(null);
		jComboBoxMedicoEspecialidade.setSelectedIndex(0);
		
	}
	
	public void cadastrar() throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido, ExcecaoRepositorioVazio{
		Object[] options = { "SIM", "NÃO" };
		int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(opcao==0){
			String dataA = data.getText();
			String horaA= jComboBoxAgendaHorario.getSelectedItem().toString();
			String cpfMedico = buscarCpfMedico();
			String idAgenda = cpfMedico+dataA+horaA;
			String status = "disponível";
			
			Agenda agenda = new Agenda(dataA, horaA, cpfMedico, idAgenda, status);
			this.fachada.inserir(agenda);
			JOptionPane.showMessageDialog(null, "CADASTRADA COM SUCESSO!");
			textArea_2.setText("");
		}else{
			JOptionPane.showMessageDialog(this,"NÃO CADASTRADA!");
			textArea_2.setText("");
		}
		
	}
	
	public void imprimir() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{
		String dataA = data.getText();
		String horaA= jComboBoxAgendaHorario.getSelectedItem().toString();
		String cpfMedico = buscarCpfMedico();
		String idAgenda = cpfMedico+dataA+horaA;		
		textArea_2.append(this.fachada.imprimirAgenda(idAgenda));
	}
	
	public void remover() throws ExcecaoRepositorioVazio, ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Object[] options = { "SIM", "NÃO" };
		int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(opcao==0){
			String dataA = data.getText();
			String horaA= jComboBoxAgendaHorario.getSelectedItem().toString();
			String cpfMedico = buscarCpfMedico();
			String idAgenda = cpfMedico+dataA+horaA;
			this.fachada.removerAgenda(idAgenda);
			JOptionPane.showMessageDialog(this,"REMOVIDO COM SUCESSO!");
			textArea_2.setText("");
		}else{
			JOptionPane.showMessageDialog(this,"NÃO REMOVIDO!");
			textArea_2.setText("");
		}
		
	}
	public void medicoVazio() throws ExcecaoDadoInvalido{
		String nome = jComboBoxMedicoNome.getSelectedItem()+"";
		if(nome.equals("null")){
			throw new ExcecaoDadoInvalido();
		}
	}
}

	