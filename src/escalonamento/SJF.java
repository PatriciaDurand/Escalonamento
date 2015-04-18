package escalonamento;

import java.util.ArrayList;

/**
 *
 * @author Patricia Durand e Tamires Domingues
 */
public class SJF {

    private ArrayList<Processo> listaDeProcessos;
    private ArrayList<Processo> listaParaOrdenar;
    private ArrayList<String> graficoSaida;
    int tempo = 0;
    int tempoVerificacaoChegada = 0;

    public SJF(ArrayList<Processo> listaDeProcessos) {
        this.listaDeProcessos = listaDeProcessos;
        listaParaOrdenar = new ArrayList<Processo>();
        graficoSaida = new ArrayList<String>();
        executaEscalonamento();
    }

    private void executaEscalonamento() {
        if (listaDeProcessos != null) {
            if (processoChegou()) {
                atualizaFila();
            }
            if (temProcessoNaFila()) {
                executaProcesso();
                atualizaContador();
            } else {
                graficoSaida.add("-");
            }
        }
    }

    private boolean processoChegou() {
        for (int i = 0; i < listaDeProcessos.size(); i++) {
            if (listaDeProcessos.get(i).getTempoDeChegada() <= tempo
                    && listaDeProcessos.get(i).getTempoDeChegada() > tempoVerificacaoChegada) {
                listaParaOrdenar.add(listaDeProcessos.get(i));
                return true;
            }
        }
        return false;
    }

    private void atualizaFila() {
        for (int i = 0; i < listaParaOrdenar.size(); i++) {
            int tempoDeExecucaoDoProcessoParaOrdenar = listaParaOrdenar.get(i).getTempoDeExecucao();
            int localParaInserirOProcesso = 0;
            int j = localParaInserirOProcesso;

            if (!listaDeProcessos.isEmpty()) {
                while (tempoDeExecucaoDoProcessoParaOrdenar > listaDeProcessos.get(j).getTempoDeExecucao()) {
                    localParaInserirOProcesso++;
                    j++;
                }
            }
            listaDeProcessos.add(localParaInserirOProcesso, listaParaOrdenar.get(i));
        }
    }

    private boolean temProcessoNaFila() {
        return true;
    }

    private void executaProcesso() {        
    }

    private void atualizaContador() {
    }
}