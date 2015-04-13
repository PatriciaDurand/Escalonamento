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

        ArrayList<String> dados = a.pegaDadosDoArquivo();

        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i));
        }
    }

}
