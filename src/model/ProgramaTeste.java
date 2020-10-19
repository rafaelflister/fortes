package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Locacao;
import model.Locadora;
import model.Veiculo;


public class ProgramaTeste {

	public static void main(String[] args) {
		Locadora locadora = new Locadora();
		
		// Criar veiculos
		Veiculo v1 = new Veiculo("Gol", "Azul", "ABC1234", 100.0);
		Veiculo v2 = new Veiculo("Onix", "Vermelho", "HMI4444", 110.0);
		
		// Adicionar veiculos
		locadora.adicionarVeiculo(v1);
		locadora.adicionarVeiculo(v2);
		
		
		// Criar clientes
		Cliente c1 =  new Cliente("João", "008860566-32");
		Cliente c2 =  new Cliente("Maria", "008870566-77");
		
		
		// Adicionar Clientes
		locadora.adicionarCliente(c1);
		locadora.adicionarCliente(c2);
		
		// Listar Veiculos Disponiveis para locação
		System.out.println("Lista de Veiculos disponiveis:");
		List<Veiculo> lista = locadora.getListaVeiculosDisponiveis();
		for(int i = 0 ; i < lista.size(); i++){
			System.out.println(lista.get(i).getModelo() + " " + 
		                       lista.get(i).getCor() + " " + 
					           lista.get(i).getPlaca());
		}
		
		// Criar locacao
		Locacao locacao1 = new Locacao(v1, c1);
		locacao1.alugar("16/10/2020");
		locadora.adicionarLocacao(locacao1);
		
		// Listar veiculos alugados;
		System.out.println("\n");
		System.out.println("Lista de Veiculos alugados:");
		List<Locacao> listaloc = locadora.getListaLocacao();
		for(int i = 0 ; i < listaloc.size(); i++){
			Locacao loc = listaloc.get(i);
			Veiculo v = loc.getVeiculo();
			Cliente c = loc.getCliente();
			
			if (v.alugado) {
				System.out.println(v.getModelo() + " " + v.getCor() + " " + v.getPlaca());
				System.out.println(c.getNome() + " " + c.getCpf());
			}
		}
		
		// Devolver Veiculo
		locacao1.devolver("17/10/2020");
		
		// Listar Veiculos Disponiveis para locação
		System.out.println("\n");
		System.out.println("Lista de Veiculos disponiveis:");
		List<Veiculo> lista2 = locadora.getListaVeiculosDisponiveis();
		for (int i = 0; i < lista2.size(); i++) {
			System.out.println(lista2.get(i).getModelo() + " " + 
			                   lista2.get(i).getCor() + " " + 
					           lista2.get(i).getPlaca());
		}
	}

}