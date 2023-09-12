import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculosDataHora {
  public static void main(String[] args) {
    LocalDate data = LocalDate.parse("2023-01-06");
    LocalDateTime dataHora = LocalDateTime.parse("2023-03-15T13:35:32");
    Instant dataHoraGlobal = Instant.parse("2023-01-30T22:15:31-03:00");

    // dataHora são objetos imutáveis. Uma vez instanciadas, permanecem com o mesmo
    // valor
    // para realizar operações, é necessário criar uma nova variável que recebe o
    // novo valor

    // os métodos que realizam esses cálculos estão dentro do objeto instanciado
    LocalDate dataMenosUmaSemana = data.minusDays(7);
    LocalDate dataMaisUmaSemana = data.plusDays(7);
    System.out.println(data);
    System.out.println("Data uma semana antes: " + dataMenosUmaSemana);
    System.out.println("Data uma semana depois: " + dataMaisUmaSemana);

    LocalDateTime dataHoraMenosUmaSemana = dataHora.minusDays(7);
    LocalDateTime dataHoraMaisUmaSemana = dataHora.plusDays(7);
    System.out.println(dataHora);
    System.out.println("Data-hora uma semana antes: " + dataHoraMenosUmaSemana);
    System.out.println("Data-hora uma semana depois: " + dataHoraMaisUmaSemana);

    // o instant não possui o minusDays e plusDays, mas há um minus e plus geral
    // que pede a quantidade e a unidade, represetada por ChronoUnit.UNIDADE, como
    // segue:
    Instant dataHoraGlobalMenosUmaSemana = dataHoraGlobal.minus(7, ChronoUnit.DAYS);
    Instant dataHoraGlobalMaisUmaSemana = dataHoraGlobal.plus(7, ChronoUnit.DAYS);
    System.out.println(dataHoraGlobal);
    System.out.println("Instant uma semana antes: " + dataHoraGlobalMenosUmaSemana);
    System.out.println("Instant uma semana depois: " + dataHoraGlobalMaisUmaSemana);

    // cálculo da duração - não funciona com LocalDate pois retorna o tempo em horas
    // é necessário converter para localDateTime com o atTime(hr, min) ou ats...,
    // ex:
    Duration duracao1 = Duration.between(
      data.atTime(0, 0),
      dataMaisUmaSemana.atStartOfDay()
    );
    System.out.println("Diferença de tempo: " + duracao1);

    // os métodos "to...()" do objeto instanciado permitem definir a unidade
    Duration duracao2 = Duration.between(dataHoraMenosUmaSemana, dataHora);
    System.out.println("Diferença de tempo: " + duracao2.toDays() + " dias");

    // com Instant
    Duration duracao3 = Duration.between(dataHoraGlobal, dataHoraGlobalMaisUmaSemana);
    System.out.println("Diferença de tempo: " + duracao3.toMinutes() + " minutos");
  }
}
