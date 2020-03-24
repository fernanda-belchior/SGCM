package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import exceptions.ExcecaoPerfilNaoAutorizado;

import java.awt.Toolkit;



public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("SGCM - HCENTER");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagens/HC.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 730);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new LineBorder(SystemColor.window, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.WHITE);
		layeredPane.setBackground(SystemColor.window);
		layeredPane.setBounds(0, 121, 212, 524);
		contentPane.add(layeredPane);
		
		JLabel lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastro.setBounds(30, 25, 94, 14);
		layeredPane.add(lblCadastro);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setBackground(SystemColor.activeCaption);
		lblMenu.setForeground(SystemColor.menuText);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMenu.setBounds(10, 0, 63, 14);
		layeredPane.add(lblMenu);
		
		JLabel lblConsulta = new JLabel("CONSULTA");
		lblConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsulta.setBounds(30, 233, 94, 14);
		layeredPane.add(lblConsulta);
		
		JButton btnAgenda = new JButton("AGENDA");
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAgenda frame = new TelaAgenda();
				frame.setVisible(true);
			}
		});
		btnAgenda.setBounds(59, 48, 153, 23);
		layeredPane.add(btnAgenda);
		
		JButton btnPaciente = new JButton("PACIENTE");
		btnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPaciente telaPaciente = new TelaPaciente();
				telaPaciente.setVisible(true);
			}
			
		});
		btnPaciente.setBounds(59, 79, 153, 23);
		layeredPane.add(btnPaciente);
		
		JButton btnMdico = new JButton("M\u00C9DICO");
		btnMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					entrarMedico();
				}catch(ExcecaoPerfilNaoAutorizado e){
					JOptionPane.showMessageDialog(null, e.getMessage());					
				}
			}
		});
		btnMdico.setBounds(59, 113, 153, 23);
		layeredPane.add(btnMdico);
		
		JButton btnAtendente = new JButton("ATENDENTE");
		btnAtendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					entrarAtendente();
				}catch(ExcecaoPerfilNaoAutorizado e){
					JOptionPane.showMessageDialog(null, e.getMessage());					
				}
			}
		});
		btnAtendente.setBounds(59, 146, 153, 23);
		layeredPane.add(btnAtendente);
		
		JButton btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					entrarAdministrador();
				}catch(ExcecaoPerfilNaoAutorizado e){
					JOptionPane.showMessageDialog(null, e.getMessage());					
				}
				
			}
		});
		btnAdministrador.setBounds(58, 180, 154, 23);
		layeredPane.add(btnAdministrador);
		
		JButton btnAgendamento = new JButton("AGENDAMENTO");
		btnAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAgendamento frame = new TelaAgendamento();
				frame.setVisible(true);
			}
		});
		btnAgendamento.setBounds(59, 269, 153, 23);
		layeredPane.add(btnAgendamento);
		
		JButton btnCancelamento = new JButton("CANCELAMENTO");
		btnCancelamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCancelamento frame = new TelaCancelamento();
				frame.setVisible(true);
			}
		});
		btnCancelamento.setBounds(59, 303, 153, 23);
		layeredPane.add(btnCancelamento);
		
		JButton btnNewButton = new JButton("BUSCA/CONFIRMA\u00C7\u00C3O");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscaConfirmacao frame = new TelaBuscaConfirmacao();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(44, 337, 168, 23);
		layeredPane.add(btnNewButton);
		
		final JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.window, 5));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(213, 121, 759, 524);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHcenter = new JLabel("HCENTER");
		lblHcenter.setBounds(253, 220, 309, 54);
		panel.add(lblHcenter);
		lblHcenter.setForeground(Color.WHITE);
		lblHcenter.setBackground(Color.WHITE);
		lblHcenter.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
		
		JLabel lblSuperteFernandaFarias = new JLabel("Suporte: Fernanda Farias - (81) 98239-6405");
		lblSuperteFernandaFarias.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSuperteFernandaFarias.setForeground(Color.WHITE);
		lblSuperteFernandaFarias.setBounds(691, 656, 281, 14);
		contentPane.add(lblSuperteFernandaFarias);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(SystemColor.window, 5));
		layeredPane_1.setBounds(0, 0, 782, 83);
		contentPane.add(layeredPane_1);
		
		JLabel lblNewLabel = new JLabel("PAGINA PRINCIPAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 11, 144, 14);
		layeredPane_1.add(lblNewLabel);
	}
	
	public void entrarAdministrador() throws ExcecaoPerfilNaoAutorizado{		
		if(Programa.getPerfilEntrar().equals("ADMINISTRADOR")){
			TelaAdministrador telaAdministrador = new TelaAdministrador();
			telaAdministrador.setVisible(true);
			
		}else{
			throw new ExcecaoPerfilNaoAutorizado();
		}
	}
	
	public void entrarAtendente() throws ExcecaoPerfilNaoAutorizado{
		if(Programa.getPerfilEntrar().equals("ADMINISTRADOR")){
			TelaAtendente telaAtendente =  new TelaAtendente();
			telaAtendente.setVisible(true);
			
		}else{
			throw new ExcecaoPerfilNaoAutorizado();
		}
	}
		
	public void entrarMedico() throws ExcecaoPerfilNaoAutorizado{
		if(Programa.getPerfilEntrar().equals("ADMINISTRADOR")){
			TelaMedico telaMedico =  new TelaMedico();
			telaMedico.setVisible(true);
			
		}else{
			throw new ExcecaoPerfilNaoAutorizado();
		}
	}
	
}