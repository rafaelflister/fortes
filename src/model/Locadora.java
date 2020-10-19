package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Locadora {
  private List<Veiculo> ListaVeiculos;
  private List<Cliente> ListaClientes; 
  private List<Locacao> ListaLocacao;
  private PrintWriter arquivoVeiculos;
  
  public Locadora() {
	  this.ListaVeiculos = new ArrayList<Veiculo>();
	  this.ListaClientes = new ArrayList<Cliente>();
	  this.ListaLocacao = new ArrayList<Locacao>();
  }
  
	public void adicionarVeiculo(Veiculo v) {
		ListaVeiculos.add(v);

		try (FileWriter fw = new FileWriter("veiculos.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(v.getModelo() + " " + v.getCor() + " " + v.getPlaca() + " " + v.getPreco());
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}

	}
  
  public void adicionarCliente(Cliente c) {
	  ListaClientes.add(c);
	  
		try (FileWriter fw = new FileWriter("clientes.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(c.getNome() + " " + c.getCpf());
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
  }
  
  public void adicionarLocacao(Locacao l) {
	  ListaLocacao.add(l);
	  try (FileWriter fw = new FileWriter("locacoes.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
		    Veiculo v = l.getVeiculo();
		    Cliente c = l.getCliente();
			out.println(v.getModelo() + " " + v.getCor() + " " + v.getPlaca() + " " + v.getPreco());
			out.println(c.getNome() + " " + c.getCpf());
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
  }
  
  public List<Veiculo> getListaVeiculos() {
	  return ListaVeiculos;
  }
  
  public List<Veiculo> getListaVeiculosDisponiveis() {
	  List<Veiculo> ListaVeiculosDisponiveis = new ArrayList<Veiculo>();
	  
	  for(int i = 0 ; i < this.ListaVeiculos.size(); i++){
		  Veiculo v = ListaVeiculos.get(i);
		  if (v.getAlugado() == false)
		  {
		    ListaVeiculosDisponiveis.add(v);
		  }
	  }
	  return ListaVeiculosDisponiveis;
  }
  
  public List<Cliente> getListaClientes() {
	  return ListaClientes;
  }

public List<Locacao> getListaLocacao() {
	return ListaLocacao;
}

}
