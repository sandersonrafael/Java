import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] linhas = new String[] { "Bom dia", "Boa tarde", "Boa noite" };

        String caminho = "./file-writer-result.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            // new FileWriter(caminho) -> recria se o arquivo existir
            // new FIleWriter(caminho, true) -> acrescenta caso arquivo exista
            for (String linha : linhas) {
                bw.write(linha); // não tem quebra de linha por padrão
                bw.newLine(); // adiciona quebra de linha
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
