public class Main {
  public static void main (String[] args) {
    // soma simples
    /*     int x;
        double y;
        x = 5;
        y = 2 * x;

        System.out.println(x);
        System.out.println(y);
    */

        // cálculo de área

    /*     double b, B, h, area;

        // boa prática colocar .0 quando trata-se de um double
        // se for float, usa-se f, ex: 6f, 8f, 5f
        b = 6.0;
        B = 8.0;
        h = 5.0;
    */

    // casting -> conversão explícita de dados
    /* 
    int a, b;
    double resultado;

    a = 5;
    b = 2;

    // resultado = a / b;
    // // vai imprimir 2.0 e não 2.5 -> a e b são inteiros
    // System.out.println(resultado);

    // como contornar
    resultado = (double) a / b; // -> trata-se de casting
    System.out.println(resultado);
    */

    // evitando "perda de dados"
    double a;
    int b;

    a = 5.0;
    // b = a; a não pode ser convertido para double desta maneira, então usa-se
    b = (int) a;
    System.out.println(b);
  }
}
