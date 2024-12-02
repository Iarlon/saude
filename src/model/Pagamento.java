// src/model/Pagamento.java
package model;

import enums.MetodoPagamento;

public class Pagamento {
  private double valor;
  private MetodoPagamento metodoPagamento;
  
  public Pagamento(double valor, MetodoPagamento metodoPagamento) {
    this.valor = valor;
    this.metodoPagamento = metodoPagamento;
  }
  
  public double getValor() {
    return valor;
  }
  
  public void setValor(double valor) {
    this.valor = valor;
  }
  
  public MetodoPagamento getMetodoPagamento() {
    return metodoPagamento;
  }
  
  public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
    this.metodoPagamento = metodoPagamento;
  }
  
  @Override
  public String toString() {
    return "Pagamento{" +
        "valor=" + valor +
        ", metodoPagamento=" + metodoPagamento +
        '}';
  }
}