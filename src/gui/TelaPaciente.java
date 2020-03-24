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
import negocio.Endereco;
import negocio.Fachada;
import negocio.Paciente;
import exceptions.ExcecaoDadoInvalido;
import exceptions.ExcecaoElementoInexistente;
import exceptions.ExcecaoElementoJaExistente;
import exceptions.ExcecaoRepositorioVazio;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpf01;
	private JTextField telefone;
	private JTextField nome;
	private JTextField rua;
	private JTextField numero;
	private JTextField cep;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField cpf02;
	JTextArea textArea_2 = new JTextArea();
	Fachada fachada = Fachada.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
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
	public TelaPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPaciente.class.getResource("/imagens/HC.png")));
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
		
		JLabel lblMenuCadastro = new JLabel(" MENU - CADASTRO - PACIENTE");
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
		
		JLabel label_5 = new JLabel("ENDERE\u00C7O");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(10, 306, 168, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("RUA:");
		label_6.setBounds(10, 331, 46, 14);
		contentPane.add(label_6);
		
		rua = new JTextField();
		rua.setColumns(10);
		rua.setBounds(97, 328, 436, 20);
		contentPane.add(rua);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(97, 361, 139, 20);
		contentPane.add(numero);
		
		JLabel label_7 = new JLabel("BAIRRO: ");
		label_7.setBounds(10, 392, 67, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("CEP: ");
		label_8.setBounds(10, 473, 46, 14);
		contentPane.add(label_8);
		
		cep = new JTextField();
		cep.setColumns(10);
		cep.setBounds(97, 470, 139, 20);
		contentPane.add(cep);
		
		bairro = new JTextField();
		bairro.setColumns(10);
		bairro.setBounds(97, 389, 436, 20);
		contentPane.add(bairro);
		
		JLabel label_9 = new JLabel("N\u00DAMERO:");
		label_9.setBounds(10, 364, 88, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("CIDADE:");
		label_10.setBounds(10, 427, 46, 14);
		contentPane.add(label_10);
		
		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(97, 427, 436, 20);
		contentPane.add(cidade);
		
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
				
				

			}
		});
		btnCadastrar.setBounds(10, 557, 145, 23);
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
		btnAlterar.setBounds(194, 557, 145, 23);
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
		btnRemover.setBounds(388, 557, 145, 23);
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
	}	
	
	
	

	public void cadastrar()throws ExcecaoDadoInvalido, ExcecaoElementoJaExistente, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {
				
		String nomeP = nome.getText();
		String cpfP = cpf02.getText();				
		String telefoneP = telefone.getText();
		String ruaP = rua.getText();
		String numeroP = numero.getText();
		String bairroP = bairro.getText();
		String cidadeP = cidade.getText();
		String cepP = cidade.getText();



		Endereco endereco = new Endereco(ruaP,numeroP,bairroP,cidadeP,cepP);
		Paciente paciente = new Paciente(nomeP,cpfP,telefoneP,endereco);
		this.fachada.inserir(paciente);
		JOptionPane.showMessageDialog(this,"CADASTRADO COM SUCESSO!");
		limparCampos();
		try{
			textArea_2.append(this.fachada.imprimirPaciente(cpfP));
		}catch (ExcecaoElementoInexistente | ExcecaoDadoInvalido e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		

	}
		
	
	public void alterar()throws ExcecaoDadoInvalido, ExcecaoElementoInexistente, ExcecaoRepositorioVazio {		

		String nomeP = nome.getText();
		String cpfP = cpf01.getText();				
		String telefoneP = telefone.getText();
		String ruaP = rua.getText();
		String numeroP = numero.getText();
		String bairroP = bairro.getText();
		String cidadeP = cidade.getText();
		String cepP = cep.getText();


		Endereco endereco = new Endereco(ruaP,numeroP,bairroP,cidadeP,cepP);
		Paciente paciente = new Paciente(nomeP,cpfP,telefoneP,endereco);
		Object[] options = { "SIM", "NÃO" };
		int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(opcao==0){
			this.fachada.alterar(paciente);
			JOptionPane.showMessageDialog(this,"ALTERADO COM SUCESSO!");
			limparTextArea();
			imprimir();
			limparCampos();
		}else{
			JOptionPane.showMessageDialog(this,"NÃO ALTERADO!");
			limparTextArea();
			limparCampos();
		}
		
					

	}
	

	
	public void buscar() throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
			
		Paciente paciente03 = fachada.buscarPaciente(cpf01.getText());	
		

		nome.setText(paciente03.getNome());
		cpf02.setText(paciente03.getCpf());				
		telefone.setText(paciente03.getTelefone());
		rua.setText(paciente03.getEndereco().getRua());
		numero.setText(paciente03.getEndereco().getNum());
		bairro.setText(paciente03.getEndereco().getBairro());			
		cidade.setText(paciente03.getEndereco().getCidade());
		cep.setText(paciente03.getEndereco().getCep());	

	}


	public void remover() throws ExcecaoElementoInexistente, ExcecaoDadoInvalido{
		Object[] options = { "SIM", "NÃO" };
		int opcao= JOptionPane.showOptionDialog(null, "CONFIRMA A OPERAÇÃO?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(opcao==0){
			this.fachada.removerPaciente(cpf01.getText());
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
		textArea_2.append(this.fachada.imprimirPaciente(cpf01.getText()));
	}
	
	
	
	public void listar() throws ExcecaoRepositorioVazio{
		ArrayList<String> listaPacientes = this.fachada.listarPacientes();
		limparTextArea();
		for(int i=0;i<listaPacientes.size();i++){
			textArea_2.append(listaPacientes.get(i));
		}
		
	}
	


	public void fieldIsEmpty() throws ExcecaoDadoInvalido{
		if(cpf02.getText().equals("")||nome.getText().equals("")||telefone.getText().equals("")||rua.getText().equals("")
				||numero.getText().equals("")||bairro.getText().equals("")||cidade.getText().equals("")||cep.getText().equals("")){
			throw new ExcecaoDadoInvalido();		

		}
	}
	
	
	public void cpfIsEmpty()throws ExcecaoDadoInvalido{
		if(cpf01.getText().equals("")){
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
}
