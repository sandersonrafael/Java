import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solucao {

    public static void main(String[] args) {

        Set<String> usuarios = new HashSet<>();

        try (
            BufferedReader br = new BufferedReader(new FileReader("./log.txt"));
        ) {
            String usuario = obterUsuario(br.readLine());

            while (usuario != null) {
                usuarios.add(usuario);
                usuario = obterUsuario(br.readLine());
            }

            System.out.println("Há " + usuarios.size() + " usuários que acessaram o site.");
        } catch(IOException e) {}
    }

    public static String obterUsuario(String linha) {
        return linha == null ? null : linha.split(" ")[0];
    }
}
