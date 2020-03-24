package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.UIManager;

import negocio.Administrador;
import negocio.Atendente;
import negocio.Fachada;
import negocio.Medico;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoPerfilInvalido;
import exceptions.ExcecaoPerfilNaoAutorizado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Programa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpf;
	private JTextField senha;
	private static String cpfEntrar;
	private static String senhaEntrar;
	private static String perfilEntrar;
	private JComboBox<String> perfil;
	private static Fachada fachada = Fachada.getInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {		
				try {
					Programa frame = new Programa();
					frame.setVisible(true);
					try{
						inserir();
					}catch(Exception e){
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Programa() {
		
		this.cpfEntrar = cpfEntrar;
		this.senhaEntrar = senhaEntrar;
		this.perfilEntrar = perfilEntrar;
		
		
		setTitle("SGCM - HCENTER");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Programa.class.getResource("/imagens/HC.png")));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 730);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cpf = new JTextField();
		cpf.setBackground(new Color(255, 255, 255));
		cpf.setForeground(new Color(0, 0, 0));
		cpf.setColumns(10);
		
		JList<String> comboBox = new JList<String>();
		
		JLabel lblCpf = new JLabel("CPF: ");
		
		JLabel lblSenha = new JLabel("SENHA: ");
		
		senha = new JTextField();
		senha.setBackground(new Color(255, 255, 255));
		senha.setForeground(Color.BLACK);
		senha.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					entrar();					
				}catch(ExcecaoPerfilNaoAutorizado e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ExcecaoPerfilInvalido e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ExcecaoElementoInexistente e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ExcecaoDadoInvalido e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			
				
			}
		});
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.setForeground(new Color(0, 0, 0));
		
		JButton btnEsqueciASenha = new JButton("ESQUECI A SENHA");
		btnEsqueciASenha.setBackground(UIManager.getColor("Button.background"));
		
		perfil = new JComboBox<String>();
		perfil.setBackground(UIManager.getColor("Button.background"));
		perfil.setModel(new DefaultComboBoxModel<String>(new String[] {"< INFORME SEU PERFIL >", "ATENDENTE", "M\u00C9DICO", "ADMINISTRADOR"}));
		
		JLabel lblHcenter = new JLabel("HCENTER");
		lblHcenter.setBackground(SystemColor.textHighlightText);
		lblHcenter.setForeground(SystemColor.textHighlightText);
		lblHcenter.setFont(new Font("Tahoma", Font.PLAIN, 60));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(387)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addComponent(senha, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(375, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(lblHcenter, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGap(244))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(338)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEsqueciASenha)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(perfil, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(491, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(lblHcenter, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(perfil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(comboBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEsqueciASenha)
						.addComponent(btnEntrar))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
	public  static String getCpfEntrar() {
		return cpfEntrar;
	}

	public static void setCpfEntrar(String cpfEntrar) {
		Programa.cpfEntrar = cpfEntrar;
	}

	public static String getSenhaEntrar() {
		return senhaEntrar;
	}

	public void setSenhaEntrar(String senhaEntrar) {
		Programa.senhaEntrar = senhaEntrar;
	}

	public static String getPerfilEntrar() {
		return perfilEntrar;
	}

	public void setPerfilEntrar(String perfilEntrar) {
		Programa.perfilEntrar = perfilEntrar;
	}
	
	
	public void verificarCamposVazios() throws ExcecaoDadoInvalido {
		if(cpf.getText().equals("")||senha.equals("")){
			throw new ExcecaoDadoInvalido();
		}
	}


	public  boolean entrar() throws ExcecaoPerfilInvalido, ExcecaoElementoInexistente, ExcecaoDadoInvalido, ExcecaoPerfilNaoAutorizado{
		boolean resposta = false;
		try{
			verificarCamposVazios();
			cpfEntrar= cpf.getText();
			senhaEntrar=senha.getText();
			perfilEntrar= perfil.getSelectedItem()+"";

			if(perfilEntrar.equals("< INFORME SEU PERFIL >")){
				throw new ExcecaoPerfilInvalido();
			}else{
				if(perfilEntrar.equals("ADMINISTRADOR")){
					Administrador administrador = this.fachada.buscarAdministrador(cpfEntrar);
					if(administrador.getSenha().equals(senhaEntrar)){
						Menu menu = new Menu();
						menu.setVisible(true);
					}else{
						 throw new ExcecaoPerfilNaoAutorizado();
					}
				}else if(perfilEntrar.equals("ATENDENTE")){
					Atendente atendente = this.fachada.buscarAtendente(cpfEntrar);
					if(atendente.getSenha().equals(senhaEntrar)){
						Menu menu = new Menu();
						menu.setVisible(true);
					}else{
						 throw new ExcecaoPerfilNaoAutorizado();
					}
				}else if(perfilEntrar.equals("MÉDICO")){
					Medico medico = this.fachada.buscarMedico(cpfEntrar);
					if(medico.getSenha().equals(senhaEntrar)){
						Menu menu = new Menu();
						menu.setVisible(true);
					}else{
						 throw new ExcecaoPerfilNaoAutorizado();
					}
				}
			}
		}catch(ExcecaoDadoInvalido e){
			JOptionPane.showMessageDialog(null, e.getMessage());	
			
		}		
		
		resposta=true;
		return resposta;
	}
		
		
	public void analisarResposta() throws ExcecaoPerfilInvalido, ExcecaoElementoInexistente, ExcecaoDadoInvalido, ExcecaoPerfilNaoAutorizado{
		boolean resposta = entrar();
		JOptionPane.showMessageDialog(null,resposta);
		if (resposta==true){
			Menu menu = new Menu();
			menu.setVisible(true);
		}		
	}
	
	public static void inserir() throws ExcecaoElementoJaExistente, ExcecaoDadoInvalido{
		Administrador a1 = new Administrador("Fernanda","079","081","ad11");
		Atendente a2 = new Atendente("Heleno","058","081","a112");
		Medico medico3 = new Medico("Ana","427","081","e113","Psicologia");
		fachada.inserir(a1);
		fachada.inserir(a2);
		fachada.inserir(medico3);
	}
}


