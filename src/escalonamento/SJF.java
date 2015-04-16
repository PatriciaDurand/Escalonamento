package escalonamento;

import java.util.ArrayList;

/**
 *
 * @author Patricia Durand e Tamires Domingues
 */
public class SJF {

    private ArrayList<Processo> listaDeProcessos;
    private ArrayList<String> graficoSaida;
    int tempo = 0;

    public SJF(ArrayList<Processo> listaDeProcessos) {
        this.listaDeProcessos = listaDeProcessos;
        graficoSaida = new ArrayList<String>();
        executaEscalonamento();
    }

    private void executaEscalonamento() {
        if (listaDeProcessos != null && !listaDeProcessos.isEmpty()) {
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
        return true;
    }

    private void atualizaFila() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean temProcessoNaFila() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void executaProcesso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void atualizaContador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
