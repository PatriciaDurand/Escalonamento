package escalonamento;

/**
 *
 * @author Patricia Durand e Tamires Domingues
 */
public class Processo {

    private int numeroDoProcesso;
    private int tempoDeChegada;
    private int tempoDeExecucao;
    private int tempoExecutado;
    private int prioridade;

    public Processo(int numeroDoProcesso, int tempoDeChegada, int tempoDeExecucao, int prioridade) {
        this.numeroDoProcesso = numeroDoProcesso;
        this.tempoDeChegada = tempoDeChegada;
        this.tempoDeExecucao = tempoDeExecucao;
        this.prioridade = prioridade;
        this.tempoExecutado = 0;
    }

    public int getTempoExecutado() {
        return tempoExecutado;
    }

    public void setTempoExecutado(int tempoExecutado) {
        this.tempoExecutado = tempoExecutado;
    }

    public int getTempoDeChegada() {
        return tempoDeChegada;
    }

    public int getTempoDeExecucao() {
        return tempoDeExecucao;
    }

    public void setTempoDeExecucao(int novoTempoDeExecucao) {
        this.tempoDeExecucao = novoTempoDeExecucao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getNumeroDoProcesso() {
        return numeroDoProcesso;
    }
    
}
