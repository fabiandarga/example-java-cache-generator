package de.fabiandarga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/numbers_and_colors";
        String user = "numbers_and_colors_admin";
        String password = "123456";

        Connection conn = null;

        // serialize it
        try {
            conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO pairs (number, color) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 1000);
            statement.setString(2, "red");

            statement.executeUpdate();


            System.out.println("Objects created");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}