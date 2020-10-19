package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import model.Cliente;
import model.Locacao;
import model.Locadora;
import model.Veiculo;
import view.Tela2;

public class Tela1 {

	private JFrame frame;
	private JTextField textCor;
	private JTextField textPlaca;
	private JTextField textPreco;
	private Locadora locadora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 window = new Tela1();
					//Tela2 frame = new Tela2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Locadora locadora = new Locadora();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserir veiculos:");
		lblNewLabel.setBounds(30, 22, 93, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane textModelo = new JTextPane();
		textModelo.setBounds(100, 46, 69, 19);
		frame.getContentPane().add(textModelo);
		
		JLabel lblNewLabel_1 = new JLabel("modelo");
		lblNewLabel_1.setBounds(40, 49, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cor");
		lblNewLabel_2.setBounds(40, 84, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textCor = new JTextField();
		textCor.setBounds(100, 81, 69, 19);
		frame.getContentPane().add(textCor);
		textCor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Placa");
		lblNewLabel_3.setBounds(40, 119, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(100, 116, 69, 19);
		frame.getContentPane().add(textPlaca);
		textPlaca.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Preço");
		lblNewLabel_4.setBounds(40, 153, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		textPreco = new JTextField();
		textPreco.setBounds(100, 150, 69, 19);
		frame.getContentPane().add(textPreco);
		textPreco.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Modelo Cadastrado ");

				// Criar veiculos
				Veiculo v1 = new Veiculo(textModelo.getText(), textCor.getText(), textPlaca.getText(),
						Double.parseDouble(textPreco.getText()));

				// Adicionar veiculos
				locadora.adicionarVeiculo(v1);

				// Listar Veiculos Disponiveis para locação
				System.out.println("Lista de Veiculos disponiveis:");
				List<Veiculo> lista = locadora.getListaVeiculosDisponiveis();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(
							lista.get(i).getModelo() + " " + lista.get(i).getCor() + " " + lista.get(i).getPlaca());
				}
			}
		});
		btnCadastrar.setBounds(38, 197, 93, 21);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Visualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tela2 frame = new Tela2();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBounds(188, 197, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
