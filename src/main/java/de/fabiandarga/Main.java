package de.fabiandarga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/numbers_and_colors";
        String user = "numbers_and_colors_admin";
        String password = "123456";

        String[] colors = {"yellow", "red", "blue", "green"};
        Random random = new Random();

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO pairs (number, color) VALUES (?, ?)";
            int i = 0;

            for (; i < 10000; i++) {
                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setInt(1, random.nextInt(1, 1001));

                int colorIndex = random.nextInt(colors.length);
                statement.setString(2, colors[colorIndex]);
                statement.executeUpdate();
            }

            System.out.println(i + " Objects created");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}