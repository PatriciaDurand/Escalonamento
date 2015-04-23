package escalonamento;

/**
 *
 * @author Patricia Durand e Tamires Domingues
 */
public class Processo {

    private int numeroDoProcesso;
    private int tempoDeChegada;
    private int tempoDeExecucao;
    private int tempoQueFaltaExecutar;
    private int prioridade;

    public Processo(int numeroDoProcesso, int tempoDeChegada, int tempoDeExecucao, int prioridade) {
        this.numeroDoProcesso = numeroDoProcesso;
        this.tempoDeChegada = tempoDeChegada;
        this.tempoDeExecucao = tempoDeExecucao;
        this.prioridade = prioridade;
    }

    public int getTempoQueFaltaExecutar() {
        return tempoQueFaltaExecutar;
    }

    public void setTempoExecutado(int fatiaDeTempo) {
        this.tempoQueFaltaExecutar -= fatiaDeTempo;
    }

    public void atualizaTempoQueFaltaExecutar() {
        tempoQueFaltaExecutar = tempoDeExecucao;
    }

    public int getTempoDeChegada() {
        return tempoDeChegada;
    }

    public int getTempoDeExecucao() {
        return tempoDeExecucao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getNumeroDoProcesso() {
        return numeroDoProcesso;
    }

}
