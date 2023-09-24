package aplicacao;

import java.sql.Connection;

import db.DB;

public class Programa {
    public static void main(String[] args) {
        Connection connection = DB.getConnection();
        DB.closeConnection();
    }
}
