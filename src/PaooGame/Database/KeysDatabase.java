package PaooGame.Database;

import PaooGame.Maps.Map;

import java.sql.*;

public class KeysDatabase {
    //Metoda are rolul de a cuantifica numarul de chei colectate in toate cele 3 niveluri
    public int NumberOfKeys(Map map) {
        int totalNumberOfKeys = 0;
        Connection c = null;
        Statement stmt = null;
        PreparedStatement updateStmt = null;
        PreparedStatement insertStmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:NumberOfKeys.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS NumberOfKeys " + "(Level INT, Keys INT)");
            int level = map.GetLevel();
            int collectedKeys = map.getItemManager().GetHero().GetCollectedKeys();

            PreparedStatement selectStmt = c.prepareStatement("SELECT * FROM NumberOfKeys WHERE Level = ?");
            selectStmt.setInt(1, level);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                updateStmt = c.prepareStatement("UPDATE NumberOfKeys SET Keys = ? WHERE Level = ?");
                updateStmt.setInt(1, collectedKeys);
                updateStmt.setInt(2, level);
                updateStmt.executeUpdate();
            } else {
                insertStmt = c.prepareStatement("INSERT INTO NumberOfKeys (Level, Keys) VALUES (?, ?)");
                insertStmt.setInt(1, level);
                insertStmt.setInt(2, collectedKeys);
                insertStmt.executeUpdate();
            }

            rs = stmt.executeQuery("SELECT SUM(Keys) AS TotalNumberOfKeys FROM NumberOfKeys");
            while (rs.next())
                totalNumberOfKeys = rs.getInt("TotalNumberOfKeys");

            rs.close();
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return totalNumberOfKeys;
    }
}
