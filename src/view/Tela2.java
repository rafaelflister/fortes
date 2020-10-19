package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.Scanner; 

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.awt.event.ActionEvent;

import model.Cliente;
import model.Locacao;
import model.Locadora;
import model.Veiculo;
import view.Tela2;

public class Tela2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Tela2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de modelos disponiveis:");
		lblNewLabel.setBounds(27, 28, 174, 13);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(37, 53, 358, 174);
		contentPane.add(textArea);
		
		String saida = "";
		
		try {
		      File myObj = new File("veiculos.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        saida = saida + data + "\n";
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		textArea.setText(saida);
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela2.this.dispose();
			}
		});
		btnNewButton.setBounds(144, 237, 85, 21);
		contentPane.add(btnNewButton);
	}
}
