package exercicio.aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import exercicio.entidades.Produto;

public class Programa {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("./in.csv"))) {
            List<Produto> produtos = new ArrayList<>();
            String linha = br.readLine();
            String[] dadosProduto = linha != null ? linha.split(",") : null;

            while (linha != null) {
                produtos.add(new Produto(dadosProduto[0], Double.parseDouble(dadosProduto[1])));
                linha = br.readLine();
                dadosProduto = linha != null ? linha.split(",") : null;
            }

            System.out.println("Preço médio dos produtos: ");

            Double somatorio = produtos.stream().map(p -> p.getPreco()).reduce(0.0, (soma, preco) -> soma + preco);
            Double media = somatorio / produtos.size();
            System.out.println(String.format("%.2f", media));

            List<Produto> produtosAbaixoDaMedia = produtos.stream().filter(x -> x.getPreco() < media).collect(Collectors.toList());
            Collections.sort(produtosAbaixoDaMedia, (p1, p2) -> - p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase()));

            produtosAbaixoDaMedia.stream().map(p -> p.getNome()).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
