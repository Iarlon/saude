import service.UsuarioService;
import model.Usuario;
import model.Profissional;
import model.Servicos;
import model.Cliente;
import enums.TipoDeServico;
import enums.MetodoPagamento;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    UsuarioService usuarioService = new UsuarioService();

    Cliente cliente = (Cliente) usuarioService.cadastrarCliente("Feliphe", "Feliphe@example.com", "123456789", "senha123");

    Profissional profissional = (Profissional) usuarioService.cadastrarProfissional("Cris", "cris@example.com", "987654321", "senha456");

    Servicos servico1 = new Servicos(TipoDeServico.ESTETICA, 100.0, Arrays.asList("10:00", "11:00", "14:00"));
    Servicos servico2 = new Servicos(TipoDeServico.ESPORTE, 150.0, Arrays.asList("09:00", "13:00", "15:00"));
    profissional.adicionarServico(servico1);
    profissional.adicionarServico(servico2);

    Usuario usuarioLogado = usuarioService.login("Feliphe@example.com", "senha123");
    if (usuarioLogado != null) {
      System.out.println("Login efetuado com sucesso!: " + usuarioLogado.getNome());

      if (usuarioLogado instanceof Cliente) {
        Cliente clienteLogado = (Cliente) usuarioLogado;

        boolean pagamentoRealizado = clienteLogado.selecionarServicoERealizarPagamento(profissional, TipoDeServico.ESTETICA, "10:00", 100.0, MetodoPagamento.CARTAO);
        if (pagamentoRealizado) {
          System.out.println("Serviço selecionado e pagamento concluído.");
        } else {
          System.out.println("Falha em selecionar serviço ou efetuar pagamento.");
        }
      } else {
        System.out.println("Usuário logado não é um cliente.");
      }
    } else {
      System.out.println("Falha no login.");
    }
  }
}