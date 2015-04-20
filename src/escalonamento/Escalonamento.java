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

        //Execução do SJF
        SJF sjf = new SJF(listaDeProcessos);

        ArrayList<String> graficoDeSaidaSJF = sjf.getGraficoDeSaida();
        double acumuladorTempoDeEspera;
        double acumuladorTempoDeResposta;
        double acumuladorTempoDeTurnaround;

        System.out.println("Gráfico de saída: SJF");
        for (int i = 0; i < graficoDeSaidaSJF.size(); i++) {
            System.out.print(graficoDeSaidaSJF.get(i));
        }

        System.out.println("");

        acumuladorTempoDeEspera = 0;
        acumuladorTempoDeResposta = 0;
        acumuladorTempoDeTurnaround = 0;

        Calculadora calculadoraSJF = new Calculadora(listaDeProcessos, graficoDeSaidaSJF);
        for (int i = 0; i < listaDeProcessos.size(); i++) {
            System.out.println("Calculo para o processo " + listaDeProcessos.get(i).getNumeroDoProcesso());
            calculadoraSJF.calculaTemposDoProcesso(listaDeProcessos.get(i));

            System.out.print("Tempo de Espera: ");
            System.out.println(calculadoraSJF.getTempoDeEspera());
            acumuladorTempoDeEspera += calculadoraSJF.getTempoDeEspera();

            System.out.print("Tempo de Resposta: ");
            System.out.println(calculadoraSJF.getTempoDeResposta());
            acumuladorTempoDeResposta += calculadoraSJF.getTempoDeResposta();

            System.out.print("Tempo de Turnaround: ");
            System.out.println(calculadoraSJF.getTempoDeTurnaround());
            acumuladorTempoDeTurnaround += calculadoraSJF.getTempoDeTurnaround();
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        }

        System.out.print("Tempo médio de Espera: ");
        System.out.println(acumuladorTempoDeEspera / quantidadeProcessos);

        System.out.print("Tempo médio de Resposta: ");
        System.out.println(acumuladorTempoDeResposta / quantidadeProcessos);

        System.out.print("Tempo médio de Turnaroud: ");
        System.out.println(acumuladorTempoDeTurnaround / quantidadeProcessos);

        //Execução do Round Robin
        RoundRobin roundrobin = new RoundRobin(listaDeProcessos, tamanhoDaFatiaDeTempo);

        ArrayList<String> graficoDeSaidaRoundRobin = roundrobin.getGraficoDeSaida();

        System.out.println("Gráfico de saída: SJF");
        for (int i = 0; i < graficoDeSaidaRoundRobin.size(); i++) {
            System.out.print(graficoDeSaidaRoundRobin.get(i));
        }

        System.out.println("");

        acumuladorTempoDeEspera = 0;
        acumuladorTempoDeResposta = 0;
        acumuladorTempoDeTurnaround = 0;

        Calculadora calculadoraRoundRobin = new Calculadora(listaDeProcessos, graficoDeSaidaRoundRobin);
        for (int i = 0; i < listaDeProcessos.size(); i++) {
            System.out.println("Calculo para o processo " + listaDeProcessos.get(i).getNumeroDoProcesso());
            calculadoraRoundRobin.calculaTemposDoProcesso(listaDeProcessos.get(i));

            System.out.print("Tempo de Espera: ");
            System.out.println(calculadoraRoundRobin.getTempoDeEspera());
            acumuladorTempoDeEspera += calculadoraRoundRobin.getTempoDeEspera();

            System.out.print("Tempo de Resposta: ");
            System.out.println(calculadoraRoundRobin.getTempoDeResposta());
            acumuladorTempoDeResposta += calculadoraRoundRobin.getTempoDeResposta();

            System.out.print("Tempo de Turnaround: ");
            System.out.println(calculadoraRoundRobin.getTempoDeTurnaround());
            acumuladorTempoDeTurnaround += calculadoraRoundRobin.getTempoDeTurnaround();
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        }

        System.out.print("Tempo médio de Espera: ");
        System.out.println(acumuladorTempoDeEspera / quantidadeProcessos);

        System.out.print("Tempo médio de Resposta: ");
        System.out.println(acumuladorTempoDeResposta / quantidadeProcessos);

        System.out.print("Tempo médio de Turnaroud: ");
        System.out.println(acumuladorTempoDeTurnaround / quantidadeProcessos);

    }
}
