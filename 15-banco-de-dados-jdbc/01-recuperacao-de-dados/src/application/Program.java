package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DB.getConnection();

            statement = connection.createStatement();

            // Selecionar tudo (*) de department
            resultSet = statement.executeQuery("SELECT * FROM department");

            // o resultSet começa no índice 0, que são os títulos
            // após o primeiro next, está na posição 1
            while (resultSet.next()) {
                // para acessar as informações, usamos o resultSet.getAlgumaCoisa()
                System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally { // É importante fechar depois de usar, pois são recursos externos e podem estourar a memória
            // os closes foram criados como métodos estáticos da classe DB.java, para que não fiquem dentro do código
            // do main e não tenham que ficar sendo tratados com try catch() a todo momento
            DB.closeResultSet(resultSet);
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
