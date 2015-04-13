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
       
        
        
    }

}
