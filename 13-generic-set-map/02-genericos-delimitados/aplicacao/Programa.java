package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import entidades.Produto;
// import servicos.ServicoCalculo;
import servicos.ServicoCalculo;

public class Programa {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        try (
            BufferedReader br = new BufferedReader(new FileReader("./in.txt"));
        ) {
            String line = br.readLine();

            while (line != null) {
                String nome = line.split(",")[0];
                double preco = Double.parseDouble(line.split(",")[1]);
                lista.add(new Produto(nome, preco));
                line = br.readLine();
            }

            Produto produtoMaisCaro = ServicoCalculo.maior(lista);
            System.out.println(produtoMaisCaro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
