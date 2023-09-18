import java.io.File;
import java.util.Scanner;

public class ClasseFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho do arquivo (recomendação: ./ ): ");
        String diretorio = sc.nextLine();

        File caminho = new File(diretorio); // retorna um caminho do sistema

        // :: -> trata-se de reference methods / basta usar o Tipo do array
        // digitar ::, pressionar: ctrl + espaço para ver as possibilidades
        // ex File::isDirectory -> refere a todos arquivos do array que forem diretórios
        File[] pastas = caminho.listFiles(File::isDirectory);
        System.out.println("Pastas:");
        for (File pasta : pastas) {
            System.out.println(pasta);
        }

        File[] arquivos = caminho.listFiles(File::isFile);
        for (File arquivo : arquivos) {
            System.out.println(arquivo);
        }

        // criando diretório
        boolean sucesso = new File(diretorio + "/pasta-teste").mkdir();
        System.out.println("Subpasta foi criada? -> " + (sucesso ? "Sim" : "Não"));
    }
}
