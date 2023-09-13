package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entidades.Comentario;
import entidades.Postagem;

public class Programa {
  public static void main(String[] args) throws ParseException {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Postagem postagem1 = new Postagem(
      formato.parse("21/06/2018 13:05:44"),
      "Viajando para Nova Zelândia",
      "Estou indo visitar esse maravilhoso país!",
      12
    );
    Comentario comentario11 = new Comentario("Tenha uma boa viagem");
    Comentario comentario12 = new Comentario("Wow, isso é incrível!");
    postagem1.adicionarComentario(comentario11);
    postagem1.adicionarComentario(comentario12);

    Postagem postagem2 = new Postagem(formato.parse("28/07/2018 23:14:19"), "Boa noite galera", "Vejo vocês amanhã", 5);
    Comentario comentario21 = new Comentario("Boa noite");
    Comentario comentario22 = new Comentario("Que a força esteja com você");
    postagem2.adicionarComentario(comentario21);
    postagem2.adicionarComentario(comentario22);

    System.out.println(postagem1);
    System.out.println(postagem2);
  }
}
