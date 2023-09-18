import java.io.File;
import java.util.Scanner;

public class InformacoesPath {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo (recomendação ../ ou ./arquivo-teste.txt): ");
        String caminhoDigitado = sc.nextLine();

        File caminho = new File(caminhoDigitado);

        // métodos
        System.out.println("getName: " + caminho.getName());
        System.out.println("getParent: " + caminho.getParent());
        System.out.println("getPath: " + caminho.getPath());
        System.out.println("getAbsolutePath: " + caminho.getAbsolutePath());


        sc.close();
    }
}
