/* Exceção personalizada */
package model.excecoes;

// pode ser um extend Excepction ou um extend RuntimeExepction
// diferença: RuntimeException o compilador não obriga a tratar, enquanto a Exception sim
// recomendação minha -> usar o Exception sempre, pois é mais seguro
public class ExcecaoDeDominio extends Exception {
  // private static final long serialVersionUID = 1L;

  public ExcecaoDeDominio(String msg) {
    super(msg);
  }
}
