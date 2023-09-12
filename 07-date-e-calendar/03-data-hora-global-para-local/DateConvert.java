import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

public class DateConvert {
  public static void main(String[] args) {
    LocalDate data = LocalDate.parse("2023-01-10");
    LocalDateTime dataHora = LocalDateTime.parse("2023-03-15T13:35:32");
    Instant dataHoraGlobal = Instant.parse("2023-01-30T22:15:31-03:00");

    // retorna uma lista com todos os nomes dos fusorários customizados
    Set<String> zId = ZoneId.getAvailableZoneIds();
    System.out.println(zId.size() + " zonas existentes...");;
    /* for (String zoneId : zId) {
      if (zoneId.indexOf("Brazil") != -1) {
        System.out.println(zoneId);
      }
    } */

    // zoneId da máquina:
    ZoneId minhaZona = ZoneId.systemDefault();
    System.out.println("Zona da máquina: " + minhaZona);

    // converter global em local do sistema
    LocalDate dataConvertida1 = LocalDate.ofInstant(dataHoraGlobal, minhaZona);
    LocalDate dataConvertida2 = LocalDate.ofInstant(dataHoraGlobal, ZoneId.of("Portugal"));

    LocalDateTime dataHoraConvertida1 = LocalDateTime.ofInstant(dataHoraGlobal, minhaZona);
    LocalDateTime dataHoraConvertida2 = LocalDateTime.ofInstant(dataHoraGlobal, ZoneId.of("Portugal"));


    System.out.println(dataConvertida1);
    System.out.println(dataConvertida2);
    System.out.println(dataHoraConvertida1);
    System.out.println(dataHoraConvertida2);

    // métodos para data local
    System.out.println("Dia retirado do método da variável 'data': " + data.getDayOfMonth());
    System.out.println("Mês retirado do método da variável 'dataHora': " + dataHora.getMonthValue());
  }
}
