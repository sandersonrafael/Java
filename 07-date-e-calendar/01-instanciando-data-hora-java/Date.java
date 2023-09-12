import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
  public static void main(String[] args) {
    // now() -> agora
    LocalDate dataLocal = LocalDate.now(); // data do sistema agora
    LocalDateTime dataHoraLocal = LocalDateTime.now(); // data e hora do sistema agora
    Instant dataHoraGlobal = Instant.now(); // data e hora global agora

    // obtendo dados e transformando no objeto data do Java
    LocalDate dataParseada = LocalDate.parse("2023-01-01");
    LocalDateTime dataHoraParseada = LocalDateTime.parse("2023-01-01T12:35:32.41234");
    Instant dataHoraGlobalParseada = Instant.parse("2023-01-01T12:35:32.41234-03:00");

    // referência do DateTimeFormater -> converter string personalizada em data-hora
    // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataParseadaPersonalizada1 = LocalDate.parse("20/07/2023", formato1);

    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDate dataParseadaPersonalizada2 = LocalDate.parse("20/07/2023 03:30", formato2);

    // passando ano, mes, dia, hora, minuto, segundo e nanosegundos
    LocalDateTime diaMesAno = LocalDateTime.of(2023, 9, 12, 1, 30, 30, 123912839);

    // toString() transforma o objeto data em string ISO 8601
    System.out.println("Data local agora: " + dataLocal.toString());
    System.out.println("Data e hora local agora: " + dataHoraLocal.toString());
    System.out.println("Data e hora global agora: " + dataHoraGlobal.toString());
    System.out.println("Data local gerada: " + dataParseada.toString());
    System.out.println("Data e hora local gerada: " + dataHoraParseada.toString());
    System.out.println("Data e hora global gerada: " + dataHoraGlobalParseada.toString());
    System.out.println("Data e hora global gerada: " + dataParseadaPersonalizada1.toString());
    System.out.println("Data e hora global gerada: " + dataParseadaPersonalizada2.toString());
    System.out.println("Data gerada por ano, mês e dia: " + diaMesAno.toString());
  }
}
