package model;

public class Veiculo {
  private String modelo;
  private String cor;
  private String placa;
  private double preco;
  boolean alugado;

  public Veiculo(String modelo,String cor, String placa, double preco)
  {
	  this.setModelo(modelo);
	  this.setCor(cor);
	  this.setPlaca(placa);
	  this.setPreco(preco);
	  this.setAlugado(false);
  }

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getCor() {
	return cor;
}

public void setCor(String cor) {
	this.cor = cor;
}

public String getPlaca() {
	return placa;
}

public void setPlaca(String placa) {
	this.placa = placa;
}
  
public void setAlugado(boolean b) {
	this.alugado = b;
}

public boolean getAlugado() {
	return this.alugado;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}
}
