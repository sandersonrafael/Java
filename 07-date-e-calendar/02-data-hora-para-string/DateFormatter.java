import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
  public static void main(String[] args) {
    LocalDate dataLocal = LocalDate.parse("2023-09-12");
    LocalDateTime dataHoraLocal = LocalDateTime.parse("2023-01-01T01:30:30");
    Instant dataHoraGlobal = Instant.parse("2023-04-15T13:35:21Z");

    // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter dataHoraFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    

    // dois métodos de formatação
    System.out.println("Data local formatada: " + dataLocal.format(dataFormatada));
    System.out.println("Data local formatada: " + dataFormatada.format(dataLocal));

    System.out.println("Data local formatada com data hora local: " + dataHoraLocal.format(dataFormatada));
    System.out.println("Data e hora local formatados: " + dataHoraLocal.format(dataHoraFormatada));

    // o instant não possui o método format naturalmente. Necessário fazer:
    DateTimeFormatter instantFormatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
    System.out.println("Instant formatado para horário do sistema: " + instantFormatado.format(dataHoraGlobal));

    // também é possível usar DateTimeFormatter padrão, como segue:
    DateTimeFormatter formatoPadrao = DateTimeFormatter.ISO_DATE_TIME;
    System.out.println("DateTimeFormatter padrão ISO_DATE_TIME: " + dataHoraLocal.format(formatoPadrao));

    // usando o instant
    DateTimeFormatter instantPadrao = DateTimeFormatter.ISO_INSTANT;
    System.out.println("DateTimeFormatter padrão ISO_INSTANT: " + instantPadrao.format(dataHoraGlobal));
    System.out.println("Usando toString() resulta o mesmo: " + dataHoraGlobal.toString());
  }
}
