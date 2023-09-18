import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Produto;

public class Main {

    public static void main(String[] args) {

        new File("./out").mkdir();

        try (
            BufferedReader br = new BufferedReader(new FileReader("./dados.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("./out/summary.csv"));
        ) {
            List<Produto> produtos = new ArrayList<>();
            String linhaDosDados = br.readLine();

            while (linhaDosDados != null) {
                String[] dadosDoProduto = linhaDosDados.split(",");
                Produto produto = new Produto(dadosDoProduto[0], Double.parseDouble(dadosDoProduto[1]), Integer.parseInt(dadosDoProduto[2]));
                produtos.add(produto);
                linhaDosDados = br.readLine();
            }

            for (Produto p : produtos) {
                bw.write(p.getNome() + "," + p.getPreco() * p.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Deu erro");
        }
    }
}
