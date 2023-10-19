package PaooGame.Database;

import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;

import java.sql.*;

public class Database {
    //Implementeaza ideea de salvare a jocului
    public void SaveLevelStatus(Map map) {
        try {
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:SaveLevelStatus.db");
            stmt = c.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS SaveLevelStatus " + "(Level INT, Life INT, x INT, y INT)");
            stmt.execute("DELETE FROM SaveLevelStatus");
            stmt.executeUpdate("INSERT INTO SaveLevelStatus (Level, Life, x, y) " + "VALUES(" + map.GetLevel() +
                    ", " + map.getItemManager().GetHero().getLife() +
                    ", " + map.getItemManager().GetHero().GetX() +
                    ", " + map.getItemManager().GetHero().GetY() + ");");

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    //Implementeaza ideea de incarcare a jocului din punctul in care a fost salvat
    public void LoadLevelStatus(Map map)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:SaveLevelStatus.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            stmt.execute("SELECT * FROM SaveLevelStatus");
            ResultSet rs =  stmt.getResultSet();
            map.SetLevel(rs.getInt("Level"));
            map.getItemManager().GetHero().setLife(rs.getInt("Life"));
            map.getItemManager().GetHero().SetX(rs.getInt("x"));
            map.getItemManager().GetHero().SetY(rs.getInt("y"));

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
