package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();

            // prepara um estado que irá receber os valores e preencherá nos "?" com os "setEtc(index(a partir de 1), valor)"
            preparedStatement = connection.prepareStatement(
                "INSERT INTO seller"
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                + "VALUES"
                + "(?, ?, ?, ?, ?)"
                , Statement.RETURN_GENERATED_KEYS
                // trata-se de uma sobrecarga, passando Statement e sua constante como parêmtro do prepareStatement
            );

            preparedStatement.setString(1, "Lucas Oliveira");
            preparedStatement.setString(2, "lucasoliveira@gmail.com");
            // para inserir datas para o sql, usa-se o java.sql.Date() e não o java.util.Date()
            preparedStatement.setDate(3, new Date(sdf.parse("22/04/1985").getTime()));
            preparedStatement.setDouble(4, 1320.00);
            preparedStatement.setInt(5, 4);

            // fazendo mais que uma adição por vez ->
            /* preparedStatement = connection.prepareStatement(
                "INSERT INTO department (Name) values ('D1'),('D2')",
                Statement.RETURN_GENERATED_KEYS
            ); */
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) { // retonra as chaves geradas que ficaram armazenadas na constante RETURN_GENERATED_KEYS
                ResultSet resultSet = preparedStatement.getGeneratedKeys(); // pode ter múltiplos valores retornados

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("Feito! Id: " + id);
                }

            } else System.out.println("Sem linhas alteradas");

        } catch(SQLException e) {
           e.printStackTrace();
        } catch(Throwable t) {
           t.printStackTrace();
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
