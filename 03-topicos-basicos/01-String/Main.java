// métodos para Strings no Java

/* Formatar */
/*
toLowerCase() -> letras minúsculas
toUpperCase() -> letras maiúsculas
trim() -> remover espaços em branco isolados
*/

/* Recortar */
  /*
  substring(inicio) -> recorta tudo a partir de determinado índice
  substring(inicio, fim) -> recorta tudo num intervalo
  */
  
/* Substituir */
/*
  replace(char, char) -> substitui todas ocorrências de um caractere por outro especificado
  replace(String, String) -> substitui sequências de caracteres por outra
  */
  
  /* Buscar */
  /*
  indexOf(char) -> localiza o índice de determinado caractere
  lastIndexOf(char) -> localiza o último índice que possui um caractere
  */
  
  /* Separar */
  /*
  srt.splice(char) -> separa a string em todas ocorrências do caractere informado
  */

  public class Main {
    public static void main (String[] args) {
      String original = "abcde FGHIJ ABC abc DEFG    ";
  
      String minusc = original.toLowerCase();
      String maiusc = original.toUpperCase();
      String trim = original.trim();
      String minSubstring = original.substring(2);
      String maxSubstring = original.substring(2, 9);
      String replaceChar = original.replace("a", " XXXX ");
      String replaceString = original.replace("abc", "ABCABCABC");
      int i = original.indexOf("bc");
      int j = original.lastIndexOf("bc");
      String arrayDeTeste = "array de teste";
      String[] array = arrayDeTeste.split(" ");
  
      System.out.println("original: |" + original + "|");
      System.out.println("minusc: |" + minusc + "|");
      System.out.println("maiusc: |" + maiusc + "|");
      System.out.println("trim: |" + trim + "|");
      System.out.println("minSubstring: |" + minSubstring + "|");
      System.out.println("maxSubstring: |" + maxSubstring + "|");
      System.out.println("replaceChar: |" + replaceChar + "|");
      System.out.println("replaceString: |" + replaceString + "|");
      System.out.println("Primeira ocorrência do bc: indice " + i + "; Última ocorrência do bc: indice " + j);
      System.out.println(array[0] + array[1] + array[2]);
    }
  }