package escalonamento;

import java.util.ArrayList;

/**
 *
 * @author Patricia Durand e Tamires Domingues
 */
public class Escalonamento {

    public static void main(String[] args) {
        Arquivo a = new Arquivo();
        a.leArquivo("arquivo.txt");

        ArrayList<String> dadosDoArquivo = a.pegaDadosDoArquivo();

        //manipula os dados para passar para o gerenciador de processos
        int quantidadeProcessos = Integer.parseInt(dadosDoArquivo.get(0));
        int tamanhoDaFatiaDeTempo = Integer.parseInt(dadosDoArquivo.get(1));

        //passa os dados manipulados para o gerenciador de processos
        GerenciadorDeProcessos gerenciadorDeProcessos;
        gerenciadorDeProcessos = new GerenciadorDeProcessos(quantidadeProcessos, tamanhoDaFatiaDeTempo, dadosDoArquivo);
        gerenciadorDeProcessos.adicionaProcessos();

        ArrayList<Processo> listaDeProcessos = gerenciadorDeProcessos.getListaDeProcessos();

        SJF sjf = new SJF(listaDeProcessos);

        ArrayList<String> graficoDeSaida = sjf.getGraficoDeSaida();

        System.out.println("Gráfico de saída: SJF");
        for (int i = 0; i < graficoDeSaida.size(); i++) {
            System.out.print(graficoDeSaida.get(i));
        }

        System.out.println("");
        
        Calculadora calculadora = new Calculadora(listaDeProcessos, graficoDeSaida);
        for (int i = 0; i < listaDeProcessos.size(); i++) {
            System.out.println("Calculo para o processo " + listaDeProcessos.get(i).getNumeroDoProcesso());
            calculadora.calculaTemposDoProcesso(listaDeProcessos.get(i));

            System.out.print("Tempo de Espera: ");
            System.out.println(calculadora.getTempoDeEspera());

            System.out.print("Tempo de Resposta: ");
            System.out.println(calculadora.getTempoDeResposta());

            System.out.print("Tempo de Turnaround: ");
            System.out.println(calculadora.getTempoDeTurnaround());
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        }

    }
}
