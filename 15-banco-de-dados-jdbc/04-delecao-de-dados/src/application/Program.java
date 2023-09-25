package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {
    public static void main(String[] args) {
        /* Atenção ao erro de integridade referencial */
        // para casos onde a chave primária de uma linha de uma tabela seja referenciada em outra
        // ela não pode ser apagada normalmente, pois sua referência deixa de existir enquanto ainda
        // há outras tabelas que a referenciam, gerando erro de integridade referencial; ex:
        // | Usuario | Cod_Cidade |            | Id | Cidade    |
        // | Fulano  |     5      |            | 5  | Mossoró   |
        // (linha 5 seria apagada do db, mas ainda referenciada por outra tabela)


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                "DELETE FROM department "
                + "WHERE "
                + "Id = ?"
            );

            // se selecionar o Id como sendo 2, apresentará erro de integridade como explicado acima
            preparedStatement.setInt(1, 2);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Atualização realizada! Linhas afetadas: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } catch(Throwable t) {
            t.printStackTrace();
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
