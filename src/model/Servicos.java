package model;

import enums.TipoDeServico;
import java.util.List;

public class Servicos {
    private TipoDeServico tipoDeServico;
    private double valor;
    private List<String> horariosDisponiveis;

    public Servicos(TipoDeServico tipoDeServico, double valor, List<String> horariosDisponiveis) {
        this.tipoDeServico = tipoDeServico;
        this.valor = valor;
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public TipoDeServico getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(TipoDeServico tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(List<String> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }

    @Override
    public String toString() {
        return "Servicos{" +
                "tipoDeServico=" + tipoDeServico +
                ", valor=" + valor +
                ", horariosDisponiveis=" + horariosDisponiveis +
                '}';
    }
}