package model;

import enums.MetodoPagamento;
import enums.TipoDeServico;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Cliente extends Pessoa implements Usuario {

  public Cliente(int id, String nome, String email, String contato, String senha) {
    super(id, nome, email, contato, senha);
  }

  public List<Profissional> buscarServicos(TipoDeServico tipoDeServico, List<Profissional> profissionais) {
    return profissionais.stream()
            .filter(profissional -> profissional.getServicos().stream()
                    .anyMatch(servico -> servico.getTipoDeServico().equals(tipoDeServico)))
            .collect(Collectors.toList());
  }

  public boolean escolherHorario(Profissional profissional, TipoDeServico tipoDeServico, String horario) {
    for (Servicos servico : profissional.getServicos()) {
      if (servico.getTipoDeServico().equals(tipoDeServico)) {
        List<String> horariosDisponiveis = servico.getHorariosDisponiveis();
        if (horariosDisponiveis.contains(horario)) {
          servico.setHorariosDisponiveis(horariosDisponiveis);
          return true;
        }
      }
    }
    return false;
  }

  public List<Servicos> buscarServicosPorTipo(List<Profissional> profissionais, TipoDeServico tipoDeServico) {
    return profissionais.stream()
            .flatMap(profissional -> profissional.getServicos().stream())
            .filter(servico -> servico.getTipoDeServico().equals(tipoDeServico))
            .collect(Collectors.toList());
  }

  public List<Servicos> buscarServicosPorNomeProfissional(List<Profissional> profissionais, String nomeProfissional) {
    return profissionais.stream()
            .filter(profissional -> profissional.getNome().equalsIgnoreCase(nomeProfissional))
            .flatMap(profissional -> profissional.getServicos().stream())
            .collect(Collectors.toList());
  }

  public List<Servicos> buscarServicosPorValor(List<Profissional> profissionais, boolean crescente) {
    Comparator<Servicos> comparator = Comparator.comparingDouble(Servicos::getValor);
    if (!crescente) {
      comparator = comparator.reversed();
    }
    return profissionais.stream()
            .flatMap(profissional -> profissional.getServicos().stream())
            .sorted(comparator)
            .collect(Collectors.toList());
  }

  public void pagar(Pagamento pagamento) {
    System.out.println("Forma de pagamento: " + pagamento);
  }

  public boolean selecionarServicoERealizarPagamento(Profissional profissional, TipoDeServico tipoDeServico, String horario, double valor, MetodoPagamento metodoPagamento) {
    if (escolherHorario(profissional, tipoDeServico, horario)) {
      Pagamento pagamento = new Pagamento(valor, metodoPagamento);
      pagar(pagamento);
      System.out.println("Pagamento realizado: " + pagamento);
      return true;
    } else {
      System.out.println("Falha ao selecionar serviço ou horário.");
      return false;
    }
  }

  @Override
  public String toString() {
    return "Cliente{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", email='" + email + '\'' +
            ", contato='" + contato + '\'' +
            ", senha='" + senha + '\'' +
            '}';
  }
}