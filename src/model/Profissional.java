package model;

import java.util.ArrayList;
import java.util.List;

public class Profissional extends Pessoa implements Usuario {
  private List<Servicos> servicos;

  public Profissional(int id, String nome, String email, String contato, String senha) {
    super(id, nome, email, contato, senha);
    this.servicos = new ArrayList<>();
  }

  public List<Servicos> getServicos() {
    return servicos;
  }

  public void adicionarServico(Servicos servico) {
    this.servicos.add(servico);
  }

  @Override
  public String toString() {
    return "Profissional{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", email='" + email + '\'' +
            ", contato='" + contato + '\'' +
            ", senha='" + senha + '\'' +
            ", servicos=" + servicos +
            '}';
  }
}