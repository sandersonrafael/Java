package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import modelo.servicos.ServicoJuros;
import modelo.servicos.ServicoJurosEua;

public class Programa {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Sistema de juros composto");

        System.out.print("Quantidade: ");
        double quantidade = sc.nextDouble();

        System.out.print("Meses: ");
        int meses = sc.nextInt();

        ServicoJuros sj = new ServicoJurosEua(1.0);
        double pagamento = sj.pagamento(quantidade, meses);

        System.out.print("Pagamento após " + meses + " meses: ");
        System.out.printf("%.2f", pagamento);

        sc.close();
    }
}
