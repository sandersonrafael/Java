package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Postagem {
  private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  private Date dataDoPost;
  private String titulo;
  private String conteudo;
  private Integer curtidas;

  private ArrayList<Comentario> comentarios = new ArrayList<>();

  public Postagem() {
  }

  public Postagem(Date dataDoPost, String titulo, String conteudo, Integer curtidas) {
    this.dataDoPost = dataDoPost;
    this.titulo = titulo;
    this.conteudo = conteudo;
    this.curtidas = curtidas;
  }

  public Date getDataDoPost() {
    return dataDoPost;
  }

  public void setDataDoPost(Date dataDoPost) {
    this.dataDoPost = dataDoPost;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public Integer getCurtidas() {
    return curtidas;
  }

  public void setCurtidas(Integer curtidas) {
    this.curtidas = curtidas;
  }

  public ArrayList<Comentario> getComentarios() {
    return comentarios;
  }

  public void adicionarComentario(Comentario comentario) {
    comentarios.add(comentario);
  }

  public void removerComentario(Comentario comentario) {
    comentarios.remove(comentario);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(titulo + "\n");
    sb.append(curtidas);
    sb.append(" Curtidas - ");
    sb.append(formato.format(dataDoPost) + "\n");
    sb.append(conteudo + "\n");
    sb.append("Comentários\n");

    for (Comentario comentario: comentarios) {
      sb.append(comentario.getTexto() + "\n");
    }
    return sb.toString();
  }
}
