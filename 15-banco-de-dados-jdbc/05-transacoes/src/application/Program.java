package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DB.getConnection();

            // faz com que as alterações não sejam confirmadas automaticamente, necessitando que o próprio dev confirme
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            /* -> o que acontece nesse bloco, prova a questão da transaction apresentando erro, onde só o rows1 é executado
            int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            // simulando uma exceção
            int x = 1;
            if (x < 2) throw new SQLException("Erro fake");
            int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
             */

            int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            connection.commit();

            System.out.println("Linhas1 = " + rows1);
            System.out.println("Linhas2 = " + rows2);

        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transação retornada ao estado inicial. Erro: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Falha ao tentar realizar o rollback. Erro: " + e1.getMessage());
            }
        } catch(Throwable t) {
            t.printStackTrace();
        } finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
