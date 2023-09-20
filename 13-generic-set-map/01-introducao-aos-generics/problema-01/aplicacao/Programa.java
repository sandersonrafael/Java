package aplicacao;

import java.util.Scanner;

import servicos.ServicoImpressao;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServicoImpressao<String> si = new ServicoImpressao<>();

        System.out.println("Quantos valores?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String valor = sc.next();
            si.adicionarValor(valor);
        }

        si.imrpimir();
        System.out.println("Primeiro: " + si.primeiro());

        sc.close();
    }
}
