package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
    public static void main(String[] args) {
        /* Operacao 1 - Objetos criados inicialmente */
        /* Pessoa p1 = new Pessoa(null, "Carlim Tete", "carlimte@gmail.com");
        Pessoa p2 = new Pessoa(null, "Marcele Campelo", "marcecam@gmail.com");
        Pessoa p3 = new Pessoa(null, "Dudu Laerte", "dudula@gmail.com"); */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        /* Operacao 1 - Objetos inseridos inicialmente */
        /* em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit(); */

        /* Operacao 2 - Recuperação de objeto */
        // passa a classe como primeiro argumento e a Pk como segundo argumento
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        /* Operação 3 - Monitoramento e deleção */
        Pessoa p2 = new Pessoa(2, null, null);
        // em.remove(p2);
        /* mesmo que p2 seja idêntico a algum objeto do Banco de Dados, ele não é o mesmo
        ou seja, ele não está sendo monitoriado e vai dar erro.
        para apagar, precisa ter buscado anteriormente ou ter criado a própria pessoa e salvo no DB
        antes de usar o método remove(pessoa) */

        // como Pessoa p acima realmente foi buscada, é possível usar para remover, pois está monitorada

        // sempre que fizer alteração ou algo que não seja uma consulta, é preciso iniciar e finalizar uma transação:
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Sucesso!");
        em.close();
        emf.close();
    }
}
