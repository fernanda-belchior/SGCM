package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.Medico;
import negocio.Fachada;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class TelaMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpf01;
	private JTextField telefone;
	private JTextField nome;
	private JTextField cpf02;
	JTextArea textArea_2 = new JTextArea();
	Fachada fachada = Fachada.getInstance();
	private JTextField senhaAntiga;
	private JTextField novaSenha;
	private JTextField senha;
	private JComboBox<String> comboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedico frame = new TelaMedico();
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
	public TelaMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMedico.class.getResource("/imagens/HC.png")));
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
		
		JLabel lblMenuCadastro = new JLabel(" MENU - CADASTRO - M\u00C9DICO");
		lblMenuCadastro.setBounds(10, 0, 360, 14);
		contentPane.add(lblMenuCadastro);
		
		JLabel label_1 = new JLabel("CPF:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 122, 46, 14);
		contentPane.add(label_1);
		
		cpf01 = new JTextField();
		cpf01.setColumns(10);
		cpf01.setBounds(97, 119, 139, 20);
		contentPane.add(cpf01);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"<ESPECIALIDADE>", "Psicologia", "Psiquiatria"}));
		comboBox.setBounds(269, 229, 170, 20);
		contentPane.add(comboBox);
		
		JButton button = new JButton("LIMPAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTextArea();
				limparCampos();
			}
		});
		button.setBounds(440, 118, 108, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("DADOS PESSOAIS");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 173, 157, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("NOME:");
		label_3.setBounds(10, 201, 78, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("TELEFONE:");
		label_4.setBounds(10, 261, 78, 14);
		contentPane.add(label_4);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(97, 258, 139, 20);
		contentPane.add(telefone);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(97, 198, 436, 20);
		contentPane.add(nome);
		
		
		JLabel label_11 = new JLabel("CPF:");
		label_11.setBounds(10, 236, 46, 14);
		contentPane.add(label_11);
		
		cpf02 = new JTextField();
		cpf02.setColumns(10);
		cpf02.setBounds(97, 229, 139, 20);
		contentPane.add(cpf02);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					cpfIsEmpty();
					try {
						limparTextArea();
						buscar();
						try{
							imprimir();
						}catch (ExcecaoElementoInexistente | ExcecaoDadoInvalido e){
							JOptionPane.showMessageDialog(null,e.getMessage());

						} catch (ExcecaoRepositorioVazio e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
					} catch (ExcecaoElementoInexistente | ExcecaoDadoInvalido e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
				}
				
				catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}			
			
				
			}
		});
		
		btnBuscar.setBounds(284, 118, 114, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(589, 201, 409, 286);
		contentPane.add(scrollPane);
		
		
		textArea_2.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea_2);
		textArea_2.setBounds(589, 201, 409, 286);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				try{
					senhaIsEmpty();	
					try{
						fieldIsEmpty();					
						try{					
							cadastrar();
						} catch (ExcecaoDadoInvalido | ExcecaoElementoJaExistente
								| ExcecaoElementoInexistente | ExcecaoRepositorioVazio e) {
							JOptionPane.showMessageDialog(null,e.getMessage());

						}					
					}catch(ExcecaoDadoInvalido e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				

			}
		});
		btnCadastrar.setBounds(10, 347, 145, 23);
		contentPane.add(btnCadastrar);
		
		
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					fieldIsEmpty();					
					try{					
						alterar();						
					} catch (ExcecaoDadoInvalido | ExcecaoElementoInexistente e) {
						JOptionPane.showMessageDialog(null,e.getMessage());

					} catch (ExcecaoRepositorioVazio e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}					
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		btnAlterar.setBounds(200, 347, 145, 23);
		contentPane.add(btnAlterar);
		
		
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					fieldIsEmpty();					
					try{					
						remover();
						limparCampos();
						limparTextArea();
						
					} catch (ExcecaoDadoInvalido | ExcecaoElementoInexistente e) {
						JOptionPane.showMessageDialog(null,e.getMessage());

					}					
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		btnRemover.setBounds(388, 347, 145, 23);
		contentPane.add(btnRemover);
		
		JButton listar = new JButton("LISTAR TODOS");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					listar();
				}catch(ExcecaoRepositorioVazio e){
					JOptionPane.showMessageDialog(null,e.getMessage());				
				}
			}
		});
		listar.setBounds(730, 557, 178, 23);
		contentPane.add(listar);
		
		JLabel lblTrocarSenha = new JLabel("TROCAR SENHA");
		lblTrocarSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrocarSenha.setBounds(10, 419, 157, 14);
		contentPane.add(lblTrocarSenha);
		
		JLabel lblSenhaAntiga = new JLabel("SENHA ANTIGA:");
		lblSenhaAntiga.setBounds(10, 471, 108, 14);
		contentPane.add(lblSenhaAntiga);
		
		JLabel lblNovaSenha = new JLabel("NOVA SENHA:");
		lblNovaSenha.setBounds(10, 517, 108, 14);
		contentPane.add(lblNovaSenha);
		
		JButton btnConfirma = new JButton("CONFIRMAR");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					fieldIsEmpty();
					try{
						trocarSenhaIsEmpty();
						try{					
							trocarSenha();
							limparCampos();
							limparTextArea();						
						} catch (ExcecaoDadoInvalido | ExcecaoElementoInexistente e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
					}catch(ExcecaoDadoInvalido e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
										
				}catch(ExcecaoDadoInvalido e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
								
			
		});
		btnConfirma.setBounds(58, 557, 178, 23);
		contentPane.add(btnConfirma);
		
		senhaAntiga = new JTextField();
		senhaAntiga.setColumns(10);
		senhaAntiga.setBounds(97, 468, 139, 20);
		contentPane.add(senhaAntiga);
		
		novaSenha = new JTextField();
		novaSenha.setColumns(10);
		novaSenha.setBounds(97, 514, 139, 20);
		contentPane.add(novaSenha);

		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(97, 289, 139, 20);
		contentPane.add(senha);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(10, 292, 46, 14);
		contentPane.add(lblSenha);
		
			
			
	}
	
	
	
	

	public void cadastrar()throws ExcecaoDadoInvalido, ExcecaoElementoJaExistente, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {
		try{
			comboBoxNaoSelecionado();		
			String nomeA = nome.getText();
			String cpfA = cpf02.getText();				
			String telefoneA = telefone.getText();
			String senhaA=senha.getText();
			String especialidadeA=comboBox.getSelectedItem()+"";

			Medico medico = new Medico(nomeA,cpfA,telefoneA,senhaA,especialidadeA);
			this.fachada.inserir(medico);
			JOptionPane.showMessageDialog(this,"CADASTRADO COM SUCESSO!");
			limparCampos();

			try{
				textArea_2.append(this.fachada.imprimirMedico(cpfA));
			} catch (ExcecaoDadoInvalido | ExcecaoElementoInexistente e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}	
			
		}catch(ExcecaoDadoInvalido e){
		JOptionPane.showMessageDialog(null, e.getMessage());			
		}
	}
		
	
	public void alterar()throws ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {	
		try{
			comboBoxNaoSelecionado();
			Medico atd= this.fachada.buscarMedico(cpf01.getText());
			String nomeP = nome.getText();
			String cpfP = cpf01.getText();				
			String telefoneP = telefone.getText();
			String especialidadeA=comboBox.getSelectedItem()+"";
			String senha = atd.getSenha();
			Medico medico = new Medico(nomeP,cpfP,telefoneP,senha,especialidadeA);
			
			Object[] options = { "SIM", "NÃO" };
			int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(opcao==0){
				this.fachada.alterar(medico);
				JOptionPane.showMessageDialog(this,"ALTERADO COM SUCESSO!");
				limparTextArea();
				imprimir();
				limparCampos();
			}else{
				JOptionPane.showMessageDialog(this,"NÃO ALTERADO!");
				limparTextArea();
				limparCampos();
			}	
		}catch(ExcecaoDadoInvalido e){
			JOptionPane.showMessageDialog(null, e.getMessage());			
		}
		
					

	}
	

	
	public void buscar() throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
			
		Medico medico03 = fachada.buscarMedico(cpf01.getText());
		nome.setText(medico03.getNome());
		cpf02.setText(medico03.getCpf());				
		telefone.setText(medico03.getTelefone());
		
	}


	public void remover() throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Object[] options = { "SIM", "NÃO" };
		int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(opcao==0){
			this.fachada.removerMedico(cpf01.getText());
			JOptionPane.showMessageDialog(this,"REMOVIDO COM SUCESSO!");
			limparTextArea();
			limparCampos();
		}else{
			JOptionPane.showMessageDialog(this,"NÃO REMOVIDO!");
			limparTextArea();
			limparCampos();
		}		
	}	


	public void imprimir() throws ExcecaoRepositorioVazio, ExcecaoDadoInvalido, ExcecaoElementoInexistente{	
		textArea_2.append(this.fachada.imprimirMedico(cpf01.getText()));
	}	
	
	
	public void listar() throws ExcecaoRepositorioVazio{
		ArrayList<String> listaMedicos = this.fachada.listarMedicos();
		limparTextArea();
		for(int i=0;i<listaMedicos.size();i++){
			textArea_2.append(listaMedicos.get(i));
		}
		
	}
	
	public void trocarSenha() throws ExcecaoDadoInvalido,ExcecaoElementoInexistente{
		
		Medico medico = this.fachada.buscarMedico(cpf01.getText());
		if(senhaAntiga.getText().equals(medico.getSenha())){
			medico.setSenha(novaSenha.getText());
			Object[] options = { "SIM", "NÃO" };
			int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(opcao==0){
				try{
					this.fachada.alterar(medico);
					JOptionPane.showMessageDialog(null,"SENHA ALTERADA COM SUCESSO!");
					limparCampos();
					limparTextArea();
				} catch (ExcecaoDadoInvalido | ExcecaoElementoInexistente e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}else{
				JOptionPane.showMessageDialog(this,"SENHA NÃO ALTERADA!");
				limparTextArea();
				limparCampos();
			}
		}else{
			JOptionPane.showMessageDialog(this,"SENHA DIGITADA NÃO CONFERE COM A CADASTRADA.");
			limparTextArea();
			limparCampos();
		}
			
	}	


	public void fieldIsEmpty() throws ExcecaoDadoInvalido{
		if(cpf02.getText().equals("")||nome.getText().equals("")||telefone.getText().equals("")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	
	public void cpfIsEmpty()throws ExcecaoDadoInvalido{
		if(cpf01.getText().equals("")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	public void senhaIsEmpty()throws ExcecaoDadoInvalido{
		if(senha.getText().equals("")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	public void trocarSenhaIsEmpty()throws ExcecaoDadoInvalido{
		if(senhaAntiga.getText().equals("")||novaSenha.getText().equals("")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	public void limparCampos(){
		for (int i=0; i < getContentPane().getComponentCount(); i++) {
			Component c = getContentPane().getComponent(i);

			if (c instanceof JTextField) {
				JTextField field = (JTextField) c;
				field.setText("");
			}
		}
	}
	
	
	public void limparTextArea(){
		textArea_2.setText("");
		
	}
	
	public void comboBoxNaoSelecionado() throws ExcecaoDadoInvalido{
		String valor = comboBox.getSelectedItem()+"";
		if(valor.equals("<ESPECIALIDADE>")){
			throw new ExcecaoDadoInvalido();
		}
	}
	
	
}
