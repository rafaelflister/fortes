package model;
 

public class Locacao {

	private Veiculo veiculo;
	private Cliente cliente;
	private String dataLocacao;
	private String dataDevolucao;
	
	public Locacao (Veiculo veiculo, Cliente cliente) {
		this.setVeiculo(veiculo);
		this.setCliente(cliente);
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public void alugar(String data) {
		this.dataLocacao = data;
		this.getVeiculo().setAlugado(true);
	}
	
	public void devolver(String data) {
		this.dataDevolucao = data;
		this.getVeiculo().setAlugado(false);
	}
	
	
}
