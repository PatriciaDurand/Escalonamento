package escalonamento;

import java.util.ArrayList;

/**
 *
 * @author PATRICIA
 */
public class Calculadora {

    private ArrayList<Processo> listaDeProcessos;
    private ArrayList<String> graficoDeSaida;
    private int tempoDeEspera;
    private int tempoDeResposta;
    private int tempoDeTurnaround;

    public Calculadora(ArrayList<Processo> listaDeProcessos, ArrayList<String> graficoDeSaida) {
        this.listaDeProcessos = listaDeProcessos;
        this.graficoDeSaida = graficoDeSaida;
        tempoDeEspera = 0;
        tempoDeResposta = 0;
        tempoDeTurnaround = 0;
    }

    public void calculaTemposDoProcesso(Processo processo) {
        int tempoDeChegada = processo.getTempoDeChegada();
        int tempoDeExecucao = processo.getTempoDeExecucao();
        int numeroDoProcesso = processo.getNumeroDoProcesso();

        int tempoTerminoDoProcesso = pegaOTempoDeTerminoDoProcesso(numeroDoProcesso);
        int tempoInicioDoProcesso = pegaOTempoDeInicioDoProcesso(numeroDoProcesso);;

        tempoDeEspera = tempoTerminoDoProcesso - tempoDeChegada - tempoDeExecucao;
        tempoDeResposta = tempoInicioDoProcesso - tempoDeChegada;
        tempoDeTurnaround = tempoTerminoDoProcesso - tempoDeChegada;
    }

    private int pegaOTempoDeTerminoDoProcesso(int numeroDoProcesso) {
        for (int i = graficoDeSaida.size() - 1; i > 0; i--) {
            if (graficoDeSaida.get(i).equals("" + numeroDoProcesso)) {
                return i + 1;
            }
        }
        return -1;
    }

    private int pegaOTempoDeInicioDoProcesso(int numeroDoProcesso) {
        for (int i = 0; i < graficoDeSaida.size(); i++) {
            if (graficoDeSaida.get(i).equals("" + numeroDoProcesso)) {
                return i;
            }
        }
        return -1;
    }

    public int getTempoDeEspera() {
        return tempoDeEspera;
    }

    public int getTempoDeResposta() {
        return tempoDeResposta;
    }

    public int getTempoDeTurnaround() {
        return tempoDeTurnaround;
    }
}
