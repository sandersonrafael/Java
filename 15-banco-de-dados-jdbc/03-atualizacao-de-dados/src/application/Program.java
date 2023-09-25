package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                "UPDATE seller "
                + "SET BaseSalary = BaseSalary + ? " // atualiza tabela vendedor, na coluna BaseSalary
                + "WHERE " // define quem vai ser atualizado (se não passar o WHERE, atualiza TODOS)
                + "(DepartmentId = ?)"
            );

            preparedStatement.setDouble(1, 200.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Atualização realizada! Linhas afetadas: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Throwable t) {
            t.printStackTrace();
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
