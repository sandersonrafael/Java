package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Contrato;
import model.entidades.Parcela;
import model.servicos.ServicoContrato;
import model.servicos.ServicoPaypal;

public class Programa {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados do contrato");
        System.out.print("Numero do contrato: ");
        int numeroContrato = sc.nextInt();

        System.out.print("Informe a data início do contrato: ");
        Date dataContrato = sdf.parse(sc.next());

        System.out.print("Informe o valor do contrato: ");
        double valorContrato = sc.nextDouble();

        System.out.print("Informe a quantidade de parcelas: ");
        int parcelasContrato = sc.nextInt();

        Contrato contrato = new Contrato(numeroContrato, dataContrato, valorContrato);
        ServicoContrato servico = new ServicoContrato();

        servico.processarContrato(contrato, parcelasContrato, new ServicoPaypal());

        for (Parcela parcela : contrato.getParcelas()) {
            Date dataNaoFormatada = parcela.getVencimento();
            String dataFormatada = sdf.format(dataNaoFormatada);
            double quantidade = parcela.getQuantidade();

            System.out.println(dataFormatada + " - " + quantidade);
        }

        sc.close();
    }
}
